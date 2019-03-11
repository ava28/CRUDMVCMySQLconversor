
package crud;

//CLASE MODELO

import java.text.DecimalFormat;

public class Moneda {
    int id_c;
    String nombre;
    Double precio;
    Double Cant;
    Double Res;
    
    public Moneda(){
    }

    public Moneda(int id_c, String nombre, Double precio, Double Cantidad, Double res) {
        this.id_c = id_c;
        this.nombre = nombre;
        this.precio = precio;
        this.Cant=Cantidad;
        this.Res=Res;

    }
    public Moneda(String nombre,int id_c, Double precio, Double Cantidad, Double res) {
        this.id_c = id_c;
        this.nombre = nombre;
        this.precio = precio;
        this.Cant=Cantidad;
        this.Res=Res;

    }

    public Double getCant() {
        return Cant;
    }

    public void setCant(Double Cant) {
        this.Cant = Cant;
    }

    

    public Double getRes() {
        return Res;
    }

    public void setRes(Double res) {
        this.Res = res;
    }
    

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    

    @Override
    public String toString() {
        return "Moneda{" + "id_c=" + id_c + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    public Double conversor(){
        DecimalFormat df = new DecimalFormat("#.00");
        this.Res=this.Cant/this.precio;
        this.Res=Double.parseDouble(df.format(this.Res));//deciales a dos bato!
        return this.Res;
    }
    
    
    
}
