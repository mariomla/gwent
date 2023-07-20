package gwent.observer

import scala.collection.mutable.ListBuffer

abstract class Subject() extends ISubject {
  private val observers: ListBuffer[Observer] = ListBuffer()

  override def registerObserver(observer: Observer): Unit = {
    observers += observer
  }

  override def notifyObserver(response: Any): Unit = {
    for (observer <- observers) {
      observer.update(this)
    }
  }
}
