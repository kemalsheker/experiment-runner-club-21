class graph:
    def __init__(self):
        # Defining the graph statically
        self.graph = {
            0: [1, 2],
            1: [3, 4],
            2: [5],
            3: [6, 7],
            4: [8],
            5: [],
            6: [9],
            7: [9],
            8: [9],
            9: [0]
        }

    def get_graph(self):
        return self.graph
