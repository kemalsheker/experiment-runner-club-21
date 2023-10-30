import sys

class Fibonacci:
    def __init__(self):
        self.memo = {}

    def get_fibonacci(self, n):
        if n in self.memo:
            return self.memo[n]
        
        if n == 0:
            return 0
        elif n == 1:
            return 1

        result = self.get_fibonacci(n-1) + self.get_fibonacci(n-2)
        self.memo[n] = result
        return result

sys.setrecursionlimit(1000000)

# Example usage
for i in range(1000):
    fib = Fibonacci()
    fib.get_fibonacci(10000)

