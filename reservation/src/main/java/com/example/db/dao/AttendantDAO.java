package com.example.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.db.common.DbUtil;
import com.example.db.common.Version;
import com.example.db.model.Attendant;
import com.mysql.jdbc.Driver;


public class AttendantDAO {
	private Connection connection = null;
	
	public AttendantDAO (){
		connection = DbUtil.getConnection();
	}
	
	public boolean createAttendant(Attendant attendant) {     
        
        try {
            Driver jdbcDriver = new com.mysql.jdbc.Driver ();
        	DriverManager.registerDriver(jdbcDriver);
        	connection = DbUtil.getConnection();
        	Statement st = connection.createStatement();
            
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into attendant(firstname,lastname,email,phoneNumber) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, attendant.getFirstName());
			preparedStatement.setString(2, attendant.getLastName());
			preparedStatement.setString(3, "wstest@gmail.com");
			preparedStatement.setString(4, "630-123-4567");
			preparedStatement.executeUpdate();
                    
			ResultSet rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                
                System.out.println("WIJS 000 10/29 aaa: MySQL Version is:  " + rs.getString(1));
            }
            DriverManager.deregisterDriver(jdbcDriver);;

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } 
        
		return true;
	}
	
	
	
    public List<Attendant> getAllUsers() {
        List<Attendant> attendants = new ArrayList<Attendant>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from attendant");
            while (rs.next()) {
            	Attendant attendant = new Attendant();
            	attendant.setFirstName(rs.getString("firstname"));
            	attendant.setLastName(rs.getString("lastname"));
            	attendant.setPhoneNumber(rs.getString("phoneNumber"));
            	attendant.setEmail(rs.getString("email"));
            	attendants.add(attendant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendants;
    }	
	
	


}
