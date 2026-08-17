import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private String stockSymbol;
    private int quantity;
    private double price;
    private double totalAmount;
    private String dateTime;

    public Transaction(String type, String stockSymbol,
                       int quantity, double price) {

        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = quantity * price;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.dateTime = LocalDateTime.now().format(formatter);
    }

    public String getType() {
        return type;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {

        return String.format(
                "%-6s %-8s Qty: %-5d Price: ₹%-10.2f Total: ₹%-10.2f Date: %s",
                type,
                stockSymbol,
                quantity,
                price,
                totalAmount,
                dateTime
        );
    }
}