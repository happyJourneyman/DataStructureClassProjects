package structures;

  /**
  * This interface defines methods for handling collisions in an array-based hashtable
  * using open addressing to resolve collisions.
  * The hashtable uses an array of type K to store keys, and an array of type boolean,
  * where true indicates an active cell in the array and false indicates an inactive cell.
  */
public interface CollisionHandler <K>{

 /**
  * Method starts at index and searches linearly until an open spot
  * is found in the array. This could include index itself.
  */
    public int probe(int index, boolean[] activeArray, int M);

      /**
  * Start at index and search the array linearly until the target
  * is found. Then return the array index of the target. 
  * Return -1 if not found.
  */
    public int search(int startIndex, K target, K[] keyArray, boolean [] activeArray, int M);
    
}
