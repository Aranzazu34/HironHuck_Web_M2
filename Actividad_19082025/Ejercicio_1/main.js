//Live Server
//127.0.0.1:550/index.html

//crear una CARD de un personaje donde el usuario pueda pedir el id.
//Recuerda que puedes usar los string literals para ese objetivo.

const nombrePersonaje = document.getElementById("nombrepersonaje");
const imagenPersonaje = document.getElementById("imagenpersonaje");

const numeroPersonaje = document.getElementById("numeropersonaje"); //pilla el input

const botonNumero = document.getElementById("enviarnumero"); // pilla el botón

botonNumero.addEventListener("click", mostrarPersonaje);

const resultado = document.getElementById("resultado"); //pilla el div de resultado lista personaje/s

// funcion que llamamos al apretar el botón VER ID
function mostrarPersonaje() {
  let id = numeroPersonaje.value; //lee el numero del usuario
  let personajeURL = `https://rickandmortyapi.com/api/character/${id}`; //id variable
  fetch(personajeURL)
    .then((respuesta) => respuesta.json()) // convierte a JSON real la info recibida HTTP
    .then((data) => {
      //otra funcion anonima y aquí ya puedes ejecutar el codigo o llamar a otras funciones
      console.log(data);

      //mostrar en pantalla
      // dentro del parrafo vacio irá el nombre:
      //nombrepersonaje.innerHTML = data.name;

      //en la imagen, asignamos el source (src) de la imagen que queremos:
      //imagenpersonaje.src = data.image;

      //mostrar en pantalla

      resultado.innerHTML += `
        <br><br>
        <div style="text-align: center;">
           <u style="text-decoration: underline;">${data.name}</u>
        </div>        
        <br><br>
        <div margin: auto; style="width: 200px; height: 200px; background-color: blue; border: 1px solid grey; padding: 20px;">
        <img src=${data.image} style="display: block; margin: 0 auto; width: 100%; height: 100%;">
        </div>
        <br>
      `;
    })
    .catch((error) => console.log(error));
}
