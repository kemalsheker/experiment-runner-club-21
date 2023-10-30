struct FibonacciCalculator {
    memo: Vec<u32>,
}

impl FibonacciCalculator {
    // Initialize with base Fibonacci numbers
    fn new() -> Self {
        Self { memo: vec![0, 1] }
    }

    // Calculate Fibonacci numbers using memoization
    fn calculate(&mut self, n: usize) -> u32 {
        while self.memo.len() <= n {
            let next_value = self.memo[self.memo.len() - 1] + self.memo[self.memo.len() - 2];
            self.memo.push(next_value);
        }
        self.memo[n]
    }
}

fn main() {
    let mut calculator = FibonacciCalculator::new();
    let n = 1000000000;
    let result = calculator.calculate(n);
}

