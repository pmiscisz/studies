const mongoose = require("mongoose");

const gameSchema = new mongoose.Schema({
    title: { type: String, required: true },
    description: { type: String },
    price: { type: Number, required: true },
    coverImage: { type: String },
});

const Game = mongoose.model("Game", gameSchema);
module.exports = Game;
