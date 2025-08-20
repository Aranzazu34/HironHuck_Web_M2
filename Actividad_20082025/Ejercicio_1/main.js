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

//Ver todos los personajes FETCH/THEN
function verTodos() {
  // Limpia el contenido del div con id "resultado"
  document.getElementById("contenedor").innerHTML = "";

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

//Ver 4 personajes primeros FOR EACH/LIST
async function verTodos1() {
  // Limpia el contenido del div con id "resultado"
  document.getElementById("contenedor").innerHTML = "";

  try {
    //MOSTRAR LOS 4 PRIMEROS
    const response = await fetch(
      "https://rickandmortyapi.com/api/character?limit=4"
    );
    const data = await response.json();
    //solo con limit=4
    const personajeList = data.results.slice(0, 4); // Tomamos los primeros 4 personajes

    // Obtener detalles de todos los personajes en paralelo
    const personajeDetails = await Promise.all(
      personajeList.map(async (personaje) => {
        try {
          const personajeData = await fetch(personaje.url);
          return await personajeData.json();
        } catch (err) {
          console.error(`Error cargando detalles de ${personaje.name}:`, err);
          return null;
        }
      })
    );

    // Usar fragmento de documento para optimizar inserciones al DOM
    const fragment = document.createDocumentFragment();

    //if (personajeDetails && personajeDetails.length > 0) {
    personajeDetails.forEach((personajeJson) => {
      if (!personajeJson) return;
      const card = document.createElement("div");
      card.classList.add("card");
      card.innerHTML = `
            <img src="${personajeJson.image}" alt="${personajeJson.name}">
            <h3>${personajeJson.name.toUpperCase()}</h3>
            <p>ID: #${personajeJson.id}</p>
            <p>Status: ${personajeJson.status}</p>
            <p>Species: ${personajeJson.species}</p>
          `;
      fragment.appendChild(card);
    });

    contenedor.appendChild(fragment);
    /*
    } else {
      contenedor.textContent = "No se encontraron registros.";
    }
    */
  } catch (error) {
    console.error("Error cargando Personaje:", error);
  }
}

//Ver 4 personajes a partir del 10 FOR EACH/LIST
async function verTodos2() {
  // Limpia el contenido del div con id "resultado"
  document.getElementById("contenedor").innerHTML = "";

  try {
    //MOSTRAR 4 A PARTIR DEL PERSONAJE 10
    const response = await fetch(
      "https://rickandmortyapi.com/api/character?offset=10&limit=4"
    );
    const data = await response.json();
    // Ajusta el offset y el límite
    const offset = 10;
    const limit = 4;
    const startIndex = offset;
    const endIndex = offset + limit;
    const personajeList = data.results.slice(startIndex, endIndex); // Tomamos los primeros 4 personajes
    //const personajeList = await response.json();

    // Obtener detalles de todos los personajes en paralelo
    const personajeDetails = await Promise.all(
      personajeList.map(async (personaje) => {
        try {
          const personajeData = await fetch(personaje.url);
          return await personajeData.json();
        } catch (err) {
          console.error(`Error cargando detalles de ${personaje.name}:`, err);
          return null;
        }
      })
    );

    // Usar fragmento de documento para optimizar inserciones al DOM
    const fragment = document.createDocumentFragment();

    //if (personajeDetails && personajeDetails.length > 0) {
    personajeDetails.forEach((personajeJson) => {
      if (!personajeJson) return;
      const card = document.createElement("div");
      card.classList.add("card");
      card.innerHTML = `
            <img src="${personajeJson.image}" alt="${personajeJson.name}">
            <h3>${personajeJson.name.toUpperCase()}</h3>
            <p>ID: #${personajeJson.id}</p>
            <p>Status: ${personajeJson.status}</p>
            <p>Species: ${personajeJson.species}</p>
          `;
      fragment.appendChild(card);
    });

    contenedor.appendChild(fragment);
    /*
    } else {
      contenedor.textContent = "No se encontraron registros.";
    }
    */
  } catch (error) {
    console.error("Error cargando Personaje:", error);
  }
}
