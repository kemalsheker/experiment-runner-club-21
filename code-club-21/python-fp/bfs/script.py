from tree_creation import create_tree, Node
from functools import reduce

def bfs_functional(queue, result):
    if not queue:
        return result
    
    # Head of the queue
    node = queue[0]  
    
    # New result after visiting the current node
    new_result = result + [node.value]  
    
    # New queue after visiting children of the current node
    new_queue = queue[1:] + [child for child in (node.left, node.right) if child]
    
    return bfs_functional(new_queue, new_result)

if __name__ == "__main__":
    for i in range(1000000):
        tree_root = create_tree(1, 0, 5)
        bfs_result = bfs_functional([tree_root], [])
