use std::collections::HashSet;

type Graph = Vec<Vec<i32>>;

fn dfs(graph: &Graph, start: i32, visited: &mut HashSet<i32>) -> Vec<i32> {
    let mut result = Vec::new();

    visited.insert(start);
    result.push(start);

    for &neighbor in &graph[start as usize] {
        if !visited.contains(&neighbor) {
            result.extend(dfs(graph, neighbor, visited));
        }
    }

    result
}

fn main() {
    for _i in 0..100000000 {
        let graph: Graph = vec![
            vec![1, 2],
            vec![0, 2],
            vec![0, 1],
            vec![],
        ];

        let mut visited = HashSet::new();
        let start_node = 0;
        let _visited_nodes = dfs(&graph, start_node, &mut visited);
    }
}

