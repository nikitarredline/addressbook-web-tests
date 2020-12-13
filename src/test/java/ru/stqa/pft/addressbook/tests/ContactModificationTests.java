package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHomePage();
        if (app.db().contacts().size() == 0) {
            app.contact().createContact(new ContactData().withFirstname("test_name").withLastname("test_surname").withGroup("[none]")
                    .withHomePhone("+7 (111)").withMobilePhone("22-22").withWorkPhone("33 33 33").withAddress("New York, NY, 10120, USA")
                    .withEmail("qwerty@mail.ru").withEmail2("asdfgh@mail.ru").withEmail3("zxcvbn@mail.ru"), true);
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = (ContactData) before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("test").withLastname("test_surname").withGroup("[none]");
        app.goTo().gotoHomePage();
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
