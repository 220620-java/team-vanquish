package com.teamvanquish;

public class ArrayList implements List {

    // Private data
    private Object[] objectArray;
    private int totalUsed;
    
    ArrayList() {
        totalUsed = 0;
        objectArray = new Object[10];
    }

    ArrayList(int initialLength) {
        objectArray = new Object[initialLength];
        totalUsed = 0;
    }

    @Override
    public void add(Object obj) {
        // If the current array is full create a new array 50% larger
        // and copy the existing array to it.
        if (totalUsed == objectArray.length - 1) {
            int newLength = objectArray.length + objectArray.length / 2;

            Object[] newObjectArray = new Object[newLength];
            System.arraycopy(objectArray, 0, newObjectArray, 0, objectArray.length);

            objectArray = newObjectArray;
        }

        // Add the new item to the array and update the totalUsed count.
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
        // if the index is invalid, do nothing.
        if (index < 0 || index >= totalUsed) {
            return null;
        }

        // if the index is valid, starting at index, move all items
        // down 1, set the last item to null, and decrement totalUsed.
        Object returnedObject = objectArray[index];
        for (int i = index; i < totalUsed; ++i) {
            objectArray[i] = objectArray[i + 1];
        }

        objectArray[totalUsed - 1] = null;
        --totalUsed;

        return returnedObject;
    }

    void vanquish(int index) {
        delete(index);
    }

    @Override
    public int indexOf(Object obj) {

        int foundIndex = -1;
        for (int i = 0; i < totalUsed; ++i) {
            if (objectArray[i] == obj) {
                foundIndex = i;
                break;
            }
        }

        return foundIndex;
    }
}
