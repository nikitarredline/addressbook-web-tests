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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void alertClose() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
