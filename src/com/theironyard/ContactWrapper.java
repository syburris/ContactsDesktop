package com.theironyard;

import java.util.ArrayList;

/**
 * Created by stevenburris on 9/27/16.
 */
public class ContactWrapper {
    ArrayList<Contact> contacts;

    public ContactWrapper() {
    }

    public ContactWrapper(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
