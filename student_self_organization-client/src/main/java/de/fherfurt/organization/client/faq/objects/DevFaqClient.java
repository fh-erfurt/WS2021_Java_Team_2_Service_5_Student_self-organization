package de.fherfurt.organization.client.faq.objects;

import de.fherfurt.organization.client.faq.FaqClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DevFaqClient implements FaqClient {

    private ArrayList<FaqDto> elements;

    public DevFaqClient(){
        elements = new ArrayList<>();
    }

    @Override
    public Optional<FaqDto> getElementById(int elementId){
        for(FaqDto element : elements) {
            if(element.getId() == (elementId)){
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<FaqDto> getElementsByTitle(String title) {
        ArrayList<FaqDto> result = new ArrayList<>();

        for(FaqDto element : elements){
            if(element.getTitle().equals(title)){
                result.add(element);
            }
        }
        return result;
    }

    @Override
    public List<FaqDto> getElementsByAuthor(String author) {
        ArrayList<FaqDto> result = new ArrayList<>();

        for(FaqDto element : elements){
            if(element.getAuthor().equals(author)){
                result.add(element);
            }
        }
        return result;
    }
}
