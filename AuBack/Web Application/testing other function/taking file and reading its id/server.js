const express = require('express');
const multer = require('multer');
const fs = require('fs');
const path = require('path');

const app = express();
const port = 3000;

// Configure multer for file uploads
const upload = multer({ dest: 'uploads/' });

// Serve the HTML form
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

// Handle file upload
app.post('/upload', upload.single('file'), (req, res) => {
  const filePath = req.file.path;

  // Read the uploaded file
  fs.readFile(filePath, 'utf8', (err, data) => {
    if (err) {
      console.error('Error reading the file', err);
      return res.status(500).send('Error reading the file');
    }

    // Split the data using the "^" delimiter
    const ids = data.split('^');


    // Print each ID one by one
    ids.forEach((id, index) => {
      console.log(`ID ${index + 1}: ${id}`);
    });

    // Respond to the client
    res.send('<script>alert("File uploaded successfully!"); window.location.href="/";</script>');
  });
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
