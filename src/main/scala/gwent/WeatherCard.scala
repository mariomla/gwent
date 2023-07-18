package gwent

class WeatherCard(private val name: String, private val effect: String) extends AbstractCard(name, effect) {

  //playcard OJO, ARREGLAR??
  override def playCardHumanPlayer(board: Board): Unit = {
    if (board.getWeatherZone == null) {
      board.setWeatherZone(this)
    }
    else {
      println("El jugador UNO intento jugar una carta de clima, sin embargo, la zona de clima esta ocupada por la carta: " + board.getWeatherZone.toString())
    }
  }

  override def playCardComputerPlayer(board: Board): Unit = {
    if (board.getWeatherZone == null) {
      board.setWeatherZone(this)
    }
    else {
      println("El jugador DOS intento jugar una carta de clima, sin embargo, la zona de clima esta ocupada por la carta: " + board.getWeatherZone.toString())
    }
  }

  private def canEqual(other: Any): Boolean = other.isInstanceOf[WeatherCard]

  override def equals(other: Any): Boolean = other match {
    case that: WeatherCard =>
      (that canEqual this) &&
        name == that.name &&
        effect == that.effect
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, effect)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"WeatherCard($name, $effect)"
}
