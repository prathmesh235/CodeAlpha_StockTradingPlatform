import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

    private static final String FILE_NAME =
            "portfolio_data.txt";

    public static void saveUser(User user) {

        try {

            File file =
                    new File(FILE_NAME);

            FileWriter fileWriter =
                    new FileWriter(file);

            PrintWriter writer =
                    new PrintWriter(fileWriter);

            writer.println(
                    "=========================================="
            );

            writer.println(
                    "       STOCK TRADING PLATFORM DATA"
            );

            writer.println(
                    "=========================================="
            );

            writer.println(
                    "Username: " + user.getUsername()
            );

            writer.printf(
                    "Balance: %.2f%n",
                    user.getBalance()
            );

            writer.println();

            writer.println("PORTFOLIO:");

            if (user.getPortfolio().isEmpty()) {

                writer.println(
                        "No stocks owned."
                );

            } else {

                for (var entry :
                        user.getPortfolio()
                                .getHoldings()
                                .entrySet()) {

                    writer.println(
                            entry.getKey()
                                    + " : "
                                    + entry.getValue()
                                    + " shares"
                    );
                }
            }

            writer.println();

            writer.println(
                    "TRANSACTIONS:"
            );

            for (Transaction transaction :
                    user.getTransactions()) {

                writer.println(transaction);
            }

            writer.close();

            System.out.println(
                    "\nData saved successfully to "
                            + FILE_NAME
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving data: "
                            + e.getMessage()
            );
        }
    }
}