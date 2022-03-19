package de.fherfurt.organization.faq;

import java.util.LinkedList;
import java.util.List;


public class FAQ {
    private List<Elements> faqList;

    FAQ(){
        faqList = new LinkedList<>();
    }

    public void addElement(Elements element){
        faqList.add(element);
    }

    public Elements searchElement(int elementId) {
        Elements searchedElement = faqList.stream()
                .filter(Elements -> elementId == Elements.getElementId()).findAny().orElse(null);

        return searchedElement;
    }

    public void deleteElement(int elementId){
        faqList.remove(searchElement(elementId));

    }

    public void deleteAllElements(){
        faqList.clear();
    }


    public void printFAQList(){
        System.out.println(faqList);
    }
}
