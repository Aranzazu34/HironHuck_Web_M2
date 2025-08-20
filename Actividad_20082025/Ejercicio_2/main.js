//Live Server
//127.0.0.1:550/index.html

//crear una CARD de un personaje donde el usuario pueda pedir el id.
//Recuerda que puedes usar los string literals para ese objetivo.

/*
Prueba a usar classList y createElement + appendChild para visualizar una lista de resultados en tu web de 
Rick & Morty u otra.

Después prueba a mejorar la disposición y estilo del conjunto de la página.

(si alguien quiere experimentar con foreach en vez de for of y async/await en vez del then, adelante!)

*/

const numeroPersonaje = document.getElementById("numeropersonaje"); //pilla el input
const botonNumero = document.getElementById("enviarnumero"); // pilla el botón
let numeroInput;
let urlRM = "";

const contenedor = document.getElementById("contenedor");

botonNumero.addEventListener("click", mostrarPersonaje);

function mostrarPersonaje() {
  numeroInput = parseInt(numeroPersonaje.value);

  urlRM = `https://rickandmortyapi.com/api/character/${numeroInput}`;
  numeroPersonaje.value = "";
  fetch(urlRM)
    //.then(res => res.json())
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
    })
    .catch((err) => {
      console.error("Error:", err);
    });
}

function verTodos() {
  urlRM = "https://rickandmortyapi.com/api/character"; ///?page=${numPagina}
  numeroPersonaje.value = "";
  fetch(urlRM)
    //.then(res => res.json())
    .then((res) => res.json())
    .then((data) => {
      // for of facilita recorrer los elementos de un array
      // primero nombras el elemento ('perso') y después el conjunto del array (data.results)
      for (let perso of data.results) {
        // aqui se recorren todos uno a uno y se pueden ir añadiendo

        // crear fondo tarjeta
        let card = document.createElement("div");
        card.classList.add("card"); //añadir estilo CSS clase 'card'

        // crear elemento imagen
        let imagenPersonaje = document.createElement("img");
        imagenPersonaje.src = perso.image;

        // crear elemento parrafo
        let nombrePersonaje = document.createElement("p");
        nombrePersonaje.innerText = perso.name;

        //añadir imagen y texto a la tarjeta:
        card.appendChild(imagenPersonaje);
        card.appendChild(nombrePersonaje);

        // añadir la tarjeta al contenedor:
        contenedor.appendChild(card);
      }

      /* for each para cada uno llama a una función. No funciona bien con async/await
      data.results.forEach(perso => {
        console.log(perso.name);
      });*/
    })
    .catch((err) => {
      console.error("Error:", err);
    });
}
