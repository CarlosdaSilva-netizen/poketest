package stjd.poketest.ui.pokemon

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import stjd.poketest.data.PokemonRepository
import stjd.poketest.ui.pokemon.model.Pokemon

class PokemonViewModel(
    private val pokemonRepository: PokemonRepository = PokemonRepository()
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()

    init {
            fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                val response = pokemonRepository.getPokemons()
                _pokemonList.value = response
            } catch (e: Exception) {
                Log.e("PokemonViewModel", "Failed to load pokemons", e)
                _pokemonList.value = emptyList() // or keep a separate error state
            }
        }
    }
}
