import scala.collection.mutable.Queue

class Graph[V](adjList: Map[V, List[V]]) {
  def bfs(start: V): List[V] = {
    val visited = collection.mutable.Set[V]()
    val result = collection.mutable.ListBuffer[V]()
    val queue = Queue(start)

    while (queue.nonEmpty) {
      val vertex = queue.dequeue()
      if (!visited.contains(vertex)) {
        visited += vertex
        result += vertex
        for (neighbor <- adjList.getOrElse(vertex, List())) {
          if (!visited.contains(neighbor)) {
            queue.enqueue(neighbor)
          }
        }
      }
    }

    result.toList
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val adjacencyList = Map(
      "A" -> List("B", "C"),
      "B" -> List("D", "E"),
      "C" -> List("F"),
      "D" -> List(),
      "E" -> List("F"),
      "F" -> List()
    )

    val graph = new Graph(adjacencyList)
    val startNode = "A"
    val bfsResult = graph.bfs(startNode)

    System.exit(0)
  }
}
