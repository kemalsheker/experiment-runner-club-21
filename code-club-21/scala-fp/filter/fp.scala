case class Transaction(reason: String, amount: Double)

object TransactionAnalyzer {
  def main(args: Array[String]): Unit = {
    val transactions = List(
      Transaction("github", 7),
      Transaction("food", 10),
      Transaction("coffee", 5),
      Transaction("digitalocean", 5),
      Transaction("food", 5),
      Transaction("riotgames", 25),
      Transaction("food", 10),
      Transaction("amazon", 200),
      Transaction("paycheck", -1000)
    )


    // Using PyFunctional-like syntax
    val foodCostPyFunctional = transactions
      .filter(_.reason == "food")
      .map(_.amount)
      .sum

  }
}
