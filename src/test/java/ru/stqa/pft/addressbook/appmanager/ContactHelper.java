package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillAddNew(GroupData groupData) {
        type(By.name("firstname"), groupData.getName());
        type(By.name("lastname"), groupData.getHeader());
        type(By.name("mobile"), groupData.getFooter());
        type(By.name("email"), groupData.getEmail());
    }

}
