package gwent.player
import gwent.board.Board
import gwent.cards.ICard

class HumanPlayer(private val name: String, private val section: Int, private var cardDeck: List[ICard],
                  private var cardHand: List[ICard], private var gemstones: Int) extends
                  AbstractPlayer(name, section, cardDeck, cardHand, gemstones){

  // Aqui ira metodo "jugar", que sera distinto entre HumanPLayer y ComputerPlayer
  def playCard(card: ICard, board: Board): Unit = {
    if (this.getCardHand.contains(card)) {
      card.playCardHumanPlayer(board)
      this.applyEffectToBoard(board, 1, card.getEffect)
      this.removeCardFromCardHand(card)
    }
    else{
      println("El jugador UNO no posee la carta " + card.toString + " en la mano.")
    }
  }

  def this(name: String, cardDeck: List[ICard]) = this(name, 1, cardDeck, Nil, 2)

  def lose(): Unit = {
    notifyObserver(this)
  }

  def setCardHand(aCardHand: List[ICard]): Unit = {this.cardHand = cardHand}
  override def toString = s"HumanPlayer($name, $section, $gemstones, $cardDeck, $cardHand)"

  private def canEqual(other: Any): Boolean = other.isInstanceOf[HumanPlayer]

  override def equals(other: Any): Boolean = other match {
    case that: HumanPlayer =>
        (that canEqual this) &&
        name == that.name &&
        section == that.section
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(super.hashCode(), name, section)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}