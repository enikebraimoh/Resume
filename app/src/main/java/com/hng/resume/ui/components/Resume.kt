package com.hng.resume.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hng.resume.R
import com.hng.resume.ui.theme.ResumeTheme

@Composable
fun Resume(modifier: Modifier = Modifier) {
    var childrenWidth by remember {
        mutableStateOf(0.dp)
    }

    Card(
        shape = RoundedCornerShape(
            topEnd = 0.dp, topStart = 20.dp, bottomEnd = 0.dp, bottomStart = 20.dp
        ),
        backgroundColor = MaterialTheme.colors.primary,
        modifier = modifier
            .fillMaxWidth(1f)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 20.dp)
        ) {
            Row() {
                Column() {
                    Text(
                        text = "Resume Side",
                        style = MaterialTheme.typography.h6.copy(fontSize = 30.sp)
                    )
                    Text(
                        text = "$10k - $15k/mo",
                        style = MaterialTheme.typography.caption.copy(fontSize = 18.sp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    TabRowDefaults.Divider(
                        color = MaterialTheme.colors.background,
                        thickness = 0.5.dp,
                        modifier = Modifier.width(childrenWidth)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    val density = LocalDensity.current

                    Text(
                        text = stringResource(R.string.resume_description),

                        style = MaterialTheme.typography.caption.copy(fontSize = 15.sp),
                        modifier = Modifier
                            .onGloballyPositioned {
                                childrenWidth = density.run { it.size.width.toDp() }
                            }
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.padding(vertical = 20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .background(Color.White, RoundedCornerShape(5.dp))
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .background(Color.White, RoundedCornerShape(5.dp))
                    )
                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ResumePreview() {
    ResumeTheme {
        Resume(Modifier)
    }
}