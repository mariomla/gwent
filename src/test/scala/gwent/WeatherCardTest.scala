package gwent

import gwent.cards.WeatherCard
import gwent.effect.{EscarchaMordiente, NieblaImpenetrable, NoEffect}
import munit.FunSuite

class WeatherCardTest extends FunSuite {
  var card1: WeatherCard = null
  var card2: WeatherCard = null
  var card3: WeatherCard = null
  var card4: WeatherCard = null
  var card5: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new WeatherCard("Escarcha mordiente", new EscarchaMordiente)
    card2 = new WeatherCard("Escarcha mordiente", new EscarchaMordiente)
    card3 = new WeatherCard("Escarcha blanca", new EscarchaMordiente)
    card4 = new WeatherCard("Escarcha mordiente", new NoEffect)
    card5 = new WeatherCard("Niebla impenetrable", new NieblaImpenetrable)
  }

  test("Una carta debe tener un nombre y un efecto. Ademas prueba los getters") {
    assertEquals(card1.getName, "Escarcha mordiente")
    assertEquals(card1.getEffect, new EscarchaMordiente)
  }

  test("Dos cartas son iguales cuando el nombre y el efecto son el mismo") {
    assertEquals(card1, card2)
    assertNotEquals(card1, card3)
    assertNotEquals(card1, card4)
    assertNotEquals(card1, card5)
  }
}