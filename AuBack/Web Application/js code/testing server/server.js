const http = require("http");
const fs = require("fs");
const path = require("path");

const hostname = "127.0.0.1";
const port = 3000;

const files = {
    "/": {
        path: "../../Codes/Auback/Home page/index.html",
        contentType: "text/html"
    },
    "/login": {
        path: "../../Codes/Auback/login/index.html",
        contentType: "text/html"
    },
    "/profile": {
        path: "../../Codes/Auback/profile/index.html",
        contentType: "text/html"
    },
    "/Hstyle.css": {
        path: "../../Codes/Auback/Home page/Hstyle.css",
        contentType: "text/css"
    },
    "/Lstyle.css": {
        path: "../../Codes/Auback/login/Lstyle.css",
        contentType: "text/css"
    },
    "/logo/A.png": {
        path: "../../Codes/Auback/logo/A.png",
        contentType: "image/png"
    },
    "/logo/full.png": {
        path: "../../Codes/Auback/logo/full.png",
        contentType: "image/png"
    }
};

const server = http.createServer((req, res) => {
    console.log(req.url);
    const url = req.url;
    const file = files[url];

    if (file) {
        fs.readFile(file.path, (err, data) => {
            if (err) {
                res.statusCode = 500;
                res.setHeader("Content-Type", "text/html");
                res.end("<h1>500 Internal Server Error</h1>");
            } else {
                res.statusCode = 200;
                res.setHeader("Content-Type", file.contentType);
                res.end(data);
            }
        });
    } else {
        res.statusCode = 404;
        res.setHeader("Content-Type", "text/html");
        res.end("<h1>404 Not Found</h1>");
    }
});

server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});
