import concurrent.futures
from matrices import a, b

class MatrixMultiplier:
    def __init__(self, a, b):
        self.a = a
        self.b = b
        self.result = [[0] * len(b[0]) for _ in range(len(a))]

    def calculate_cell(self, i, j):
        self.result[i][j] = sum(self.a[i][k] * self.b[k][j] for k in range(len(self.b)))

    def multiply(self):
        with concurrent.futures.ThreadPoolExecutor() as executor:
            futures = [
                executor.submit(self.calculate_cell, i, j)
                for i in range(len(self.a))
                for j in range(len(self.b[0]))
            ]

            # Ensure all calculations are done before proceeding.
            concurrent.futures.wait(futures)

if __name__ == "__main__":

    for i in range (10000):
        matrix_multiplier = MatrixMultiplier(a, b)
        matrix_multiplier.multiply()
