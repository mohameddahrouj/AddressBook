package lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public BuddyInfo(){

    }

    public BuddyInfo(String firstName, String lastName, String address, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!BuddyInfo.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final BuddyInfo other = (BuddyInfo) obj;

        if(firstName.equals(other.getFirstName()) && lastName.equals(other.getLastName())
                && address.equals(other.getAddress()) && phoneNumber.equals(other.getPhoneNumber())){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "-" + address +  "-" + phoneNumber;
    }
}
