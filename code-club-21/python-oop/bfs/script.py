from collections import deque
from tree_creation import create_tree, Node

def bfs(root):
    if not root:
        return []
    
    result, queue = [], deque([root])
    while queue:
        node = queue.popleft()
        result.append(node.value)
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    return result

# Example usage:
# Create a tree and perform BFS.
if __name__ == "__main__":
    for i in range(1000000):
        tree_root = create_tree(1, 0, 5)
        bfs_result = bfs(tree_root)
