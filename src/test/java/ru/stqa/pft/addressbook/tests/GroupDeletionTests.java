package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testAddNewDeletion() {
    app.getContactHelper().returnToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertClose();
    app.getContactHelper().returnToHomePage();
  }
}
