import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    //ArrayList<Contacts> contact = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook ab = new AddressBook();
        ArrayList<Contacts> contact = new ArrayList<>();
        // ArrayList<Contacts> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ab.addNewContacts(contact);
        boolean loop = true;
        while (loop) {
            System.out.println("Enter what you want to perform : " + '\n' + "press 1 for Edit Contact" +
                    '\n' + "press 2 for print contact" + '\n' + "Enter 3 for add contact" + '\n' +
                    "Enter 4 for delete contact" + '\n' + "Enter 0 to exit");
            final int editContact = 1, printContact = 2, addContact = 3, deleteContact = 4, Quit = 5;
            int choice = sc.nextInt();
            switch (choice) {
                case editContact:
                    ab.editContact(contact);
                    System.out.println("After editing contact");
                    ab.printContact(contact);
                    break;
                case printContact:
                    ab.printContact(contact);
                    break;
                case addContact:
                    ab.addNewContacts(contact);
                    System.out.println("After adding contacts");
                    ab.printContact(contact);
                    break;
                case deleteContact:
                    ab.deleteContact(contact);
                    break;
                case Quit:
                    ab.toQuit();
                    break;
                default:
                    loop=false;
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
            }
        }
    }

    public void deleteContact(ArrayList<Contacts> contact) {
        System.out.println("Plz enter the name whose details you want to delete");
        String name = sc.next();
        for (int i = 0; i < contact.size(); i++) {
            if (name.equalsIgnoreCase(contact.get(i).firstname)) {
                contact.remove(i);
            }
        }
    }

    private void printContact(ArrayList<Contacts> contact) {
        for (Contacts x : contact) {
            System.out.println(x.firstname + " " + x.lastname + " " + x.address + " " + x.city
                    + " " + x.state + " " + x.zip + " " + x.phoneno + " " + x.email);
        }
    }

    public void toQuit() {
        System.out.println("***** The End *****");
    }
}