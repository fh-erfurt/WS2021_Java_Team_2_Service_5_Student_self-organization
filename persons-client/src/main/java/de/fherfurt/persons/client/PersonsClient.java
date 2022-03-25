package de.fherfurt.persons.client;

public interface PersonsClient {
    /**
     *
     * This Methode "findPersonUsingIteratorByPersonID" will
     * find a Person from the ArrayList by
     * the PersonID with an Iterator.
     * @param PersonID - this Parameter is needed for the Searching.
     * @return Optional (Person) with all her/his values
     *
     */
    Person findPersonUsingIteratorBy(int PersonID);

    /**
     * This methode "findPersonAvatarBy" will find a Person Avatar from a HashMap
     * through a PersonID - Key.
     * @param PersonID - this Parameter is needed for the Searching.
     * @return byte Code which
     */

    byte[] findPersonAvatarBy(int PersonID);
}
