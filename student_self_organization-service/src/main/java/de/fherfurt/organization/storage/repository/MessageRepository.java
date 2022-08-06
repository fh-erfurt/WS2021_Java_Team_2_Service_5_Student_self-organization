package de.fherfurt.organization.storage.repository;

import de.fherfurt.organization.core.models.Message;

import java.util.List;

public interface MessageRepository {
    List<Message> getAllMessages();

    Message getMessage( int messageId );
    boolean createMessage( Message message );
    boolean updateMessage( Message message );
    boolean deleteMessage( int messageId );
}
