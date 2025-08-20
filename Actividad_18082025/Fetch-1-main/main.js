//let id = 3;

let pokemonURL = "https://pokeapi.co/api/v2/pokemon/3";
const nombrePokemon = document.getElementById("nombrepokemon");
const imagenPokemon = document.getElementById("imagenpokemon");

// fetch conecta con la URl y concatena metodos (then y el catch)
fetch(pokemonURL)
.then((respuesta) => respuesta.json()) // convierte a JSON real la info recibida HTTP
.then((data) => {
    //otra funcion anonima y aquí ya puedes ejecutar el codigo o llamar a otras funciones
    console.log("todo:", data);
    console.log("moves:", data.moves);
    console.log("moves, el primero:", data.moves[0]);
    console.log("moves, el primero, solo valor de 'move':", data.moves[0].move);
    console.log("moves, el primero, valor de 'move' y valor del nombre:", data.moves[0].move.name);
    console.log("ver la ruta de front female:", data.sprites.front_female);
    console.log("llegar a clorofila: ", data.abilities[1].ability.name)

    //mostrar en pantalla
    // dentro del parrafo vacio irá el nombre:
    nombrePokemon.innerHTML = data.name;

    //en la imagen, asignamos el source (src) de la imagen que queremos:
    imagenPokemon.src = data.sprites.front_female;
})
.catch((error) => console.log(error));



/*
// directo con todos los pokemon:

let pokemonURL2 = "https://pokeapi.co/api/v2/pokemon";


fetch(pokemonURL2)
.then((respuesta) => respuesta.json()) 
.then((data) => {
    console.log("desde URL general pokemon:", data.results[3].name);
})
.catch((error) => console.log(error));*/