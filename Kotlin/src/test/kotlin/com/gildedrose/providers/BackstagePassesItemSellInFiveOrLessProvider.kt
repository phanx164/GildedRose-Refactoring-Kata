package com.gildedrose.providers

import com.gildedrose.Item
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class BackstagePassesItemSellInFiveOrLessProvider : ArgumentsProvider {
  override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
    return Stream.of(
      Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)),
      Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 4, 50)),
      Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 3, 1)),
      Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 1, 0)),
    ) //
  }
}
