package gwent.board

import gwent.board.Component
import gwent.cards.ICard

class Zone(private[gwent] var cards: Array[ICard]) { // extends COmponent??

  def this() = this(new Array[ICard](0)) // 
  
  def setZone(aCards: Array[ICard]) = {this.cards = aCards}


  private def canEqual(other: Any): Boolean = other.isInstanceOf[Zone]

  private def eqArray(aZone: Zone): Boolean = {
    var ret = true
    for (i <- 0 to (this.cards.length - 1)) {
      ret && (this.cards(0).equals(aZone.cards(0)))
    }
    ret
  }

  override def equals(other: Any): Boolean = other match
    case that: Zone =>
      that.canEqual(this) &&
        this.eqArray(that)
    case _ => false

  override def hashCode(): Int =
    val state = Seq(cards)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)


  override def toString: String = {
    var re = "Zone = ["
    for (card <- this.cards) {
      re += card.toString + ", "
    }
    re += " ]"
    re
  }

}
