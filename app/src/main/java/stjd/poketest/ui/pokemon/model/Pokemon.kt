package stjd.poketest.ui.pokemon.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val name: String,
    val image: String,
    val height: Int? = null,
    val id: Int,
    val type: String? = null,
    val weight: Int? = null,
    val species: String? = null,
)