//Live Server
//127.0.0.1:550/index.html

//let id = 3;

let berryURL = "https://pokeapi.co/api/v2/berry/2";

const nombreBerry = document.getElementById("nombreberry");
const imagenBerry = document.getElementById("imagenberry");

//fetch conecta con la URL y concatena metodos (then y el catch)
fetch(berryURL)
  .then((respuesta) => respuesta.json()) //convierte a JSON real la info recibida HTTP
  .then((data) => {
    //otra función anónima y aquí ya puedes ejecutar
    //el código o llamar a otras funciones
    console.log("todo:", data);

    //mostrar en pantalla
    //dentro del parrafo vacío irá el nombre:
    nombreBerry.innerHTML = data.name;

    //en la imagen, asignamos el source (src) de la imagen que queremos:
    imagenBerry.src = data.natural_gift_type.url;
  })
  .catch((err) => console.log(err));

/*
// directo con todos los Berry:

let berryURL2 = "https://pokeapi.co/api/v2/Berry";

fetch(berryURL2)
.then((respuesta) => respuesta.json()) 
.then((data) => {
    console.log("desde URL general Berry:", data.results[3].name);
})
.catch((error) => console.log(error));
  */
