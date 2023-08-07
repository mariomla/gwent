package gwent

import gwent.cards.{ICard, MeleeUnit, RangedUnit, SiegeUnit, WeatherCard}
import gwent.effect.{EscarchaMordiente, NieblaImpenetrable}
import munit.FunSuite
import gwent.player.HumanPlayer

class HumanPlayerTest extends FunSuite {
  var name1: String = null
  var name2: String = null
  var card1: ICard = null
  var card2: ICard = null
  var card3: ICard = null
  var card4: ICard = null

  var cardDeck1: List[ICard] = null
  var cardDeck2: List[ICard] = null
  var cardHand: List[ICard] = null

  var player1: HumanPlayer = null
  var player2: HumanPlayer = null
  var player3: HumanPlayer = null
  var player4: HumanPlayer = null

  override def beforeEach(context: BeforeEach): Unit = {
    name1 = "Genghis Khan"
    name2 = "Saladino"
    card1 = new MeleeUnit("Piquero", new NieblaImpenetrable, 2)
    card2 = new SiegeUnit("Catapulta", 2)
    card3 = new RangedUnit("Arquero", 3)
    card4 = new WeatherCard("Escarcha mordiente", new EscarchaMordiente)

    cardDeck1 = List(card1, card1, card1, card3)
    cardDeck2 = List(card1, card3, card2, card4)
    cardHand = List(card3, card1, card4)

    player1 = HumanPlayer(name1, cardDeck1)
    player2 = HumanPlayer(name2, 2, cardDeck2, cardHand, 3)
    player3 = HumanPlayer(name1, 1, cardDeck1, cardHand, 2)
    player4 = HumanPlayer(name1, 2, cardDeck1, Nil, 2)
  }
  test("Un HumanPlayer debe tener name, section, cardDeck, cardHand(puede ser null) y gemstones. Ademas prueba los getters"){
    assertEquals(player1.getName, name1)
    assertEquals(player1.getSection, 1)
    assertEquals(player1.getCardDeck, cardDeck1)
    assertEquals(player1.getCardHand, Nil)
    assertEquals(player1.getGemstones, 2)

    assertEquals(player2.getName, name2)
    assertEquals(player2.getSection, 2)
    assertEquals(player2.getCardDeck, cardDeck2)
    assertEquals(player2.getCardHand, cardHand)
    assertEquals(player2.getGemstones, 3)
  }

  test("Dos Human Player son iguales si tienen el mismo nombre y estan en la misma seccion (no pueden haber dos jugadores en la misma seccion ni con el mismo nombre)"){
    assert(player1.equals(player3))
    assert(!player1.equals(player2))
    assert(!player2.equals(player4))
    assert(!player1.equals(player4))
    }


  test("Al hacer DrawCard, la cardHand debe aumentar en 1 y el cardDeck disminuir en 1, ademas se deberia tomar el primer elemento de la lista cardDeck"){
    assertEquals(player1.getCardHand.length, 0)
    assertEquals(player1.getCardDeck.length, 4)
    assertEquals(player1.getCardDeck.head, card1)
    player1.drawCard()
    assertEquals(player1.getCardHand.length, 1)
    assertEquals(player1.getCardDeck.length, 3)
    assertEquals(player1.getCardHand.head, card1)
    }

  test("Al usar decrementGemstones, la cantidad de gemstones debe disminuir en 1"){
    assertEquals(player1.getGemstones, 2)
    assertEquals(player2.getGemstones, 3)
    player1.decrementGemstones()
    player2.decrementGemstones()
    assertEquals(player1.getGemstones, 1)
    assertEquals(player2.getGemstones, 2)
    }

  test("Al usar shuffleDeck, el Deck es el mismo pero cambian las cartas de lugar en la lista"){
    assertEquals(player2.getCardDeck, cardDeck2)
    player2.shuffleDeck()
    assertNotEquals(player2.getCardDeck, cardDeck2) // revisa que sean distintos
    assertEquals(player2.getCardDeck.length, cardDeck2.length) // revisa el largo
    assert(cardDeck2.contains(player2.getCardDeck.head)) // revisa que tengan los mismos elementos en distinto orden
    assert(cardDeck2.contains(player2.getCardDeck.tail.head))
    assert(cardDeck2.contains(player2.getCardDeck.tail.tail.head))
    assert(cardDeck2.contains(player2.getCardDeck.tail.tail.tail.head))
    }
}
