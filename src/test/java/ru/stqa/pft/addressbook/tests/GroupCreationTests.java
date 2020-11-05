package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3", "test4"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testAddNewAdress() {
    app.getNavigationHelper().gotoAddNew();
    app.getContactHelper().fillAddNew(new GroupData("test1", "test2", "test3", "test4"));
    app.getGroupHelper().submitGroupCreation();
    app.getContactHelper().returnToHomePage();
  }

}
