const router = require("express").Router();
const { User, validate } = require("../models/user");
const bcrypt = require("bcrypt");
const tokenVerification = require("../middleware/tokenVerification");
const Game = require("../models/game.js");

// Pobierz listę gier użytkownika
router.get("/me/games", tokenVerification, async (req, res) => {
    try {
        const user = await User.findById(req.user._id).populate("games");
        if (!user) return res.status(404).send({ message: "Użytkownik nie znaleziony" });

        res.status(200).send({ data: user.games, message: "Twoje gry" });
    } catch (err) {
        res.status(500).send({ message: "Błąd serwera" });
    }
});
// Usun gre z biblioteki

router.delete("/me/games/:gameId", tokenVerification, async (req, res) => {
  try {
    const userId = req.user._id;  // tak samo jak w innych endpointach
    const gameId = req.params.gameId;
    const user = await User.findById(userId);
    if (!user) return res.status(404).json({ message: "Użytkownik nie znaleziony" });

    user.games = user.games.filter(id => id.toString() !== gameId);
    await user.save();

    res.json();
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: "Coś poszło nie tak" });
  }
});


// Dodaj grę do biblioteki użytkownika
router.post("/me/games", tokenVerification, async (req, res) => {
    try {
        const { gameId } = req.body;
        if (!gameId) return res.status(400).send({ message: "Brak ID gry" });

        const user = await User.findById(req.user._id);
        if (!user) return res.status(404).send({ message: "Użytkownik nie znaleziony" });

        // Sprawdź, czy gra istnieje w bazie
        const game = await Game.findById(gameId);
        if (!game) return res.status(404).send({ message: "Gra nie znaleziona" });

        // Sprawdź, czy gra już jest w bibliotece
        if (user.games.some(id => id.toString() === gameId)) {
            return res.status(400).send({ message: "Gra już jest w bibliotece" });
        }

        user.games.push(gameId);
        await user.save();

        res.status(200).send({ message: "Gra dodana do biblioteki" });
    } catch (err) {
        console.error("Błąd podczas dodawania gry:", err);
        res.status(500).send({ message: "Błąd serwera" });
    }
});

// Zmiana hasła
router.put("/me/password", tokenVerification, async (req, res) => {
    try {
        const { currentPassword, newPassword } = req.body;

        if (!currentPassword || !newPassword) {
            return res.status(400).send({ message: "Obecne i nowe hasło są wymagane." });
        }

        const user = await User.findById(req.user._id);
        if (!user) {
            return res.status(404).send({ message: "Użytkownik nie znaleziony" });
        }

        const isMatch = await bcrypt.compare(currentPassword, user.password);
        if (!isMatch) {
            return res.status(401).send({ message: "Obecne hasło jest nieprawidłowe" });
        }

        const salt = await bcrypt.genSalt(Number(process.env.SALT));
        const hashedNewPassword = await bcrypt.hash(newPassword, salt);

        user.password = hashedNewPassword;
        await user.save();

        res.status(200).send({ message: "Hasło zostało zmienione" });
    } catch (err) {
        console.error("Błąd przy zmianie hasła:", err);
        res.status(500).send({ message: "Błąd serwera" });
    }
});



router.post("/", async (req, res) => {
    try {
        const { error } = validate(req.body);
        if (error)
            return res.status(400).send({ message: error.details[0].message });

        const user = await User.findOne({ email: req.body.email });
        if (user)
            return res
                .status(409)
                .send({ message: "User with given email already exists!" });

        const salt = await bcrypt.genSalt(Number(process.env.SALT));
        const hashPassword = await bcrypt.hash(req.body.password, salt);

        await new User({ ...req.body, password: hashPassword }).save();
        res.status(201).send({ message: "User created successfully" });
    } catch (error) {
        res.status(500).send({ message: "Internal Server Error" });
    }
});

router.get("/", tokenVerification, async (req, res) => { // <-- Dodaj middleware
    try {
        const users = await User.find();
        res.status(200).send({ data: users, message: "Lista użytkowników" });
    } catch (error) {
        res.status(500).send({ message: error.message });
    }
});

router.get("/me", tokenVerification, async (req, res) => { // <-- Dodaj middleware
    try {
        const user = await User.findById(req.user._id).select("-password");
        if (!user) return res.status(404).send({ message: "Użytkownik nie znaleziony" });
        res.status(200).send({ data: user, message: "Mój Profil" });
    } catch (err) {
        res.status(500).send({ message: "Błąd serwera" });
    }
});

router.delete("/me", tokenVerification, async (req, res) => { // <-- Dodaj middleware
    try {
        await User.findByIdAndDelete(req.user._id);
        res.status(200).send({ message: "Konto usunięte pomyślnie" });
    } catch (err) {
        res.status(500).send({ message: "Błąd serwera" });
    }
});

module.exports = router;
