// import fs from 'fs';
const { google } = require('googleapis');
const path = require('path')
const fs = require('fs')
var ID_to_update = "hola1"



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

const filePath = path.join(__dirname, 'girl.png')



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


//for deleting file
async function deleteFile()
{
    try
    {
        const response = await drive.files.delete(
        {
            fileId: ID_to_update,
        });
        console.log(response.data, response.status);
        console.log("file deleted sucessfully");
    }
    catch (error)
    {
        console.log(error.message);
    }
}

//for downloading or generating the url of the file

async function generatePublicUrl()
{
    try
    {
        const fileId = '1YWE6woUdllmp8dRcr8l6OUXeaK05uV_3';
        await drive.permissions.create(
        {
            fileId: fileId,
            requestBody:
            {
                role: 'reader',
                type: 'anyone',
            },
        });
        const result = await drive.files.get(
        {
            fileId: fileId,
            fields: 'webViewLink, webContentLink',
        });
        console.log(result.data);
    }
    catch (error)
    {
        console.log(error.message);
    }
}

//for taking inputs 
function storeFilePath() {
    // Get the value from the input field
    const filePath = document.getElementById('filePathInput').value;

    // Check if the input is not empty
    if (filePath) {
        // Store the file path (for example, in the local storage)
        localStorage.setItem('filePath', filePath);

        // Display a message or perform any other action
        alert(`File path "${filePath}" stored successfully!`);

        console.log("file path is ",filePath);
        uploadFile();
        
    }
    else
    {
        alert('Please enter a file path.');
    }
}




async function running(){
    uploadFile();


    // time interval
    var hu=1;
    var interval= setInterval(()=>{
        deleteFile();
        hu=hu+1;
        if(hu=2)
            clearInterval(interval);
    },15000)
    
    
    
    
}
running()
//generatePublicUrl();
//storeFilePath();
