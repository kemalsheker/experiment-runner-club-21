class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def create_tree(root_value, current_depth, max_depth):
    if current_depth == max_depth:
        return None
    root = Node(root_value)
    root.left = create_tree(root_value*2, current_depth + 1, max_depth)
    root.right = create_tree(root_value*2 + 1, current_depth + 1, max_depth)
    return root
