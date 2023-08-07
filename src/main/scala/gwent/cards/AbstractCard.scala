package gwent.cards

import gwent.board.Board
import gwent.cards.ICard
import gwent.effect.IEffect

abstract class AbstractCard(private val name: String, private var effect: IEffect) extends ICard{
  override def getName: String = this.name

  override def getEffect: IEffect = this.effect
  
  
  // Por ahora no hay forma en que el nombre o el efecto cambien por lo que no se haran dichos setters, no seran usados
  
  /*
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
  */
}
