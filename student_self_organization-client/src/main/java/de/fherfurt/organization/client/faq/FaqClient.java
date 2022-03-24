package de.fherfurt.organization.client.faq;

import javax.lang.model.element.Element;
import java.util.List;

/**
 * This Interface provides functionality from Faq Service.
 * It could be used by other services
 *
 * @author Felix Zwicker
 */
public interface FaqClient {
    /**
     * This Methode will find an Element
     * from the LinkedList by
     * the elementId
     *
     * @param elementId - needed for searching
     * @return Element - with all its values
     */
    Element getElementById(int elementId);

    /**
     * This Methode could return
     * the FaqList with all created
     * Elements to use in other Services
     *
     * @return LinkedList - containing Elements
     */
    List<Element> getFaqList();
}
