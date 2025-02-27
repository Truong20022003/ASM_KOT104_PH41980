package com.example.ph41980_asm_kot104

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController


@Preview(showBackground = true)
@Composable
fun ProductDetail(navController: NavController? = null) {

    Box {
        Box(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 50.dp,
                    end = 20.dp,
                    bottom = 20.dp
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = null,
                Modifier
                    .size(40.dp)
                    .clickable(onClick = {
                        navController?.popBackStack()
                    })
            )
        }

        Box(
            modifier = Modifier
                .padding(
                    start = 40.dp,
                    top = 150.dp
                )
                .zIndex(1f)
        ) {
            Column(
                modifier = Modifier
                    .width(64.dp)
                    .height(192.dp)
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(50.dp)
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 5.dp,
                            color = Color("#909090".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {}

                Column(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            Color("#B4916C".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 5.dp,
                            color = Color("#F0F0F0".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {}

                Column(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            Color("#E4CBAD".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .border(
                            width = 5.dp,
                            color = Color("#F0F0F0".toColorInt()),
                            shape = RoundedCornerShape(50.dp)
                        )
                ) {}
            }
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.minimalstand),
                contentDescription = null,
                Modifier
                    .width(323.dp)
                    .height(455.dp)
                    .align(Alignment.End)
                    .clip(RoundedCornerShape(bottomStart = 50.dp))
            )

            Column(
                modifier = Modifier
                    .padding(
                        start = 20.dp,
                        top = 20.dp,
                        end = 20.dp,
                    )
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
//                            navController?.navigate(Screen.ProductDetail.route)
                        })
            ) {

                // tên sản phẩm
                Text(
                    text = "Minimal Stand",
                    fontFamily = FontFamily(Font(R.font.gelasio_regular)),
                    fontWeight = FontWeight(500),
                    fontSize = 24.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    // giá
                    Text(
                        text = "$ 50",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(700),
                        fontSize = 30.sp,
                    )

                    // số lượng
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(113.dp)
                    ) {

                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .size(30.dp)
                                .background(
                                    Color("#F0F0F0".toColorInt()),
                                    shape = RoundedCornerShape(10.dp)
                                )
                        ) {
                            Text(
                                text = "+",
                                color = Color("#242424".toColorInt()),
                                fontSize = 24.sp,
                            )
                        }

                        Text(
                            text = "1",
                            fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                            fontWeight = FontWeight(600),
                            fontSize = 18.sp,
                            color = Color("#242424".toColorInt()),
                            modifier = Modifier.padding(
                                start = 10.dp,
                                end = 10.dp
                            )
                        )

                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .size(30.dp)
                                .background(
                                    Color("#F0F0F0".toColorInt()),
                                    shape = RoundedCornerShape(10.dp)
                                )
                        ) {
                            Text(
                                text = "-",
                                color = Color("#242424".toColorInt()),
                                fontSize = 24.sp,
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // đánh giá
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gold_star_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "4.8",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(700),
                        fontSize = 18.sp,
                        color = Color("#303030".toColorInt())
                    )

                    Spacer(modifier = Modifier.width(15.dp))

                    Text(
                        text = "(50 reviews)",
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(600),
                        fontSize = 14.sp,
                        color = Color("#808080".toColorInt())
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                // mô tả
                Text(
                    text = "Minimal Stand is made of by natural wood. " +
                            "The design that is very simple and minimal. " +
                            "This is truly one of the best furnitures in any family for now. " +
                            "With 3 different colors, you can easily select the best match for your home. ",
                    fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                    fontWeight = FontWeight(300),
                    fontSize = 14.sp,
                    color = Color("#606060".toColorInt()),
                )

            }
        }

        Box(
            modifier = Modifier
                .padding(
                    bottom = 20.dp,
                    start = 20.dp,
                    top = 780.dp,
                    end = 20.dp
                )
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(60.dp)
                        .background(
                            Color("#F0F0F0".toColorInt()),
                            RoundedCornerShape(8.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.addtofavourite),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color("#242424".toColorInt())
                    ),
                    modifier = Modifier
                        .height(60.dp)
                        .width(250.dp)
                        .background(
                            Color("#242424".toColorInt()),
                            RoundedCornerShape(8.dp)
                        )
                ) {
                    Text(
                        text = "Add to cart",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.nunitosans_regular)),
                        fontWeight = FontWeight(600),
                        fontSize = 20.sp,
                    )
                }
            }

            // nút thêm vào yêu thích


        }


    }
}