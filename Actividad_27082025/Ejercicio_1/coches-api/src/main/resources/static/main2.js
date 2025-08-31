const imagenPerfil = document.getElementById("imagen");
const nombreCoche = document.getElementById("nombre");
const colorCoche = document.getElementById("color");
const plazasCoche = document.getElementById("plazas");

const inputId = document.getElementById("inputId");
const buscarBtn = document.getElementById("buscarBtn");

const contenedor = document.getElementById("contenedor");

//const urlCoches = "http://localhost:8080/coches";

//para que todo se ejecute desde el mismo sitio
//De esta forma, tanto el frontend como el backend estarán en el mismo origen (127.0.0.1), y el navegador no bloqueará
//la petición.
const urlCoches = "http://127.0.0.1:8080/coches";

/**
 * para probar el mostrar el coche que se solicite desde el INPUT
 **/
function buscarCochePorId(id) {
  if (!id) {
    alert("Por favor, introduce un ID válido.");
    return;
  }

  fetch(`${urlCoches}/${id}`)
    .then((res) => {
      if (!res.ok) {
        throw new Error("Coche no encontrado.");
      }
      return res.json();
    })
    .then((coche) => {
      console.log("Coche encontrado:", coche);

      // Actualizar contenido del DOM
      imagenPerfil.src = `images/${coche.imagen}`;
      imagenPerfil.alt = coche.modelo;
      imagenPerfil.style.display = "block";

      nombreCoche.innerText = coche.modelo;
      colorCoche.innerText = `Color: ${coche.color}`;
      plazasCoche.innerText = `Plazas: ${coche.num_plazas}`;
    })
    .catch((err) => {
      console.error(err);
      alert("Coche no encontrado o error al conectar con el servidor.");
      imagenPerfil.src = "";
      imagenPerfil.style.display = "none";
      nombreCoche.innerText = "No encontrado";
      colorCoche.innerText = "-";
      plazasCoche.innerText = "-";
    });
}

buscarBtn.addEventListener("click", () => {
  const id = inputId.value;
  buscarCochePorId(id);
});

//=================================

/**
 * para probar el mostrar el coche que se solicite desde el INPUT
 **/
function mostrarTodosModelos() {
  fetch(`${urlCoches}`)
    .then((res) => {
      if (!res.ok) {
        throw new Error("No hay datos de Coches.");
      }
      return res.json();
    })
    .then((data) => {
      // for of facilita recorrer los elementos de un array
      // primero nombras el elemento ('coche') y después el conjunto del array (data)
      for (let coche of data) {
        // aqui se recorren todos uno a uno y se pueden ir añadiendo

        console.log("Coche encontrado:", coche);

        // crear fondo tarjeta
        let card = document.createElement("div");
        card.classList.add("card"); //añadir estilo CSS clase 'card'

        // Actualizar contenido del DOM

        // imagen
        let imagenModelo = document.createElement("img");
        imagenModelo.src = `images/${coche.imagen}`;
        imagenModelo.alt = coche.modelo;
        imagenModelo.style.width = "250px";
        imagenModelo.style.borderRadius = "8px";

        // textos
        let textos = document.createElement("div");
        textos.classList.add("textos");

        let nombre = document.createElement("h2");
        nombre.innerText = coche.modelo;

        let color = document.createElement("p");
        color.innerText = `Color: ${coche.color}`;

        let plazas = document.createElement("p");
        plazas.innerText = `Plazas: ${coche.num_plazas}`;

        // montar elementos
        textos.appendChild(nombre);
        textos.appendChild(color);
        textos.appendChild(plazas);
        card.appendChild(imagenModelo);
        card.appendChild(textos);

        // añadir la tarjeta al contenedor:
        contenedor.appendChild(card);
      }
    });
}

//=================================

//función de pasos iniciales
function mostrarInicio() {
  fetch(urlCoches)
    .then((res) => res.json())
    .then((data) => {
      if (!data || data.length === 0) {
        console.log("No hay coches disponibles.");
        nombreCoche.innerText = "No hay coches";
        colorCoche.innerText = "-";
        plazasCoche.innerText = "-";
        imagenPerfil.style.display = "none";
        return;
      }

      //datos en consola para comprobar que se accede bien
      console.log(data);
      console.log("coche 10: ", data[10].imagen);

      // Elegir un coche al azar
      const randomIndex = Math.floor(Math.random() * data.length);
      const coche = data[randomIndex];

      console.log("Coche seleccionado:", coche);

      console.log("Valor de coche.modelo:", coche.modelo);

      // Actualizar contenido del DOM
      imagenPerfil.src = `images/${coche.imagen}`;
      imagenPerfil.alt = coche.modelo;
      imagenPerfil.style.display = "block";

      nombreCoche.innerText = coche.modelo;
      colorCoche.innerText = `Color: ${coche.color}`;
      plazasCoche.innerText = `Plazas: ${coche.num_plazas}`;
    })
    .catch((err) => console.log(err));
}
