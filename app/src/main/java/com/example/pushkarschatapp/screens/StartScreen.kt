package com.example.pushkarschatapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pushkarschatapp.R


@Composable
fun StartScreen() {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop
        )

        Text(text = "Stay connected with your friends and family",
            fontSize = 36.sp,
            lineHeight = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)

        Spacer(modifier = Modifier.height(30.dp))
        Row (modifier = Modifier.fillMaxWidth()){
            Icon(imageVector = Icons.Default.CheckCircle , contentDescription =" ",
                tint = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Secure private messaging",
                color = Color.White)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {/*TODO*/}) {
            Text(text = "Get Started",
                fontWeight = FontWeight.Bold)
        }
    }
}