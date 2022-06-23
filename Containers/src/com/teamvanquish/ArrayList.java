package com.teamvanquish;

public class ArrayList implements List {

    @Override
    public void add(Object obj) {
        // TODO Auto-generated method stub
        if ( totalUsed == objectArray.length - 1 )
        {
            int newLength = objectArray.length + objectArray.length/2;
            
            Object[] newObjectArray = new Object[newLength];
            System.arraycopy(objectArray, 0, newObjectArray, 0, objectArray.length);
            
            objectArray = newObjectArray;

        }
        
        objectArray[totalUsed] = obj;
        totalUsed++;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= objectArray.length) {
            return null;
        }
        
        return objectArray[index];
    }

    @Override
    public Object delete(int index) {
        if (index < 0 || index >= totalUsed ) {
            return null;
        }
        
        Object returnedObject = objectArray[index];
        for ( int i = index ; i < totalUsed ; ++i )
        {
            objectArray[i] = objectArray[i+1];
        }
        
        objectArray[totalUsed-1] = null;
        --totalUsed;
        
        return returnedObject;
    }

    void vanquish(int index) {
        delete(index);
    }

    @Override
    public int indexOf(Object obj) {
        // TODO Auto-generated method stub
        
        int foundIndex = -1;
        for ( int i = 0 ; i < totalUsed ; ++i )
        {
            if ( objectArray[i] == obj )
            {
                foundIndex = i;
                break;
            }
        }
        
        return foundIndex;
    }

    Object[] objectArray = new Object[2];
    int totalUsed = 0;

}
