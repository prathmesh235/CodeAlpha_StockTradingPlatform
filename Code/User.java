import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private double balance;

    private Portfolio portfolio;

    private List<Transaction> transactions;

    public User(String username, double initialBalance) {

        this.username = username;
        this.balance = initialBalance;

        this.portfolio = new Portfolio();

        this.transactions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean buyStock(Stock stock, int quantity) {

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return false;
        }

        double totalCost =
                stock.getPrice() * quantity;

        if (totalCost > balance) {

            System.out.println(
                    "Insufficient balance."
            );

            return false;
        }

        balance -= totalCost;

        portfolio.addStock(
                stock.getSymbol(),
                quantity
        );

        Transaction transaction =
                new Transaction(
                        "BUY",
                        stock.getSymbol(),
                        quantity,
                        stock.getPrice()
                );

        transactions.add(transaction);

        return true;
    }

    public boolean sellStock(Stock stock, int quantity) {

        if (quantity <= 0) {

            System.out.println(
                    "Invalid quantity."
            );

            return false;
        }

        int owned =
                portfolio.getQuantity(
                        stock.getSymbol()
                );

        if (owned < quantity) {

            System.out.println(
                    "You don't own enough shares."
            );

            return false;
        }

        double totalAmount =
                stock.getPrice() * quantity;

        portfolio.removeStock(
                stock.getSymbol(),
                quantity
        );

        balance += totalAmount;

        Transaction transaction =
                new Transaction(
                        "SELL",
                        stock.getSymbol(),
                        quantity,
                        stock.getPrice()
                );

        transactions.add(transaction);

        return true;
    }

    public void displayAccount() {

        System.out.println("\n======================================================");
        System.out.println("                   ACCOUNT DETAILS");
        System.out.println("======================================================");

        System.out.println(
                "Username : " + username
        );

        System.out.printf(
                "Cash Balance : ₹%.2f%n",
                balance
        );

        System.out.println("======================================================");
    }

    public void displayTransactions() {

        if (transactions.isEmpty()) {

            System.out.println(
                    "\nNo transactions found."
            );

            return;
        }

        System.out.println("\n======================================================");
        System.out.println("                 TRANSACTION HISTORY");
        System.out.println("======================================================");

        for (Transaction transaction : transactions) {

            System.out.println(transaction);
        }

        System.out.println("======================================================");
    }
}