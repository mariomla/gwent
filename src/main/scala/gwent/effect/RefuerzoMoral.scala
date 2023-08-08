package gwent.effect

import gwent.board.{Zone, Board}
import gwent.cards.ICard

/** Clase que representa al efecto de Refuerzo Moral
 *
 * Esta definida por el nombre de la carta que tiene este efecto y por las veces que se aplicado este efecto sobre
 * una zona
 * 
 * @param cardName Nombre de la carta que posee este efecto
 * @param cardsEffectApplied Numero de veces que se ha aplicado este efecto sobre una zona. Inicialmente solo es 0.
 *                           Es usado para la aplicacion del efecto.
 *                           
 * @constructor Crea un efecto de Refuerzo Moral con el cardName especificado, cardEffectApplied parte siempre en 0
 *              por defecto.
 * 
 * Extiende de IEffect
 */

class RefuerzoMoral(cardName: String, var cardsEffectApplied: Int) extends IEffect {
  // Se supondra que no existen dos cartas de distinto tipo con el mismo nombre
  def this(cardName: String) = this(cardName, 0)

  /** Metodo que determina si alguna carta de la zona tiene el mismo nombre que cardName del efecto.
   * 
   * @param zone zona donde se buscara
   * @return Devuelve true si existe una carta con el mismo nombre y false en el caso contrario.
   */
  private def isCardNameInZone(zone: Zone): Boolean = {
    var ret: Boolean = false
    for (card <- zone.cards) {
      ret = ret || (cardName == card.getName)
    }
    ret
  }

  /** Metodo que determina si la carta es la ultima de su zona.
   *
   * @param card carta que se desee saber si es la ultima
   * @param zone Zona donde esta la carta.
   * @return Devuelve true si es la ultima carta de la zona y false en el caso contrario
   */
  private def isTheLastCard(card: ICard, zone: Zone): Boolean = { // si tiene el mismo nombre que la carta que aplico el efecto y se ha aplicado el efecto a todas menos a una entonces es la ultima carta
    val cardsInZone = zone.cards.length
    if ((card.getName == cardName) && (cardsEffectApplied == cardsInZone - 1)) {true}
    else {false}
  }

  /** Metodo intermedio que se encarga de reconocer si una carta debe recibir el efecto y lo aplica si es el caso.
   *  
   * @param zone zona donde esta la carta
   * @param card carta a la cual se reconocera si se le debe aplicar el efecto o no
   */
  private def refuerzoMoralEffect(zone: Zone, card: ICard): Unit = {
    if (this.isCardNameInZone(zone) && !(this.isTheLastCard(card, zone))) { // si esta la cardName en la zona entonces es la zona donde hay q aplicar el efecto, y si es la ultimo rntonces no hya que aplicar el efectp
      card.setStrength(card.getStrength + 1)
    }
    this.cardsEffectApplied = this.cardsEffectApplied + 1
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de combate cuerpo a cuerpo
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.meleeZonePlayerOne}
    else {zone = board.meleeZonePlayerTwo}
    refuerzoMoralEffect(zone, card)
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de combate a distancia
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.meleeZonePlayerOne}
    else {zone = board.meleeZonePlayerTwo}
    refuerzoMoralEffect(zone, card)
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de asedio
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.meleeZonePlayerOne}
    else {zone = board.meleeZonePlayerTwo}
    refuerzoMoralEffect(zone, card)
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de clima
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}
}
