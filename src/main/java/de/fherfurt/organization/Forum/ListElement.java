package de.fherfurt.organization.Forum;

// defines how the elements of the list are built up

public class ListElement
{
    String s;
    ListElement next;

    public ListElement(String s)
    {
        this.s = s;
        next = null;    // in case it's the last element
    }

    public boolean hasNext()
    {
        if (this.next == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
