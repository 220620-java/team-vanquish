package com.teamvanquish;

public class ArrayList implements List{

	Object[] array = new Object[10];
	// For Doubling when capacity is full
	int size = 0;
	
    @Override
    public void add(Object obj) {
        // TODO Auto-generated method stub
        	array[size] = obj;
    	size++;
    	if(array.length == size ) {
    		Object[] array1 = new Object[array.length * 2];
    		for(int i = 0; i < array.length; i++) {
    			array1[i] = array[i];
    		}
    	

    		array = array1;
    	}
    }

     public void remove(int index) {
    	if(index >= 0 && index < size) {
    		for(int i = 0; i < size - 1; i++) {
    			array[i] = array[i + 1];
    		}
    		size--;
    	}
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    public void remove(int index) {
    	if(index >= 0 && index < size) {
    		for(int i = 0; i < size - 1; i++) {
    			array[i] = array[i + 1];
    		}
    		size--;
    	}
    }

    @Override
    public Object delete(int index) {
        	int check = -1;
    	Object obj = new Object();
    	for(int i = 0; i < size; i++) {
    		if(i == index) {
    			obj = array[i];
    			check = i;
    		}
    		size--;
    		
    	}
    	if(check != -1) {
    		remove(check);
    	}
    
    	return obj;  
    }

    	@Override
	public int indexOf(Object obj) {
		// -1 for validation
		int index = -1;

		for(int i = 0; i < size; i++) {
			if(obj.equals(array[i])){
				index = i;
			}
		}
	return index;
	}

	@Override
	public int getSize() {
		return size;
	}

}
