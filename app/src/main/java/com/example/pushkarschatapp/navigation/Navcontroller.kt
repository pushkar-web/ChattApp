package com.example.pushkarschatapp.navigation

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch
import com.example.pushkarschatapp.signin.SignInViewModel
import com.example.pushkarschatapp.signin.datastore.UserDatastore
import com.example.pushkarschatapp.screens.ChatScreen
import com.example.pushkarschatapp.screens.HomeScreen
import com.example.pushkarschatapp.screens.StartScreen
import com.example.pushkarschatapp.signin.GoogleAuthUiClient
import com.example.pushkarschatapp.screens.ProfileScreen
import com.example.pushkarschatapp.signin.SignInScreen
import com.example.pushkarschatapp.signin.UserData

@Composable
fun MainNavController(
    paddingValues: PaddingValues,
    navController: NavHostController,
) {


    val context = LocalContext.current
    val datastore = UserDatastore(context)
    val name = datastore.getName.collectAsState(initial = "")
    val isLoggedIn = datastore.getLoginStatus.collectAsState(initial = false)
    var userData by remember {
        mutableStateOf<UserData?>(null)
    }

    LaunchedEffect(key1 = isLoggedIn.value) {
        userData = UserData(userId = "ABC123", username = name.value, profilePictureUrl = null)
    }

    val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = context.applicationContext,
            oneTapClient = Identity.getSignInClient(context.applicationContext)
        )
    }
    val coroutineScope = rememberCoroutineScope()



    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route,
    ) {





        composable(Screens.SignInScreen.route) {
            val viewModel = viewModel<SignInViewModel>()
            val state by viewModel.state.collectAsState()

            LaunchedEffect(key1 = Unit) {
                if (googleAuthUiClient.getSignedInUser() != null) {
                    navController.navigate(Screens.EnterHomeScreen.route)
                }
            }

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == Activity.RESULT_OK) {
                        coroutineScope.launch {
                            val signInResult = googleAuthUiClient.signInWithIntent(
                                intent = result.data ?: return@launch
                            )
                            viewModel.onSignInResult(signInResult)
                        }
                    }
                }
            )

            LaunchedEffect(key1 = state.isSignInSuccessful) {
                if (state.isSignInSuccessful) {
                    Toast.makeText(
                        context.applicationContext,
                        "Sign in successful",
                        Toast.LENGTH_LONG
                    ).show()

                    navController.navigate("profile")
                    viewModel.resetState()
                }
            }

            SignInScreen(
                navController= navController,
                state = state,
                onSignInClick = {
                    coroutineScope.launch {
                        val signInIntentSender = googleAuthUiClient.signIn()
                        launcher.launch(
                            IntentSenderRequest.Builder(
                                signInIntentSender ?: return@launch
                            ).build()
                        )
                    }
                }
            )
        }


        composable("profile") {
            ProfileScreen(
                navController = navController,
                userData = googleAuthUiClient.getSignedInUser(),
                onSignOut = {
                    coroutineScope.launch {
                        googleAuthUiClient.signOut()
                        Toast.makeText(
                            context.applicationContext,
                            "Signed out",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.navigate(Screens.StartScreen.route)
                    }
                }
            )
        }


        composable(Screens.StartScreen.route) {
            StartScreen(navController = navController)
        }



        composable(Screens.EnterHomeScreen.route) {
            println("UserData is ${googleAuthUiClient.getSignedInUser()}")
            HomeScreen(navHostController = navController, userData = userData)
        }
        composable(Screens.ChatScreen.route) {
            println("UserDataSS is ${googleAuthUiClient.getSignedInUser()}")
            ChatScreen(navController = navController, userData = googleAuthUiClient.getSignedInUser())
        }

        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }


    }
}
