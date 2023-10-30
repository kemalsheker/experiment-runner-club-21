import time

from functional import seq
from collections import namedtuple

Transaction = namedtuple('Transaction', 'reason amount')
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

# Using the Scala/Spark inspired APIs
food_cost = seq(transactions)\
    .filter(lambda x: x.reason == 'food')\
    .map(lambda x: x.amount).sum()

# Using the LINQ inspired APIs
food_cost = seq(transactions)\
    .where(lambda x: x.reason == 'food')\
    .select(lambda x: x.amount).sum()

# Using PyFunctional with fn
from fn import _
for i in range(1000000):
    food_cost = seq(transactions).filter(_.reason == 'food').map(_.amount).sum()

# This code is taken from the pyfunctional's documentation
