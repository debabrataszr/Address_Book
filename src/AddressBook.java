import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    ArrayList<Contacts> contact = new ArrayList<>();
    private int noOfContacts;

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        System.out.println("Enter number of persons : ");
        int persons = sc.nextInt();
        Contacts[] arr = new Contacts[persons];
        int result = 0;
        while (result != 4) {
            System.out.println("What do you want to perform");
            System.out.println("1.Add \t2.Edit \t3.Delete  \t4.Quit");
            result = sc.nextInt();
            switch (result) {
                case 1:
                    add(persons, arr);
                    break;
                case 2:
                    edit(persons, arr);
                    break;
                case 3:
                    delete(persons, arr);
                    break;
                case 4:
                    quit();
                    break;
                default:
                    break;
            }
        }
    }

    public static void add(int persons, Contacts[] array) {

        for (int i = 0; i < persons; i++) {
            Contacts contact = new Contacts();
            System.out.println("enter " + (i + 1) + " person name-");
            contact.setFirstname(sc.next());
            System.out.println("enter " + (i + 1) + " person lastname-");
            contact.setLastname(sc.next());
            System.out.println("enter " + (i + 1) + " person address-");
            contact.setAddress(sc.next());
            System.out.println("enter " + (i + 1) + " person city-");
            contact.setCity(sc.next());
            System.out.println("enter " + (i + 1) + " person state-");
            contact.setState(sc.next());
            System.out.println("enter " + (i + 1) + " person zip code-");
            contact.setZip(sc.nextInt());
            System.out.println("enter " + (i + 1) + " person phone no.-");
            contact.setPhoneno(sc.nextLong());
            System.out.println("enter " + (i + 1) + " person email-");
            contact.setEmail(sc.next());
            array[i] = contact;
        }
    }

    public static void edit(int persons, Contacts[] array) {
        System.out.println("What do you want to edit?");
        System.out.println("1. First name " + "2. Last name " + "3. Address " + "4. City " + "5. State " + "6. Zip " +
                "7. Phone No. " + "8. Email ");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:

                System.out.println("Firstname : ");
                String firstname = sc.next();
                break;

            case 2:
                System.out.println("Lastname : ");
                String lastname = sc.next();
                break;
            case 3:
                System.out.println("Address : ");
                String address = sc.next();
                break;
            case 4:
                System.out.println("City : ");
                String city = sc.next();
                break;
            case 5:
                System.out.println("State : ");
                String state = sc.next();
                break;
            case 6:
                System.out.println("Zipcode : ");
                int zip = sc.nextInt();
                break;
            case 7:
                System.out.println("Phone No. : ");
                long phoneno = sc.nextLong();
                break;
            case 8:
                System.out.println("Email : ");
                String email = sc.next();
                break;
        }

        System.out.println("Contact edited successfully");
    }

    public static void delete(int persons, Contacts[] arr) {
        System.out.println("Enter the firstname you want to delete : ");
        String del = sc.next();
        System.out.println("Address book is now for : " + (persons - 1) + " person");
        for (int i = 0; i < persons; i++) {
            if (del.equals(arr[i].getFirstname())) {
                for (int j = i; j < persons - 1; j++) {
                    arr[j] = arr[j + 1];
                }
            }
        }
        for (int i = 0; i < persons - 1; i++) {
            System.out.println(arr[i].getFirstname() + " " + arr[i].getLastname() + " " + arr[i].getAddress() + " "
                    + arr[i].getState() + " " + arr[i].getZip() + " " + arr[i].getPhoneno() + " " + arr[i].getEmail());
        }
         System.out.println("Contact edited successfully");
    }

    public static void quit() {
        System.out.println("***** The End *****");
    }
}
