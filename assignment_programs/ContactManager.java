import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private ArrayList<Contact> contactList;

    public ContactManager() {
        this.contactList = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void searchContact(String name) {
        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact found:\n" + contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void removeDuplicates() {
        ArrayList<Contact> uniqueContacts = new ArrayList<>();
        for (Contact contact : contactList) {
            if (!uniqueContacts.contains(contact)) {
                uniqueContacts.add(contact);
            }
        }
        contactList = uniqueContacts;
        System.out.println("Duplicates removed.");
    }

    public void displayContactList() {
        System.out.println("Contact List:");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Remove Duplicates");
            System.out.println("4. Display Contact List");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Contact newContact = new Contact(name, phoneNumber, email);
                    contactManager.addContact(newContact);
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    contactManager.searchContact(searchName);
                    break;

                case 3:
                    contactManager.removeDuplicates();
                    break;

                case 4:
                    contactManager.displayContactList();
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{name='" + name + "', phoneNumber='" + phoneNumber + "', email='" + email + "'}";
    }
}