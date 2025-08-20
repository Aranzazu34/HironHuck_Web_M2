const pokedex = document.getElementById("pokedex");


// Función optimizada para traer datos de la API
async function fetchPokemons() {
  try {
    const response = await fetch("https://pokeapi.co/api/v2/pokemon?limit=20");
    const data = await response.json();
    const pokemonList = data.results;

    // Obtener detalles de todos los Pokémon en paralelo
    const pokemonDetails = await Promise.all(
      pokemonList.map(async (pokemon) => {
        try {
          const pokeData = await fetch(pokemon.url);
          return await pokeData.json();
        } catch (err) {
          console.error(`Error cargando detalles de ${pokemon.name}:`, err);
          return null;
        }
      })
    );

    // Usar fragmento de documento para optimizar inserciones al DOM
    const fragment = document.createDocumentFragment();
    pokemonDetails.forEach((pokeJson) => {
      if (!pokeJson) return;
      const card = document.createElement("div");
      card.classList.add("card");
      card.innerHTML = `
        <img src="${pokeJson.sprites.front_default}" alt="${pokeJson.name}">
        <h3>${pokeJson.name.toUpperCase()}</h3>
        <p>ID: #${pokeJson.id}</p>
        <p>Tipo: ${pokeJson.types.map(t => t.type.name).join(", ")}</p>
      `;
      fragment.appendChild(card);
    });
    pokedex.appendChild(fragment);
  } catch (error) {
    console.error("Error cargando Pokémon:", error);
  }
}

fetchPokemons();
