/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tragaperras;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author baske
 */
public class Tragaperras {
    static Scanner teclado = new Scanner(System.in);
    static Random random = new Random();
    private String nombre;
    private double dinero;
    private int avance;
    private Casilla casilla1;
    private Casilla casilla2;
    private Casilla casilla3;

    public Tragaperras(String nombre, double dinero, int avance, Casilla casilla1, Casilla casilla2, Casilla casilla3) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.avance = avance;
        this.casilla1 = casilla1;
        this.casilla2 = casilla2;
        this.casilla3 = casilla3;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDinero(){
        return dinero;
    }

    public int getAvance() {
        return avance;
    }

    public Casilla getCasilla1() {
        return casilla1;
    }

    public Casilla getCasilla2() {
        return casilla2;
    }

    public Casilla getCasilla3() {
        return casilla3;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public void setCasilla1(Casilla casilla1) {
        this.casilla1 = casilla1;
    }

    public void setCasilla2(Casilla casilla2) {
        this.casilla2 = casilla2;
    }

    public void setCasilla3(Casilla casilla3) {
        this.casilla3 = casilla3;
    }

    public void mostrarInfo() {
        System.out.format("""
                          dinero ->  %.2f
                          """, dinero);
    }

    public void introducirSaldo(Jugador jugador, double saldoIntroducido) {

        jugador.setDinero(jugador.getDinero() - saldoIntroducido);
        setDinero(getDinero()+saldoIntroducido);

    }
    
    /**
     * Metodo para "tirar" de la ruleta y que aparezcan 3 numeros aleatorios entre 0 y 7
     * @param casilla el array de casillas que hemos creado.
     */
    public void tirarCarrusel(Casilla[] casilla){
        
        setDinero(getDinero()-0.5);
        
        for(int i = 0; i<casilla.length;i++){
            
            casilla[i].setNumero(random.nextInt(8));
            casilla[i].mostrarInfo();
            
        }
        
        
    }
    /**
     * Aquí estableceremos gran parte de la lógica de los premios, lo haremos pensando que solo puedes ganar un premio de los que existen,
     * ya que no tiene mucho sentido que ganes el premio de coincidir 3 casillas y también te den el de coincidir 2 y demás, pero le daremos
     * prioridad a los mejores premios (premios en metalico) e iran bajando de importancia
     * @param casilla el array de nuestras casillas
     */
    public void comprobarRecompensas(Casilla[] casilla){
       int numero = 0;
       
        for (int i = 0; i<casilla.length; i++){
            numero +=casilla[i].getNumero();
        }
        
        if(jackpot(casilla)){
            primerPremio();
        }else if (numerosIguales(casilla)){
            segundoPremio();
        }else if (numero % 10 == 0){
            tercerPremio();
        }else if (numero % 5 == 0){
            cuartoPremio();
        }else if (numero % 3 == 0){
            quintoPremio();
        }
        
    
    }
    
    
    /**
     * Premio de los 500 euros
     */
    public void primerPremio(){
        System.out.println("Enhorabuena, ganaste el PRIMER PREMIO, 50 euros!!");
        setDinero(getDinero()+50);
    }
    public void segundoPremio(){
        System.out.println("Enhorabuena, ganaste el SEGUNDO PREMIO, 5 euros!!");
       setDinero(getDinero()+5);
    }
    public void tercerPremio(){
        System.out.println("Enhorabuena, ganaste un premio, obtienes 4 avances!!");
        setAvance(getAvance()+4);
    }
    public void cuartoPremio(){
        System.out.println("Enhorabuena, ganaste un premio, obtienes 3 avances!!");
        setAvance(getAvance()+3);
    }
    public void quintoPremio(){
        System.out.println("Enhorabuena, ganaste un premio, obtienes 2 avances!!");
        setAvance(getAvance()+2);
    }
    
    /**
     * Comprobaremos que los 3 numeros sean iguales
     * @param casilla
     * @return true si son iguales
     */
    public boolean jackpot(Casilla[] casilla) {
        boolean iguales = false;
        if (casilla[0].getNumero() == casilla[1].getNumero()) {
            if (casilla[0].getNumero() == casilla[2].getNumero()) {
                iguales = true;
            }
        }
        return iguales;
    }
    
    
    /**
     * Comprobaremos si en los 3 hay semejancia
     * @return  true si son iguales 2 de 3
     */
    public boolean numerosIguales(Casilla[] casilla) {
        boolean iguales = false;

        for (int i = 0; i < casilla.length; i++) {
            for (int j = i+1; j < casilla.length; j++) {
                if (casilla[i].getNumero() == casilla[j].getNumero()) {
                    if(i!=j){
                    iguales = true;}
                }
            }

        }

        return iguales;

    }
    
    
    public void sacarDinero(Jugador jugador){
        System.out.println("Cuanto dinero deseas sacar?");
        
        double usuario;
        do{
        usuario = teclado.nextDouble();
          if (usuario > getDinero()){
              System.out.println("No dispones de tanto saldo para sacar, ahora mismo tienes: " + getDinero());}
        }while(usuario > getDinero());
        
        setDinero(getDinero()-usuario);
        jugador.setDinero(jugador.getDinero()+usuario);
        
    }
    public void mostrarAvance(){
        System.out.println(getAvance());
    }
    
    public void usarAvance(Casilla[] casilla) {
        int usuario;
        do {
            do {
                System.out.println("");
                System.out.println("En que casilla deseas usar el avance?");
                usuario = teclado.nextInt();
                if (usuario > 3 || usuario < 1) {
                    System.out.println("Por favor, selecciona la casilla 1 , 2 o 3 ");
                }

            } while (usuario > 3 || usuario < 1);
            if (!casilla[usuario].isAvanceMax()) {
                System.out.println("Ya se ha alcanzado el numero maximo de avances");
            }
        } while (!casilla[usuario].isAvanceMax());

        casilla[usuario].setNumero(random.nextInt(8));
        casilla[usuario].generarAvance();
        setAvance(getAvance() - 1);

    }
    
    
    
}
