  /**
   * This class uses an instance of HashTable (an ArrayHashTable to be exact)
   * to store usernames and passwords. The username, a String, is the key, and the 
   * password is the value. The user's password is encoded using a Java library
   * class' implementation of an MD5 Hashing algorithm. This makes the database 
   * more secure as the passwords would have to be decoded before they can be 
   * used. 
   */
  
package app;

import structures.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

public class CredentialDatabase {
   // storing Keys: userID, Values: user's password (encoded).
  protected HashTable<String, String> table;
  private CollisionHandler <String> collisionHdler;
  /**
   * Constructor: instantiates the HashTable and choses
   * which collision handler the table should use.
   */
  public CredentialDatabase() {
    // Init the type of collision handler: linear or quadratic.
    collisionHdler = new LinearCollisionHandler<String>();
    //collisionHdler = new QuadraticCollisionHandler<String>();
    table = new ArrayHashTable<String, String> (collisionHdler);
  }

  /*
  * Uses MD5 Hashing algorithm to produce a secure hash of the input password.
  * It is safer to store this secure hash in our database, as opposed to the plaintext password.
  */
  private String securePasswordHash(String password) throws Exception{

    String securePasswordHash = null;
    MessageDigest md = null;
    try{
       // MessageDigest could throw NoSuchAlgorithmException
       md = MessageDigest.getInstance("MD5");
       md.update(password.getBytes());
       byte[] bytes = md.digest();

       StringBuilder sb = new StringBuilder();
       for(int i=0; i< bytes.length ;i++) {
         sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
       }
       securePasswordHash = sb.toString();
      } catch(Exception ex){
        System.out.println("Error in securePasswordHash: "+ ex.getMessage());
        throw ex;
      }
    return securePasswordHash;
  }

  /**
   * Determines if this user exists in the database. 
   * Returns true if this user has an account, false otherwise.
   */
  public boolean userNameExists(String username){
    boolean exists = true;
    String res = table.getValue(username);
    if(res == null)
      exists = false;
    return exists;
  }

  /**
   * Add user login to database. Do not store passwords in plaintext. 
   * Call the put method with the username and for the second argument 
   * use the securePasswordHash method to get a hashed version of the 
   * password and store that as the user's password in the table.
   *  
   * @throws NoSuchAlgorithmException by the call to securePasswordHash
   */
  public void addUser(String username, String password) throws Exception {
    table.put(username, securePasswordHash(password));
  }

  /**
   * Return true only if the username and password match a set we have stored.
   * Otherwise return false.
   * Calls securePasswordHash on the password to check against the value returned
   * from the get method.
   * @throws NoSuchAlgorithmException by the call to securePasswordHash
   */
  public boolean loginUser(String username, String password) throws Exception {
    String hashedPass = table.getValue(username);
    if(hashedPass == null){
      return false;
    }
    return hashedPass.equals(securePasswordHash(password));
  }

  /**
   * Delete user from database. Tries to login user first, 
   * if successful login, calls the HashTable remove method.
   * 
   * @throws Exception if login unsuccessful with message: "login unsuccessful"
   * @throws ElementNotFoundException if username not in table (thrown by remove method).
   */
  public void deleteUser(String username, String password) throws Exception  {
      boolean success = loginUser(username, password);
      if(!success)
         throw new Exception("login unsuccessful");
      else
         table.remove(username);
  }

    /**
   * Returns a String representation of all key/values in the hashtable.
   * The String is of the form:
   * username+ ", "+encrypted password+line break
   * Example:
   * thebutlerdidit, c54af2cd241a8f707dec0f405477e54c
   * MykittyCatrules, 604aa2421098a2d229d157fa0beccab7
   * quentinTheeCoder, cd1b6d63bd62eae42a22cd6dd5837c30
   * 
   * If the hashtable is empty, the EXACT String "no entries." is returned.
   */
  
  public String getAllLoginsDebugString(){
    StringBuilder outStr = new StringBuilder();
    if(table.getSize()<1)
       outStr.append("no entries.").append(System.lineSeparator());
    else{
      Iterator<String> keyIter = table.keyIterator();
      while(keyIter.hasNext()){
        String curKey = keyIter.next();
        String curPwd = table.getValue(curKey);
        outStr.append(curKey).append(", ").append(curPwd).append(System.lineSeparator());
      }
    }
    return outStr.toString();
  }

}
