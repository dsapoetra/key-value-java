
# KeyValueStoreJavaShell

This project is a Java-based Key-Value Store implemented as a CLI application. The Key-Value Store allows storing, retrieving, and managing key-value pairs with specific attribute types and metadata.

## Project Structure

The main files in this project include:

- **Main.java**: Entry point of the application, where the command-line interface (CLI) initiates and interacts with the key-value store.
- **Store.java**: Core class for managing the storage and retrieval of key-value pairs.
- **AttributeType.java**: Defines different types of attributes that can be stored (e.g., String, Integer).
- **AttributeMetadata.java**: Contains metadata for each attribute, such as its type and additional properties.

## Features

- **Add Key-Value Pair**: Add a new key-value pair with specified attribute type and metadata.
- **Retrieve Value by Key**: Retrieve a value based on the specified key.
- **List All Keys**: Display all stored keys.
- **Delete Key**: Remove a key-value pair by key.
- **Metadata Management**: Each key-value pair can have metadata attributes, providing additional details.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Installation

1. Download and unzip the project files.
2. Open a terminal and navigate to the project directory.

### Compilation

Run the following command to compile all Java files in the directory:
```bash
javac *.java
```

### Running the Program

After compiling, run the program with:
```bash
java Main
```

## Usage

The CLI interface will prompt you to enter commands for managing key-value pairs. The available commands might include options to add, retrieve, list, and delete keys, as well as manage attribute metadata.

### Example Interaction

```plaintext
Welcome to KeyValueStore CLI
1. Add Key-Value Pair
2. Retrieve Value by Key
3. List All Keys
4. Delete Key
5. Exit
Choose an option: 1

Enter key: user1
Enter value: Alice
Enter attribute type (e.g., String, Integer): String
Key-Value pair added.

Choose an option: 2
Enter key to retrieve: user1
Value: Alice
```

## Notes

This project provides a fundamental example of a key-value store. Extend or modify as needed for more complex use cases.

## License

This project is provided as-is for educational and demonstration purposes.

---

Feel free to explore and expand the functionalities in this Java-based Key-Value Store!
