package structures;

import java.util.Iterator;

public class KeyIterator<K> implements Iterator<K>{
    K[] keys;
    int numKeys;
    int curIndex;
    int keyCount;

  /**
   *  Accepts the array of keys and the number of data items on the array.
   */
    public KeyIterator(K[] keyArr, int size) {
        keys = keyArr;
        numKeys = size;
        curIndex = 0;
        keyCount = 0;
    }

  /**
   *  Returns true if there is another key in the array, false otherwise.
   */
    public boolean hasNext() {
        return keyCount < numKeys;
    }

  /**
   *  Returns the next key in the array of keys.
   */
    public K next() {
        K result = null;
        do {
            result = keys[curIndex];
            curIndex++;
        }
        while(result == null);
        if(result!=null)
           keyCount++;
        return result;
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
