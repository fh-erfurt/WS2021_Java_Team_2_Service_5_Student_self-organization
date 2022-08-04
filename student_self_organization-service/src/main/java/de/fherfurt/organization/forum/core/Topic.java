package de.fherfurt.organization.forum.core;

import de.fherfurt.organization.storage.core.AbstractDatabaseEntity;

import javax.persistence.Entity;

@Entity
public class Topic extends AbstractDatabaseEntity {
    private String topic;

    public Topic(){}

    public Topic(String topic ) {
        super();
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
