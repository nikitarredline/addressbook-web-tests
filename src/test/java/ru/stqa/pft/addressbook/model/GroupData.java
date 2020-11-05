package ru.stqa.pft.addressbook.model;

public class GroupData {
    private final String name;
    private final String header;
    private final String footer;
    private final String email;

    public GroupData(String name, String header, String footer, String email) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public String getEmail() { return email; }
}
