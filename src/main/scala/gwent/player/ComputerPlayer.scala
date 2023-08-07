package gwent.player
import gwent.board.Board
import gwent.cards.ICard
import gwent.effect.IEffect

class ComputerPlayer(private val name: String, private val section: Int, private var cardDeck: List[ICard],
                    private var cardHand: List[ICard], private var gemstones: Int) extends
                      AbstractPlayer(name, section, cardDeck, cardHand, gemstones) {

  // Aqui ira metodo "jugar", que sera distinto entre HumanPLayer y ComputerPlayer
  def playCard(card: ICard, board: Board): Unit = {
    if (this.getCardHand.contains(card)) {
      val index = cardHand.indexOf(card)
      cardHand = cardHand.patch(index, Nil, 1) // Elimina la carta del índice obtenido
      card.playCardComputerPlayer(board)
      this.applyEffectToBoard(board, 2, card.getEffect)
    }
    else {
      println("El jugador DOS no posee la carta "+ card.toString + " en la mano.")
    }
  }
  
  
  def lose(): Unit = {
    //notifyObserver(this)
  }

  def this(name: String, cardDeck: List[ICard]) = this(name, 2, cardDeck, Nil, 2)

  override def toString = s"ComputerPlayer($name, $section, $gemstones, $cardDeck, $cardHand)"

  private def canEqual(other: Any): Boolean = other.isInstanceOf[ComputerPlayer]

  override def equals(other: Any): Boolean = other match {
    case that: ComputerPlayer =>
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