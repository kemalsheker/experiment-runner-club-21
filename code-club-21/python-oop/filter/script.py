import time
from collections import namedtuple

Transaction = namedtuple('Transaction', 'reason amount')

class TransactionAnalyzer:
    def __init__(self, transactions):
        self.transactions = transactions
        
    def calculate_cost_for_reason(self, reason):
        total_cost = 0
        for transaction in self.transactions:
            if transaction.reason == reason:
                total_cost += transaction.amount
        return total_cost

if __name__ == "__main__":
    for i in range (1000000):
        transactions = [
            Transaction('github', 7),
            Transaction('food', 10),
            Transaction('coffee', 5),
            Transaction('digitalocean', 5),
            Transaction('food', 5),
            Transaction('riotgames', 25),
            Transaction('food', 10),
            Transaction('amazon', 200),
            Transaction('paycheck', -1000)
        ]

        analyzer = TransactionAnalyzer(transactions)
        food_cost = analyzer.calculate_cost_for_reason('food')
