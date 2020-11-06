package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testAddNewAdress() {
        app.getNavigationHelper().gotoAddNew();
        app.getContactHelper().fillAddNew(new GroupData("test1", "test2", "test3", "test4"));
        app.getGroupHelper().submitGroupCreation();
        app.getContactHelper().returnToHomePage();
    }

}
