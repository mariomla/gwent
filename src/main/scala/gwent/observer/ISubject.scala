package gwent.observer

trait ISubject {
  def registerObserver(observer: Observer): Unit
  def notifyObserver(response: Any): Unit
}
