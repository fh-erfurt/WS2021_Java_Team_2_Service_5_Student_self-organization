package de.fherfurt.organization.faq.core.errors;

/**
 * Basic exception to catch errors
 *
 * @author Felix Zwicker
 */
public class EntryNotFoundException extends Exception{

    /**
     * @param exceptionMsg - needed Error-Message
     */
    public EntryNotFoundException(String exceptionMsg){
        super(exceptionMsg);
    }
}
