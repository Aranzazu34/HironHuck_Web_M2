const numeroPersonaje = document.getElementById("numero");
const botonEnviar = document.getElementById("botoncito");
let numeroInput;
let urlRM = "";

const contenedor = document.getElementById("contenedor");

botonEnviar.addEventListener('click', probarFetch);

function probarFetch() {
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

function verTodos(){
  urlRM = "https://rickandmortyapi.com/api/character"; ///?page=${numPagina}
  numeroPersonaje.value = "";
  fetch(urlRM)
    //.then(res => res.json())
    .then((res) => res.json())
    .then((data) => {
      // for of facilita recorrer los elementos de un array
      // primero nombras el elemento ('perso') y después el conjunto del array (data.results)
      for(let perso of data.results){
       // aqui se recorren todos uno a uno y se pueden ir añadiendo
       
       // crear fondo tarjeta
      let card = document.createElement('div');
      card.classList.add("card"); //añadir estilo CSS clase 'card'

      // crear elemento imagen
      let imagenPersonaje = document.createElement('img');
      imagenPersonaje.src = perso.image;

      // crear elemento parrafo
      let nombrePersonaje = document.createElement('p');
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
