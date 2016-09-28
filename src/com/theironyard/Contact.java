package com.theironyard;

/**
 * Created by stevenburris on 9/27/16.
 */
public class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + ", " + phoneNumber + ", " + email;
    }
}
