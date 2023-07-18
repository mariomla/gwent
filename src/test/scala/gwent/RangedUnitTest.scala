package gwent

import munit.FunSuite

class RangedUnitTest extends FunSuite {
  var card1: RangedUnit = null
  var card2: RangedUnit = null
  var card3: RangedUnit = null
  var card4: RangedUnit = null
  var card5: RangedUnit = null
  var card6: RangedUnit = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = RangedUnit("Monje", "Refuerzo Moral", 2)
    card2 = RangedUnit("Monje", "Refuerzo Moral", 2)
    card3 = RangedUnit("Monje", 2)
    card4 = RangedUnit("Monje", "Refuerzo Moral", 3)
    card5 = RangedUnit("Monje", "Vinculo Estrecho", 2)
    card6 = RangedUnit("Arquero", "Refuerzo Moral", 2)
  }

  test("Una RangedUnit debe tener nombre y fuerza, puedo o no tener efecto. Ademas pruebas los getters"){
    assertEquals(card1.getName, "Monje")
    assertEquals(card1.getStrength, 2)
    assertEquals(card1.getEffect, "Refuerzo Moral")
    assertEquals(card3.getEffect, "Ninguno")
  }

  test("Dos cartas son iguales si tienen el mismo nombre, efecto y fuerza") {
    assertEquals(card1, card2)
    assertNotEquals(card1, card3)
    assertNotEquals(card1, card4)
    assertNotEquals(card1, card5)
    assertNotEquals(card1, card6)
  }
}