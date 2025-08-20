const nombrePokemon = document.getElementById("nombrepokemon");
const imagenPokemon = document.getElementById("imagenpokemon");

const numeroUsuario = document.getElementById("numerousuario"); //pilla el input

const botonNumero = document.getElementById("enviarnumero"); // pilla el botón

botonNumero.addEventListener("click", mostrarPokemon);

const botonTodos = document.getElementById("botontodos");
botonTodos.addEventListener("click", mostrarTodos);

const resultado = document.getElementById("resultado"); //pilla el div de resultado lista pokemons

// funcion que llamamos al apretar el botón VER ID
function mostrarPokemon() {
  let id = numeroUsuario.value; //lee el numero del usuario
  let pokemonURL = `https://pokeapi.co/api/v2/pokemon/${id}`; //id variable
  fetch(pokemonURL)
    .then((respuesta) => respuesta.json()) // convierte a JSON real la info recibida HTTP
    .then((data) => {
      //otra funcion anonima y aquí ya puedes ejecutar el codigo o llamar a otras funciones
      console.log(data);

      //mostrar en pantalla
      // dentro del parrafo vacio irá el nombre:
      nombrePokemon.innerHTML = data.name;

      //en la imagen, asignamos el source (src) de la imagen que queremos:
      imagenPokemon.src = data.sprites.front_default;
    })
    .catch((error) => console.log(error));
}

// funcion que llamamos al apretar el botón VER TODO
function mostrarTodos() {
  resultado.innerHTML = "";
  for (let id = 1; id <= 20; id++) {
    let pokemonURL = `https://pokeapi.co/api/v2/pokemon/${id}`; //id variable
    fetch(pokemonURL)
      .then((respuesta) => respuesta.json()) // convierte a JSON real la info recibida HTTP
      .then((data) => {
        console.log(data.name);

        //mostrar en pantalla

        resultado.innerHTML += `
        <br>${data.name}<br>
        <div style="width: 250px; height: 250px; background-color: white; border: 1px solid grey; padding: 20px;">
        <img src=${data.sprites.other.dream_world.front_default} style="width: 100%; height: 100%;">
        </div>
        <br>
        `;

        // dentro del parrafo vacio irá el nombre:
        //nombrePokemon.innerHTML = data.name;

        //en la imagen, asignamos el source (src) de la imagen que queremos:
        //imagenPokemon.src = data.sprites.front_default;
      })
      .catch((error) => console.log(error));
  }
}
