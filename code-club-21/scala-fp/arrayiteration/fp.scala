def multiplyArrayByFactor(arr: Array[Int], factor: Int): Array[Int] = {
  arr.map(_ * factor)
}

def main(args: Array[String]): Unit = {
  for (i <- 0 to 1000) {
    val inputArray = (0 until 1000000).toArray
    val factor = 2
    val resultArray = multiplyArrayByFactor(inputArray, factor)
  }

  System.exit(0)
}
