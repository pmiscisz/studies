/* 1.3
const http = require('http')

function process_request(req, res) {
 const body = 'Witaj na platformie Node!\n'
 const content_length = body.length
 res.writeHead(200, {
 'Content-Length': content_length,
 'Content-Type': 'text/plain'
 });
 res.end(body)
}

const server = http.createServer(process_request)
server.listen(3000, () => console.log('Serwer działa!'))

function fibonacci(num){ 
    let a = 1;
    let b = 0;
    let temp;
    while (num >= 0){ 
        temp = a 
        a = a + b 
        b = temp 
        num-- 
    }   
    return b 
} 

console.log(fibonacci(5))
*/
/* 1.4
const http = require('http') 
const fs = require('fs') 
const port = 3000 
 
function serveStaticFile(res, path, contentType, responseCode = 200){ 
    fs.readFile(__dirname + path, (err, data) => { 
        if(err){ 
            res.writeHead(500, { 'Content-Type': 'text/plain'}) 
            return res.end('500 - Blad wewnetrzny') 
        } 
        res.writeHead(responseCode, { 'Content-Type':contentType}) 
        res.end(data) 
    }) 
} 
 
const server = http.createServer((req, res) => { 
    switch(req.url){ 
        case '/': 
         serveStaticFile(res, '/public/home.html', 'text/html' ) 
            break 
        case '/about': 
         serveStaticFile(res, '/public/about.html', 'text/html' ) 
        break 
        case '/logo.jpg': 
            serveStaticFile(res, '/public/img/logo.jpg', 'image/jpg' ) 
            break 
        default: 
          serveStaticFile(res, '/public/404.html','text/html' ) 
          break 
    } 
}) 
 
server.listen(port, () => console.log(`Server działa na porcie ${port}; `+ 'naciśnij Ctrl+C, aby zakończyć'))
*/

// 1.4

// const http = require('http')
// const url = require('url')
// http.createServer(function (req, res) {
//  res.writeHead(200, {'Content-Type': 'text/html'})
//  let q = url.parse(req.url, true).query
//  let txt = q.year + " " + q.month + " " + q.day
//  res.end(txt)
// }).listen(3000)

const http = require('http');
const url = require('url');

http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  let q = url.parse(req.url, true).query;
  let a = parseFloat(q.a);
  let b = parseFloat(q.b);
  let c = parseFloat(q.c);

  if(isNaN(a) || isNaN(b) || isNaN(c)){
    res.end('Podane boki trojkata nie sa liczbami!');
  }
  else if (a <= 0 || b <= 0 || c <= 0) {
    res.end('Dlugosci bokow musza byc wieksze od zera!');
  } 
  else if (a + b <= c || a + c <= b || b + c <= a) {
    res.end(`Dane: ${a} ${b} ${c} <br>To nie jest trojkat!`);
  }
  else{
    let s = (a + b + c) / 2;
    let area = Math.sqrt(s * (s - a) * (s - b) * (s - c)).toFixed(2);
    res.end(`Dane: ${a} ${b} ${c} <br>Pole powierzchni trojkata wynosi: ${area}`);
  }
}).listen(3000, () => console.log('Server działa na porcie 3000; naciśnij Ctrl+C, aby zakończyć'));
//http://localhost:3000/?a=3&b=4&c=5


// 1.5
/*
const http = require("http"); 
const hostname = "localhost"; 
const port = 3000; 

const server = http.createServer((req, res) => { 
  res.statusCode = 200; 
  res.setHeader("Content-Type", "text/html"); 
  res.end(`
    <html>
      <head>
        <title>Aplikacja w Node</title>
        <style>
          body {
            font-family: Arial, sans-serif;
          }
          h1 {
            font-size: 24px;
            font-weight: bold;
          }
          p {
            font-size: 18px;
            font-weight: bold;
          }
          ul {
            list-style-type: none;
            padding: 0;
          }
          li {
            font-size: 18px;
            font-weight: bold;
          }
        </style>
      </head>
      <body>
        <h1>Aplikacja w Node</h1>
        <p>To jest odpowiedz HTML</p>
        <ul>
          <li>1.</li>
          <li>2.</li>
          <li>3.</li>
        </ul>
      </body>
    </html>
  `);
}); 

server.listen(port, hostname, () => { 
  console.log(`Server running at http://${hostname}:${port}/`); 
});
*/
 
// 1.6
/*
const http = require('http');
const fs = require('fs');
const port = 3000;

function serveStaticFile(res, path, contentType, responseCode = 200) {
    fs.readFile(__dirname + path, (err, data) => {
        if (err) {
            res.writeHead(500, { 'Content-Type': 'text/plain' });
            return res.end('500 - Blad wewnetrzny');
        }
        res.writeHead(responseCode, { 'Content-Type': contentType });
        res.end(data);
    });
}

const server = http.createServer((req, res) => {
    switch (req.url) {
        case '/': 
         serveStaticFile(res, '/public/home.html', 'text/html' ) 
            break; 
        case '/home': 
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            res.end('Strona domowa'); 
            break; 
        case '/about': 
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            res.end('Strona o mnie');
        break; 
        case '/logo.jpg': 
            serveStaticFile(res, '/public/img/logo.jpg', 'image/jpg' ) 
            break; 
        case '/lab5':
            res.writeHead(200, { 'Content-Type': 'text/plain' });
            res.end('lab5!');
            break;
        default:
            res.writeHead(404, { 'Content-Type': 'text/plain' });
            res.end('Nie znaleziono');
            break;
    }
});

server.listen(port, () => console.log(`Server działa na porcie ${port}; naciśnij Ctrl+C, aby zakończyć`));
*/

// 1.7

/*
const http = require('http');
let items = [];
const server = http.createServer(function (req, res) {
    if ('/' == req.url) {
        switch (req.method) {
            case 'GET':
                show(res);
                break;
            case 'POST':
                add(req, res);
                break;
            default:
                badRequest(res);
        }
    }
    else {
        notFound(res);
    }
});

const port = 3000;
server.listen(3000, () => console.log(`Server działa na porcie ${port}; naciśnij Ctrl+C, aby zakończyć`));

function show(res) {
    let html = '<html><head><title>Lista zadań</title></head><body>'
        + '<h1>Lista zadań</h1>'
        + '<form method="post" action="/" style="display: inline-block;">'
        + '<input type="text" name="item" />'
        + '<input type="submit" value="Dodaj" />'
        + '</form>'
        + '<form method="post" action="/" style="display: inline-block; margin-left: 10px;">'
        + '<input type="hidden" name="action" value="remove" />'
        + '<input type="submit" value="Skasuj" />'
        + '</form>'
        + '<ul>'
        + items.map(function (item) {
            return '<li>' + item + '</li>';
        }).join('')
        + '</ul>'
        + '</body></html>';

    res.setHeader("Content-Type", "text/html; charset=utf-8");
    res.setHeader('Content-Length', Buffer.byteLength(html));
    res.end(html);
}


function notFound(res) {
    res.statusCode = 404;
    res.setHeader('Content-Type', 'text/plain');
    res.end('Not Found');
}

let qs = require('querystring');

function add(req, res) {
    var body = '';
    req.setEncoding('utf8');
    req.on('data', function (chunk) { body += chunk });
    req.on('end', function () {
        var obj = qs.parse(body);
        
        if (obj.action === 'remove') {
            items = [];
        } else if (obj.item) {
            items.push(obj.item);
        }
        show(res);
    });
}

function badRequest(res) {
    res.statusCode = 400;
    res.setHeader('Content-Type', 'text/plain');
    res.end('Bad Request');
}
*/