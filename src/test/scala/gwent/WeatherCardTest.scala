package gwent

import munit.FunSuite

class WeatherCardTest extends FunSuite {
  var card1: WeatherCard = null
  var card2: WeatherCard = null
  var card3: WeatherCard = null
  var card4: WeatherCard = null
  var card5: WeatherCard = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new WeatherCard("Escarcha mordiente",
      "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1")
    card2 = new WeatherCard("Escarcha mordiente",
      "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1")
    card3 = new WeatherCard("Escarcha blanca",
      "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1")
    card4 = new WeatherCard("Escarcha mordiente", "Ninguno")
    card5 = new WeatherCard("Niebla impenetrable",
      ": Establece el valor de fuerza de todas las cartas de combate a distancia a 1.")
  }

  test("Una carta debe tener un nombre y un efecto. Ademas prueba los getters") {
    assertEquals(card1.getName, "Escarcha mordiente")
    assertEquals(card1.getEffect,
      "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1")
  }

  test("Dos cartas son iguales cuando el nombre y el efecto son el mismo") {
    assertEquals(card1, card2)
    assertNotEquals(card1, card3)
    assertNotEquals(card1, card4)
    assertNotEquals(card1, card5)
  }
}