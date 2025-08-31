const imagenPerfil = document.getElementById("imagen");
const nombreCoche = document.getElementById("nombre");
const colorCoche = document.getElementById("color");
const plazasCoche = document.getElementById("plazas");

const inputId = document.getElementById("inputId");
const buscarBtn = document.getElementById("buscarBtn");
const mostrarTodosBtn = document.getElementById("mostrarTodosBtn");
const limpiarBtn = document.getElementById("limpiarBtn");

const tarjetaIndividual = document.getElementById("tarjeta-individual");
const contenedor = document.getElementById("contenedor");

const urlCoches = "http://127.0.0.1:8080/coches";

// 🔹 Función para limpiar resultados previos
function limpiarContenido() {
  // Ocultar y limpiar tarjeta individual
  tarjetaIndividual.classList.add("oculto");
  imagenPerfil.src = "";
  nombreCoche.innerText = "";
  colorCoche.innerText = "";
  plazasCoche.innerText = "";

  // Ocultar y limpiar contenedor múltiple
  contenedor.classList.add("oculto");
  contenedor.innerHTML = "";
}

// 🔹 Buscar coche por ID
function buscarCochePorId(id) {
  if (!id) {
    alert("Por favor, introduce un ID válido.");
    return;
  }

  limpiarContenido(); // 🧹 limpiar antes de mostrar

  tarjetaIndividual.classList.remove("oculto");

  fetch(`${urlCoches}/${id}`)
    .then((res) => {
      if (!res.ok) {
        throw new Error("Coche no encontrado.");
      }
      return res.json();
    })
    .then((coche) => {
      tarjetaIndividual.classList.remove("oculto");
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
    });
}

// 🔹 Mostrar todos los modelos
function mostrarTodosModelos() {
  limpiarContenido(); // 🧹 limpiar antes de mostrar

  //Antes de pintar los coches, limpia el contenedor (para que no se acumulen):
  contenedor.innerHTML = "";

  //También asegúrate que la lista de tarjetas (contenedor) se muestre (quita .oculto):
  contenedor.classList.remove("oculto");

  //Oculta la tarjeta individual para que no confunda:
  tarjetaIndividual.classList.add("oculto");

  fetch(`${urlCoches}`)
    .then((res) => {
      if (!res.ok) throw new Error("No hay datos de Coches.");
      return res.json();
    })
    .then((data) => {
      contenedor.classList.remove("oculto");

      for (let coche of data) {
        const card = document.createElement("div");
        card.classList.add("card");

        const imagenModelo = document.createElement("img");
        imagenModelo.src = `images/${coche.imagen}`;
        imagenModelo.alt = coche.modelo;

        const textos = document.createElement("div");
        textos.classList.add("textos");

        const nombre = document.createElement("h2");
        nombre.innerText = coche.modelo;

        const color = document.createElement("p");
        color.innerText = `Color: ${coche.color}`;

        const plazas = document.createElement("p");
        plazas.innerText = `Plazas: ${coche.num_plazas}`;

        textos.appendChild(nombre);
        textos.appendChild(color);
        textos.appendChild(plazas);

        card.appendChild(imagenModelo);
        card.appendChild(textos);
        contenedor.appendChild(card);
      }
    })
    .catch((err) => {
      console.error(err);
      alert("Error al obtener los modelos.");
    });
}

// 🔹 Eventos de botones
buscarBtn.addEventListener("click", () => {
  const id = inputId.value;
  buscarCochePorId(id);
});

mostrarTodosBtn.addEventListener("click", () => {
  mostrarTodosModelos();
});

limpiarBtn.addEventListener("click", limpiarContenido);
