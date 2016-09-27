package com.theironyard;

/**
 * Created by stevenburris on 9/27/16.
 */
public class Contact {
    String name;
    String phoneNumber;
    String email;

    @Override
    public String toString() {
        return name + ", " + phoneNumber + ", " + email;
    }
}
