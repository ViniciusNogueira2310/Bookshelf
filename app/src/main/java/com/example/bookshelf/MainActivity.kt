package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookshelf.ui.theme.BookshelfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    BookshelfScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfScreen() {
    val books = listOf(
        R.drawable.book1,
        R.drawable.book2,
        R.drawable.book3,
        R.drawable.book4,
        R.drawable.book5,
        R.drawable.book6
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Bookshelf") },
                modifier = Modifier.background(Color(0xFFA34D2C)), // cor marrom
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues)
                .padding(4.dp),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(books) { bookResId ->
                BookItem(bookResId)
            }
        }
    }
}

@Composable
fun BookItem(bookResId: Int) {
    Image(
        painter = painterResource(id = bookResId),
        contentDescription = "Book Cover",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .aspectRatio(0.7f)
            .border(2.dp, Color.White)
            .fillMaxWidth()
    )
}
