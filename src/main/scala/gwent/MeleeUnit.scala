package gwent

class MeleeUnit(private val name: String, private val effect: String, private val strength: Int)
                extends UnitCard(name, effect, strength){

  def this(name: String, strength: Int) = this(name, "Ninguno", strength)
  
  override def playCardHumanPlayer(board: Board): Unit = {
    board.meleeZonePlayerOne = board.meleeZonePlayerOne :+ this
  }

  override def playCardComputerPlayer(board: Board): Unit = {
    board.meleeZonePlayerTwo = board.meleeZonePlayerTwo :+ this
  }

  override def toString = s"MeleeUnit($name, $effect, $strength)"

  private def canEqual(other: Any): Boolean = other.isInstanceOf[MeleeUnit]

  override def equals(other: Any): Boolean = other match
    case that: MeleeUnit =>
      that.canEqual(this) &&
        name == that.name &&
        effect == that.effect &&
        strength == that.strength
    case _ => false

  override def hashCode(): Int =
    val state = Seq(name, effect, strength)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)

  //play card
}
