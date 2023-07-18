package gwent

// Solo puede haber un Board

class Board(private[gwent] var meleeZonePlayerOne: List[ICard], private[gwent] var rangedZonePlayerOne: List[ICard],
            private[gwent] var siegeZonePlayerOne: List[ICard], private[gwent] var meleeZonePlayerTwo: List[ICard],
            private[gwent] var rangedZonePlayerTwo: List[ICard], private[gwent] var siegeZonePlayerTwo: List[ICard],
            private[gwent] var weatherZone: ICard){
  def this() = this(Nil, Nil, Nil, Nil, Nil, Nil, null) // Se crea un tablero totalmente vacio

  def getMeleeZonePlayerOne: List[ICard] = this.meleeZonePlayerOne

  def getRangedZonePlayerOne: List[ICard] = this.rangedZonePlayerOne

  def getSiegeZonePlayerOne: List[ICard] = this.siegeZonePlayerOne

  def getMeleeZonePlayerTwo: List[ICard] = this.meleeZonePlayerTwo

  def getRangedZonePlayerTwo: List[ICard] = this.rangedZonePlayerTwo

  def getSiegeZonePlayerTwo: List[ICard] = this.siegeZonePlayerTwo

  def getWeatherZone: ICard = this.weatherZone

  def setWeatherZone(card: ICard): Unit = {
    this.weatherZone = card
  }
  //setters?
}
