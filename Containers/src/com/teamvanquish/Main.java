package com.teamvanquish;

import com.teamvanquish.ArrayList;

class TempObject
{
    static {
        maxId = 0;
    }
    
    TempObject() {
        id = maxId;
        maxId++;
    }
    
    
    public void Display()
    {
        System.out.println("This is a temp object " + id + ".");
    }
    
    int id;
    static int maxId;
}

public class Main {
    

    public static void main(String[] args) {
        
        ArrayList myList = new ArrayList();
        
        myList.add(new TempObject());
        
        Object object1 = new TempObject();
        myList.add(object1);
        myList.add(new TempObject());
        myList.add(new TempObject());
        
        Object o = myList.get(2);
        
        if ( o == null )
        {
            System.out.println("Failed to add to the ArrayList");
        }
        else
        {
            ((TempObject) o).Display();
        }
        
        myList.vanquish(2);
        
        o = myList.get(2);
        
        if ( o == null )
        {
            System.out.println("Failed to add to the ArrayList");
        }
        else
        {
            ((TempObject) o).Display();
        }
        
        int index1 = myList.indexOf(object1);
        
        if ( index1 == -1 )
        {
            System.out.println("Object1 not found");
        }
        else
        {
            System.out.println("Index of object 1 is " + index1);
        }


    }
    

    //myList.add(new TempObject());
    
    
    
    
}
