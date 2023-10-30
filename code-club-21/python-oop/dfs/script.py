from graph import graph

class DepthFirstSearch:
    def __init__(self, graph):
        self.graph = graph
    
    def DFSUtil(self, v, visited):
        visited.add(v)
 
        for neighbour in self.graph[v]:
            if neighbour not in visited:
                self.DFSUtil(neighbour, visited)
 
    def DFS(self, v):
        visited = set()
        self.DFSUtil(v, visited)

if __name__ == "__main__":
    for i in range(1000000):
        g = graph()
        dfs = DepthFirstSearch(g.get_graph())
        dfs.DFS(0)


#This DFS algorithm taken from https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/ #
