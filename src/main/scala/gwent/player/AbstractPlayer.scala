package gwent.player


//import gwent.observer.Subject
import gwent.board.Board
import gwent.cards.ICard

import scala.::

abstract class AbstractPlayer(private val name: String, private val section: Int, private var cardDeck: List[ICard],
                              private var cardHand: List[ICard], private var gemstones: Int) /*extends Subject*/ {

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
  
  def lose(): Unit 
  
  def decrementGemstones(): Unit = {
    if (gemstones <= 1) {
      gemstones = 0
      this.lose()
    }
    else {gemstones -= 1}
  }

  def shuffleDeck(): Unit = {
    cardDeck = scala.util.Random.shuffle(cardDeck)
  }
}

