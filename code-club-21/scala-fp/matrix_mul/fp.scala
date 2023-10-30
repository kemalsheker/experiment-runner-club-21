import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object MatrixMultiplierFP {
  type Matrix = List[List[Int]]

  // Function to compute an element of the result matrix
  def computeElement(A: List[Int], B: List[Int]): Int = {
    A.zip(B).map { case (a, b) => a * b }.sum
  }

  // Function to extract a column from a matrix
  def getCol(matrix: Matrix, j: Int): List[Int] = {
    matrix.map(_(j))
  }

  // Function to multiply two matrices using a functional approach
  def functionalMatrixMultiply(A: Matrix, B: Matrix): Matrix = {
    val numRowsA = A.length
    val numColsA = A.head.length
    val numColsB = B.head.length

    // Ensure the matrices can be multiplied
    if (numColsA != B.length) {
      throw new IllegalArgumentException("Incompatible matrix dimensions for multiplication")
    }

    val resultMatrix: List[List[Future[Int]]] = (for {
      i <- 0 until numRowsA
    } yield {
      (for {
        j <- 0 until numColsB
      } yield {
        Future {
          computeElement(A(i), getCol(B, j))
        }
      }).toList
    }).toList

    val futures: List[Future[List[Int]]] = resultMatrix.map { rowFutures =>
      Future.sequence(rowFutures)
    }

    val result: List[List[Int]] = Await.result(Future.sequence(futures), 5.seconds)

    result
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

    val result = functionalMatrixMultiply(a, b)
  }
}
