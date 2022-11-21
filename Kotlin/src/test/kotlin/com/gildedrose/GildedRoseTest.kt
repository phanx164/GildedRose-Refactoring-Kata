package com.gildedrose

import com.gildedrose.providers.AgedBrieSellInGreaterThanZeroProvider
import com.gildedrose.providers.AgedBrieSellInZeroOrLessProvider
import com.gildedrose.providers.BackstagePassesItemSellInFiveOrLessProvider
import com.gildedrose.providers.BackstagePassesItemSellInTenOrLessProvider
import com.gildedrose.providers.BackstagePassesItemSellInZeroOrLessProvider
import com.gildedrose.providers.StandardItemSellInZeroOrLessProvider
import com.gildedrose.providers.StandardSellInGreaterThanZeroProvider
import com.gildedrose.providers.SulfurasItemProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import kotlin.math.absoluteValue

internal class GildedRoseTest {

  @Test
  fun foo() {
    val items = arrayOf<Item>(Item("foo", 0, 0))
    val app = GildedRose(items)
    app.updateQuality()
    assertEquals("foo", app.items[0].name)
  }

  @ParameterizedTest
  @ArgumentsSource(AgedBrieSellInGreaterThanZeroProvider::class)
  fun `test Aged Brie before sellin expired`(item: Item) {
    val items = arrayOf<Item>(item)
    val startingSellIn = item.sellIn
    val startingQuality = item.quality

    with(GildedRose(items)) {
      for (i in 0..startingSellIn) {
        assertEquals(minOf(startingQuality + i, Constants.STANDARD_ITEM_MAX_QUALITY), item.quality)
        assertEquals(startingSellIn - i, item.sellIn)
        updateQuality()
      }
    }
    assertEquals(-1, item.sellIn)
  }

  @ParameterizedTest
  @ArgumentsSource(AgedBrieSellInZeroOrLessProvider::class)
  fun `test Aged Brie after sell in expired`(item: Item) {
    val items = arrayOf<Item>(item)
    val startingSellIn = item.sellIn
    val startingQuality = item.quality

    with(GildedRose(items)) {
      for (i in 0..item.sellIn.absoluteValue) {
        assertEquals(
          minOf(startingQuality + 2 * i, Constants.STANDARD_ITEM_MAX_QUALITY),
          item.quality
        )
        assertEquals(startingSellIn - i, item.sellIn)
        updateQuality()
      }
    }
  }

  @ParameterizedTest
  @ArgumentsSource(StandardSellInGreaterThanZeroProvider::class)
  fun `test standard before sell in expired`(item: Item) {
    val items = arrayOf(item)
    val startingQuality = item.quality

    with(GildedRose(items)) {
      for (i in 0..item.sellIn) {
        assertEquals(maxOf(Constants.STANDARD_ITEM_MIN_QUALITY, startingQuality - i), item.quality)
        updateQuality()
      }
    }
  }

  @ParameterizedTest
  @ArgumentsSource(StandardItemSellInZeroOrLessProvider::class)
  fun `test standard after sell in expired`(item: Item) {
    val items = arrayOf(item)
    val startingQuality = item.quality

    with(GildedRose(items)) {
      for (i in 0..item.sellIn.absoluteValue) {
        assertEquals(
          maxOf(Constants.STANDARD_ITEM_MIN_QUALITY, startingQuality - 2 * i),
          item.quality
        )
        updateQuality()
      }
    }
    assertEquals(0, item.quality)
  }

  @ParameterizedTest
  @ArgumentsSource(SulfurasItemProvider::class)
  fun `test Sulfuras Item`(item: Item) {
    val items = arrayOf(item)
    val startingSellIn = item.sellIn
    val startingQuality = item.quality

    with(GildedRose(items)) {
      for (i in 0..item.sellIn.absoluteValue) {
        assertEquals(startingSellIn, item.sellIn)
        assertEquals(startingQuality, item.quality)
        updateQuality()
      }
    }
  }

  @ParameterizedTest
  @ArgumentsSource(BackstagePassesItemSellInFiveOrLessProvider::class)
  fun `test Backstage Passes Item Sell In Five days or less`(item: Item) {
    val items = arrayOf(item)
    val startingSellIn = item.sellIn
    val startingQuality = item.quality

    with(GildedRose(items)) {
      for (i in 0..item.sellIn) {
        assertEquals(
          minOf(startingQuality + 3 * i, Constants.STANDARD_ITEM_MAX_QUALITY),
          item.quality
        )
        assertEquals(startingSellIn - i, item.sellIn)
        updateQuality()
      }
    }
  }

  @ParameterizedTest
  @ArgumentsSource(BackstagePassesItemSellInTenOrLessProvider::class)
  fun `test Backstage Passes Item Sell In Ten days or less`(item: Item) {
    val items = arrayOf(item)
    val startingSellIn = item.sellIn
    val startingQuality = item.quality

    with(GildedRose(items)) {
      for (i in 0..minOf(item.sellIn - 5, 5)) {
        assertEquals(
          minOf(startingQuality + 2 * i, Constants.STANDARD_ITEM_MAX_QUALITY),
          item.quality
        )
        assertEquals(startingSellIn - i, item.sellIn)
        updateQuality()
      }
    }
  }

  @ParameterizedTest
  @ArgumentsSource(BackstagePassesItemSellInZeroOrLessProvider::class)
  fun `test Backstage Passes Item Sell In Zero days or less`(item: Item) {
    val items = arrayOf(item)
    val startingSellIn = item.sellIn
    val startingQuality = item.quality

    with(GildedRose(items)) {
      for (i in 0..startingSellIn.absoluteValue) {
        if (item.sellIn >= 0) {
          assertEquals(startingQuality, item.quality)
        } else {
          assertEquals(0, item.quality)
        }
        assertEquals(startingSellIn - i, item.sellIn)
        updateQuality()
      }
    }
  }
}


