package ir.hfathi.cryptotest.ui.crypto_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.hfathi.cryptotest.CustomGreen
import ir.hfathi.cryptotest.CustomRed
import ir.hfathi.cryptotest.DP_16
import ir.hfathi.cryptotest.DP_2
import ir.hfathi.cryptotest.DP_20
import ir.hfathi.cryptotest.DP_5
import ir.hfathi.cryptotest.DarkGray
import ir.hfathi.cryptotest.Gold
import ir.hfathi.cryptotest.LightGray
import ir.hfathi.cryptotest.LighterGray
import ir.hfathi.cryptotest.SP_10
import ir.hfathi.cryptotest.SP_12
import ir.hfathi.cryptotest.data.entitiy.CoinEntity

@Composable
fun CryptoListScreen(
    cryptoList: List<CoinEntity>,
    onItemClick: (String) -> Unit
) {

    Scaffold(
        topBar = {
            CoinsScreenTopBar()
        }
    ) {
        LazyColumn {
            items(cryptoList) { item ->
                CoinListItem(
                    coin = item,
                    modifier = Modifier
//                        .clickable { onItemClick(item) }
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun CoinsScreenTopBar() {
    Box(Modifier.fillMaxWidth().padding(top = 30.dp)) {
        Text(
            text = "Compose multi platform",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
            color = DarkGray,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun CoinListItem(
    modifier: Modifier = Modifier,
    coin: CoinEntity,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(DP_20),
        verticalAlignment = Alignment.CenterVertically,
    ) {

//        Column(
//            horizontalAlignment = Alignment.Start,
//            modifier = Modifier
//                .weight(2f)
//        ) {
//            Box(
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .background(LighterGray)
//                    .size(DP_50)
//            ) {

//                AsyncImage(
//                    model = coins.icon,
//                    contentDescription = String(),
//                    modifier = Modifier
//                        .size(DP_20)
//                        .align(Alignment.Center)
//                )
//            }
//        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(5f)
        ) {
            Text(
                text = coin.name,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                color = DarkGray,
                textAlign = TextAlign.Start
            )

            Row {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(DP_2))
                        .background(LighterGray)
                        .size(DP_16)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = coin.rank.toString(),
                        fontSize = SP_10,
                        fontWeight = FontWeight.Bold,
                        color = Gold,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = coin.symbol,
                    fontSize = SP_12,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = DP_5)
                )

            }

        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(3f)
        ) {
            Text(
                text = coin.price.toString(),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = DarkGray
            )

            Text(
                text = coin.priceChange1d.toString() + "%",
                fontSize = SP_12,
                fontWeight = FontWeight.Bold,
                color = if (coin.priceChange1d < 0) CustomRed else CustomGreen
            )
        }
    }

    Divider(color = LightGray)
}