package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("test_name").withLastname("test_surname").withGroup("[none]")
                .withHomePhone("+7 (111)").withMobilePhone("22-22").withWorkPhone("33 33 33").withAddress("New York, NY, 10120, USA")
                .withEmail("qwerty@mail.ru").withEmail2("asdfgh@mail.ru").withEmail3("zxcvbn@mail.ru");
        app.contact().createContact(contact, true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}