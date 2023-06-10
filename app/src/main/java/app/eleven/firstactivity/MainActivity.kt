package app.eleven.firstactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.eleven.firstactivity.ui.theme.FirstActivityTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			FirstActivityTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					Greeting("Android")
				}
			}
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Composable
fun BoardingPass(firstName: String) {

	val name = remember {
		mutableStateOf(firstName)
	}

	Column(
		Modifier
			.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(text = "Boarding Pass", fontWeight = FontWeight.Bold, fontSize = 24.sp)
		Image(
			painter = painterResource(id = R.drawable.img),
			contentDescription = null,
			modifier = Modifier.size(200.dp),
		)
		Text(text = "Passenger Name: ${name.value}", fontSize = 16.sp)
		Text(text = "Flight Number: AB123", fontSize = 16.sp)
		Text(text = "Departure Time: 8:30 AM", fontSize = 16.sp)
		Text(text = "Gate: A5", fontSize = 16.sp)
		Text(text = "Seat: 12C", fontSize = 16.sp)
		Image(
			painter = painterResource(id = R.drawable.img_1),
			contentDescription = null,
			modifier = Modifier.fillMaxWidth()
		)
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() = BoardingPass("John")