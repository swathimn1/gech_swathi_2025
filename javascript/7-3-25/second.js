// function changeBackgroundColor(){
//     let h1=document.getElementById("h1tag");
//     h1.innerText="hello world";
//     h1.style.backgroundColor="yellow";
// }
document.addEventListener("DOMContentLoaded", function () {
    let h1Tag = document.getElementById("h1tag");
    let textNode = document.createTextNode("Hello, World!");
    h1Tag.appendChild(textNode); // Adding text using childNodes concept
    h1Tag.style.backgroundColor = "red"; // Setting background color
});