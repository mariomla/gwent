package gwent

import gwent.states.{GameController, PlayerOneTurn}
import gwent.cards.{ICard, MeleeUnit, RangedUnit, SiegeUnit, WeatherCard}
import gwent.effect.{CieloDespejado, LluviaTorrencial, NoEffect, VinculoEstrecho}
import munit.FunSuite

class GameControllerTest extends FunSuite{
  var gc: GameController = null
  var name1: String = null
  var name2: String = null
  var cardDeck1: List[ICard] = null
  var cardDeck2: List[ICard] = null

  var card1: ICard = null
  var card2: ICard = null
  var card3: ICard = null
  var card4: ICard = null
  var card5: ICard = null
  var card6: ICard = null
  var card7: ICard = null
  var card8: ICard = null
  var card9: ICard = null
  var card10: ICard = null
  var card11: ICard = null
  var card12: ICard = null

  override def beforeEach(context: BeforeEach): Unit = {
    gc = GameController()
    name1 = "Genghis Khan"
    name2 = "Saladino"
    card1 = new MeleeUnit("Piquero", new NoEffect, 3)
    card2 = new MeleeUnit("Piquero",new NoEffect, 3)
    card3 = new MeleeUnit("Espadachin", new NoEffect, 6)
    card4 = new MeleeUnit("Espadachin", new NoEffect, 5)
    card5 = new RangedUnit("Arquero", new VinculoEstrecho("Arquero"), 2)
    card6 = new RangedUnit("Arquero", new VinculoEstrecho("Arquero"), 2)
    card7 = new RangedUnit("Ballestero", new NoEffect, 4)
    card8 = new SiegeUnit("Catapulta", new NoEffect, 5)
    card9 = new SiegeUnit("Escorpion", new NoEffect, 4)
    card10 = new SiegeUnit("LanzaPiedra", new NoEffect, 7)
    card11 = new WeatherCard("Lluvia Torrencial", new LluviaTorrencial)
    card12 = new WeatherCard("Cielo Despejado", new CieloDespejado)

    cardDeck1 = List(card1, card2, card3, card5, card6, card10, card11, card12)
    cardDeck2 = List(card5, card6, card7, card8, card8, card9, card11, card12)
  }

  test("Empezar Partida") {
    gc.createHumanPlayer(name1, cardDeck1)
    gc.createComputerPlayer(name2, cardDeck2)
    gc.startGame(4)
    assert(gc.getState.equals(new PlayerOneTurn))
    assertEquals(gc.getPlayer1.getCardHand.length, 4)
    assertEquals(gc.getPlayer2.getCardHand.length, 4)
    assertEquals(gc.getPlayer1.getCardDeck.length, 4)
    assertEquals(gc.getPlayer2.getCardDeck.length, 4)
  }


  test("Player1 juega una carta y luego player2 juega otra carta"){
    gc.createHumanPlayer(name1, cardDeck1)
    gc.createComputerPlayer(name2, cardDeck2)
    gc.startGame(4)
    assert(gc.isPlayerOneTurn)
    gc.playerOnePlayCard(gc.getPlayer1.getCardHand.head)
    assertEquals(gc.getPlayer1.getCardHand.length, 3)
    assert(gc.getBoard.meleeZonePlayerOne.cards.length == 1 || gc.getBoard.rangedZonePlayerOne.cards.length == 1 ||
           gc.getBoard.siegeZonePlayerOne.cards.length == 1 || gc.getBoard.weatherZone.cards.length == 1)
    assert(gc.isPlayerTwoTurn)
    gc.playerTwoPlayCard(gc.getPlayer2.getCardHand.head)
    assert(gc.getBoard.meleeZonePlayerTwo.cards.length == 1 || gc.getBoard.rangedZonePlayerTwo.cards.length == 1 ||
      gc.getBoard.siegeZonePlayerTwo.cards.length == 1 || gc.getBoard.weatherZone.cards.length == 1)
    assert(gc.isPlayerOneTurn)
  }

  test("Si un player pasa, el otro pasa a su turno infinito"){
    gc.createHumanPlayer(name1, cardDeck1)
    gc.createComputerPlayer(name2, cardDeck2)
    gc.startGame(4)
    gc.playerOnePass()
    assert(gc.isPlayerTwoInfiniteTurn)
    gc.playerTwoPlayCard(gc.getPlayer2.getCardHand.head)
    gc.playerTwoPlayCard(gc.getPlayer2.getCardHand.head)
  }

}
