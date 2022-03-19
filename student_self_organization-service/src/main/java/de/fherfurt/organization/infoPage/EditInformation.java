package de.fherfurt.organization.infoPage;

import de.fherfurt.persons.client.PersonsClient;
import de.fherfurt.persons.client.DevPerson;


public class EditInformation {

    private String header;
    private String content;
    private DevPerson devPerson;

    EditInformation(String header, String content){
        this.header = header;
        this.content = content;
    }

    private void setContent(String content){
        this.content = content;
    }

    private void setHeader(String header){
        this.header = header;
    }

    public void setPerson(){
        //TODO person-client einbinden
    }

}
