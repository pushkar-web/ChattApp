package com.example.pushkarschatapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity
import com.example.pushkarschatapp.bottombar.BottomBar
import com.example.pushkarschatapp.navigation.MainNavController
import com.example.pushkarschatapp.navigation.Screens
import com.example.pushkarschatapp.screens.ChatScreen
import com.example.pushkarschatapp.screens.HomeScreen
import com.example.pushkarschatapp.screens.StartScreen
import com.example.pushkarschatapp.signin.GoogleAuthUiClient
import com.example.pushkarschatapp.signin.SignInScreen
import com.example.pushkarschatapp.ui.theme.PushkarsChatAppTheme

class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PushkarsChatAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val bottomBarState = rememberSaveable { mutableStateOf(true) }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    navBackStackEntry?.destination?.route?.let { route ->
                        bottomBarState.value = when (route) {
                            Screens.EnterHomeScreen.route,
                            Screens.ProfileScreen.route ->true
                            else -> false
                        }
                    }

                    Scaffold(
                        bottomBar = {
                            BottomBar(
                                navController = navController,
                                bottomBarState = bottomBarState
                            )
                        }
                    ) {
                        val scaffoldState = rememberScaffoldState()
                        MainNavController(
                            it,
                            navController
                        )
                    }
                }
            }
        }
    }
}