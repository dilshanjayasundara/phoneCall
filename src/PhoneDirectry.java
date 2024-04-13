import java.util.HashMap;
import java.util.Map;

class PhoneDirectory {
    private Map<String, Contact> contacts;

    public PhoneDirectory() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, new Contact(name, phoneNumber));
    }

    public void deleteContact(String name) {
        contacts.remove(name);
    }

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public void displayAllContacts() {
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }
}