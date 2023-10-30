from functional import seq
from graph import graph


def dfs_func(graph, node, visited=None):
    visited = visited if visited is not None else []

    if node in visited:
        return visited

    new_visited = seq(graph.get_graph().get(node, [])).reduce(
        lambda acc, neighbour: dfs_func(graph, neighbour, acc),
        visited + [node]
    )

    return new_visited


# Example usage
if __name__ == "__main__":
    for i in range(1000000):
        dfs_func(graph(), 0)
