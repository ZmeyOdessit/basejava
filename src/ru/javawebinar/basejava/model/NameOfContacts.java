package ru.javawebinar.basejava.model;

public enum NameOfContacts {
    PHONE("Тел."),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел."),
    SKYPE("Skype"),
    MAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STATCKOVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private String title;

    NameOfContacts(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
