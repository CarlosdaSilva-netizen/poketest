// MainActivity.kt
package stjd.poketest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import stjd.poketest.ui.pokemon.model.Pokemon
import stjd.poketest.ui.pokemon.screens.PokemonDetailScreen
import stjd.poketest.ui.pokemon.screens.PokemonListScreen
import stjd.poketest.ui.theme.PoketestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PoketestTheme {
                AppNav()
            }
        }
    }
}

@Serializable
data class PokemonDetailRoute(val pokemonID: Int)
@Composable
private fun AppNav() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "list") {
        composable("list") {
            PokemonListScreen { pokemon ->
                nav.navigate(PokemonDetailRoute(pokemon))
            }
        }
        composable<PokemonDetailRoute> { backStack ->
            val pokemonDetailRoute: PokemonDetailRoute = backStack.toRoute()
            PokemonDetailScreen(pokemonDetailRoute.pokemonID)
        }
    }
}
