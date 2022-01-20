package lumpofyums;

import java.sql.*;

public class UserDatabase {

	Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    
    //for register user 
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into user(username, email, address, password, first_name, last_name, phone, gender) values(?,?,?,?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getUserName());
           pt.setString(2, user.getEmail());
           pt.setString(3, user.getAddress());
           pt.setString(4, user.getPassword());
           pt.setString(5, user.getFirstName());
           pt.setString(6, user.getLastName());
           pt.setInt(7, user.getPhone());
           pt.setString(8, user.getGender());
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
  //user login
    public User login(String username, String password){
        User usr=null;
        try{
            String query ="select * from user where username=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new User();
                usr.setId(rs.getInt("id"));
                usr.setUserName(rs.getString("username"));
                usr.setEmail(rs.getString("email"));
                usr.setAddress(rs.getString("address"));
                usr.setFirstName(rs.getString("first_name"));
                usr.setLastName(rs.getString("last_name"));
                usr.setGender(rs.getString("gender"));
                usr.setPhone(rs.getInt("phone"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }


}
