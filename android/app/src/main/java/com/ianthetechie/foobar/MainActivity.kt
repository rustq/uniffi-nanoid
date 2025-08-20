package com.ianthetechie.foobar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ianthetechie.core.SafeCalculator
import com.ianthetechie.foobar.ui.theme.FoobarTheme
import uniffi.foobar.Nano

class MainActivity : ComponentActivity() {
  private val calculator = SafeCalculator()
  private val nano = Nano()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      FoobarTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Column(
            modifier = Modifier
              .fillMaxSize()
              .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp), // 控件之间留间距
          ) {
            Greeting(
              name = "🦀says 1 + 1 = ${calculator.add(1,1)}",
              modifier = Modifier.fillMaxWidth()
            )
            NanoSpace(
              id = nano.id(),
              modifier = Modifier.fillMaxWidth()
            )
          }
        }

      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(text = "Hello $name!", modifier = modifier)
}


@Composable
fun NanoSpace(id: String, modifier: Modifier = Modifier) {
  Text(text = "id = $id!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  FoobarTheme { Greeting("Android") }
}
