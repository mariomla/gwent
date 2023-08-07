package gwent

@main
def main(): Unit = {
  val a1: Array[Int] = Array(1, 2)
  val a2: Array[Int] = Array(1, 2)
  if(a1 != a2){println("si")}
  println(a1(a1.length - 1))
}
