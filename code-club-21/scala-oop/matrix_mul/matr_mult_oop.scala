object MatrixMultiplierOO {
  type Matrix = List[List[Int]]

  class MatrixOperations(matrix: Matrix) {
    def computeElement(A: List[Int], B: List[Int]): Int = {
      A.zip(B).map { case (a, b) => a * b }.sum
    }

    def getCol(j: Int): List[Int] = {
      matrix.map(_(j))
    }

    def multiplyWith(other: Matrix): Matrix = {
      val numRowsA = matrix.length
      val numColsA = matrix.head.length
      val numColsB = other.head.length

      if (numColsA != other.length) {
        throw new IllegalArgumentException("Incompatible matrix dimensions for multiplication")
      }

      (for {
        i <- 0 until numRowsA
      } yield {
        (for {
          j <- 0 until numColsB
        } yield {
          computeElement(matrix(i), other.map(_(j)))
        }).toList
      }).toList
    }
  }


  // Example usage:
  def main(args: Array[String]): Unit = {
    val a: Matrix = List(
      List(1, 2, 3, 4, 5),
      List(6, 7, 8, 9, 10),
      List(11, 12, 13, 14, 15),
      List(16, 17, 18, 19, 20),
      List(21, 22, 23, 24, 25)
    )

    val b: Matrix = List(
      List(25, 24, 23, 22, 21),
      List(20, 19, 18, 17, 16),
      List(15, 14, 13, 12, 11),
      List(10, 9, 8, 7, 6),
      List(5, 4, 3, 2, 1)
    )

    val matrixOpsA = new MatrixOperations(a)
    val result = matrixOpsA.multiplyWith(b)

    System.exit(0)
  }
}
