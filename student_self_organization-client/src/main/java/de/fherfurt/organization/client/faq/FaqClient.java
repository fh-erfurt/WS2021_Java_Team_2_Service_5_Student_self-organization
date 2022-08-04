package de.fherfurt.organization.client.faq;

import de.fherfurt.organization.client.faq.objects.FaqDto;

import java.util.List;
import java.util.Optional;

/**
 * This Interface provides functionality from Faq Service
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
    Optional<FaqDto> getElementById(int elementId);

    List<FaqDto> getElementsByTitle(String title);

    List<FaqDto> getElementsByAuthor(String author);

}
