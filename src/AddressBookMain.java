import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
    HashMap<String, ArrayList<Contacts>> addressbook = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook Program");
        Scanner sc = new Scanner(System.in);
        AddressBookMain abm = new AddressBookMain();
        AddressBook ab = new AddressBook();
        abm.createAddressBook();
        boolean loop = true;
        while (loop) {
            System.out.println("Enter what you want to perform : ");
            System.out.println("Press 1 to create new address book" + '\n' + "Press 2 to perform operation " +
                    "on existing address book" + '\n' + "Press 3 to search contacts with city " + '\n' + "Press 0 to exit");
            final int createAddressBook = 1, operateExisting = 2, searchContacts = 3, exit = 0;
            int option=sc.nextInt();
            switch (option) {
                case createAddressBook:
                    abm.createAddressBook();
                    break;
                case operateExisting:
                    System.out.println("Enter key belonging to address book");
                    String inputKey = sc.next();
                    if (abm.addressbook.containsKey(inputKey))
                        ab.callAddressBook(abm.addressbook.get(inputKey));
                    else
                        System.out.println("Entered key address book not available");
                    break;
                case  searchContacts:
                    abm.searchContactsWithCity();
                    break;
                case exit:
                    ab.toQuit();
                    loop = false;
                    break;

                default:
                    System.out.println("Entered Incorrect input");
            }
        }
    }

    public void createAddressBook() {
        System.out.println("Create address book of your choice");
        ArrayList<Contacts> contacts = new ArrayList<>();
        System.out.println("Enter the unique key name");
        String name = sc.next();
        if (!addressbook.containsKey(name))
            addressbook.put(name, contacts);
        else
            System.out.println("The key is already present");
    }

    public void searchContactsWithCity() {
        System.out.println("Please enter city name");
        String cityName = sc.next();
        List<Contacts> listOfContacts = addressbook.values().stream().flatMap(p -> p.stream()).filter(p -> p.getCity().equals(cityName)).collect(Collectors.toList());
        for (Contacts contact : listOfContacts) {
            if (contact.getCity().equals(cityName)) {
                System.out.println(contact);
            }
        }
    }
}