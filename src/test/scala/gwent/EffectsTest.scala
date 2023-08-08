package gwent
import munit.FunSuite
import gwent.cards.ICard
import gwent.player.{ComputerPlayer, HumanPlayer}
import gwent.board.Board
import gwent.effect.{CieloDespejado, EscarchaMordiente, IEffect, LluviaTorrencial, NieblaImpenetrable, NoEffect, RefuerzoMoral, VinculoEstrecho}
import gwent.cards.{MeleeUnit, WeatherCard, RangedUnit, SiegeUnit}

class EffectsTest extends FunSuite {
 var name1: String = null
 var name2: String = null

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
 var card13: ICard = null
 var card14: ICard = null
 var card15: ICard = null
 var card16: ICard = null

 var cardDeck1: List[ICard] = null
 var cardDeck2: List[ICard] = null

 var player1: HumanPlayer = null
 var player2: ComputerPlayer = null

 var board: Board = null

 override def beforeEach(context: BeforeEach): Unit = {
  name1 = "Genghis Khan"
  name2 = "Saladino"
  card1 = new MeleeUnit("Piquero", new RefuerzoMoral("Piquero"), 3)
  card2 = new MeleeUnit("Piquero", new RefuerzoMoral("Piquero"), 3)
  card3 = new MeleeUnit("Piquero", new RefuerzoMoral("Piquero"), 3)
  card4 = new MeleeUnit("Espadachin", new NoEffect, 6)
  card5 = new MeleeUnit("Lancero", new NoEffect, 4)
  card6 = new WeatherCard("Escarcha Mordiente", new EscarchaMordiente)
  card7 = new WeatherCard("Cielo Despejado", new CieloDespejado)
  card8 = new MeleeUnit("Campeon", new VinculoEstrecho("Campeon"), 3)
  card9 = new MeleeUnit("Campeon", new VinculoEstrecho("Campeon"), 3)
  card10 = new MeleeUnit("Campeon", new VinculoEstrecho("Campeon"), 3)
  card11 = new RangedUnit("Arquero", 3)
  card12 = new RangedUnit("Ballestero", 5)
  card13 = new SiegeUnit("Catapulta", 7)
  card14 = new SiegeUnit("LanzaPiedras", 9)
  card15 = new WeatherCard("Lluvia Torrencial", new LluviaTorrencial)
  card16 = new WeatherCard("Niebla Impenetrable", new NieblaImpenetrable)

  cardDeck1 = List(card1, card2, card3, card4, card7, card8, card9, card10, card11, card13)
  cardDeck2 = List(card4, card5, card6, card1, card12, card2, card14, card15, card16, card8)

  player1 = HumanPlayer(name1, cardDeck1)
  player2 = ComputerPlayer(name2, cardDeck2)

  board = Board()

  for (x <- 0 until 10) {
   player1.drawCard()
   player2.drawCard()
  }
 }

 test("RefuerzoMoral") {
  player1.playCard(card4, board)
  player1.playCard(card1, board)
  player1.playCard(card2, board)
  player1.playCard(card3, board)
  assertEquals(card4.getStrength, 9)
  assertEquals(card1.getStrength, 5)
  assertEquals(card2.getStrength, 4)
  assertEquals(card3.getStrength, 3)
 }

 test("Escarcha Mordiente") {
  player1.playCard(card1, board)
  player1.playCard(card4, board)
  player2.playCard(card5, board)
  player2.playCard(card6, board)
  assertEquals(card1.getStrength, 1)
  assertEquals(card4.getStrength, 1)
  assertEquals(card5.getStrength, 1)
 }

 test("Vinculo Estrecho") {
  player1.drawCard()
  player1.drawCard()
  player1.drawCard()
  player1.playCard(card4, board)
  player1.playCard(card8, board)
  player1.playCard(card9, board)
  player1.playCard(card10, board)
  assertEquals(card4.getStrength, 6)
  assertEquals(card8.getStrength, 12)
  assertEquals(card9.getStrength, 12)
  assertEquals(card9.getStrength, 12)
 }

 test("LLuvia Torrencial"){
  player2.playCard(card14, board)
  player1.playCard(card13, board)
  player2.playCard(card15, board)
  assertEquals(card13.getStrength, 1)
  assertEquals(card14.getStrength, 1)
 }

 test("Niebla Impenetrable") {
  player1.playCard(card11, board)
  player2.playCard(card12, board)
  player2.playCard(card16, board)
  assertEquals(card11.getStrength, 1)
  assertEquals(card12.getStrength, 1)
 }

 test("Cielo Despejado") {
  player2.playCard(card15, board)
  println(board.getWeatherZone.cards(0))
  assert(board.getWeatherZone.cards(0).getEffect.equals(new LluviaTorrencial))
  player1.playCard(card7, board)
  println(board.getWeatherZone.cards)
  assertEquals(board.getWeatherZone.cards.length, 0)
 }
}
