import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        while (true) {
            System.out.println("\nPhone Directory");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. GUI");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneDirectory.addContact(name, phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter contact name to delete: ");
                    String delName = scanner.nextLine();
                    phoneDirectory.deleteContact(delName);
                    break;
                case 3:
                    System.out.print("Enter contact name to search: ");
                    String searchName = scanner.nextLine();
                    Contact contact = phoneDirectory.searchContact(searchName);
                    if (contact != null) {
                        System.out.println("Contact found: " + contact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("All Contacts:");
                    phoneDirectory.displayAllContacts();
                    break;
                case 5:
                    SwingUtilities.invokeLater(() -> {
                        PhoneDirectoryGUI gui = new PhoneDirectoryGUI();
                        gui.setVisible(true);
                    });
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
