package stjd.poketest.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetailResponse(
    val abilities: List<Ability>? = null,
    val base_experience: Int,
    val cries: Cries,
    val height: Int,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val name: String,
    val order: Int,
    val species: Species,
    val sprites: Sprites,
    val types: List<Type>,
    val weight: Int
)

@Serializable
data class Ability(
    val is_hidden: Boolean,
    val slot: Int
)

@Serializable
data class Cries(
    val latest: String,
    val legacy: String
)
@Serializable
data class Species(
    val name: String,
    val url: String
)
@Serializable
data class Sprites(
    val back_default: String? = null,
    val back_female: String? = null,
    val back_shiny: String? = null,
    val back_shiny_female: String? = null,
    val front_default: String,
    val front_female: String? = null,
    val front_shiny: String? = null,
    val front_shiny_female: String? = null,
    val other: Other? = null
)
@Serializable
data class Type(
    val slot: Int,
    @SerialName("type")
    val type: TypeX
)

@Serializable
data class TypeX (
    val name: String
)

@Serializable
data class Other(
    @SerialName("official-artwork")
    val officialArtwork: OfficialArtwork,
)
@Serializable
data class OfficialArtwork(
    val front_default: String? = null,
)