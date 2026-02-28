const express = require('express'); 
const path = require('path'); 
const app = express(); 
const PORT = 3000; 

app.use(express.json()); 
app.use(express.urlencoded({ extended: true }));

// === Zadanie 1.13 – Middleware ===
let metodaLog = (req, res, next) => {
    console.log("Metoda:", req.method);
    console.log("Ścieżka:", req.protocol + "://" + req.get('host') + req.originalUrl);
    next();
};
app.use(metodaLog);


let metodaHTML = (req, res, next) => {
    const info = `
        <h2>Metoda: ${req.method}</h2>
        <p>Ścieżka: ${req.protocol}://${req.get('host')}${req.originalUrl}</p>
    `;
    res.send(info);
};

app.use('/middleware-test', metodaHTML);


app.get('/', function (req, res) {
    res.send('Szkielet programistyczny Express!');
});

app.get('/about', (req, res) => {
    res.send('Autor strony: Jan Kowalski');
});

// 1.9 - Parametry w URL
app.get('/name/:imie', function (request, response) {
    response.status(200);
    response.set('Content-Type', 'text/html');
    response.end('<html><body>' + '<h1>Cześć ' + request.params.imie + '</h1>' + '</body></html>');
});

// 1.11 - Walidacja
const { check, validationResult } = require('express-validator');

function alreadyHaveEmail(email) {
    const existingEmails = ['test@example.com', 'user@example.com'];
    return existingEmails.includes(email);
}

function createInitials(fullname) {
    return fullname.split(' ')
        .map(name => name.charAt(0).toUpperCase())
        .join('');
}

app.get('/form2', (req, res) => {
    res.sendFile(path.join(__dirname, 'form2.html'));
});

app.post('/form2', [
    check('fullname')
        .trim()
        .stripLow()
        .customSanitizer(createInitials),

    check('nazwisko')
        .trim()
        .stripLow()
        .isAlpha().withMessage('Nazwisko może zawierać tylko litery')
        .isLength({ min: 3, max: 25 }).withMessage('Nazwisko musi zawierać od 3 do 25 znaków'),

    check('email')
        .trim()
        .normalizeEmail()
        .isEmail().withMessage('Niepoprawny adres email')
        .custom(email => {
            if (alreadyHaveEmail(email)) {
                throw new Error('Email już istnieje!');
            }
            return true;
        }),

    check('wiek')
        .bail()
        .isInt({ min: 0, max: 110 }).withMessage('Wiek musi być liczbą z zakresu 0–110'),

], (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        return res.status(400).json({ errors: errors.array() });
    }

    const { fullname, nazwisko, email, wiek } = req.body;
    res.send(`Użytkownik: ${fullname} ${nazwisko}<br>Email: ${email}<br>Wiek: ${wiek}`);
});

// 1.12 - API użytkowników
const users = require('./users');

app.get('/api/users', (req, res) => { 
    res.json(users);
});

app.get('/api/users/:id', (req, res) => { 
    const found = users.some(user => user.id === parseInt(req.params.id));
    if (found) {
        res.json(users.filter(user => user.id === parseInt(req.params.id)));
    } else {
        res.status(400).json({ message: `Użytkownik o id ${req.params.id} nie został znaleziony` });
    }
});

app.post('/api/users', (req, res) => { 
    const existingIds = users.map(user => user.id);
    let newId = 1;
    while (existingIds.includes(newId)) {
        newId++;
    }

    const newUser = {
        id: newId,
        name: req.body.name,
        email: req.body.email,
        status: "aktywny"
    };
    if (!newUser.name || !newUser.email) { 
        return res.status(400).json({ msg: 'Wprowadź poprawne imię i nazwisko oraz email!' }) 
    } 
    users.push(newUser); 
    res.json(users); 
});

app.patch('/api/users/:id', (req, res) => { 
    const id = parseInt(req.params.id);
    if (users.some(user => user.id === id)) {  
        const user = users.find(user => user.id === id); 
        const updUser = req.body;
        user.name = updUser.name ? updUser.name : user.name;
        user.email = updUser.email ? updUser.email : user.email;
        res.json({ msg: 'Dane użytkownika zaktualizowane', user }); 
    } else { 
        res.status(400).json({ msg: `Użytkownik o id ${id} nie istnieje!` }); 
    } 
});

app.delete('/api/users/:id', (req, res) => {
    const id = parseInt(req.params.id);
    const userIndex = users.findIndex(user => user.id === id);
    if (userIndex !== -1) {
        users.splice(userIndex, 1);
        res.json({ msg: 'Użytkownik usunięty', users });
    } else {
        res.status(400).json({ msg: `Użytkownik o id ${id} nie istnieje!` });
    }
});

// Start serwera
app.listen(PORT, () => console.log(`Serwer działa na porcie ${PORT}`));
