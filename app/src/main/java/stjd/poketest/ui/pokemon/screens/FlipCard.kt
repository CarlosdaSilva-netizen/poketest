package stjd.poketest.ui.pokemon.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import stjd.poketest.ui.pokemon.model.Pokemon


@Composable
fun PokemonFlipCard(
    pokemon: Pokemon,
    onNavigateDetails: (Pokemon) -> Unit,
    modifier: Modifier = Modifier
) {
    var flipped by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (flipped) 180f else 0f,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
        label = "flipRotation"
    )

    val density = LocalDensity.current
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .height(220.dp)
                .graphicsLayer {
                    cameraDistance =
                        with(density) { 12.dp.toPx() * 50 }
                    rotationY = rotation
                }
                .padding(12.dp)
                .clickable(true, onClick = { flipped = !flipped })
            ,
            contentAlignment = Alignment.Center
        ) {
            if (rotation <= 90f) {
                FrontFace(
                    pokemon = pokemon,
                )
            } else {
                Box(
                    modifier = Modifier.graphicsLayer { rotationY = 180f }
                        .clickable(true, onClick = { flipped = !flipped }),
                ) {
                    BackFace(
                        pokemon = pokemon,
                        onDetails = {
                            onNavigateDetails(pokemon)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun FrontFace(
    pokemon: Pokemon,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemon.image)
                .crossfade(true)
                .build(),
            contentDescription = pokemon.name,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Spacer(Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = pokemon.name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase() else it.toString()
                },
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

        }
    }
}

@Composable
private fun BackFace(
    pokemon: Pokemon,
    onDetails: () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Quick stats",
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(Modifier.height(5.dp))
        Surface(
            shape = RoundedCornerShape(4.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            tonalElevation = 2.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                StatCell(label = "Height",value = pokemon.height?.let { "${it / 10f} m" } ?: "—")
                VerticalDivider(
                    modifier = Modifier
                        .height(24.dp)
                        .padding(horizontal = 12.dp)
                )
                StatCell(label = "Weight", value = pokemon.weight?.let { "${it / 10f} kg" } ?: "—")
            }
        }

        Spacer(Modifier.height(12.dp))
        Text(
            text = "Type: ${pokemon.type ?: "—"}",
            style =  MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(24.dp))
        Row (
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onDetails, modifier = Modifier.weight(1f)) {
                Text("Details")
            }
        }
    }
}

@Composable
private fun StatCell( value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
    }
}
