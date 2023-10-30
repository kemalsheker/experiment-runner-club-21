use std::collections::{HashSet, VecDeque};

type Graph = Vec<Vec<i32>>;

struct GraphWrapper {
    graph: Graph,
}

impl GraphWrapper {
    fn new(graph: Graph) -> Self {
        Self { graph }
    }

    fn bfs(&self, start: i32) -> Vec<i32> {
        let mut visited = HashSet::new();
        let mut queue = VecDeque::new();
        let mut result = Vec::new();

        visited.insert(start);
        queue.push_back(start);

        while let Some(current) = queue.pop_front() {
            result.push(current);

            for &neighbor in &self.graph[current as usize] {
                if !visited.contains(&neighbor) {
                    visited.insert(neighbor);
                    queue.push_back(neighbor);
                }
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
        let _visited_nodes = graph_wrapper.bfs(start_node);
    }
}

