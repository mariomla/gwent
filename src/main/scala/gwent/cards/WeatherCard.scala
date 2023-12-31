package gwent.cards

import gwent.cards.AbstractCard
import gwent.board.Board
import gwent.effect.{CieloDespejado, IEffect}

/** Clase que represente una carta de clima
 *
 * Esta definida por su nombre (name) y por su efecto (effect)
 *
 * @param name El nombre de la carta
 * @param effect El efecto de la carta
 *
 * @constructor Crea una carta con el nombre, el efecto y la fuerza especificada
 *
 * Extiende de AbstractCard
 */

class WeatherCard(private val name: String, private val effect: IEffect) extends AbstractCard(name, effect) {


  override def setStrength(newStrength: Int): Unit = {println("WeatherCard no tiene atributo Strngth")}

  override def getStrength: Int = {
    println("WeatherCard no tiene atributo Strngth")
    0
  }

  /** Metodo para jugar una carta.
   *
   * Juega esta carta en el tablero board cuando es jugada por un jugador humano
   *
   * @param board Tablero en el que se jugara la carta
   */
  override def playCardHumanPlayer(board: Board): Unit = {
    if (board.getWeatherZone.cards.length == 0 || this.effect.equals(new CieloDespejado)) {
      board.setWeatherZone(this)
    }
    else {
      println("El jugador UNO intento jugar una carta de clima, sin embargo, la zona de clima esta ocupada por la carta: " + board.getWeatherZone.cards(0).getName)
    }
  }

  /** Metodo para jugar una carta.
   *
   * Juega esta carta en el tablero board cuando es jugada por un jugador computador.
   *
   * @param board Tablero en el que se jugara la carta
   */
  override def playCardComputerPlayer(board: Board): Unit = {
    if (board.getWeatherZone.cards.length == 0) {
      board.setWeatherZone(this)
    }
    else {
      println("El jugador DOS intento jugar una carta de clima, sin embargo, la zona de clima esta ocupada por la carta: " + board.getWeatherZone.cards(0).getName)
    }
  }

  /** Metodo para aplicar un efecto sobre esta carta.
   *
   * Aplica el efecto effect, que fue aplicado sobre el tablero board en la seccion section del mismo, sobre esta carta.
   *
   * @param board   Tablero donde se aplico el efecto y donde esta la carta.
   * @param section Seccion del jugador que jugo el efecto
   * @param effect  Efecto que se va a aplicar sobre la carta.
   */
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
