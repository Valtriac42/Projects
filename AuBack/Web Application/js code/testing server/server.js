
const { google } = require('googleapis');
const http = require("http");
const fs = require("fs");
var ID_to_update = "hola1"
const path = require("path");

const hostname = "127.0.0.1";
const port = 3000;



const CLIENT_ID ='438743069163-lr5m1kvbu5f89rduusgg296subnfg9fe.apps.googleusercontent.com';
const CLIENT_SECRET = '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';
const REDIRECT_URI = 'https://developers.google.com/oauthplayground';
const REFRESH_TOKEN ='1//04SUewKb9OI4LCgYIARAAGAQSNwF-L9Ir2pubyscSAd_MsXyyPboDgKrykMV91BDedTXvjGEJsAIVGI4r-jwA28C5TW0avPHucQE'


const oauth2Client = new google.auth.OAuth2(
    CLIENT_ID,
    CLIENT_SECRET,
    REDIRECT_URI
);

oauth2Client.setCredentials({ refresh_token: REFRESH_TOKEN })



const drive= google.drive(
    {
        version:"v3",
        auth:oauth2Client
    }
)

const filePath = path.join(__dirname, '../girl.png')


//used to upload a specific file
async function uploadFile()
{
    try
    {
        const response = await drive.files.create(
        {
            requestBody:
            {
                name: 'beautifulgie/pngrl.png',
                mimeType: 'imag'
            },
            media:
            {
                mimeType: 'image/png',
                body: fs.createReadStream(filePath)
            }
        })
    
        console.log("done");
        console.log(response.data.id);
        ID_to_update= response.data.id;
        console.log("\n\n",response.data);
    }

    //to display error
    catch (error)
    {
        console.log(error.message);
    }
    
}



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
    },
    "/Pstyle.css": {
        path: "../../Codes/Auback/profile/Pstyle.css",
        contentType: "text/css"
    },
    "/upload": {
        path: "../app.js",
        contentType: "text/js"
    }
};

const server = http.createServer((req, res) => {
    console.log(req.url);
    const url = req.url;
    const file = files[url];
    if (url == "/upload")
        uploadFile();
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
            // const { message } = require('../app.js'); // Adjust the path to reach moduleA.js
            // console.log(message); // Output: Hello from moduleA!
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


