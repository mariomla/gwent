package gwent.player


import gwent.{Board, ICard}

import scala.::

abstract class AbstractPlayer(private val name: String, private val section: Int, private var cardDeck: List[ICard],
                              private var cardHand: List[ICard], private var gemstones: Int) {

  def getName: String = this.name

  def getSection: Int = this.section

  def getCardDeck: List[ICard] = this.cardDeck

  def getCardHand: List[ICard] = this.cardHand

  def getGemstones: Int = this.gemstones
  //setters
  def playCard(card: ICard, board: Board): Unit
  
  def drawCard(): Unit = {
    val firstCard = cardDeck.head
    val deckWOfirstCard = cardDeck.tail
    cardHand = cardHand :+ firstCard
    cardDeck = deckWOfirstCard
  }

  def decrementGemstones(): Unit = {
    if (gemstones <= 1) {
      gemstones = 0
      print("Has perdido")
    }
    else {gemstones -= 1}
  }

  def shuffleDeck(): Unit = {
    cardDeck = scala.util.Random.shuffle(cardDeck)
  }
}

