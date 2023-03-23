import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of persons to add : ");
        int persons = sc.nextInt();
        Contacts arr[] = new Contacts[persons];
        for (int i = 0; i < persons; i++) {
            System.out.println("Firstname :");
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
            arr[i] = contact;
        }

        for (int i = 0; i < persons; i++) {
            System.out.println(arr[i].firstname + " " + arr[i].lastname + " " + arr[i].address + " " + arr[i].city + " "
                    + arr[i].state + " " + arr[i].zip + " " + arr[i].phoneno + " " + arr[i].email);
        }

    }
}