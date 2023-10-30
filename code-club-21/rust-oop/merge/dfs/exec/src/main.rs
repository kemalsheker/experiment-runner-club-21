use std::collections::HashSet;

type Graph = Vec<Vec<i32>>;

struct GraphWrapper {
    graph: Graph,
}

impl GraphWrapper {
    fn new(graph: Graph) -> Self {
        Self { graph }
    }

    fn dfs(&self, start: i32) -> Vec<i32> {
        let mut visited = HashSet::new();
        self._dfs(start, &mut visited)
    }

    fn _dfs(&self, current: i32, visited: &mut HashSet<i32>) -> Vec<i32> {
        let mut result = Vec::new();

        visited.insert(current);
        result.push(current);

        for &neighbor in &self.graph[current as usize] {
            if !visited.contains(&neighbor) {
                result.extend(self._dfs(neighbor, visited));
            }
        }

        result
    }
}

fn main() {

    for _i in 0..100000000 {
        let graph: Graph = vec![
            vec![1, 2],
            vec![0, 2],
            vec![0, 1],
            vec![],
        ];

        let graph_wrapper = GraphWrapper::new(graph);
        let start_node = 0;
        let _visited_nodes = graph_wrapper.dfs(start_node);
    }
}

