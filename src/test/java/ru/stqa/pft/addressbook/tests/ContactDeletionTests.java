package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHomePage();
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactData().withFirstname("test_name").withLastname("test_surname"), true);
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = (ContactData) before.iterator().next();
        app.contact().deleteContact(deletedContact);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size() - 1));

        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
