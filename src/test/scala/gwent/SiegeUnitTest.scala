package gwent

import gwent.cards.SiegeUnit
import gwent.effect.{EscarchaMordiente, NoEffect, NieblaImpenetrable}
import munit.FunSuite

class SiegeUnitTest extends FunSuite {
  var card1: SiegeUnit = null
  var card2: SiegeUnit = null
  var card3: SiegeUnit = null
  var card4: SiegeUnit = null
  var card5: SiegeUnit = null
  var card6: SiegeUnit = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = SiegeUnit("Escorpion", new EscarchaMordiente, 2)
    card2 = SiegeUnit("Escorpion", new EscarchaMordiente, 2)
    card3 = SiegeUnit("Escorpion", 2)
    card4 = SiegeUnit("Escorpion", new EscarchaMordiente, 3)
    card5 = SiegeUnit("Escorpion", new NieblaImpenetrable, 2)
    card6 = SiegeUnit("Ariete", new EscarchaMordiente,2)
  }

  test("Una SiegeUnit debe tener nombre y fuerza, puedo o no tener efecto. Ademas pruebas los getters"){
    assertEquals(card1.getName, "Escorpion")
    assertEquals(card1.getStrength, 2)
    assertEquals(card1.getEffect, new EscarchaMordiente)
    assertEquals(card3.getEffect, new NoEffect)
  }

  test("Dos cartas son iguales si tienen el mismo nombre, efecto y fuerza") {
    assertEquals(card1, card2)
    assertNotEquals(card1, card3)
    assertNotEquals(card1, card4)
    assertNotEquals(card1, card5)
    assertNotEquals(card1, card6)
  }
}