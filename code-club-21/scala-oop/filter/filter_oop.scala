class TransactionOOP(reason: String, amount: Double) {
  def getReason: String = reason
  def getAmount: Double = amount
}

class TransactionAnalyzer(transactions: List[TransactionOOP]) {
  def calculateCostForReason(reason: String): Double = {
    var totalCost = 0.0
    for (transaction <- transactions) {
      if (transaction.getReason == reason) {
        totalCost += transaction.getAmount
      }
    }
    totalCost
  }
}

object TransactionAnalyzerApp {
  def main(args: Array[String]): Unit = {
    val transactions = List(
      new TransactionOOP("github", 7),
      new TransactionOOP("food", 10),
      new TransactionOOP("coffee", 5),
      new TransactionOOP("digitalocean", 5),
      new TransactionOOP("food", 5),
      new TransactionOOP("riotgames", 25),
      new TransactionOOP("food", 10),
      new TransactionOOP("amazon", 200),
      new TransactionOOP("paycheck", -1000)
    )

    val analyzer = new TransactionAnalyzer(transactions)
    val start = System.currentTimeMillis()
    val foodCost = analyzer.calculateCostForReason("food")
    val elapsed = (System.currentTimeMillis() - start) / 1000.0

    System.exit(0)
  }
}
