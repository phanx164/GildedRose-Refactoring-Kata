package com.gildedrose.providers

import com.gildedrose.Item
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class BackstagePassesItemSellInTenOrLessProvider : ArgumentsProvider {
  override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
    return Stream.of(
      Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 10, 49)),
      Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 9, 50)),
      Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 8, 10)),
      Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 6, 0)),
    ) //
  }
}
