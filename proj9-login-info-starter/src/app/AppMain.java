package app;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) throws Exception {
        /*
         * This code creates a console-based version of a user interface to test the 
         * usage of the CredentialDatabase functionality, and, indirectly, the ArrayHashTable class.
         * */
       Scanner scan = new Scanner(System.in);
       boolean keepGoing = true;
       CredentialDatabase credDB = new CredentialDatabase();
       String choice = "";
       // generate the user interface simulation:
       System.out.println("Welcome to The Secure Website.");
       while(keepGoing){
          System.out.println("Enter L to log in, C to create a new account, "
          +"P to change password, D to delete account, V to view all logins (for debug), X to quit:");
          choice = scan.nextLine();
          if (choice.equalsIgnoreCase("X")){
            keepGoing = false;
          }
          else if (choice.equalsIgnoreCase("L")){//login
             System.out.println("Login by entering username and password:");
             System.out.println("Username:");
             String userName = scan.nextLine();
             System.out.println("Enter password:");
             String userPwd = scan.nextLine();
             boolean ok = credDB.loginUser(userName, userPwd);
             if(ok)
                System.out.println("Welcome "+userName+", You are logged in.");
             else{
              System.out.println("Login unsuccessful for "+userName+".");
             }
          }
          else if (choice.equalsIgnoreCase("C")){//create account
            System.out.println("Username:");
            String userName = scan.nextLine();
            System.out.println("Enter password:");
            String userPwd = scan.nextLine();
            boolean ok = credDB.userNameExists(userName); // check if user exists
            if(ok)
               System.out.println("An account for "+userName+" already exists.");
            else{ // account does not exist- create account
               credDB.addUser(userName, userPwd);
               ok = credDB.loginUser(userName, userPwd);
               if(ok)
                  System.out.println("Welcome "+userName+", You are logged in.");
               else
                 System.out.println("An error occurred, could not create an account for "+userName+".");
            }
          }
          else if (choice.equalsIgnoreCase("P")){//change password
            System.out.println("Login by entering username and password:");
            System.out.println("Username:");
            String userName = scan.nextLine();
            System.out.println("Enter existing password:");
            String userPwd = scan.nextLine();
            boolean ok = credDB.loginUser(userName, userPwd);
            if(ok){
              System.out.println("Enter new password:");
              userPwd = scan.nextLine();
              credDB.addUser(userName, userPwd);
              System.out.println("New password for "+userName+" saved, check by logging in.");
            }
            else{
              System.out.println("Credentials for "+userName+" invalid.");
            }
         }
          else if (choice.equalsIgnoreCase("D")){//delete account
            System.out.println("Username:");
            String userName = scan.nextLine();
            System.out.println("Enter password:");
            String userPwd = scan.nextLine();
            boolean ok = credDB.loginUser(userName, userPwd);//check credentials
            if(ok){  // login OK
              try{
               credDB.deleteUser(userName, userPwd);
              } catch (Exception ex){
                System.out.println("Error deleting account: "+ex.getMessage()+" Account for "+userName+" was not deleted.");
              }
            }// login failed 
            else{
              System.out.println("Credentials for "+userName+" invalid.");
            }
          }
          else if (choice.equalsIgnoreCase("V")){//view all logins (for debugging)
            String str = credDB.getAllLoginsDebugString();
            System.out.println(str);
          }
          else{
            System.out.println("Did not recognize that choice.");
          }       
        }
        System.out.println("Bye for now.");
        scan.close();
      }    
}
