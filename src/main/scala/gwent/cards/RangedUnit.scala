package gwent.cards

import gwent.cards.UnitCard
import gwent.board.{Board, Zone}
import gwent.effect.IEffect
import gwent.effect.NoEffect

/** Clase que represente una carta de unidad de distancia
 *
 * Esta definida por su nombre (name), por su efecto (effect) y por su fuerza (strenght)
 *
 * @param name El nombre de la carta
 * @param effect El efecto de la carta
 * @param strength La fuerza de la carta
 *
 * @constructor Crea una carta con el nombre, el efecto y la fuerza especificada
 * @constructor Segundo constructor, crea una carta con un nombre y fuerza especificada y atribuye el efecto NoEffect
 *              
 * Extiende de UnitCard
 */

class RangedUnit(private val name: String, private val effect: IEffect, private val strength: Int)
                 extends UnitCard(name, effect, strength) {

  def this(name: String, strength: Int) = this(name, new NoEffect, strength)

  /** Metodo para jugar una carta.
   *
   * Juega esta carta en el tablero board cuando es jugada por un jugador humano
   *
   * @param board Tablero en el que se jugara la carta
   */
  override def playCardHumanPlayer(board: Board): Unit = {
    board.rangedZonePlayerOne.cards = board.rangedZonePlayerOne.cards :+ this
  }

  /** Metodo para jugar una carta.
   *
   * Juega esta carta en el tablero board cuando es jugada por un jugador computador.
   *
   * @param board Tablero en el que se jugara la carta
   */
  override def playCardComputerPlayer(board: Board): Unit = {
    board.rangedZonePlayerTwo.cards = board.rangedZonePlayerTwo.cards :+ this
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
    effect.applyEffectRanged(section, this, board)
  }
 
  override def toString = s"RangedUnit($name, $effect, $strength)"

  private def canEqual(other: Any): Boolean = other.isInstanceOf[RangedUnit]

  override def equals(other: Any): Boolean = other match
    case that: RangedUnit =>
      that.canEqual(this) &&
        name == that.name &&
        effect == that.effect &&
        strength == that.strength
    case _ => false

  override def hashCode(): Int =
    val state = Seq(name, effect, strength)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
}
