package com.assistant.justtrain


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assistant.justtrain.ui.theme.Typography


//поле персоны
@Composable
fun CustomItem(person: Person, modifier: Modifier = Modifier, image: Int) {
    //говорим что это имеет вид поля
    Row(
        modifier = Modifier //основные настройки
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically, //выравнивание по вертикали
        horizontalArrangement = Arrangement.spacedBy(12.dp) //выравнивание по горизонтали c отсутпом
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp, 30.dp)
                .background(shape = CircleShape, color = Color.Blue)
        )
        //для каждого параметра текста отдельно прописываем свойства
        Text(
            // возраст
            text = "${person.age},",
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            //имя
            text = person.firstName,
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Normal
        )
        Text(
            //фамилия
            text = person.lastName,
            color = Color.Black,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Normal
        )

    }
}

//чтобы сортировать по алфавиту нужно предварительно создать поле
@Composable
fun CustomCharacter(char: String, modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(text = char, //в качестве символа сортируем список и юзаем элементы по порядку
            color = Color.Blue,
            fontSize = Typography.h5.fontSize,
            fontWeight = FontWeight.Normal)
    }
}

//превьюшечки
@Composable
@Preview
fun CustomItemPreview() {
    CustomItem(
        person = Person(id = 0,
            firstName = "John",
            lastName = "Doe",
            age = 20),
        image = R.drawable.ic_launcher_background
    )
}

@Composable
@Preview
fun CustomCharacterPreview() {
    CustomCharacter(char = "a", modifier = Modifier)
}