const fs = require('fs');

const just_create ="";
const data = 'Hello, this is a sample text file!';
const next_line ="^";



// Create a file
function Create_ID_file(){
    fs.writeFile('ID_of_file.txt', just_create, (err) => {
        if (err) {
          console.error('Error in creating a file', err);
        } else {
          console.log('File has been created');
        }
    });
}



// adding a ^ in the file 
function Add_char_in_ID(){
    fs.appendFile("ID_of_file.txt",next_line, (err)=>{
        if (err) {
            console.error('Error in adding a text in the file', err);
          } else {
            console.log('Text has been added in the text file');
          }
    });
}


// add text in the file
function Adding_text_in_file(){
    fs.appendFile("ID_of_file.txt",data, (err)=>{
        if (err) {
            console.error('Error in adding a text in the file', err);
          } else {
            console.log('Text has been added in the text file');
          }
    });
}


//read
fs.readFile('ID_of_file.txt', 'utf8', (err, data) => {
    if (err) {
      console.error('Error reading the file', err);
      return;
    }
  
    // Split the data using the "^" delimiter
    const ids = data.split('^');
  
    // Print each ID one by one
    ids.forEach((id, index) => {
      console.log(`ID ${index + 1}: ${id}`);
      
    });
  });
