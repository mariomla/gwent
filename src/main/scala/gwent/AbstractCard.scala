package gwent

abstract class AbstractCard(private val name: String, private val effect: String) extends ICard{
  override def getName: String = this.name

  override def getEffect: String = this.effect
  
  // Por ahora no hay forma en que el nombre o el efecto cambien por lo que no se haran dichos setters, no seran usados

  override def handleEffect(board: Board, section:Int): Unit = {
    this.getEffect match{
      case "Refuerzo Moral" => board.refuerzoMoral()
      case "Vinculo Estrecho" => board.vinculoEstrecho()
      case "Escarcha mordiente" => board.escarchaMordiente(section)
      case "Niebla impenetrable" => board.nieblaImpenetrable(section)
      case "Lluvia torrencial" => board.lluviaTorrencial(section)
      case "Clima despejado" => board.climaDespejado()
      case _ =>
    }
  }
}
