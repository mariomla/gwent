package gwent

import gwent.cards.MeleeUnit
import gwent.effect.{EscarchaMordiente, NoEffect, NieblaImpenetrable}
import munit.FunSuite

class MeleeUnitTest extends FunSuite {
  var card1: MeleeUnit = null
  var card2: MeleeUnit = null
  var card3: MeleeUnit = null
  var card4: MeleeUnit = null
  var card5: MeleeUnit = null
  var card6: MeleeUnit = null

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = MeleeUnit("Piquero", new EscarchaMordiente, 2)
    card2 = MeleeUnit("Piquero", new EscarchaMordiente, 2)
    card3 = MeleeUnit("Piquero", 2)
    card4 = MeleeUnit("Piquero", new EscarchaMordiente, 3)
    card5 = MeleeUnit("Piquero", new NieblaImpenetrable, 2)
    card6 = MeleeUnit("Soldado", new EscarchaMordiente, 2)
  }

  test("Una MeleeUnit debe tener nombre y fuerza, puedo o no tener efecto. Ademas pruebas los getters"){
    assertEquals(card1.getName, "Piquero")
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
