class ArrayMultiplier(arr: Array[Int]) {
  def multiply(factor: Int): Array[Int] = {
    arr.map(_ * factor)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 1000) {
      val inputArray = (0 until 1000000).toArray
      val factor = 2
      val arrayMultiplier = new ArrayMultiplier(inputArray)
      val resultArray = arrayMultiplier.multiply(factor)
    }
    System.exit(0)
  }
}
