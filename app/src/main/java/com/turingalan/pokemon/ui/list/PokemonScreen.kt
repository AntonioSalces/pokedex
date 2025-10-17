
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.turingalan.pokemon.data.model.Pokemon
import com.turingalan.pokemon.data.repository.PokemonInMemoryRepository
import com.turingalan.pokemon.ui.list.PokemonListViewModel
import com.turingalan.pokemon.ui.theme.components.PokemonItemDesign


@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel(),
) {
    Text(modifier = modifier,
        text = "LISTA DE POKEMONS")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    onNavigateToDetail: () -> Unit
){
    val repository = PokemonInMemoryRepository()
    val pokemons: List<Pokemon> = repository.readAll()
    Scaffold(

    ){

            paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            contentPadding = PaddingValues(8.dp)) {
            items(
                items = pokemons,
                key = {
                    it.id
                }
            ){
                    pokemons ->
                PokemonItemDesign(
                    pokemon = pokemons,
                    function = {
                        SelectedChampion.champion = champion
                        onNavigateToDetail()
                    }

                )
            }
        }
    }
}