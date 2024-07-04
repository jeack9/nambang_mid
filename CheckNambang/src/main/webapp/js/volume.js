/**
 * 
 */
document.querySelector(".dec").addEventListener("click", (e) => console.log(e.target.parentElement.children[1].value));
document.querySelector(".inc").addEventListener("click", (e) => console.log(e.target.parentElement.children[1].value));
//let tr = document.querySelector("tbody> tr:nth-of-type(1)").cloneNode(true);
//document.querySelector("tbody").appendChild(tr);