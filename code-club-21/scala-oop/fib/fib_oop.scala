object Fibonacci {
  def fibonacci(n: Int): BigInt = n match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci(n-2) + fibonacci(n-1)
  }

  def main(args: Array[String]): Unit = {
    val n = 20 // Change this to the desired Fibonacci number
    val t0 = System.nanoTime()
    val result = fibonacci(n)

    System.exit(0)
  }
}
