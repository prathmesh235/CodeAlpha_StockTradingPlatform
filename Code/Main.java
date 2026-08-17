import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner =
            new Scanner(System.in);

    private static Map<String, Stock> market =
            new HashMap<>();

    private static User user;

    public static void main(String[] args) {

        initializeMarket();

        showWelcomeScreen();

        createUser();

        boolean running = true;

        while (running) {

            displayMenu();

            int choice =
                    readInteger("Enter your choice: ");

            switch (choice) {

                case 1:
                    displayMarket();
                    break;

                case 2:
                    buyStock();
                    break;

                case 3:
                    sellStock();
                    break;

                case 4:
                    user.getPortfolio()
                            .displayPortfolio(market);
                    break;

                case 5:
                    user.displayTransactions();
                    break;

                case 6:
                    user.displayAccount();
                    break;

                case 7:
                    updateStockPrices();
                    break;

                case 8:
                    FileManager.saveUser(user);
                    break;

                case 9:
                    System.out.println(
                            "\nThank you for using "
                                    + "Stock Trading Platform."
                    );

                    running = false;
                    break;

                default:
                    System.out.println(
                            "\nInvalid choice."
                    );
            }
        }

        scanner.close();
    }

    private static void showWelcomeScreen() {

        System.out.println();

        System.out.println(
                "======================================================"
        );

        System.out.println(
                "              STOCK TRADING PLATFORM"
        );

        System.out.println(
                "======================================================"
        );

        System.out.println(
                "      Java OOP Based Trading Simulation"
        );

        System.out.println(
                "======================================================"
        );
    }

    private static void initializeMarket() {

        market.put(
                "TCS",
                new Stock(
                        "TCS",
                        "Tata Consultancy Services",
                        3800
                )
        );

        market.put(
                "INFY",
                new Stock(
                        "INFY",
                        "Infosys",
                        1750
                )
        );

        market.put(
                "RELI",
                new Stock(
                        "RELI",
                        "Reliance Industries",
                        2900
                )
        );

        market.put(
                "HDFC",
                new Stock(
                        "HDFC",
                        "HDFC Bank",
                        1650
                )
        );

        market.put(
                "ICICI",
                new Stock(
                        "ICICI",
                        "ICICI Bank",
                        1250
                )
        );

        market.put(
                "WIPRO",
                new Stock(
                        "WIPRO",
                        "Wipro",
                        550
                )
        );

        market.put(
                "ITC",
                new Stock(
                        "ITC",
                        "ITC Limited",
                        480
                )
        );

        market.put(
                "SBIN",
                new Stock(
                        "SBIN",
                        "State Bank of India",
                        820
                )
        );
    }

    private static void createUser() {

        System.out.println();

        System.out.println(
                "Create Trading Account"
        );

        System.out.println(
                "----------------------"
        );

        System.out.print(
                "Enter your username: "
        );

        String username =
                scanner.nextLine();

        double balance =
                readDouble(
                        "Enter initial balance: ₹"
                );

        while (balance < 0) {

            System.out.println(
                    "Balance cannot be negative."
            );

            balance =
                    readDouble(
                            "Enter initial balance: ₹"
                    );
        }

        user =
                new User(
                        username,
                        balance
                );

        System.out.println(
                "\nAccount created successfully!"
        );
    }

    private static void displayMenu() {

        System.out.println();

        System.out.println(
                "================ MAIN MENU ================"
        );

        System.out.println(
                "1. View Market"
        );

        System.out.println(
                "2. Buy Stock"
        );

        System.out.println(
                "3. Sell Stock"
        );

        System.out.println(
                "4. View Portfolio"
        );

        System.out.println(
                "5. Transaction History"
        );

        System.out.println(
                "6. Account Details"
        );

        System.out.println(
                "7. Update Market Prices"
        );

        System.out.println(
                "8. Save Portfolio Data"
        );

        System.out.println(
                "9. Exit"
        );

        System.out.println(
                "============================================"
        );
    }

    private static void displayMarket() {

        System.out.println();

        System.out.println(
                "======================================================"
        );

        System.out.println(
                "                    MARKET DATA"
        );

        System.out.println(
                "======================================================"
        );

        System.out.printf(
                "%-10s %-25s %s%n",
                "Symbol",
                "Company",
                "Price"
        );

        System.out.println(
                "------------------------------------------------------"
        );

        for (Stock stock :
                market.values()) {

            System.out.println(stock);
        }

        System.out.println(
                "======================================================"
        );
    }

    private static void buyStock() {

        displayMarket();

        System.out.print(
                "\nEnter stock symbol to buy: "
        );

        String symbol =
                scanner.nextLine()
                        .toUpperCase();

        Stock stock =
                market.get(symbol);

        if (stock == null) {

            System.out.println(
                    "Stock not found."
            );

            return;
        }

        int quantity =
                readInteger(
                        "Enter quantity: "
                );

        double total =
                stock.getPrice()
                        * quantity;

        System.out.printf(
                "Total cost: ₹%.2f%n",
                total
        );

        System.out.printf(
                "Available balance: ₹%.2f%n",
                user.getBalance()
        );

        System.out.print(
                "Confirm purchase? (Y/N): "
        );

        String confirmation =
                scanner.nextLine();

        if (!confirmation.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Purchase cancelled."
            );

            return;
        }

        boolean success =
                user.buyStock(
                        stock,
                        quantity
                );

        if (success) {

            System.out.println(
                    "\nStock purchased successfully!"
            );

            System.out.println(
                    "Stock: " + symbol
            );

            System.out.println(
                    "Quantity: " + quantity
            );

            System.out.printf(
                    "Amount Paid: ₹%.2f%n",
                    total
            );
        }
    }

    private static void sellStock() {

        displayMarket();

        System.out.print(
                "\nEnter stock symbol to sell: "
        );

        String symbol =
                scanner.nextLine()
                        .toUpperCase();

        Stock stock =
                market.get(symbol);

        if (stock == null) {

            System.out.println(
                    "Stock not found."
            );

            return;
        }

        int owned =
                user.getPortfolio()
                        .getQuantity(symbol);

        System.out.println(
                "You currently own: "
                        + owned
                        + " shares"
        );

        int quantity =
                readInteger(
                        "Enter quantity to sell: "
                );

        if (quantity > owned) {

            System.out.println(
                    "You don't own enough shares."
            );

            return;
        }

        double total =
                stock.getPrice()
                        * quantity;

        System.out.printf(
                "You will receive: ₹%.2f%n",
                total
        );

        System.out.print(
                "Confirm sale? (Y/N): "
        );

        String confirmation =
                scanner.nextLine();

        if (!confirmation.equalsIgnoreCase("Y")) {

            System.out.println(
                    "Sale cancelled."
            );

            return;
        }

        boolean success =
                user.sellStock(
                        stock,
                        quantity
                );

        if (success) {

            System.out.println(
                    "\nStock sold successfully!"
            );

            System.out.println(
                    "Stock: " + symbol
            );

            System.out.println(
                    "Quantity: " + quantity
            );

            System.out.printf(
                    "Amount Received: ₹%.2f%n",
                    total
            );
        }
    }

    private static void updateStockPrices() {

        Random random =
                new Random();

        System.out.println(
                "\nUpdating market prices..."
        );

        for (Stock stock :
                market.values()) {

            double oldPrice =
                    stock.getPrice();

            double change =
                    (random.nextDouble() * 0.10)
                            - 0.05;

            double newPrice =
                    oldPrice
                            + (oldPrice * change);

            stock.setPrice(
                    Math.round(
                            newPrice * 100
                    ) / 100.0
            );
        }

        System.out.println(
                "Market prices updated successfully."
        );
    }

    private static int readInteger(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value =
                        Integer.parseInt(
                                scanner.nextLine()
                        );

                if (value <= 0) {

                    System.out.println(
                            "Enter a value greater than 0."
                    );

                    continue;
                }

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid amount."
                );
            }
        }
    }
}
