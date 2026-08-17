import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private Map<String, Integer> holdings;

    public Portfolio() {
        holdings = new HashMap<>();
    }

    public void addStock(String symbol, int quantity) {

        holdings.put(
                symbol,
                holdings.getOrDefault(symbol, 0) + quantity
        );
    }

    public boolean removeStock(String symbol, int quantity) {

        if (!holdings.containsKey(symbol)) {
            return false;
        }

        int currentQuantity = holdings.get(symbol);

        if (quantity > currentQuantity) {
            return false;
        }

        int remaining = currentQuantity - quantity;

        if (remaining == 0) {
            holdings.remove(symbol);
        } else {
            holdings.put(symbol, remaining);
        }

        return true;
    }

    public int getQuantity(String symbol) {
        return holdings.getOrDefault(symbol, 0);
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public boolean isEmpty() {
        return holdings.isEmpty();
    }

    public void displayPortfolio(Map<String, Stock> market) {

        if (holdings.isEmpty()) {
            System.out.println("\nYour portfolio is empty.");
            return;
        }

        System.out.println("\n======================================================");
        System.out.println("                    MY PORTFOLIO");
        System.out.println("======================================================");

        System.out.printf(
                "%-10s %-20s %-10s %-15s%n",
                "Symbol",
                "Company",
                "Quantity",
                "Current Value"
        );

        System.out.println("------------------------------------------------------");

        double totalValue = 0;

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {

            String symbol = entry.getKey();
            int quantity = entry.getValue();

            Stock stock = market.get(symbol);

            if (stock != null) {

                double value = quantity * stock.getPrice();

                totalValue += value;

                System.out.printf(
                        "%-10s %-20s %-10d ₹%-14.2f%n",
                        symbol,
                        stock.getCompanyName(),
                        quantity,
                        value
                );
            }
        }

        System.out.println("------------------------------------------------------");
        System.out.printf(
                "Total Portfolio Value: ₹%.2f%n",
                totalValue
        );

        System.out.println("======================================================");
    }

    public double calculatePortfolioValue(Map<String, Stock> market) {

        double total = 0;

        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {

            Stock stock = market.get(entry.getKey());

            if (stock != null) {
                total += entry.getValue() * stock.getPrice();
            }
        }

        return total;
    }
}