package com.example.ph41980_asm_kot104

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Preview(showBackground = true)
@Composable
fun MyBottombar(navCtrl: NavController? = null) {
    val navController = rememberNavController()
    val selected = remember { mutableStateOf(Screen.Home.route) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                modifier = Modifier
                    .height(100.dp)
            ) {

                // home
                IconButton(
                    onClick = {
                        selected.value = Screen.Home.route
                        navController.navigate(Screen.Home.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Image(
                        painter = painterResource(id = if (selected.value == Screen.Home.route) R.drawable.black_home_icon else R.drawable.home_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }

                // favorite
                IconButton(
                    onClick = {
                        selected.value = Screen.Favorite.route
                        navController.navigate(Screen.Favorite.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = if (selected.value == Screen.Favorite.route) R.drawable.black_favourite_icon else R.drawable.favourite_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Screen.Notification.route
                        navController.navigate(Screen.Notification.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = if (selected.value == Screen.Notification.route) R.drawable.black_notification_icon else R.drawable.notification_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Screen.Profile.route
                        navController.navigate(Screen.Profile.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = if (selected.value == Screen.Profile.route) R.drawable.black_profile_icon else R.drawable.profile_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.Home.route) {
                Home(navCtrl)
            }
            composable(Screen.Favorite.route) {
                Favourite(navCtrl)
            }
            composable(Screen.Notification.route) {
                Notification(navCtrl)
            }
            composable(Screen.Profile.route) {
                Profile(navCtrl)
            }
        }
    }
}