package com.gildedrose.providers

import com.gildedrose.Item
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class AgedBrieSellInGreaterThanZeroProvider : ArgumentsProvider {
  override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
    return Stream.of(
      Arguments.of(Item("Aged Brie", 2, 0)),

      Arguments.of(Item("Aged Brie", 5, 5)),
      Arguments.of(Item("Aged Brie", 15, 40)),
      Arguments.of(Item("Aged Brie", 40, 12))
    ) //
  }
}
