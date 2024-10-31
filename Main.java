
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Map<String, String>> keyValueStore = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to KeyValueStore CLI");
            System.out.println("1. Add Key-Value Pair");
            System.out.println("2. Retrieve Value by Key");
            System.out.println("3. List All Keys");
            System.out.println("4. Delete Key");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    handleAddCommand(scanner);
                    break;
                case "2":
                    handleGetCommand(scanner);
                    break;
                case "3":
                    handleListCommand();
                    break;
                case "4":
                    handleDeleteCommand(scanner);
                    break;
                case "5":
                    System.out.println("Exiting Key-Value Store...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 5.");
            }
        }
    }

    private static void handleAddCommand(Scanner scanner) {
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        System.out.print("Enter attribute: ");
        String attribute = scanner.nextLine();
        System.out.print("Enter value: ");
        String value = scanner.nextLine();

        keyValueStore.putIfAbsent(key, new HashMap<>());
        keyValueStore.get(key).put(attribute, value);
        System.out.println("Added: Key = " + key + ", Attribute = " + attribute + ", Value = " + value);
    }

    private static void handleGetCommand(Scanner scanner) {
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        System.out.print("Enter attribute: ");
        String attribute = scanner.nextLine();

        if (keyValueStore.containsKey(key) && keyValueStore.get(key).containsKey(attribute)) {
            String value = keyValueStore.get(key).get(attribute);
            System.out.println("Value: " + value);
        } else {
            System.out.println("No value found for Key = " + key + ", Attribute = " + attribute);
        }
    }

    private static void handleListCommand() {
        if (keyValueStore.isEmpty()) {
            System.out.println("The key-value store is empty.");
        } else {
            System.out.println("All keys in the store:");
            keyValueStore.keySet().forEach(System.out::println);
        }
    }

    private static void handleDeleteCommand(Scanner scanner) {
        System.out.print("Enter key to delete: ");
        String key = scanner.nextLine();

        if (keyValueStore.containsKey(key)) {
            keyValueStore.remove(key);
            System.out.println("Deleted key: " + key);
        } else {
            System.out.println("No such key found: " + key);
        }
    }
}
