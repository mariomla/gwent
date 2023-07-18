package gwent

import gwent.player.{ComputerPlayer, HumanPlayer}
import munit.FunSuite

class BoardTest extends FunSuite { //testea board y playcard
  var name1: String = null
  var name2: String = null
  var card1: ICard = null
  var card2: ICard = null
  var card3: ICard = null
  var card4: ICard = null
  var card5: ICard = null

  var cardDeck1: List[ICard] = null
  var cardDeck2: List[ICard] = null

  var player1: HumanPlayer = null
  var player2: ComputerPlayer = null

  var board1: Board = null
  var board2: Board = null

  override def beforeEach(context: BeforeEach): Unit = {
    name1 = "Genghis Khan"
    name2 = "Saladino"
    card1 = new MeleeUnit("Piquero", "Vinculo Estrecho", 2)
    card2 = new RangedUnit("Arquero", 3)
    card3 = new SiegeUnit("Catapulta", 2)
    card4 = new WeatherCard("Escarcha mordiente",
      "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1.")
    card5 = new WeatherCard("Neblina",
      "Las tropas de Rango y de Asedio no pueden atacar.")

    cardDeck1 = List(card1, card1, card5, card3)
    cardDeck2 = List(card3, card4, card2, card4)

    player1 = HumanPlayer(name1, cardDeck1)
    player2 = ComputerPlayer(name2, cardDeck2)

    board1 = Board()
    board2 = Board()

    player1.drawCard()
    player1.drawCard()
    player2.drawCard()
    player2.drawCard()
    player1.playCard(card1, board2)
    player1.playCard(card1, board2)
    player1.playCard(card3, board2)
    player2.playCard(card2, board2)
    player2.playCard(card3, board2)
    player2.playCard(card4, board2)
  }

  test("Board debe tener todas las zonas, aunque esten vacias. Ademas se prueban algunos casos parqa playCard") {
    assertEquals(board1.meleeZonePlayerOne, Nil)
    assertEquals(board1.meleeZonePlayerTwo, Nil)
    assertEquals(board1.rangedZonePlayerOne, Nil)
    assertEquals(board1.rangedZonePlayerTwo, Nil)
    assertEquals(board1.siegeZonePlayerOne, Nil)
    assertEquals(board1.siegeZonePlayerTwo, Nil)
    assertEquals(board1.weatherZone, null)

    assertEquals(board2.meleeZonePlayerOne, List(card1, card1))
    assertEquals(board2.meleeZonePlayerTwo, Nil)
    assertEquals(board2.rangedZonePlayerOne, Nil)
    assertEquals(board2.rangedZonePlayerTwo, Nil)
    assertEquals(board2.siegeZonePlayerOne, Nil)
    assertEquals(board2.siegeZonePlayerTwo, List(card3))
    assertEquals(board2.weatherZone, card4)
  }

  test("No se puede agregar una carta de clima si ya hay una en juego"){
    player1.drawCard()
    player1.playCard(card5, board2)
    assertEquals(board2.getWeatherZone, card4)
  }

  test("No se puede jugar una carta que no se tiene en la mano") {
    player1.playCard(card3, board1)
    player2.playCard(card2, board1)
    assertEquals(board1.getSiegeZonePlayerOne, Nil)
    assertEquals(board1.getRangedZonePlayerTwo, Nil)
  }
}
