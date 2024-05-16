package dev.mambo.play.motea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.mambo.play.motea.ui.UiProvider
import dev.mambo.play.motea.ui.characters.CharactersViewModel
import dev.mambo.play.motea.ui.characters.ListState
import dev.mambo.play.motea.ui.theme.MoteaTheme

class MainActivity : ComponentActivity() {

    val viewModel: CharactersViewModel = UiProvider.charactersViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val state by viewModel.state.collectAsState()

            MoteaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AnimatedContent(
                        modifier = Modifier.padding(innerPadding),
                        targetState = state.list
                    ) { data ->
                        when (data) {
                            ListState.Empty -> {
                                CenteredColumn(modifier = Modifier.fillMaxSize()) {
                                    Text(text = "List is Empty")
                                }
                            }

                            is ListState.Error -> {
                                CenteredColumn(modifier = Modifier.fillMaxSize()) {
                                    Text(text = data.message)
                                }
                            }

                            ListState.Loading -> {
                                CenteredColumn(modifier = Modifier.fillMaxSize()) {
                                    CircularProgressIndicator()
                                }
                            }

                            is ListState.Success -> {
                                val list = data.list
                                LazyColumn {
                                    items(list) { character ->
                                        Card(onClick = { /*TODO*/ }) {
                                            Text(
                                                text = character.name,
                                                modifier = Modifier.padding(16.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun CenteredColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

