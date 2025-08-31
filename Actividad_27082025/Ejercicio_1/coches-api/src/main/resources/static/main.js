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

function buscarCochePorId(id) {
  if (!id) {
    alert("Por favor, introduce un ID válido.");
    return;
  }

  limpiarContenido(); // Limpiar antes de mostrar

  // Verificar si la tarjeta está inicialmente oculta
  console.log(
    "Tarjeta individual antes de mostrar:",
    tarjetaIndividual.classList
  );

  // Asegúrate de eliminar la clase .oculto para mostrar la tarjeta
  tarjetaIndividual.classList.remove("oculto");

  // Verificar si la tarjeta se mostró correctamente
  console.log(
    "Tarjeta individual después de mostrar:",
    tarjetaIndividual.classList
  );

  fetch(`${urlCoches}/${id}`)
    .then((res) => {
      if (!res.ok) {
        throw new Error("Coche no encontrado.");
      }
      return res.json();
    })
    .then((coche) => {
      console.log("Coche encontrado:", coche); // Añadido para depurar

      // Depura aquí
      console.log("ssTarjeta antes de mostrar: ", tarjetaIndividual.classList);

      // Actualizar los detalles de la tarjeta individual
      imagenPerfil.src = `images/${coche.imagen}`;
      console.log("Ruta de imagen:", imagenPerfil.src);

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

  // Limpiar contenedor de tarjetas anteriores
  contenedor.innerHTML = "";

  // Asegurarse de que el contenedor de tarjetas se muestre
  contenedor.classList.remove("oculto");

  // Ocultar la tarjeta individual
  tarjetaIndividual.classList.add("oculto");

  fetch(`${urlCoches}`)
    .then((res) => {
      if (!res.ok) throw new Error("No hay datos de Coches.");
      return res.json();
    })
    .then((data) => {
      contenedor.classList.remove("oculto");

      // Recorre los coches y genera las tarjetas
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
