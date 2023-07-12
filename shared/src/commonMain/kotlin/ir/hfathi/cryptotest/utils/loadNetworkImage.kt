package ir.hfathi.cryptotest.utils
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.ImageBitmap
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.IntSize
//import coil.ImageLoader
//import coil.request.ImageRequest
//import com.seiko.imageloader.ImageLoader
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//
//@Composable
//suspend fun downloadAndDisplayImage(url: String, size: IntSize) {
//    val context = LocalContext.current
//    val imageLoader = ImageLoader(context)
//
//    val request = ImageRequest.Builder(context)
//        .data(url)
//        .size(size.width, size.height)
//        .build()
//
//    val result = withContext(Dispatchers.IO) {
//        imageLoader.execute(request).drawable
//    }
//
//    val imageBitmap = result?.asImageBitmap()
//    // Use the imageBitmap in your Compose UI
//}