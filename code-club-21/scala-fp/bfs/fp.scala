import scala.collection.mutable.Queue

object BFS {
  def bfs[V](adjList: Map[V, List[V]], start: V): List[V] = {
    @annotation.tailrec
    def bfsRecursive(queue: List[V], visited: Set[V], result: List[V]): List[V] = {
      queue match {
        case Nil => result.reverse
        case vertex :: rest if visited.contains(vertex) =>
          bfsRecursive(rest, visited, result)
        case vertex :: rest =>
          val neighbors = adjList.getOrElse(vertex, List())
          val unvisitedNeighbors = neighbors.filterNot(visited)
          val updatedQueue = rest ++ unvisitedNeighbors
          val updatedVisited = visited + vertex
          bfsRecursive(updatedQueue, updatedVisited, vertex :: result)
      }
    }

    val initialQueue = List(start)
    bfsRecursive(initialQueue, Set.empty, List())
  }

  def main(args: Array[String]): Unit = {
    val adjacencyList = Map(
      "A" -> List("B", "C"),
      "B" -> List("D", "E"),
      "C" -> List("F"),
      "D" -> List(),
      "E" -> List("F"),
      "F" -> List()
    )

    val startNode = "A"
    val bfsResult = bfs(adjacencyList, startNode)

    System.exit(0)
  }
}

