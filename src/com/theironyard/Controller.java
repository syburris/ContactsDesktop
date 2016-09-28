package com.theironyard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonSerializer;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField nameField;

    @FXML
    TextField phoneField;

    @FXML
    TextField emailField;

    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void addContact() throws IOException {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        Contact contact = new Contact(name, phone, email);
        if (nameField.getText().isEmpty() || phoneField.getText().isEmpty() || emailField.getText().isEmpty()) {
            return;
        }
        else {
            contacts.add(contact);
            nameField.clear();
            phoneField.clear();
            emailField.clear();
            saveContacts();
        }
    }

    public void removeContact() throws IOException {
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        if (contact != null) {
            contacts.remove(contact);
            list.refresh();
        }
        saveContacts();
    }

    public void saveContacts() throws IOException {
        File contactsJson = new File("Contacts.json");
        JsonSerializer serializer = new JsonSerializer();
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        contactArrayList.addAll(contacts);
        ContactWrapper wrappedContacts = new ContactWrapper(contactArrayList);
        String json = serializer.deep(true).serialize(wrappedContacts);
        FileWriter writeJson = new FileWriter(contactsJson);
        writeJson.write(json);
        writeJson.close();
    }

    public void loadContacts() throws IOException {
        File contactsJson = new File("Contacts.json");
        FileReader fileReader = new FileReader(contactsJson);
        int fileSize = (int) contactsJson.length();
        char[] jsonSize = new char[fileSize];
        fileReader.read(jsonSize,0,fileSize);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
