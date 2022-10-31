package com.hng.resume.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
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


@Composable
fun ResumeItem(
    position: String = "Android Engineer",
    company: String = "Tinder",
    year: String = "2017 - 2020",
    content: String = stringResource(id = R.string.bio)
) {
    var expanded by remember { mutableStateOf(false) }

    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Column(
        modifier = Modifier
            .padding(20.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = position,
                    style = MaterialTheme.typography.h1.copy(fontSize = 18.sp)
                )
                Text(
                    text = company,
                    style = MaterialTheme.typography.h3.copy(
                        fontSize = 16.sp, color = Color(0xFF424344)
                    ),
                )
            }

            IconButton(onClick = { expanded = !expanded}) {
                Icon(
                    modifier = Modifier.padding(
                        vertical = 5.dp,
                        horizontal = 5.dp
                    ).rotate(angle),
                    imageVector = ImageVector.vectorResource(id = R.drawable.down_arrow),
                    contentDescription = "ic_add"
                )
            }
        }

        if(expanded){
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.h3.copy(
                    fontSize = 15.sp, color = Color(0xFF8897A0)
                ),
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            color = MaterialTheme.colors.onBackground,
            thickness = 0.5.dp,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ResumePreview() {
    ResumeTheme {
        Resume(Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun ResumeItemPreview() {
    ResumeTheme {
        ResumeItem()
    }
}