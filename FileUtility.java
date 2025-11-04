// FileUtility.java
// Demonstrates reading, writing, and modifying text files using Java

import java.io.*;
import java.util.*;

public class FileUtility {

    // Method to write content into a file
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("✅ File written successfully: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a file
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("\n📖 File Content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file content (e.g., append text)
    public static void modifyFile(String filename, String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) { 
            // 'true' enables append mode
            writer.write("\n" + newContent);
            System.out.println("🛠 File modified successfully (content appended).");
        } catch (IOException e) {
            System.out.println("❌ Error modifying file: " + e.getMessage());
        }
    }

    // Main method demonstrating file operations
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "sample.txt";

        System.out.println("=== FILE HANDLING UTILITY ===");
        System.out.println("1. Write to File");
        System.out.println("2. Read from File");
        System.out.println("3. Modify File");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter text to write: ");
                String content = sc.nextLine();
                writeToFile(filename, content);
                break;

            case 2:
                readFromFile(filename);
                break;

            case 3:
                System.out.print("Enter text to append: ");
                String newContent = sc.nextLine();
                modifyFile(filename, newContent);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}