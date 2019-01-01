package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.*;

public class ResumeTestData {
    public static void main(String[] args) {
        final String uuid = "uuid01";
        final String name = "Григорий Кислин";

        Resume resume = new Resume(uuid, name);
        resume.addContact(NameOfContacts.MOBILE, "+7(921) 855-0482");
        resume.addContact(NameOfContacts.SKYPE, "grigory.kislin");

        SectionWithText text = new SectionWithText("Ведущий стажировок и корпоративного обучения " +
                "по Java Web и Enterprise технологиям");


        SectionWithList textList = new SectionWithList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");

        resume.addSection(NameOfSection.OBJECTIVE, text);

        resume.addSection(NameOfSection.QUALIFICATIONS, textList);

        System.out.println(resume.getFullName());
        System.out.println(NameOfContacts.MOBILE.getTitle() + ":  " + resume.getContact(NameOfContacts.MOBILE));
        System.out.println(NameOfContacts.SKYPE.getTitle() + ":  " + resume.getContact(NameOfContacts.SKYPE));

        System.out.println(NameOfSection.OBJECTIVE.getTitle() + " "+ resume.getSections(NameOfSection.OBJECTIVE));

        System.out.println(NameOfSection.QUALIFICATIONS.getTitle() + " "+ resume.getSections(NameOfSection.QUALIFICATIONS));


    }
}
