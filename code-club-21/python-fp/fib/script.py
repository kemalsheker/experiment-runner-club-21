import sys

def fibonacci(n, memo={}):
    if n in memo:
        return memo[n]

    if n == 0:
        return 0
    elif n == 1:
        return 1

    result = fibonacci(n-1, memo) + fibonacci(n-2, memo)
    memo[n] = result
    return result

sys.setrecursionlimit(1000000)

for i in range(10000):
    fibonacci(10000)
