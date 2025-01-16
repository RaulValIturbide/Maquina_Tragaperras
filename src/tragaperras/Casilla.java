/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tragaperras;

/**
 *
 * @author baske
 */
public class Casilla {
    private int numero;
    private String nombre;
    private int avance;
    private boolean avanceMax;//cuando se cumpla cierta condicion pasará a false y no podrá ejecutarse mas cambios de numero
    
    public Casilla(int numero, String nombre, int avance,boolean avanceMax){
    
        this.numero = numero;
        this.nombre = nombre;
        this.avance = avance;
        this.avanceMax = avanceMax;
        if (avance == 2){
            this.avanceMax = false;}
    }
    
    public int getNumero(){
        return numero;
    }
    public String getNombre(){
        return nombre;
    }
    public int getAvance(){
        return avance;
    }

    public boolean isAvanceMax() {
        return avanceMax;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setAvance(int avance){
        this.avance = avance;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAvanceMax(boolean avanceMax) {
        this.avanceMax = avanceMax;
    }
    
    
    public void mostrarInfo() {
        System.out.format("""
                          %s --> %d
                          """, nombre, numero);
    }
    public void generarAvance(){
        avance++;
    }
    
    
    
    
}
