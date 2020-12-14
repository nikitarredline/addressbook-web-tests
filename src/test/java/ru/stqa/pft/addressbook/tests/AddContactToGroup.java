package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().gotoHomePage();
            app.contact().createContact(new ContactData().withFirstname("test_name").withLastname("test_surname"), true);
        }

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Group"));
        }
    }

    @Test
    public void testAddContactToGroup() {
        Contacts beforeContact = app.db().contacts();
        ContactData contactSelect = beforeContact.iterator().next();
        Groups beforeGroup = app.db().groups();
        GroupData groupSelect = beforeGroup.iterator().next();

        app.goTo().gotoHomePage();
        app.contact().selectAllDisplayGroup();
        app.contact().addContactToGroup(contactSelect, groupSelect);
        app.goTo().gotoHomePage();
        assertThat(contactSelect.getGroups().withAdded(groupSelect), equalTo(app.db().contacts().stream()
                .filter((c) -> c.getId() == contactSelect.getId()).collect(Collectors.toList()).get(0).getGroups()));
    }
}

