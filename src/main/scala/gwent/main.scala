package gwent

@main
def main(): Unit = {
  var a1: Array[Int] = new Array[Int](0)
  var a2: Int = 3
  a1 = a1 :+ a2
  a1 = a1 :+ 2
  a1 = a1 :+ 1
  println(a2 += 1)

}
