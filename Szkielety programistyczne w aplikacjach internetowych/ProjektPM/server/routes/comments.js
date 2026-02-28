const mongoose = require("mongoose");
const router = require("express").Router();
const tokenVerification = require("../middleware/tokenVerification");
const Comment = require("../models/comment");
const Game = require("../models/game");
const User = require("../models/user");


// Pobierz komentarze do gry
router.get("/:gameId",tokenVerification, async (req, res) => {
  try {
    const gameId = req.params.gameId;
    console.log("Pobieranie komentarzy dla gry ID:", gameId);

    // Sprawdź, czy gra istnieje w bazie danych
    const game = await Game.findById(gameId);
    if (!game) {
      return res.status(404).send({ message: "Gra nie istnieje" });
    }

    // Pobierz komentarze do tej gry
    const comments = await Comment.find({ game: mongoose.Types.ObjectId(gameId) })
      .populate("user", "name email")
      .sort({ createdAt: -1 });

    res.status(200).send({ data: comments });
  } catch (err) {
    console.error("Błąd przy pobieraniu komentarzy:", err);
    res.status(500).send({ message: "Błąd serwera" });
  }
});

module.exports = router;


