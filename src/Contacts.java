public class Contacts {
    String firstname;
    String lastname;
    String address;
    String city;
    String state;
    int zip;
    long phoneno;
    String email;
    public Contacts() {

    }
    public Contacts(String firstname, String lastname, String address,
                   String state, int zip, int phoneno, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city=city;
        this.state = state;
        this.zip = zip;
        this.phoneno = phoneno;
        this.email = email;

}

    @Override
    public String toString() {
        return "Contacts{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneno=" + phoneno +
                ", email='" + email + '\'' +
                '}';
    }
}