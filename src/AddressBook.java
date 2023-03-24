import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    Scanner sc = new Scanner(System.in);

    public void callAddressBook(ArrayList<Contacts> contacts) {
        boolean loop = true;
        while (loop) {
            System.out.println("Enter what you want to perform : " + '\n' + "press 1 for edit Contact" +
                    '\n' + "press 2 for print contact" + '\n' + "Enter 3 for add contact" + '\n' +
                    "Enter 4 for delete contact" + '\n' + "Enter 0 to exit");
            final int editContact = 1, printContact = 2, addContact = 3, deleteContact = 4, Quit = 5;
            int choice = sc.nextInt();
            switch (choice) {
                case editContact:
                    if (contacts.isEmpty())
                        System.out.println("Address book is empty");
                    else {
                        editContact(contacts);
                        System.out.println("After editing contact");
                        printContact(contacts);
                    }
                    break;
                case printContact:
                    if (contacts.isEmpty())
                        System.out.println("Address book is empty");
                    else
                        printContact(contacts);
                    break;
                case addContact:
                    addNewContacts(contacts);
                    System.out.println("After adding contacts");
                    printContact(contacts);
                    break;
                case deleteContact:
                    if (contacts.isEmpty())
                        System.out.println("Address book is empty");
                    else
                        deleteContact(contacts);
                    break;
                default:
                    loop = false;

            }
        }
    }

    public void addNewContacts(ArrayList<Contacts> contact) {
        System.out.println("Enter how many contacts you want to save");
        int noOfContacts = sc.nextInt();

        for (int i = 0; i < noOfContacts; i++) {
            Contacts contacts = new Contacts();
            System.out.println("Enter First Name of " + (i + 1) + " Contact: ");
            contacts.firstname = sc.next();
            System.out.println("Enter last Name of " + (i + 1) + " Contact: ");
            contacts.lastname = sc.next();
            Boolean result = contact.stream().anyMatch(P -> contact.equals(P));
            if (result) {
                System.out.println("Contact already available for entered name");
                System.out.println("If you wish to retry press 1 for exit press 0");
                int choice = sc.nextInt();
                if (choice == 1)
                    i--;
                continue;
            }
            System.out.println("Enter address of " + (i + 1) + " Contact: ");
            contacts.address = sc.next();
            System.out.println("Enter city of " + (i + 1) + " Contact: ");
            contacts.city = sc.next();
            System.out.println("Enter state of " + (i + 1) + " Contact: ");
            contacts.state = sc.next();
            System.out.println("Enter ZipCode of " + (i + 1) + " Contact: ");
            contacts.zip = sc.nextInt();
            System.out.println("Enter phone number of " + (i + 1) + " Contact: ");
            contacts.phoneno = sc.nextLong();
            System.out.println("Enter email of " + (i + 1) + " Contact: ");
            contacts.email = sc.next();

            contact.add(contacts);
        }
    }

    public void editContact(ArrayList<Contacts> contact) {
        System.out.println("Please Enter the name whose details you want to change");
        String name = sc.next();
        Contacts contacts = new Contacts();
        for (int i = 0; i < contact.size(); i++) {
            if (name.equalsIgnoreCase(contact.get(i).firstname)) {
                boolean loop = true;
                while (loop) {
                    final int firstName = 1, lastName = 2, address = 3, city = 4, state = 5, zipCode = 6, phoneNumber = 7, email = 8, stopEditing = 0;
                    System.out.println("What you want to change :" + '\n' + "Press 1 for first name " + '\n' +
                            "Press 2 for last name " + '\n' + "Enter 3 for address " + '\n' + "Enter 4 for city"
                            + '\n' + "Enter 5 for state" + '\n' + "Enter 6 for zip code" + '\n' + "Enter 7 for phone number"
                            + '\n' + "Enter 8 for email" + '\n' + "Enter 0 to stop editing");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case firstName:
                            System.out.println("Please Enter the name to be updated");
                            contact.get(i).firstname = sc.next();
                            break;
                        case lastName:
                            System.out.println("Please Enter the lastname to be updated");
                            contact.get(i).lastname = sc.next();
                            break;
                        case address:
                            System.out.println("Please Enter the address to be updated");
                            contact.get(i).address = sc.next();
                            break;
                        case city:
                            System.out.println("Please Enter the city to be updated");
                            contact.get(i).city = sc.next();
                            break;
                        case state:
                            System.out.println("Please enter the state to be updated");
                            contact.get(i).state = sc.next();
                            break;
                        case zipCode:
                            System.out.println("Please Enter the zip code to be updated");
                            contact.get(i).zip = sc.nextInt();
                            break;
                        case phoneNumber:
                            System.out.println("Please Enter the phone number to be updated");
                            contact.get(i).phoneno = sc.nextLong();
                            break;
                        case email:
                            System.out.println("Please Enter the email to be updated");
                            contact.get(i).email = sc.next();
                            break;
                        case stopEditing:
                            loop = false;
                            break;
                        default:
                            System.out.println("You Entered wrong input");

                    }
                }
            } else
                System.out.println("Contact not available for entered name");
        }
    }

    public void deleteContact(ArrayList<Contacts> contact) {
        System.out.println("Plz enter the name whose details you want to delete");
        String name = sc.next();
        for (int i = 0; i < contact.size(); i++) {
            if (name.equalsIgnoreCase(contact.get(i).firstname)) {
                contact.remove(i);
            } else {
                System.out.println("Contact not available for entered name");
            }
        }
    }

    private void printContact(ArrayList<Contacts> contact) {
        for (Contacts x : contact) {
            System.out.println(x.firstname + " " + x.lastname + " " + x.address + " " + x.city
                    + " " + x.state + " " + x.zip + " " + x.phoneno + " " + x.email);
        }
    }

    public static void toQuit() {
        System.out.println("***** The End *****");
    }
}
