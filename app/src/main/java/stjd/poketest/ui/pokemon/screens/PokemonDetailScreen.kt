package stjd.poketest.ui.pokemon.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import stjd.poketest.ui.pokemon.PokemonViewModel
import stjd.poketest.ui.pokemon.model.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    pokemonID: Int,
) {
    val navController = rememberNavController()
    val viewModel: PokemonViewModel = viewModel()
    val pokemons = viewModel.pokemonList.collectAsStateWithLifecycle()
    val pokemon = pokemons.value.firstOrNull { it.id == pokemonID }
    pokemon?.let {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(pokemon.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }) })
            }
        ) { inner ->
            DetailContent(pokemon, Modifier.padding(inner))
        }
    } ?: navController.popBackStack()
}

@Composable
private fun DetailContent(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Card(
            shape = RoundedCornerShape(28.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pokemon.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = pokemon.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                )

                Text(
                    text = pokemon.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                // Row with vertical dividers
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    tonalElevation = 2.dp,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        StatCell("Type", pokemon.type ?: "—")
                        VerticalDivider(
                            Modifier
                                .height(24.dp)
                                .padding(horizontal = 12.dp)
                        )
                        StatCell("Ht", "${pokemon.height?.div(10f)} m")
                        VerticalDivider(
                            Modifier
                                .height(24.dp)
                                .padding(horizontal = 12.dp)
                        )
                        StatCell("Wt", "${pokemon.weight?.div(10f)} kg")
                        VerticalDivider(
                            Modifier
                                .height(24.dp)
                                .padding(horizontal = 12.dp)
                        )
                    }
                }

                Text(
                    text = "Species: ${pokemon.species ?: "—"}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
private fun StatCell(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
    }
}
