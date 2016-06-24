/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import java.util.*;
import models.Attributes;
import config.Database;

/**
 *
 * @author amar
 */
public class RefJenisBarangModel {
    private Connection connection;
 
    public RefJenisBarangModel() {
        connection = Database.getConnection();
    }
    
    public List<Attributes> findAll()
    {
        List<Attributes> datas = new ArrayList<Attributes>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from ref_jenis_barang order by id desc");
            
            while (results.next()) {
                Attributes jenis = new Attributes();
                
                jenis.setId(results.getString("id"));
                jenis.setName(results.getString("nama"));
                
                datas.add(jenis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return datas;
    }
    
    public Attributes findOne(String id)
    {
        Attributes data = new Attributes();
        try {
            Statement statement = connection.createStatement();
            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ref_jenis_barang where id=?");
            preparedStatement.setString(1, id);
            ResultSet result = preparedStatement.executeQuery();
            
            while (result.next()) {
                data.setId(result.getString("id"));
                data.setName(result.getString("nama"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return data;
    }
    
    public void save(Attributes data)
    {
        try {
            PreparedStatement ps = connection.prepareStatement("select id from ref_jenis_barang where id = ?");
            ps.setString(1, data.getId());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                update(data);
            }else{
                add(data);
            }
        }catch(Exception ex){
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }
    
    public void add(Attributes data)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ref_jenis_barang(nama) values (?)");
            preparedStatement.setString(1, data.getName());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Attributes data)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update ref_jenis_barang set nama=? where id=?");
            
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2, data.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from ref_jenis_barang where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
