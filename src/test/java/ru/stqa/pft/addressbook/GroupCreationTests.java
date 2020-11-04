package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase{

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3", "test4"));
    submitGroupCreation();
    returnToGroupPage();
  }

  @Test
  public void testAddNewAdress() {
    gotoAddNew();
    fillAddNew(new GroupData("test1", "test2", "test3", "test4"));
    submitGroupCreation();
    returnToHomePage();
  }

}
