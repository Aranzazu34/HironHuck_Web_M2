//Live Server
//127.0.0.1:550/index.html

/*
2- ENTRENAMIENTO: en la API del Pokemon, busca elementos que estén anidados e intenta acceder a ellos. 
Por ejemplo, cómo accedes a :

name: machine

en el pokemon numero 7 ?

{
          "level_learned_at": 0,
          "move_learn_method": {
            "name": "machine",
            "url": "https://pokeapi.co/api/v2/move-learn-method/4/"
          },
*/

const nombrePokemon = document.getElementById("nombrepokemon");
const imagenPokemon = document.getElementById("imagenpokemon");

const botonVer = document.getElementById("verinformacion"); // pilla el botón

botonVer.addEventListener("click", mostrarPokemon);

// funcion que llamamos al apretar el botón VER ID
async function mostrarPokemon() {
  //let id = numeroPokemon.value; //lee el numero del usuario
  let PokemonURL = `https://pokeapi.co/api/v2/pokemon/3`; //id variable
  fetch(PokemonURL)
    .then((respuesta) => respuesta.json()) // convierte a JSON real la info recibida HTTP
    .then((data) => {
      //otra funcion anonima y aquí ya puedes ejecutar el codigo o llamar a otras funciones
      console.log(data);

      //mostrar en pantalla
      // dentro del parrafo vacio irá el nombre:
      nombrePokemon.innerHTML = `
        <br>${data.name}<br>
        <div style="width: 250px; height: 250px; background-color: white; border: 1px solid grey; padding: 20px;">
        <p>${data.types[0].type.name}</p>
        <p>${data.types[1].type.name}</p>
        </div>
        <br>
        `;

      //en la imagen, asignamos el source (src) de la imagen que queremos:
      imagenPokemon.src = data.sprites.front_shiny;

      //mostrar en pantalla

      /*
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
      */
    })
    .catch((error) => console.log(error));
}
