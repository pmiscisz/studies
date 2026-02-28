const mongoose = require("mongoose");

const commentSchema = new mongoose.Schema({
  content: { type: String, required: true },
  user: { type: mongoose.Schema.Types.ObjectId, ref: "User" },
  game: { type: mongoose.Schema.Types.ObjectId, ref: "Game" },
}, { timestamps: true });

module.exports = mongoose.model("Comment", commentSchema);
