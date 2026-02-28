const express = require('express')
const path = require('path')
const app = express()
const PORT = 3000
app.get("/form", (req, res) => {
 res.sendFile(path.join(__dirname, "form.html"))
})

app.get("/result", (req, res) => {
    let username = req.query.username
    let password = req.query.password
    res.send("Użytkownik: " + username + "<br>Hasło: " + password)
   })
   app.listen(PORT, ()=> console.log(`Serwer działa na porcie ${PORT}`))