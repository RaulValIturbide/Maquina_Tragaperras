package tragaperras;

/**
 *
 * @author baske
 */
public class Jugador {

    private double dinero;
    private String nombre;
    private boolean bancarrota;

    public Jugador(String nombre, double dinero, boolean bancarrota) {

        this.nombre = nombre;
        this.dinero = dinero;
        this.bancarrota = bancarrota;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDinero() {
        return dinero;
    }

    public boolean isBancarrota() {
        return bancarrota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public void setBancarrota(boolean bancarrota) {
        this.bancarrota = bancarrota;
    }

    public void mostrarInfo() {

        System.out.format("""
                          Dinero:  %.2f
                         
                          """,dinero);
    }

}
