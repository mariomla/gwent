package gwent.cards

import gwent.cards.AbstractCard
import gwent.board.Board
import gwent.effect.IEffect

class WeatherCard(private val name: String, private val effect: IEffect) extends AbstractCard(name, effect) {

  //playcard OJO, ARREGLAR??
  override def setStrength(newStrength: Int): Unit = {println("WeatherCard no tiene atributo Strngth")}

  override def getStrength: Int = {
    println("WeatherCard no tiene atributo Strngth")
    0
  }


  override def playCardHumanPlayer(board: Board): Unit = {
    if (board.getWeatherZone.cards.length == 0) {
      board.setWeatherZone(this)
    }
    else {
      println("El jugador UNO intento jugar una carta de clima, sin embargo, la zona de clima esta ocupada por la carta: " + board.getWeatherZone.cards(0).getName)
    }
  }

  override def playCardComputerPlayer(board: Board): Unit = {
    if (board.getWeatherZone.cards.length == 0) {
      board.setWeatherZone(this)
    }
    else {
      println("El jugador DOS intento jugar una carta de clima, sin embargo, la zona de clima esta ocupada por la carta: " + board.getWeatherZone.cards(0).getName)
    }
  }

  override def applyEffect(board: Board, section: Int, effect: IEffect): Unit = {
    effect.applyEffectWeather(section, this, board)
  }


  private def canEqual(other: Any): Boolean = other.isInstanceOf[WeatherCard]

  override def equals(other: Any): Boolean = other match {
    case that: WeatherCard =>
      (that canEqual this) &&
        name == that.name &&
        effect.equals(that.effect)
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, effect)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"WeatherCard($name, $effect)"
}
