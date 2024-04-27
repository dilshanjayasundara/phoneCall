import java.io.*;
import java.util.*;

class PhoneDirectory {
    private Map<String, Contact> contacts;
    private static final String FILE_NAME = "contacts.txt";

    public PhoneDirectory() {
        contacts = new HashMap<>();
        loadContactsFromFile();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, new Contact(name, phoneNumber));
        saveContactsToFile();
    }

    public void deleteContact(String name) {
        contacts.remove(name);
        saveContactsToFile();
    }

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public void displayAllContacts() {
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    private void saveContactsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts.values()) {
                writer.println(contact.getName() + "," + contact.getPhoneNumber());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadContactsFromFile() {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    contacts.put(name, new Contact(name, phoneNumber));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Contacts file not found. Creating a new one.");
        }
    }
}
