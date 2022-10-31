package com.hng.resume.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hng.resume.R
import com.hng.resume.ui.theme.ResumeTheme

@Composable
fun HomeDetails() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Text(text = "Enike Braimoh", style = MaterialTheme.typography.h1)
        Text(
            text = "Android Engineer",
            style = MaterialTheme.typography.h3.copy(
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = stringResource(R.string.bio),
            style = MaterialTheme.typography.body1.copy(
                color = Color(
                    0xFF8897A0
                )
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Count(10, "Top")
            Count(7, "Years")
            Count(75, "Contacts")
        }
        Spacer(modifier = Modifier.height(20.dp))
        ActionButtons()
    }
}

@Composable
fun Count(
    count: Int = 0,
    title: String = "Top"
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.h1,
        )
        Text(
            text = title,
            style = MaterialTheme.typography.h3.copy(
                color = Color(
                    0xFF8897A0
                ),
                fontSize = 15.sp
            ),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ActionButtons() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        OutlinedButton(onClick = {}, modifier = Modifier.weight(1f)) {
            Text(
                text = "Chat",
                modifier = Modifier.padding(vertical = 15.dp),
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(
            onClick = { },
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp
            ),
            modifier = Modifier.weight(1f),
            shape = MaterialTheme.shapes.small
        ) {
            Text(
                text = "Message",
                modifier = Modifier.padding(vertical = 15.dp),
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeDetailsPreview() {
    ResumeTheme {
        HomeDetails()
    }
}