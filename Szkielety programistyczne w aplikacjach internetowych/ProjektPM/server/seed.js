const mongoose = require("mongoose");
const dotenv = require("dotenv");
const Game = require("./models/game");

dotenv.config();

mongoose
    .connect(process.env.DB, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
    })
    .then(() => console.log("Połączono z MongoDB Atlas..."))
    .catch((err) => console.error("Błąd połączenia z MongoDB", err));

const gry = [
    {
        title: "Cyberpunk 2077",
        description: "Gra RPG w otwartym świecie w futurystycznym Night City.",
        price: 129.99,
        coverImage: "https://cdn.example.com/cyberpunk2077.jpg",
    },
    {
        title: "The Witcher 3: Dziki Gon",
        description: "Przygody Geralta z Rivii w mrocznym świecie fantasy.",
        price: 89.99,
        coverImage: "https://cdn.example.com/witcher3.jpg",
    },
    {
        title: "Minecraft",
        description: "Gra o budowaniu i przetrwaniu z klocków w otwartym świecie.",
        price: 99.99,
        coverImage: "https://cdn.example.com/minecraft.jpg",
    },
    {
        title: "Grand Theft Auto V",
        description: "Kultowa gra akcji w otwartym świecie Los Santos.",
        price: 79.99,
        coverImage: "https://cdn.example.com/gta5.jpg",
    },
];

const seedGames = async () => {
    try {
        await Game.deleteMany(); // Wyczyść istniejące dane
        await Game.insertMany(gry);
        console.log("✅ Gry zostały załadowane do bazy danych.");
        mongoose.disconnect();
    } catch (err) {
        console.error("❌ Błąd podczas dodawania gier:", err);
        mongoose.disconnect();
    }
};

seedGames();
