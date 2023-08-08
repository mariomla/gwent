package gwent.effect
import gwent.board.{Board, Zone}
import gwent.cards.ICard
import gwent.player.AbstractPlayer

/** Clase que representa al efecto de Vinculo Estrecho
 *
 * Esta definida por el nombre de la carta que tiene este efecto.
 *
 * @param cardName Nombre de la carta que posee este efecto
 *
 * @constructor Crea un efecto de Vinculo Estrecho con el cardName especificado.
 *
 * Extiende de IEffect
 */

class VinculoEstrecho(val cardName: String) extends IEffect {

  /** Metodo que devuelve el numero de veces que esta cardName del efecto se repite en la zona
   * 
   * @param zone zona donde se buscara
   * @return Devuelve el numero de veces que se repite el nombre de cardName en los nombres de la cartas de la zona.
   */
  def timesThisCardInZone(zone: Zone): Int = {
    var ret: Int = 0
    for (card <- zone.cards){
      if (card.getName == cardName){
        ret += 1
      }
    }
    ret
  }

  /** Metodo intermedio que se encarga de reconocer si una carta debe recibir el efecto y lo aplica si es el caso.
   * 
   * @param zone zona donde esta la carta
   * @param card carta a la cual se reconocera si se le debe aplicar el efecto o no
   */
  def vinculoEstrechoEffect(zone: Zone, card: ICard): Unit = {
    val cond: Boolean = timesThisCardInZone(zone) > 1 // Si es mayor que 1, entonces esta carta esta mas de una vez en la fila
    if (cardName == card.getName && cond) {
      card.setStrength(card.getStrength * 2)
    }
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de combate cuerpo a cuerpo
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectMelee(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1){zone = board.meleeZonePlayerOne}
    else {zone = board.meleeZonePlayerTwo}
    vinculoEstrechoEffect(zone, card)
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de combate a distancia
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectRanged(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.rangedZonePlayerOne}
    else {zone = board.rangedZonePlayerTwo}
    vinculoEstrechoEffect(zone, card)
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de asedio
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectSiege(section: Int, card: ICard, board: Board): Unit = {
    var zone: Zone = Zone()
    if (section == 1) {zone = board.siegeZonePlayerOne}
    else {zone = board.siegeZonePlayerTwo}
    vinculoEstrechoEffect(zone, card)
  }

  /** Metodo que define la accion que tendra el efecto sobre una carta de clima
   *
   * @param section seccion del jugador que aplica el efecto
   * @param card    carta a la cual se le aplicara el efecto
   * @param board   tablero donde se aplica el efecto
   */
  override def applyEffectWeather(section: Int, card: ICard, board: Board): Unit = {}

  private def canEqual(other: Any): Boolean = other.isInstanceOf[VinculoEstrecho]

  override def equals(other: Any): Boolean = other match
    case that: VinculoEstrecho =>
      that.canEqual(this) &&
        cardName == that.cardName
    case _ => false

  override def hashCode(): Int =
    val state = Seq(cardName)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)


  override def toString = s"VinculoEstrecho($cardName)"
}
