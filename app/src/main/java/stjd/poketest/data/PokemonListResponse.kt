package stjd.poketest.data

import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Results> = emptyList()
)
@Serializable
data class Results(
    val name: String,
    val url: String
)
