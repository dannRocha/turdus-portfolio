package com.turdusportfolio.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.DataExploration
import androidx.compose.material.icons.outlined.Difference
import androidx.compose.material.icons.outlined.PriceCheck
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.TrackChanges
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.turdusportfolio.R
import com.turdusportfolio.ui.theme.TurdusPortfolioTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.onPrimary),
                title = {
                    Text(
                        text = stringResource(R.string.calculator_title_screen),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        },
    ) {
        paddingValues ->
        val toolsCard = listOf(
            CardToolDetails(
                imageVector = Icons.Outlined.Calculate,
                contentDescription = "compound interest calculator icon",
                text = "compound interest calculator",
            ),
            CardToolDetails(
                imageVector = Icons.Outlined.QueryStats,
                contentDescription = "benjamin graham calculator icon",
                text = "Benjamin Graham calculator",
            ),
            CardToolDetails(
                imageVector = Icons.Outlined.Difference,
                contentDescription = "difference assets icon",
                text = "Difference assets",
            ),
            CardToolDetails(
                imageVector = Icons.Outlined.ReceiptLong,
                contentDescription = "report icon",
                text = "Report",
            ),
            CardToolDetails(
                imageVector = Icons.Outlined.DataExploration,
                contentDescription = "benchmarking icon",
                text = "Benchmarking",
            ),
            CardToolDetails(
                imageVector = Icons.Outlined.PriceCheck,
                contentDescription = "dividends icon",
                text = "Dividends",
            ),
            CardToolDetails(
                imageVector = Icons.Outlined.TrackChanges,
                contentDescription = "goals icon",
                text = "Goals",
            )
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {

            itemsIndexed(items = toolsCard) {index, details ->
                CardTool(
                    details = details,
                )
            }
        }
    }
}

data class CardToolDetails(
    val imageVector: ImageVector,
    val contentDescription: String,
    val text: String,
    val onClick: () -> Unit = {}
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTool(
    details: CardToolDetails,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .size(150.dp),
        onClick = details.onClick,
        shape = MaterialTheme.shapes.medium,
    ) {
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center,
           modifier = Modifier
               .fillMaxSize()
               .background(MaterialTheme.colorScheme.primary)
               .padding(8.dp)
       ) {
           Icon(
               imageVector = details.imageVector,
               contentDescription = details.contentDescription,
               tint = MaterialTheme.colorScheme.onPrimary,
               modifier = Modifier
                   .size(MaterialTheme.typography.displayMedium.fontSize.value.dp)
           )
           Text(
               text = details.text,
               textAlign = TextAlign.Center,
               style = MaterialTheme.typography.titleSmall,
               color = MaterialTheme.colorScheme.onPrimary,
           )
       }
}
}

@Composable
@Preview(showBackground = true)
fun CardToolPreview() {
    TurdusPortfolioTheme {
        CardTool(
           details = CardToolDetails(
               imageVector = Icons.Outlined.QueryStats,
               contentDescription = "benjamin graham calculator icon",
               text = "Benjamin Graham calculator",
           )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ToolsScreenPreview() {
    TurdusPortfolioTheme {
        ToolsScreen()
    }
}