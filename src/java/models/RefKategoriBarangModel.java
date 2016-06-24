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
public class RefKategoriBarangModel {
    private Connection connection;
 
    public RefKategoriBarangModel() {
        connection = Database.getConnection();
    }
    
    public List<Attributes> findAll()
    {
        List<Attributes> datas = new ArrayList<Attributes>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from ref_kategori_barang order by id desc");
            
            while (results.next()) {
                Attributes kategori = new Attributes();
                
                kategori.setId(results.getString("id"));
                kategori.setName(results.getString("nama"));
                
                datas.add(kategori);
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
            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ref_kategori_barang where id=?");
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
            PreparedStatement ps = connection.prepareStatement("select id from ref_kategori_barang where id = ?");
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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ref_kategori_barang(nama) values (?)");
            preparedStatement.setString(1, data.getName());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Attributes data)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update ref_kategori_barang set nama=? where id=?");
            
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2, data.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from ref_kategori_barang where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
