/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author amar
 */
public class Attributes {
    String id,nama;
    String kd_barang,id_satuan,id_kategori_barang,id_jenis_barang,keterangan,nama_satuan,nama_kategori,nama_jenis;
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public void setName(String nama)
    {
        this.nama = nama;
    }
    
    public void setKdBarang(String kd_barang)
    {
        this.kd_barang = kd_barang;
    }
    
    public void setIdSatuan(String id_satuan)
    {
        this.id_satuan = id_satuan;
    }
    
    public void setIdKategoriBarang(String id_kategori)
    {
        this.id_kategori_barang = id_kategori;
    }
    
    public void setIdJenisBarang(String id_jenis)
    {
        this.id_jenis_barang = id_jenis;
    }
    
    public void setKeterangan(String keterangan)
    {
        this.keterangan = keterangan;
    }
    
    public void setNamaSatuan(String nama_satuan)
    {
        this.nama_satuan = nama_satuan;
    }
    
    public void setNamaKategori(String nama_kategori)
    {
        this.nama_kategori = nama_kategori;
    }
    
    public void setNamaJenis(String nama_jenis)
    {
        this.nama_jenis = nama_jenis;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return nama;
    }
    
    public String getKdBarang()
    {
        return kd_barang;
    }
    
    public String getIdSatuan()
    {
        return id_satuan;
    }
    
    public String getIdKategoriBarang()
    {
        return id_kategori_barang;
    }
    
    public String getIdJenisBarang()
    {
        return id_jenis_barang;
    }
    
    public String getKeterangan()
    {
        return keterangan;
    }
    
    public String getNamaSatuan()
    {
        return nama_satuan;
    }
    
    public String getNamaKategori()
    {
        return nama_kategori;
    }
    
    public String getNamaJenis()
    {
        return nama_jenis;
    }
}
