/*-----===VARIABLES===-----*/
const form = document.querySelector("form");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    let nome = document.getElementById("nome").value;
    
    if(nome == ""){
        alert("Nome vazio!");
    }
})