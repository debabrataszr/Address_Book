import java.util.Objects;
import java.util.stream.DoubleStream;

public class Contacts {
    String firstname;
    String lastname;
    String address;
    String city;
    String state;
    int zip;
    long phoneno;
    String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contact = (Contacts) o;
        return firstname.equals(contact.firstname) && lastname.equals(contact.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname);
    }

    @Override
    public String toString() {
        return "Contact{" + firstname + " " + lastname + " " + address + " " + city + " " + state + " " + zip + " " + phoneno + " " + email + '}';
    }
}