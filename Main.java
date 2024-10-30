
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Java Shell Key-Value Store");
        System.out.println("Commands: add <key> <attribute> <value>, get <key> <attribute>, exit");
        
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            
            if (tokens[0].equalsIgnoreCase("add") && tokens.length == 4) {
                String key = tokens[1];
                String attribute = tokens[2];
                String value = tokens[3];
                AttributeType type = store.determineType(value);
                store.addAttributeType(attribute, new AttributeMetadata(type));
                store.setValue(key, attribute, store.parseValue(type, value));
                System.out.println("Attribute added.");
            } else if (tokens[0].equalsIgnoreCase("get") && tokens.length == 3) {
                String key = tokens[1];
                String attribute = tokens[2];
                Object result = store.getValue(key, attribute);
                System.out.println("Value: " + (result != null ? result : "Not found"));
            } else if (tokens[0].equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
        
        scanner.close();
    }
}
