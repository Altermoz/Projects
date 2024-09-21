import java.io.*;
import java.util.*;

public class UserAccountManager {

    private static final String FILE_NAME = "records.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        while (true) {
            System.out.println("1. Create/Register");
            System.out.println("2. Login");
            System.out.println("3. Delete");
            System.out.println("4. Update");
            System.out.println("5. Exit");
            System.out.print("\n");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    deleteUser(scanner);
                    break;
                case 4:
                    updateUser(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    System.out.println("\n");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter a username (alphanumeric only): ");
        String username = scanner.nextLine();
        System.out.print("Enter password (alphanumeric only): ");
        String password = scanner.nextLine();

        if (!isAlphanumeric(username) || !isAlphanumeric(password)) {
            System.out.println("Username and password must be alphanumeric.");
            System.out.println("\n");
            return;
        }

        if (doesUserExist(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            System.out.println("\n");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + ":" + password);
            writer.newLine();
            System.out.println("User registered successfully.");
            System.out.println("\n");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    private static boolean doesUserExist(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return false;
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean success = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username) && parts [1].equals(password)) {
                    success = true;
                    break;
                }
            }
            if (success) {
                System.out.println("Login successful.");
                System.out.println("\n");
            } else {
                System.out.println("Invalid username or password.");
                System.out.println("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private static void deleteUser(Scanner scanner) {
        List<String> records = readFile();
        if (records.isEmpty()) {
            System.out.println("No records found.");
            System.out.println("\n");
            return;
        }

        System.out.println("User records:");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i).split(":")[0]);
        }

        System.out.print("Enter the number of the user to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < records.size()) {
            records.remove(index);
            writeFile(records);
            System.out.println("User deleted successfully.");
            System.out.println("\n");
        } else {
            System.out.println("Invalid number.");
            System.out.println("\n");
        }
    }

    private static void updateUser(Scanner scanner) {
        List<String> records = readFile();
        if (records.isEmpty()){
            System.out.println("No records found.");
            return;
        }

        System.out.println("User records:");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i).split(":")[0]);
        }

        System.out.print("Enter the number of the user to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < records.size()) {
            System.out.print("Enter new username (alphanumeric only): ");
            String newUsername = scanner.nextLine();
            System.out.print("Enter new password (alphanumeric only): ");
            String newPassword = scanner.nextLine();

            if (!isAlphanumeric(newUsername) || !isAlphanumeric(newPassword)) {
                System.out.println("Username and password must be alphanumeric.");
                System.out.println("\n");
                return;
            }

            records.set(index, newUsername + ":" + newPassword);
            writeFile(records);
            System.out.println("User updated successfully.");
            System.out.println("\n");
        } else {
            System.out.println("Invalid number.");
            System.out.println("\n");
        }
    }

    private static List<String> readFile() {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return records;
    }

    private static void writeFile(List<String> records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    private static boolean isAlphanumeric(String str) {
        return str != null && str.matches("[a-zA-Z0-9]+");
    }
}