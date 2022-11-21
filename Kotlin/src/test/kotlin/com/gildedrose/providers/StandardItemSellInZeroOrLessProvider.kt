package com.gildedrose.providers

import com.gildedrose.Item
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class StandardItemSellInZeroOrLessProvider : ArgumentsProvider {
  override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
    return Stream.of(
      Arguments.of(Item("a normal one", 0, 0)),

      Arguments.of(Item("+5 Dexterity Vest", -10, 0)),
      Arguments.of(Item("Elixir of the Mongoose", -5, 7)),
      Arguments.of(Item("Weird item", -40, 12))
    ) //
  }
}
