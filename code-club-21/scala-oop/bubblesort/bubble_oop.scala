
object Bubble {
  def sort(arr: Array[Int]): Array[Int] = {
    val n = arr.length
    for (i <- 0 until n - 1) {
      for (j <- 0 until n - i - 1) {
        if (arr(j) > arr(j + 1)) {
          // Swap arr(j) and arr(j + 1)
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }
    arr
  }


  def main(args: Array[String]): Unit = {
    val arr = (1000 to 0 by -1).toArray
    val t0 = System.nanoTime()
    val sortedArr = sort(arr)

    System.exit(0)
  }
}

