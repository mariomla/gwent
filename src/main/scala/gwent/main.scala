package gwent

@main
def main(): Unit = {
  println("Hello world!")
  val card1: WeatherCard = new WeatherCard("Neblina", "ninguno")
  println(card1)
  println(card1.getName)
}
