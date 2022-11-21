package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

object Constants {
    const val STANDARD_ITEM_MAX_QUALITY = 50
    const val STANDARD_ITEM_MIN_QUALITY = 0
}
