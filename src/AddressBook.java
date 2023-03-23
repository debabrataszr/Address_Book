import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc=new Scanner(System.in);
        System.out.println("Firstname : ") ;
        String firstname = sc.nextLine();
        System.out.println("Lastname : ");
        String lastname = sc.nextLine();
        System.out.println("Address : ");
        String address=sc.nextLine();
        System.out.println("City : ");
        String city=sc.nextLine();
        System.out.println("State : ");
        String state=sc.nextLine();
        System.out.println("Zipcode : ");
        int zip=sc.nextInt();
        System.out.println("Phone No. : ");
        long phoneno= sc.nextLong();
        System.out.println("Email : ");
        String email= sc.nextLine();
    }
}