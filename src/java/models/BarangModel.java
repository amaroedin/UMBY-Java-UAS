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
public class BarangModel {
    private Connection connection;
 
    public BarangModel() {
        connection = Database.getConnection();
    }
    
    public List<Attributes> findAll()
    {
        List<Attributes> datas = new ArrayList<Attributes>();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select b.*, fk_satuan.nama nama_satuan, fk_kategori.nama nama_kategori, fk_jenis.nama nama_jenis from barang b "
                                + "left join ref_satuan_barang fk_satuan on b.id_satuan=fk_satuan.id "
                                + "left join ref_kategori_barang fk_kategori on b.id_kategori_barang=fk_kategori.id "
                                + "left join ref_jenis_barang fk_jenis on b.id_jenis_barang=fk_jenis.id "
                                + "order by b.id desc");
            
            while (results.next()) {
                Attributes barang = new Attributes();
                
                barang.setId(results.getString("id"));
                barang.setKdBarang(results.getString("kd_barang"));
                barang.setName(results.getString("nama_barang"));
                barang.setIdSatuan(results.getString("id_satuan"));
                barang.setIdKategoriBarang(results.getString("id_kategori_barang"));
                barang.setIdJenisBarang(results.getString("id_jenis_barang"));
                barang.setKeterangan(results.getString("keterangan"));
                barang.setNamaSatuan(results.getString("nama_satuan"));
                barang.setNamaKategori(results.getString("nama_kategori"));
                barang.setNamaJenis(results.getString("nama_jenis"));
                
                datas.add(barang);
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
            
            PreparedStatement preparedStatement = connection.prepareStatement("select * from barang where id=?");
            preparedStatement.setString(1, id);
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()) {
                data.setId(result.getString("id"));
                data.setKdBarang(result.getString("kd_barang"));
                data.setName(result.getString("nama"));
                data.setIdSatuan(result.getString("id_satuan"));
                data.setIdKategoriBarang(result.getString("id_kategori_barang"));
                data.setIdJenisBarang(result.getString("id_jenis_barang"));
                data.setKeterangan(result.getString("keterangan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return data;
    }
    
    public void save(Attributes data)
    {
        try {
            PreparedStatement ps = connection.prepareStatement("select id from barang where id = ?");
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
            PreparedStatement preparedStatement = connection.prepareStatement("insert into barang(kd_barang, nama_barang, id_satuan, id_kategori_barang, id_jenis_barang, keterangan) values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, data.getKdBarang());
            preparedStatement.setString(2, data.getName());
            preparedStatement.setString(3, data.getIdSatuan());
            preparedStatement.setString(4, data.getIdKategoriBarang());
            preparedStatement.setString(5, data.getIdJenisBarang());
            preparedStatement.setString(6, data.getKeterangan());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Attributes data)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update barang set kd_barang=?, nama_barang=?, id_satuan=?, id_kategori_barang=?, id_jenis_barang, keterangan=? "
                                                                            + "where id=?");
            
            preparedStatement.setString(1, data.getKdBarang());
            preparedStatement.setString(2, data.getName());
            preparedStatement.setString(3, data.getIdSatuan());
            preparedStatement.setString(4, data.getIdKategoriBarang());
            preparedStatement.setString(5, data.getIdJenisBarang());
            preparedStatement.setString(6, data.getKeterangan());
            preparedStatement.setString(7, data.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from barang where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
