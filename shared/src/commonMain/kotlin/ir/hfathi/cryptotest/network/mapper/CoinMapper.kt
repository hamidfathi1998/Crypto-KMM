package ir.hfathi.cryptotest.network.mapper

import ir.hfathi.cryptotest.data.entitiy.CoinEntity
import ir.hfathi.cryptotest.network.model.CryptoApiModel

fun CryptoApiModel.asCoinEntity(): CoinEntity =
    CoinEntity(
        availableSupply = availableSupply,
        contractAddress = contractAddress,
        decimals = decimals,
        exp = exp,
        icon = icon,
        id = id,
        marketCap = marketCap,
        name = name,
        price = price,
        priceBtc = priceBtc,
        priceChange1d = priceChange1d,
        priceChange1h = priceChange1h,
        priceChange1w = priceChange1w,
        rank = rank,
        redditUrl = redditUrl,
        symbol = symbol,
        totalSupply = totalSupply,
        twitterUrl = twitterUrl,
        volume = volume,
        websiteUrl = websiteUrl
    )

fun Iterable<CryptoApiModel>.asCoinEntityList(): List<CoinEntity> = this.map {
    it.asCoinEntity()
}