package com.example.ph41980_asm_kot104

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun SignUp(navController: NavController) {
    preview(navController)
}

@Preview(showBackground = true)
@Composable
private fun preview(navController: NavController? = null) {
    getLayout(navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun getLayout(navController: NavController? = null) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var cfPassword by remember { mutableStateOf("") }
    var cfPasswordVisibility by remember { mutableStateOf(false) }


    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Column(
            Modifier
                .background(color = Color("#E0E0E0".toColorInt()))
                .fillMaxSize()
                .background(color = Color.White)

        ) {

            Spacer(modifier = Modifier.height(10.dp))

            thanhNgangIcon()

            Text(
                text = "WELCOME",
                fontFamily = FontFamily(Font(R.font.merriweather_regular)),
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier
                    .padding(20.dp)
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.92f)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = Color("#f4f5f6".toColorInt()),
                    )
            ) {
                Column {

                    // nhập tên
                    Text(
                        text = "Name",
                        color = Color("#909090".toColorInt()),
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                    )

                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color("#E0E0E0".toColorInt()),
                            focusedIndicatorColor = Color.Gray
                        ),
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    //nhập email
                    Text(
                        text = "Email",
                        color = Color("#909090".toColorInt()),
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                    )

                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color("#E0E0E0".toColorInt()),
                            focusedIndicatorColor = Color.Gray
                        ),
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // nhập password
                    Text(
                        text = "Password",
                        color = Color("#909090".toColorInt()),
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                    )

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color("#E0E0E0".toColorInt()),
                            focusedIndicatorColor = Color.Gray
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                                Image(
                                    painter = painterResource(id = if (passwordVisibility) R.drawable.eye_slash_icon else R.drawable.eye_icon),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(20.dp)
                                        .width(20.dp)
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // nhập lại password
                    Text(
                        text = "Password",
                        color = Color("#909090".toColorInt()),
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                    )

                    TextField(
                        value = cfPassword,
                        onValueChange = { cfPassword = it },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            unfocusedIndicatorColor = Color("#E0E0E0".toColorInt()),
                            focusedIndicatorColor = Color.Gray
                        ),
                        visualTransformation = if (cfPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            IconButton(onClick = { cfPasswordVisibility = !cfPasswordVisibility }) {
                                Image(
                                    painter = painterResource(id = if (cfPasswordVisibility) R.drawable.eye_slash_icon else R.drawable.eye_icon),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .height(20.dp)
                                        .width(20.dp)
                                )
                            }
                        }
                    )

                }

                Spacer(modifier = Modifier.height(30.dp))

                // nút đăng ký
                Button(
                    onClick = {
                        if (name.isBlank() || email.isBlank() || password.isBlank() || cfPassword.isBlank()) {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Không được để trống")
                            }
                        } else if (password != cfPassword) {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Nhập lại mật khẩu sai")
                            }
                        } else {
                            navController?.navigate(Screen.Login.route)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        Color("#242424".toColorInt())
                    ),
                    modifier = Modifier
                        .background(
                            Color("#242424".toColorInt()),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .height(50.dp)
                        .width(285.dp)
                ) {
                    Text(
                        text = "SIGN UP",
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                chuyenSangDangNhap(navController)
            }
        }
    }
}

@Composable
private fun thanhNgangIcon() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(Color("#BDBDBD".toColorInt()))
                .width(105.dp)
        )

        sofaIcon()

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(Color("#BDBDBD".toColorInt()))
                .width(105.dp)
        )
    }
}
@Composable
private fun chuyenSangDangNhap(navController: NavController? = null) {

    Row(
        modifier = Modifier
            .clickable(onClick = {
                navController?.navigate(Screen.Login.route)
            })
    ) {
        Text(
            text = "Already have account? ",
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(600),
            fontSize = 14.sp,
            color = Color("#808080".toColorInt()),
        )

        Text(
            text = "SIGN IN",
            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
            fontWeight = FontWeight(700),
            fontSize = 14.sp,
            color = Color("#303030".toColorInt()),
        )

    }

}