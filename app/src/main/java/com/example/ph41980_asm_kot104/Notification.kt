package com.example.ph41980_asm_kot104



import android.app.Notification
import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


data class DanhSachTB(
    val tenHD: String,
    val imgSP: Int?,
    val ndTomTat: String,
    val TrangThai: String?
)

val danhsach = listOf(
    DanhSachTB(
        "Your order #123456789 has been confirmed",
        R.drawable.minimalstand,
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
        "New"
    ),
    DanhSachTB(
        "Your order #123456789 has been confirmed",
        R.drawable.minimalstand,
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
        null
    )
    ,
    DanhSachTB(
        "Your order #123456789 has been confirmed",
        R.drawable.minimalstand,
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
        "Hot"
    )
    ,
    DanhSachTB(
        "Your order #123456789 has been confirmed",
          R.drawable.minimalstand,
        "hehehhehe",
"Hot"
)
,
DanhSachTB(
"Your order #123456789 has been confirmed",
    R.drawable.minimalstand,
"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Turpis pretium et in arcu adipiscing nec. Turpis pretium et in arcu adipiscing nec. ",
"Hot"
)
)

@Preview(showBackground = true)
@Composable
fun Notification(navController: NavController? = null) {
    getLayout(navController)
}

@Composable
private fun getLayout(navController: NavController? = null) {

    Scaffold(

        content = {
            LOTong_Bao(it, navController)
        }
    )
}
@Composable
fun LOTong_Bao(paddingValues: PaddingValues, navController: NavController? = null) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Notification",
            icon = R.drawable.search_icon,
            icon2 = null,
            modifier = Modifier.width(300.dp),
            onClickButtontTrai = {}
        )
        LazyColumn {
            items(danhsach) { ds ->
                ItemTB(
                    tenHD = ds.tenHD,
                    imgSP = ds.imgSP,
                    ndTomTat = ds.ndTomTat,
                    TrangThai = ds.TrangThai,
                    onClickItem = { /*TODO*/ },
                    modifier = Modifier.padding(vertical = 5.dp))
            }
        }
    }
}

@Composable
private fun ItemTB(
    tenHD: String?,
    imgSP: Int?,
    ndTomTat: String?,
    TrangThai: String?,
    onClickItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(if (TrangThai===null) Color.White else Color(0xFFF5F5F5) )
            .padding(start = 4.dp, end = 10.dp)
            .clickable { onClickItem },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        imgSP?.let {
            Image(
                painter =  painterResource(id = imgSP),  // Sử dụng Coil để tải ảnh từ URL
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )
        }
        /////
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 10.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                tenHD?.let {
                    Text(
                        text = it,
                        fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,lineHeight = 16.37.sp,
                    color = Color.Black,
                    maxLines = 1, // Thiết lập số dòng tối đa
                    overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
                    )
                }
                ndTomTat?.let {
                    Text(
                        text = it,
                        fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Justify,
                        maxLines = if (imgSP!=null)3 else 4, // Thiết lập số dòng tối đa
                        overflow = TextOverflow.Ellipsis // Sử dụng dấu ba chấm khi văn bản vượt quá
                    )
                }
            }
            TrangThai?.let {
                Text(
                    text = if (it.equals("Hot")) "${it.uppercase()} !" else it.uppercase(),
                    fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                    fontWeight = FontWeight.W900,
                    fontSize = 14.sp,
                    lineHeight = 27.8.sp,
                    color = if (it.equals("Hot")) Color.Red else Color(0xFF27AE60),
                    textAlign = TextAlign.Right,
                    maxLines = 1, // Thiết lập số dòng tối đa
                    overflow = TextOverflow.Ellipsis, // Sử dụng dấu ba chấm khi văn bản vượt quá
                    modifier = Modifier.fillMaxWidth() // Đảm bảo nó chiếm hết chiều rộng
                )
            }
        }
    }
}