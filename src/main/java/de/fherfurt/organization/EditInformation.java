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

    public void setContent(String content){
        this.content = content;
    }

    public void setHeader(String header){
        this.header = header;
    }


}
