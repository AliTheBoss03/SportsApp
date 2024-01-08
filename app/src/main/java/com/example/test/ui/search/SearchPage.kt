
package com.example.test.ui.search


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.R

class SearchPage(){

}

@Composable
fun logo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),


        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Image",
            modifier = Modifier
                .height(52.dp)
                .width(52.dp)

        )

    }

}


@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var searchText by remember { mutableStateOf("") }

    TextField(
        value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)
            println("Søgetekst opdateret: $searchText") // Tilføjelse af log statement til debugging
        },
        placeholder = { Text("Search") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 50.dp, 10.dp, 10.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(corner = CornerSize(20.dp)))
    )
}

@Composable
fun SearchFunktion() {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar(onSearch = { query ->
            searchQuery = query
            // Implementer logik for at søge og vise resultater baseret på `searchQuery`
        })

        // Simpel visning af søgeresultater
        if (searchQuery.isNotEmpty()) {
            Text(" $searchQuery")
            // Her kan du tilføje din logik til at vise faktiske søgeresultater
        }
    }
}

@Preview
@Composable
fun previewResults() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(android.graphics.Color.parseColor("#000000")),
                    Color(android.graphics.Color.parseColor("#FF9900"))
                )
            )
        )
    ){
        logo()
        SearchFunktion()



    }
}