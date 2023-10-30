def mergeSort(seq: List[Int]): List[Int] = seq match {
  case Nil => Nil 
  case xs::Nil => List(xs) 
  case _ => 
    val (left, right) = seq splitAt seq.length/2
    merge(mergeSort(left), mergeSort(right))
}

@scala.annotation.tailrec
def merge(seq1: List[Int], seq2: List[Int], accumulator: List[Int] = List()):List[Int] = (seq1, seq2) match {
  case (Nil, _) => accumulator ++ seq2
  case (_, Nil) => accumulator ++ seq1
  case (x::xs, y::ys) =>
    if(x<y) merge(xs,seq2, accumulator :+ x)
    else merge(seq1,ys, accumulator :+ y)
}

def main(args: Array[String]): Unit = {
  val seq = List(5, 3, 1, 2, 4, 32, 81, 64, 123, 1000, 999, 16, 97, 654, 222, 113) // Change this to the desired sequence
  val result = mergeSort(seq)
}
