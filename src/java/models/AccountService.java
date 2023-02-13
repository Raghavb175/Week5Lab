
package models;

/**
 *
 * @ragha
 */
public class AccountService {
    public AccountService(){
          
        }
    public User login(String username,String password){
          if(username.equals("abe")&&password.equals("password")){
              return new User("abe",null);
          }
          else if(username.equals("barb")&&password.equals("password")){
              return new User("barb",null);
          }
          else{
              return null;
           }
    }
    
    private class User{
        private String username;
        private String password;
        
        public User(){
            
        }
        public User(String username,String passsword){
            this.username=username;
            this.password=password;
        }
        
        public void setPassword(String password){
            this.password=password;
        }
    }
}