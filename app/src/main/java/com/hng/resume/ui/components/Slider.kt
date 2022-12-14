package com.hng.resume.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.hng.resume.Greeting
import com.hng.resume.R
import com.hng.resume.ui.theme.ResumeTheme
import com.hng.resume.ui.theme.Shapes
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Slider() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        val pagerState = rememberPagerState()
        val lowerPagerState = rememberPagerState()

        LaunchedEffect(pagerState.currentPage) {
            lowerPagerState.animateScrollToPage(pagerState.currentPage)
        }

        LaunchedEffect(true) {
            pagerState.scrollToPage(1)
        }

        val dpAnimation: Dp by animateDpAsState(targetValue = if (pagerState.currentPage == 1) 70.dp else 0.dp)

        var paddingValues by remember { mutableStateOf(PaddingValues(horizontal = dpAnimation)) }

        when (pagerState.currentPage) {
            0 -> {
                paddingValues = PaddingValues(horizontal = dpAnimation)
            }
            1 -> {
                paddingValues = PaddingValues(horizontal = dpAnimation)
            }
            2 -> {
                paddingValues = PaddingValues(horizontal = dpAnimation)
            }
        }

        Spacer(Modifier.height(20.dp))

        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.primary
        )
        Spacer(Modifier.height(20.dp))
        HorizontalPager(
            count = 3,
            verticalAlignment = Alignment.CenterVertically,
            state = pagerState,
            itemSpacing = 20.dp,
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) { page ->
            when (page) {
                0 -> {
                    Card(
                        shape = RoundedCornerShape(
                            topEnd = 20.dp, topStart = 0.dp,
                            bottomEnd = 20.dp, bottomStart = 0.dp
                        ),
                        backgroundColor = MaterialTheme.colors.primary,
                        modifier = if (pagerState.currentPage == 0) Modifier.fillMaxSize() else Modifier
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            var childrenWidth by remember {
                                mutableStateOf(0.dp)
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(horizontal = 30.dp, vertical = 20.dp)
                                    .weight(1f)
                            ) {
                                Row(verticalAlignment = Alignment.Top) {
                                    Column() {
                                        Text(
                                            text = "Software Engineer",
                                            style = MaterialTheme.typography.h1
                                        )

                                        Spacer(Modifier.height(20.dp))

                                        Text(
                                            text = "$10k - $15k/mo",
                                            style = MaterialTheme.typography.body1.copy(fontSize = 20.sp)
                                        )

                                        AnimatedVisibility(pagerState.currentPage == 0) {

                                            Divider(
                                                color = MaterialTheme.colors.background,
                                                thickness = 0.5.dp,
                                                modifier = Modifier
                                                    .width(childrenWidth)
                                                    .padding(top = 20.dp)
                                            )

                                            val density = LocalDensity.current

                                            Text(
                                                text = stringResource(R.string.resume_description),

                                                style = MaterialTheme.typography.body1,
                                                modifier = Modifier
                                                    .padding(top = 20.dp)
                                                    .onGloballyPositioned {
                                                        childrenWidth =
                                                            density.run { it.size.width.toDp() }
                                                    }
                                            )
                                        }

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

                            if (pagerState.currentPage != 0) {
                                Box(
                                    contentAlignment = Alignment.BottomCenter
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .rotate(-90f),
                                        textAlign = TextAlign.Center,
                                        text = "Portfolio",
                                        style = MaterialTheme.typography.body2
                                    )
                                }
                            }
                        }
                    }
                }
                1 -> {
                    Image(
                        painter = painterResource(id = R.drawable.my_image),
                        modifier = Modifier
                            .clip( RoundedCornerShape(20.dp)),
                        contentDescription = ""
                    )
                }
                2 -> {
                    Card(
                        shape = RoundedCornerShape(
                            topEnd = 0.dp, topStart = 20.dp,
                            bottomEnd = 0.dp, bottomStart = 20.dp
                        ),
                        backgroundColor = MaterialTheme.colors.primary,
                        modifier = if (pagerState.currentPage == 2) Modifier.fillMaxSize() else Modifier
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            var childrenWidth by remember {
                                mutableStateOf(0.dp)
                            }

                            if (pagerState.currentPage != 2) {
                                Box(
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .rotate(-90F),
                                        textAlign = TextAlign.Center,
                                        text = "Resume",
                                        style = MaterialTheme.typography.body2
                                    )
                                }
                            }

                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(horizontal = 30.dp, vertical = 20.dp)
                                    .weight(1f)
                            ) {
                                Row(verticalAlignment = Alignment.Top) {
                                    Column() {
                                        Text(
                                            text = "Mobile Engineer",
                                            style = MaterialTheme.typography.h1
                                        )

                                        Spacer(Modifier.height(40.dp))

                                        Text(
                                            text = "$10k - $15k/mo",
                                            style = MaterialTheme.typography.body1.copy(fontSize = 20.sp)
                                        )

                                        AnimatedVisibility(pagerState.currentPage == 2) {

                                            Spacer(modifier = Modifier.height(10.dp))

                                            Divider(
                                                color = MaterialTheme.colors.background,
                                                thickness = 0.5.dp,
                                                modifier = Modifier
                                                    .width(childrenWidth)
                                                    .padding(top = 20.dp)
                                            )

                                            Spacer(modifier = Modifier.height(10.dp))

                                            val density = LocalDensity.current

                                            Text(
                                                text = stringResource(R.string.resume_description),

                                                style = MaterialTheme.typography.body1,
                                                modifier = Modifier
                                                    .padding(top = 20.dp)
                                                    .onGloballyPositioned {
                                                        childrenWidth =
                                                            density.run { it.size.width.toDp() }
                                                    }
                                            )
                                        }

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
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        HorizontalPager(
            count = 3,
            verticalAlignment = Alignment.CenterVertically,
            state = lowerPagerState,
            userScrollEnabled = false,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> {
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        ResumeItem()
                        ResumeItem()
                        ResumeItem()
                        ResumeItem()
                        ResumeItem()
                        ResumeItem()
                    }
                }
                1 -> {
                    HomeDetails()
                }
                2 -> {
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        ResumeItem()
                        ResumeItem()
                        ResumeItem()
                        ResumeItem()
                        ResumeItem()
                        ResumeItem()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResumeTheme {
        Slider()
    }
}