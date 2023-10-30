class GraphDFSOOP {
  private var graph: Map[Int, List[Int]] = Map()

  def addNode(node: Int, neighbors: List[Int]): Unit = {
    graph += (node -> neighbors)
  }

  def dfs(startNode: Int): List[Int] = {
    val visited = dfsRecursive(startNode, List.empty)
    visited.reverse
  }

  private def dfsRecursive(node: Int, visited: List[Int]): List[Int] = {
    if (visited.contains(node)) visited
    else {
      val newVisited = node :: visited
      val neighbors = graph.getOrElse(node, List.empty)
      neighbors.foldLeft(newVisited) { (acc, neighbor) =>
        dfsRecursive(neighbor, acc)
      }
    }
  }
}

object DepthFirstSearchOOP {
  def main(args: Array[String]): Unit = {
    val graph = new GraphDFSOOP()

    graph.addNode(0, List(1, 2))
    graph.addNode(1, List(3, 4))
    graph.addNode(2, List(5))
    graph.addNode(3, List(6, 7))
    graph.addNode(4, List(8))
    graph.addNode(5, List())
    graph.addNode(6, List(9))
    graph.addNode(7, List(9))
    graph.addNode(8, List(9))
    graph.addNode(9, List(0))

    val result = graph.dfs(0)

    System.exit(0)
  }
}
