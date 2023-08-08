package gwent.board

import gwent.cards.ICard
import gwent.effect.IEffect
import jdk.internal.jmod.JmodFile.Section

/** Clase que representa el tablero del juego
 *
 * Un tablero esta definido por sus zonas las cuales son: zona de combate cuerpo a cuerpo para jugador 1 y 2,
 * zona de combate a distancia para jugador 1 y 2, zona de asedio para jugador 1 y 2 y zona de clima.
 *
 * @param meleeZonePlayerOne Zona de combate cuerpo a cuerpo para el jugador 1
 * @param meleeZonePlayerTwo Zona de combate cuerpo a cuerpo para el jugador 2
 * @param rangedZonePlayerOne Zona de combate a distancia para el jugador 1
 * @param rangedZonePlayerTwo Zona de combate a distancia para el jugador 2
 * @param siegeZonePlayerOne Zona de asedio para el jugador 1
 * @param siegeZonePlayerTwo Zona de asedio para el jugador 2
 * @param weatherZone Zona de clima
 *
 * @constructor Crea un tablero con cada una de sus zonas especificadas
 * @constructor Segundo Constructor, crea un tablero con todas sus zonas vacias
 */

class Board(private[gwent] var meleeZonePlayerOne: Zone, private[gwent] var rangedZonePlayerOne: Zone,
            private[gwent] var siegeZonePlayerOne: Zone, private[gwent] var meleeZonePlayerTwo: Zone,
            private[gwent] var rangedZonePlayerTwo: Zone, private[gwent] var siegeZonePlayerTwo: Zone,
            private[gwent] var weatherZone: Zone){
  def this() = this(new Zone(), new Zone(), new Zone(), new Zone(), new Zone(), new Zone(), new Zone())

  def getMeleeZonePlayerOne: Zone = this.meleeZonePlayerOne

  def getRangedZonePlayerOne: Zone = this.rangedZonePlayerOne

  def getSiegeZonePlayerOne: Zone = this.siegeZonePlayerOne

  def getMeleeZonePlayerTwo: Zone = this.meleeZonePlayerTwo

  def getRangedZonePlayerTwo: Zone = this.rangedZonePlayerTwo

  def getSiegeZonePlayerTwo: Zone = this.siegeZonePlayerTwo

  def getWeatherZone: Zone = this.weatherZone

  def setWeatherZone(card: ICard): Unit = {
    this.weatherZone.cards = Array(card)
  }
}
