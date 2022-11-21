package com.gildedrose.providers

import com.gildedrose.Item
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class AgedBrieSellInZeroOrLessProvider : ArgumentsProvider {
  override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
    return Stream.of(
      Arguments.of(Item("Aged Brie", 0, 0)),
      Arguments.of(Item("Aged Brie", -10, 20)),
      Arguments.of(Item("Aged Brie", -30, 50))
    ) //
  }
}
