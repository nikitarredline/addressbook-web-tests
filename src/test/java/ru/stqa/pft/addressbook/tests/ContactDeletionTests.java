package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testAddNewDeletion() {
        app.getContactHelper().returnToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().alertClose();
        app.getContactHelper().returnToHomePage();
    }

}
