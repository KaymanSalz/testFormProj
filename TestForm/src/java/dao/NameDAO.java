/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import CONN.JConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author kayman pc
 */
public class NameDAO {
    
     Connection connect = null;
    JConnect jConnect = new JConnect();
    
      public int addName(NameBean bean){
        
        String query = "insert into names values (?,?)";
        PreparedStatement ps = null;
        int status = -1;
        
        connect = jConnect.getNewConnection();
        
        try{
            
            ps = connect.prepareStatement(query);
            ps.setString(1, bean.getFirstname());
            ps.setString(2, bean.getLastname());
            
            status = ps.executeUpdate();
            if(status>0){
                status = 0;   
            }
            else{
                status = 1;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return status;
    }

      public static void main(String[] args) {
        NameDAO named = new NameDAO();
        
        NameBean bean = new NameBean();
            bean.setFirstname("Tayo");
            bean.setLastname("Parkwell");
        
        int status = named.addName(bean);
        
    }
    
}
