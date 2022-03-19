package de.fherfurt.persons.client;

import java.util.HashMap;

public class DevPerson implements PersonsClient{
        HashMap<Integer, Person> personsHashMap;
        public DevPerson(){
            personsHashMap = new HashMap<Integer, Person>();
            personsHashMap.put(1, new Person("Max","Mustermann","Studentenberatung","6.0.15","Max.Mustermann@fh-erfurt.de","0123456789"));
            personsHashMap.put(2, new Person("Sabine","Musterfrau","Gremien Leitung","6.0.12","sabine-musterfrau@fh-erfurt.de","0132435465"));

        }
        public Person getPersonById(int id){
            return personsHashMap.get(id);
        }

        @Override
        public Person findPersonUsingIteratorBy(int PersonID){
            return null;
        }

        @Override
        public byte[] findPersonAvatarBy(int PersonID){
            return new byte[0];
        }
}
