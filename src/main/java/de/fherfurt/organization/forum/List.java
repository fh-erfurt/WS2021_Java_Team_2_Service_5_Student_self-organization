package de.fherfurt.organization.forum;

// List itself with some methods

// how to use this in our case? maybe use ArrayList instead

public class List
{
    ListElement start;

    public List()
    {
        start = new ListElement("Head");
    }

    public void insertLast(String s)
    {
        ListElement newEle = new ListElement(s);
        start.next = newEle;
    }


    public String get(int n)
    {
        if (findIndex(n) == null)
        {
            return "";
        }
        return findIndex(n).s;
    }

    public void delete(int n)
    {
        if (n < 1)
        {
            return;     // avoiding deleting the head of the list
        }
        ListElement nth = findIndex(n);
        if (nth == null)
        {
            return;
        }

        ListElement pre = findIndex(n - 1);
        pre.next = nth.next;
        /* deleting the nth element by skipping it
         * pre -> nth -> suc
         * pre --------> suc
         */
    }

    private ListElement findIndex(int n)
    {
        if (n < 0)
        {
            return null;
        }

        ListElement iterator = start;
        for (int i = 0; i < n; i++)
        {
            if (iterator.hasNext())
            {
                iterator = iterator.next;
            }
            else
            {
                return null;
            }
            // continue the loop until the element is found or when we reached the last element
        }
        return iterator;
    }
}
