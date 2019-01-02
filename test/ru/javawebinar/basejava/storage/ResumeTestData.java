package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.time.Month;

public class ResumeTestData {
    public static void main(String[] args) {
        final String uuid = "uuid01";
        final String name = "Григорий Кислин";

        Resume resume = new Resume(uuid, name);
        resume.addContact(NameOfContacts.MOBILE, "+7(921) 855-0482");
        resume.addContact(NameOfContacts.SKYPE, "grigory.kislin");

        SectionText text = new SectionText("Ведущий стажировок и корпоративного обучения " +
                "по Java Web и Enterprise технологиям");


        SectionList textList = new SectionList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");


        LocalDate start = LocalDate.of(2010, Month.DECEMBER,1);
        LocalDate end = LocalDate.of(2012, Month.APRIL,1);


        Company luxoft = new Company("Luxoft (Deutsche Bank)\n", "https://www.luxoft.com/",
                start, end,
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, " +
                        "SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация " +
                        "RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического " +
                        "трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");



        resume.addSection(NameOfSections.OBJECTIVE, text);

        resume.addSection(NameOfSections.QUALIFICATIONS, textList);

        resume.addSection(NameOfSections.EXPERIENCE, new SectionCompany(luxoft));

        /*System.out.println(resume.getFullName());
        System.out.println(NameOfContacts.MOBILE.getTitle() + ":  " + resume.getContact(NameOfContacts.MOBILE));
        System.out.println(NameOfContacts.SKYPE.getTitle() + ":  " + resume.getContact(NameOfContacts.SKYPE));

        System.out.println(NameOfSections.OBJECTIVE.getTitle() + " " + resume.getSections(NameOfSections.OBJECTIVE));

        System.out.println(NameOfSections.QUALIFICATIONS.getTitle() + " " + resume.getSections(NameOfSections.QUALIFICATIONS));*/

        System.out.println(resume.toString());


    }
}
