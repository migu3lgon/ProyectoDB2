
package gio.co.hospital.ws.servicios;


/**
 *
 * @author manu
 */
public class Servicios {

   
    private int id_subcat;
    private String subcat;
    private int id_cat;
    private int costoServ;
    
    
    public Servicios(int id_subcat, String subcat, int id_cat, int costoServ) {
        this.id_subcat = id_subcat;
        this.subcat = subcat;
        this.id_cat = id_cat;
        this.costoServ = costoServ;
    }
    
    public int getId_subcat() {
        return id_subcat;
    }

    public void setId_subcat(int id_subcat) {
        this.id_subcat = id_subcat;
    }

    public String getSubcat() {
        return subcat;
    }

    public void setSubcat(String subcat) {
        this.subcat = subcat;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public int getCostoServ() {
        return costoServ;
    }

    public void setCostoServ(int costoServ) {
        this.costoServ = costoServ;
    }
    
    
    
}





