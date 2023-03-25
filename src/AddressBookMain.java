import java.util.*;
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
                    "on existing address book" + '\n' + "Press 3 to search contacts with city " + '\n'
                    + "Press 4 to get person with city" + '\n' + "Press 5 to get number of contacts by city"
                    + '\n' + "Press 6 to get sorted contacts by name/City/State/Zip" + '\n' + "Press 0 to exit");
            final int createAddressBook = 1, operateExisting = 2, searchContacts = 3, getPersonWithCity = 4,
                    getNoOfContactByCity = 5, sortedDetails = 6, exit = 0;
            try {
                int option = sc.nextInt();
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
                    case searchContacts:
                        abm.searchContactsWithCity();
                        break;
                    case getPersonWithCity:
                        abm.getContactByCityAndState();
                        break;
                    case getNoOfContactByCity:
                        abm.getNumberOfContacts();
                        break;
                    case sortedDetails:
                        abm.getSortedDetails();
                        break;
                    case exit:
                        ab.toQuit();
                        loop = false;
                        break;

                    default:
                        System.out.println("Entered Incorrect input");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You entered incorrect input, now enter correct input");
            }
        }
    }

    public void createAddressBook() {
        System.out.println("Create address book ");
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
                System.out.println(listOfContacts);
            }
        }
    }

    public void getContactByCityAndState() {
        List<Contacts> myContactList = addressbook.values().stream().flatMap(A -> A.stream()).collect(Collectors.toList());
        Map<String, List<Contacts>> myContactListByCity = myContactList.stream().collect(Collectors.groupingBy(Contacts::getCity));
        System.out.println(myContactListByCity);
        Map<String, List<Contacts>> myContactListByState = myContactList.stream().collect(Collectors.groupingBy(Contacts::getState));
        System.out.println(myContactListByState);
    }

    public void getNumberOfContacts() {
        System.out.println("Please enter choice parameter ");
        System.out.println("Press 1 for City" + '\n' + "Press 2 for State");
        final int byCity = 1, byState = 2;
        try {
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case byCity:
                    System.out.println("Please enter city name");
                    String cityName = input.next();
                    long countByCity = addressbook.values().stream().flatMap(Collection::stream).filter(p -> p.getCity().equalsIgnoreCase(cityName)).count();
                    System.out.println("Count of contacts with " + cityName + " are " + countByCity);
                    break;
                case byState:
                    System.out.println("Please enter State name");
                    String stateName = input.next();
                    long countByState = addressbook.values().stream().flatMap(Collection::stream).filter(p -> p.getCity().equalsIgnoreCase(stateName)).count();
                    System.out.println("Count of contacts with " + stateName + " are " + countByState);
                    break;
                default:
                    System.out.println("You entered wrong input");
            }
        } catch (InputMismatchException e) {
            System.out.println("You entered wrong input. Please enter valid input");
        }

    }

    public void getSortedDetails() {
        System.out.println("Please enter the choice parameter by which you want sort");
        System.out.println("Press 1 for Name" + '\n' + "Press 2 for City" + '\n' + "Press 3 for State" + '\n' + "Press 4 for ZipCode");
        final int byName = 1, byCity = 2, byState = 3, byZipCode = 4;
        try {
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case byName:
                    System.out.println(addressbook.values().stream().flatMap(Collection::stream)
                            .sorted((Comparator.comparing(Contacts::getFirstname))).collect(Collectors.toList()));
                    break;
                case byCity:
                    System.out.println(addressbook.values().stream().flatMap(Collection::stream)
                            .sorted((Comparator.comparing(Contacts::getCity))).collect(Collectors.toList()));
                    break;
                case byState:
                    System.out.println(addressbook.values().stream().flatMap(Collection::stream)
                            .sorted((Comparator.comparing(Contacts::getState))).collect(Collectors.toList()));
                    break;
                case byZipCode:
                    System.out.println(addressbook.values().stream().flatMap(Collection::stream)
                            .sorted((Comparator.comparing(Contacts::getZip))).collect(Collectors.toList()));
                    break;
                default:
                    System.out.println("You entered wrong input");
            }
        } catch (InputMismatchException e) {
            System.out.println("You entered wrong input. Please enter valid input");
        }
    }
}