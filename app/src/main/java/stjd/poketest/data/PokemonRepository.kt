package stjd.poketest.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import stjd.poketest.ui.pokemon.model.Pokemon

private const val BASE_URL = "https://pokeapi.co/api/v2/"

class PokemonRepository {
    val client = HttpClient(Android){
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }
    suspend fun getPokemons(): List<Pokemon> {
        val pokemonResponseList: PokemonListResponse = client.get("$BASE_URL/pokemon").body()
        val pokemons = pokemonResponseList.results.map { pokemon ->
            val detail: PokemonDetailResponse = client.get("$BASE_URL/pokemon/${pokemon.name}").body()
            Pokemon(
                name = pokemon.name,
                image = detail.sprites.other?.officialArtwork?.front_default
                    ?: detail.sprites.front_default,
                height = detail.height,
                id = detail.id,
                type = detail.types.firstOrNull()?.type?.name,
                weight = detail.weight,
                species = detail.species.name
            )
        }
        client.close()
        return pokemons
    }
}
