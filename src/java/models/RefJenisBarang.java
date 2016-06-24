/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author amar
 */
public class RefJenisBarang {

    String id,nama;
    Date registeredon;
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public void setName(String nama)
    {
        this.nama = nama;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getName()
    {
        return nama;
    }
}
