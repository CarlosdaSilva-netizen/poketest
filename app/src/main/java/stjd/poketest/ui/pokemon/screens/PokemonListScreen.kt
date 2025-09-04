package stjd.poketest.ui.pokemon.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import stjd.poketest.ui.pokemon.model.Pokemon
import stjd.poketest.ui.pokemon.PokemonViewModel
import stjd.poketest.ui.theme.PoketestTheme

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    viewModel: PokemonViewModel = viewModel(),
    onPokemonClick: (pokemonID: Int) -> Unit
) {
    val pokemons by viewModel.pokemonList.collectAsStateWithLifecycle()
    PokemonScreenContent(onPokemonClick, pokemons)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PokemonScreenContent(
    onPokemonClick: (Int) -> Unit,
    pokemons: List<Pokemon>
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Pokédex") })
        }
    ) { innerPadding ->
        if (pokemons.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 140.dp),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                items(
                    items = pokemons,
                    key = { it.name }
                ) { pokemon ->
                    PokemonFlipCard(
                        pokemon = pokemon,
                        onNavigateDetails = {
                            onPokemonClick(pokemon.id)
                        }

                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PokemonListScreenPreview() {
    PoketestTheme {
        PokemonScreenContent(
            onPokemonClick = {_ -> },
            pokemons = mockedPokemons
        )
    }
}

val mockedPokemons = listOf(
    Pokemon("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/", id = 1),
    Pokemon("ivysaur",   "https://pokeapi.co/api/v2/pokemon/2/", id = 1),
    Pokemon("venusaur",  "https://pokeapi.co/api/v2/pokemon/3/", id = 1),
    Pokemon("charmeleon","https://pokeapi.co/api/v2/pokemon/5/", id = 1),
    Pokemon("charizard", "https://pokeapi.co/api/v2/pokemon/6/", id = 1)
)