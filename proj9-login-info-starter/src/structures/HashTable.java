package structures;

import java.util.Iterator;

/* A public generic interface of methods that a hash table should implement. 
*  The K type must implement the hashCode method and the equals method. 
*/
public interface HashTable <K, V> {
 
  /* Adds the key-value pair to the hash table.
   * Duplicate keys are not stored.
   * If a key is in use, this method updates the associated value.
  */ 
  public void put(K key, V value);
  
   /**
   * Returns the value associated with the key if it exists in the hashtable.
   * The value is not removed from the hash table.
   * Returns null if the key is not in the table.
   */
  public V getValue(K key);
     
  /* Given a key, remove the key-value pair from the hash table and return the value */
  public V remove(K key) throws ElementNotFoundException; 
  
  /* Return the number of elements stored in the hash table. */
  public int getSize();
 
   /* Returns an Iterator for the keys in this HashTable. */
  Iterator<K> keyIterator();
   
}
