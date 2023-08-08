package gwent.cards

import gwent.board.Board
import gwent.effect.IEffect

/** Trait para definir a las cartas y establecer sus metodos
 */
trait ICard {
  def getName: String

  def getEffect: IEffect
  
  def getStrength: Int
  
  def setStrength(newStrength: Int): Unit

  /** Metodo para jugar una carta.
   *
   * Juega esta carta en el tablero board cuando es jugada por un jugador humano
   *
   * @param board Tablero en el que se jugara la carta
   */
  def playCardHumanPlayer(board: Board): Unit

  /** Metodo para jugar una carta.
   *
   * Juega esta carta en el tablero board cuando es jugada por un jugador computador.
   *
   * @param board Tablero en el que se jugara la carta
   */
  def playCardComputerPlayer(board: Board): Unit

  /** Metodo para aplicar un efecto sobre esta carta.
   *
   * Aplica el efecto effect, que fue aplicado sobre el tablero board en la seccion section del mismo, sobre esta carta.
   *
   * @param board Tablero donde se aplico el efecto y donde esta la carta.
   * @param section Seccion donde se aplico el efecto y donde esta la carta.
   * @param effect Efecto que se va a aplicar sobre la carta.
   */
  def applyEffect(board: Board, section: Int, effect: IEffect): Unit
}
