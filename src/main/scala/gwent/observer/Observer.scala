package gwent.observer

trait Observer {
  def update(observed: ISubject): Unit
}
