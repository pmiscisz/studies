const express = require("express");
const router = express.Router();
const Game = require("../models/game");
const verifyToken = require("../middleware/tokenVerification");

// GET /api/games - pobierz wszystkie gry
router.get("/", verifyToken, async (req, res) => {
    try {
        const games = await Game.find();
        res.status(200).send({ data: games, message: "Lista gier" });
    } catch (error) {
        res.status(500).send({ message: "Błąd serwera podczas pobierania gier" });
    }
});

// GET /api/games/:id - pobierz jedną grę po ID (opcjonalnie)
router.get("/:id", verifyToken, async (req, res) => {
    try {
        const game = await Game.findById(req.params.id);
        if (!game) return res.status(404).send({ message: "Gra nie znaleziona" });
        res.status(200).send({ data: game });
    } catch (error) {
        res.status(500).send({ message: "Błąd serwera podczas pobierania gry" });
    }
});

module.exports = router;
