package gwent

class SiegeUnit(private val name: String, private val effect: String, private val strength: Int)
                extends UnitCard(name, effect, strength) {

  def this(name: String, strength: Int) = this(name, "Ninguno", strength)

  override def playCardHumanPlayer(board: Board): Unit = {
    board.siegeZonePlayerOne = board.siegeZonePlayerOne :+ this
  }

  override def playCardComputerPlayer(board: Board): Unit = {
    board.siegeZonePlayerTwo = board.siegeZonePlayerTwo :+ this
  }

  override def toString = s"SiegeUnit($name, $effect, $strength)"

  private def canEqual(other: Any): Boolean = other.isInstanceOf[SiegeUnit]

  override def equals(other: Any): Boolean = other match
    case that: SiegeUnit =>
      that.canEqual(this) &&
        name == that.name &&
        effect == that.effect &&
        strength == that.strength
    case _ => false

  override def hashCode(): Int =
    val state = Seq(name, effect, strength)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)

  //playcard
}