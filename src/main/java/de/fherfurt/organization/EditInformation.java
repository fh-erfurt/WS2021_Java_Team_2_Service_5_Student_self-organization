package de.fherfurt.organization;

public class EditInformation {

    String header;
    String content;

    private void editHeader(String input){
        setHeader(input);
    }

    private void editText(String input){
        setContent(input);
    }

    private void editPersons(){
    //service persons
    }

    private void setContent(String content){
        this.content = content;
    }

    private void setHeader(String header){
        this.header = header;
    }

    private void ShowInformation(){
        System.out.println(header);
        System.out.println(content);
    }

}
