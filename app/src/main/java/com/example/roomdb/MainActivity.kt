package com.example.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdb.data.WordDatabse
import com.example.roomdb.data.WordRepositery
import com.example.roomdb.ui.theme.RoomDBTheme
import kotlinx.coroutines.coroutineScope

class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by lazy {
       ViewModelProvider(
           this,
           ViewModelFactory(WordRepositery(WordDatabse.getDatabase(this)))
       ).get(MainViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDBTheme {
                ui(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun ui(viewModel: MainViewModel){
    var word by remember {
        mutableStateOf("")
    }
    Column {
        OutlinedTextField(value =word , onValueChange = {
            word=it
        })
        
        Button(onClick = {
           viewModel.addWord(word)
            word=""
        }) {
            Text(text = "Insert Into Database")
        }



    }

}