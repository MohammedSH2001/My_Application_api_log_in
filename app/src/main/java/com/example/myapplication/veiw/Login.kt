package com.example.myapplication.veiw

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.contentValuesOf
import androidx.navigation.NavController
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Login_page(navController: NavController) {

    val context = LocalContext.current
    val scaffoldState = rememberScrollState()
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisibal = remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
            .background(color = Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {


        Image(
            painter = painterResource(id = R.drawable.mkk_1),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()


        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()

        ) {


            Box(
                modifier = Modifier.background(color = Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
//
                    painter = painterResource(id = R.drawable.mk_2),
                    contentDescription = "Log in",
                    Modifier.size(height = 350.dp, width = 400.dp)

                )
            }
            Spacer(modifier = Modifier.padding(10.dp))

            Scaffold(
                modifier = Modifier.fillMaxSize(),
//                scaffoldState = scaffoldState
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
//                        .background(color = Color.DarkGray)
                        .padding(0.dp)
                ) {
                    Text(
                        text = "Log in",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(value = email.value,
                            onValueChange = { email.value = it },
                            label = { Text(text = "Email Address", color = Color.Black) },
                            placeholder = { Text(text = "Email Adderss", color = Color.Black) },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email, // Set keyboard type to Password
                                imeAction = ImeAction.Done // ,Set IME action to Done or another action
                            ),
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .clip(RoundedCornerShape(0.dp)),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedTextColor = Color.Black, disabledTextColor = Color.Black
                            )

                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        OutlinedTextField(value = password.value,
                            onValueChange = { password.value = it },
                            label = { Text(text = "Password ", color = Color.Black) },
                            placeholder = { Text(text = "Password ", color = Color.Black) },
                            singleLine = true,

                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedTextColor = Color.Black, disabledTextColor = Color.Black

                            ),
                            trailingIcon = {
                                IconButton(onClick = { /*TODO*/ }) {


                                }
                            }

                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),

                            onClick = {

                                when {
                                    email.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please Enter Your Email",
                                            Toast.LENGTH_LONG,
                                        ).show()

                                    }

                                }
                                when {
                                    password.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please Enter Your Password",
                                            Toast.LENGTH_LONG,
                                        ).show()

                                    }
                                }
                                if (password != null && email != null) {
                                    Toast.makeText(
                                        context,
                                        "Done..",
                                        Toast.LENGTH_LONG,
                                    ).show()
                                }

                            }, modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Sign In", color = Color.White, fontSize = 20.sp)

                        }

                        TextButton(onClick = { navController.navigate("Sign_in") }) {
                            Text(text = "             Creat New Account ")


                            Spacer(modifier = Modifier.padding(20.dp))

                        }
                        Spacer(modifier = Modifier.padding(20.dp))

                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.face_svg),
                                contentDescription = null,
                                Modifier
                                    .size(30.dp)
                                    .border(1.dp, Color.Black, CircleShape)
                                    .padding(4.dp),

                                )
                            Spacer(modifier = Modifier.width(20.dp))
                            Icon(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .size(30.dp)
                                    .border(1.dp, Color.Black, CircleShape)
                                    .padding(4.dp),
                                imageVector = Icons.Default.Email,
                                contentDescription = "add",
                                tint = Color.Black,

                                )

                        }

                    }

                }

            }

        }
    }

}