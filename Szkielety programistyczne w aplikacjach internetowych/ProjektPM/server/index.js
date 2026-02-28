require('dotenv').config()
const express = require('express')
const app = express()
const cors = require('cors')
const connection = require('./db')
connection()
//middleware
app.use(express.json())
app.use(cors())

// routes

const tokenVerification = require('./middleware/tokenVerification')
const userRoutes = require("./routes/users")
const authRoutes = require("./routes/auth")
app.use((req, res, next) => {
  console.log(`REQ: ${req.method} ${req.url}`);
  next();
});
app.use("/api/users", userRoutes)
app.use("/api/auth", authRoutes)
const gamesRoute = require("./routes/games");
app.use("/api/games", gamesRoute);
const commentsRouter = require('./routes/comments');
app.use('/api/comments', commentsRouter);

const port = process.env.PORT || 8080
app.listen(port, () => console.log(`Nasłuchiwanie na porcie ${port}`))

