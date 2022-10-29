package com.hng.resume.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hng.resume.R

// Set of Material typography styles to start with

private val HkGrotesk = FontFamily(
    Font(R.font.hkgrotesk_regular, FontWeight.Normal),
    Font(R.font.hkgrotesk_semibold, FontWeight.SemiBold),
    Font(R.font.hkgrotesk_bold, FontWeight.Bold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = HkGrotesk,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = HkGrotesk,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    body1 = TextStyle(
        fontFamily = HkGrotesk,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = HkGrotesk,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = HkGrotesk,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),

    /* Other default text styles to override
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)