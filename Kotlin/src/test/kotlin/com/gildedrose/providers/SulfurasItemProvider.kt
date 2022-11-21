package com.gildedrose.providers

import com.gildedrose.Item
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class SulfurasItemProvider : ArgumentsProvider {
  override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
    return Stream.of(
      Arguments.of(Item("Sulfuras, Hand of Ragnaros", 0, 80)),
      Arguments.of(Item("Sulfuras, Hand of Ragnaros", -5, 80)),
      Arguments.of(Item("Sulfuras, Hand of Ragnaros", 10, 80)),
    ) //
  }
}
