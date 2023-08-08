package gwent.player


import gwent.observer.Subject
import gwent.board.Board
import gwent.cards.ICard
import gwent.effect.IEffect

import scala.::

/** Clase abstracta que representa un jugador
 *
 * Un jugador esta definido por su name, su section, su cardDeck, su cardHand y sus gemstones
 *
 * @param name El nombre del jugador
 * @param section La seccion del tablero en la que jugara
 * @param cardDeck El mazo de cartas que posee
 * @param cardHand La mano de cartas que tiene
 * @param gemstones Las gemas que tiene
 *                  
 * Extiende de Subject, pues sera observado por el GameController.                 
 */

abstract class AbstractPlayer(private val name: String, private val section: Int, private var cardDeck: List[ICard],
                              private var cardHand: List[ICard], private var gemstones: Int) extends Subject {

  def getName: String = this.name

  def getSection: Int = this.section

  def getCardDeck: List[ICard] = this.cardDeck

  def getCardHand: List[ICard] = this.cardHand

  def getGemstones: Int = this.gemstones

  def playCard(card: ICard, board: Board): Unit

  /** Metodo para tomar una carta del mazo.
   * 
   * Elimina una carta del mazo de cartas del jugador y la coloca en la mano de cartas del mismo.
   */
  def drawCard(): Unit = {
    val firstCard = cardDeck.head
    val deckWOfirstCard = cardDeck.tail
    cardHand = cardHand :+ firstCard
    cardDeck = deckWOfirstCard
  }

  /** Remueve la carta aCard de la mano del jugador
   * 
   * @param aCard
   */
  def removeCardFromCardHand(aCard: ICard): Unit = {
    val index = cardHand.indexOf(aCard)
    this.cardHand = cardHand.patch(index, Nil, 1)
  }

  /** Metodo que se usa cuando el player pierde. Se define en las subclases
   */
  def lose(): Unit

  /** Metodo para disminuir en 1 las gemas del jugador
   */
  def decrementGemstones(): Unit = {
    println("El jugador " + this.getName + " pierde la ronda. Pierde una gemstone")
    if (gemstones <= 1) {
      gemstones = 0
      this.lose()
    }
    else {gemstones -= 1}
  }

  /** Metodo para revolver el mazo de cartas del jugador
   */
  def shuffleDeck(): Unit = {
    cardDeck = scala.util.Random.shuffle(cardDeck)
  }

  /** Metodo para aplicar el efecto effect sobre un tablero.
   * 
   * Aplica el efecto sobre cada zona del tablero.
   * 
   * @param board tablero en el que se aplica el efecto
   * @param section seccion a la cual pertenece el jugador que aplica el efecto
   * @param effect efecto que se aplica sobre cada zona del tablero
   */
  def applyEffectToBoard(board: Board, section: Int, effect: IEffect): Unit = {
    board.meleeZonePlayerOne.applyEffect(board: Board, section: Int, effect: IEffect)
    board.meleeZonePlayerTwo.applyEffect(board: Board, section: Int, effect: IEffect)
    board.rangedZonePlayerOne.applyEffect(board: Board, section: Int, effect: IEffect)
    board.rangedZonePlayerTwo.applyEffect(board: Board, section: Int, effect: IEffect)
    board.siegeZonePlayerOne.applyEffect(board: Board, section: Int, effect: IEffect)
    board.siegeZonePlayerTwo.applyEffect(board: Board, section: Int, effect: IEffect)
    board.weatherZone.applyEffect(board: Board, section: Int, effect: IEffect)
  }
}

