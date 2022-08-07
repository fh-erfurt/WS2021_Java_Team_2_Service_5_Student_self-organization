package de.fherfurt.organization.util;

import de.fherfurt.organization.core.models.Element;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic Test-Data
 *
 * @author Felix Zwicker
 */

@Getter
public class DataProvider {
    private final List<Element> faqElements;

    public DataProvider(){
        faqElements = this.createTestElements();
    }

    private ArrayList<Element> createTestElements(){
        ArrayList<Element> faqEntrys = new ArrayList<>();

        Element element1 = new Element.Builder().withTitle("Bafög").withContent("antwort").withAuthor("Felix Zwicker").build();
        Element element2 = new Element.Builder().withTitle("Semester").withContent("Semester antwort").withAuthor("Max Mustermann").build();
        Element element3 = new Element.Builder().withTitle("Bafög").withContent("Bafög antwort").withAuthor("Sabine Musterfrau").build();

        faqEntrys.add(element1);
        faqEntrys.add(element2);
        faqEntrys.add(element3);

        return faqEntrys;
    }
}
