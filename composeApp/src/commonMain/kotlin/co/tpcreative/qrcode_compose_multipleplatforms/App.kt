package co.tpcreative.qrcode_compose_multipleplatforms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.tpcreative.qrcode_compose_multipleplatforms.database.PeopleDao
import co.tpcreative.qrcode_compose_multipleplatforms.database.PersonEntity
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.jetbrains.compose.resources.painterResource
import qrcode_compose_multipleplatforms.composeapp.generated.resources.Res
import qrcode_compose_multipleplatforms.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(peopleDao: PeopleDao) {
    MaterialTheme {



//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//
//            Greeting().greets().forEach { greeting ->
//                Text(greeting)
//                HorizontalDivider()
//            }
//
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }




        val people by peopleDao.getAllPeople().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()


        LaunchedEffect(true) {
            val peopleList = listOf(
                PersonEntity(name = "Phong"),
                PersonEntity(name = "John"),
                PersonEntity(name = "Alice")
            )

            peopleList.forEach {
                peopleDao.upsert(it)
            }


        }


        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {

            items(people) { person ->

                Text(
                    text = person.name, modifier = Modifier.fillMaxWidth()
                        .clickable {
                            scope.launch {

                                peopleDao.delete(person)

                            }
                        }
                        .padding(16.dp))
            }
        }




    }
}