const router = require("express").Router();
const { User, validate } = require("../models/user");
const bcrypt = require("bcrypt");
const tokenVerification = require("../middleware/tokenVerification"); // <-- Dodaj import

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
        res.status(200).send({ data: user, message: "Szczegóły konta" });
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
