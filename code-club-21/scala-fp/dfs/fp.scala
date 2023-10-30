object DepthFirstSearch {
  def dfs(graph: Map[Int, List[Int]], startNode: Int): List[Int] = {
    def dfsRecursive(node: Int, visited: List[Int]): List[Int] = {
      if (visited.contains(node)) visited
      else {
        val newVisited = node :: visited
        val neighbors = graph.getOrElse(node, List.empty)
        neighbors.foldLeft(newVisited) { (acc, neighbor) =>
          dfsRecursive(neighbor, acc)
        }
      }
    }

    dfsRecursive(startNode, List.empty)
  }

  def main(args: Array[String]): Unit = {
    val graph = Map(
      0 -> List(1, 2),
      1 -> List(3, 4),
      2 -> List(5),
      3 -> List(6, 7),
      4 -> List(8),
      5 -> List(),
      6 -> List(9),
      7 -> List(9),
      8 -> List(9),
      9 -> List(0)
    )

    val result = dfs(graph, 0)
  }
}
