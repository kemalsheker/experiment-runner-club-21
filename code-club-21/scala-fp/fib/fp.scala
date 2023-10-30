def fibonacci(num: Int): BigInt = {
  @scala.annotation.tailrec
  def fibFcn(n: Int, acc1: BigInt, acc2: BigInt): BigInt = n match {
    case 0 => acc1
    case 1 => acc2
    case _ => fibFcn(n - 1, acc2, acc1 + acc2)
  }
  fibFcn(num, 0, 1)
}

def main(args: Array[String]): Unit = {
  val n = 20 // Change this to the desired Fibonacci number
  val result = fibonacci(n)
}

