import java.util.Scanner;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        askUser();
    }

    public static void askUser() {
        System.out.println("Select an option..");
        System.out.println("1. Add a person");
        System.out.println("2. Edit");
        System.out.println("3. Quit");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addAPerson();
                System.out.println("\n");
                askUser();
                break;
            case 2:
                edit();
                System.out.println("\n");
                askUser();
                break;
            default:
                break;
        }
    }

    public static void addAPerson() {
        System.out.println("Firstname : ");
        String firstname = sc.next();
        System.out.println("Lastname : ");
        String lastname = sc.next();
        System.out.println("Address : ");
        String address = sc.next();
        System.out.println("City : ");
        String city = sc.next();
        System.out.println("State : ");
        String state = sc.next();
        System.out.println("Zipcode : ");
        int zip = sc.nextInt();
        System.out.println("Phone No. : ");
        long phoneno = sc.nextLong();
        System.out.println("Email : ");
        String email = sc.next();

        Contacts contact = new Contacts();
        contact.firstname = firstname;
        contact.lastname = lastname;
        contact.address = address;
        contact.city = city;
        contact.state = state;
        contact.zip = zip;
        contact.phoneno = phoneno;
        contact.email = email;
    }

    public static void edit() {
        System.out.println("What do you want to edit?");
        System.out.println("1. First name ");
        System.out.println("2. Last name ");
        System.out.println("3. Address ");
        System.out.println("4. City ");
        System.out.println("5. State ");
        System.out.println("6. Zip ");
        System.out.println("7. Phone No. ");
        System.out.println("8. Email ");
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
}