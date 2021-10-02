package com.assistant.justtrain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assistant.justtrain.ui.theme.JustTrainTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi //sticky position ещё экспериментальная фича поэтому используем такую аннотацию
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //устанавливаем стиль активити
            JustTrainTheme {
                val personRepository = PersonRepository() //люди
                val getAllData = personRepository.getAllData().sortedBy { it.firstName } //получение массива с людьми


                //делаем список
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    val grouped =
                        getAllData.groupBy { it.firstName[0] } //группировка с сортировкой по первому символу в имени

                    grouped.forEach { (initial, persons) ->
                        stickyHeader {
                            CustomCharacter(char = initial.toString()) //применение символа к полю и закрепление позиции
                        }
                        items(items = persons) { person ->
                            //выводим массив
                            CustomItem(
                                person = person,
                                modifier = Modifier.fillMaxWidth(),
                                image = R.drawable.abc_vector_test
                            )
                        }
                    }

                }
            }
        }
    }


}

@ExperimentalFoundationApi
@Composable
@Preview
fun previewMain() {
    val personRepository = PersonRepository() //люди
    val getAllData = personRepository.getAllData().sortedBy { it.firstName } //получение массива с людьми


    //делаем список
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val grouped =
            getAllData.groupBy { it.firstName[0] } //группировка с сортировкой по первому символу в имени

        grouped.forEach { (initial, persons) ->
            stickyHeader {
                CustomCharacter(char = initial.toString()) //применение символа к полю и закрепление позиции
            }
            items(items = persons) { person ->
                //выводим массив
                CustomItem(
                    person = person,
                    modifier = Modifier.fillMaxWidth(),
                    image = R.drawable.ic_launcher_background
                )
            }
        }
    }
}
