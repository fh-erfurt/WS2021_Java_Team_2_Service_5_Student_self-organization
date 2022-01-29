package de.fherfurt.organization.FAQ;

import java.util.List;

public class FAQ {
    List<Elements> faqList;

    private void setFaqList(List<Elements> faqList) {
        this.faqList = faqList;
    }

    private void addElement(Elements element){
        faqList.add(element);
    }

    private Elements searchElement(int elementId) {
        Elements findElement = faqList.stream()
                .filter(Elements -> elementId == Elements.getElementId()).findAny().orElse(null);

        return findElement;
    }

    private void deleteElement(Elements element){
        faqList.remove(element);
    }

    private void deleteAllElements(){
        faqList.clear();
    }

    private void showElement(Elements element){
        System.out.println(element);
    }
}
