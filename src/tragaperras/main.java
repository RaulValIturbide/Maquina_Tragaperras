
package tragaperras;
import java.util.Scanner;
/*    
49) Simula una máquina tragaperras con 3 casillas. En cada casilla se mostrará un número.
El usuario meterá una cantidad de euros y, para cada partida, tendrá que gastarse 0.5 euros.
Si las 3 casillas coinciden, se ganará 50 euros.
Si coinciden 2 casillas, se ganará 5 euros.
Si el número que representa las 3 casillas es divisible entre 3, se tendrá 2 avances.
Si el número que representa las 3 casillas es divisible entre 5, se tendrá 3 avances.
Si el número que representa las 3 casillas es divisible entre 10, se tendrá 4 avances.
Una casilla solo puede avanzarse 2 veces.
Un avance lo que hará será generar otro número aleatorio.
Se indicará qué casilla se quiere avanzar (0, 1 y 2). Se pondrá -1 si no se quiere consumir todos los avances y terminar la partida. 
Si se obtiene premio, se añadirá al saldo que se tenga.
Tendrá que haber un menú en el que se pida jugar o bien recoger el dinero (se terminará el juego).
*/
public class main {
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
       
        Jugador jugador = new Jugador("Raul",10,false);   
        Casilla[] aCasilla = {
           new Casilla(0, "casilla 1",0, true),
           new Casilla(0, "casilla 2", 0,true),
           new Casilla(0, "casilla 3",0,true)};
        Tragaperras tragaperras = new Tragaperras("El ahorcado",0,0,aCasilla[0],aCasilla[1],aCasilla[2]);
        int usuario;
        
        
        
        double saldoTra = Menu.Introduccion(jugador);
        tragaperras.introducirSaldo(jugador, saldoTra);
        jugador.mostrarInfo();
        do {
            usuario = Menu.eleccionUsuario();
            switch (usuario) {
                case 1:
                    jugador.mostrarInfo();
                    break;
                case 2:
                    if (Menu.saldoTirada(tragaperras)) {
                        tragaperras.tirarCarrusel(aCasilla);
                        tragaperras.mostrarInfo();
                        if (tragaperras.getAvance() > 0) {
                            if (Menu.menuCarrusel()) {
                                tragaperras.usarAvance(aCasilla);
                            }
                        }
                        tragaperras.mostrarNumeros(aCasilla);
                        tragaperras.comprobarRecompensas(aCasilla);
                    } else {
                        System.out.println("Lo siento, no tienes suficiente dinero");
                        Menu.saltoLinea();
                    }

                    break;
                case 3:
                    tragaperras.mostrarInfo();
                    Menu.saltoLinea();
                    break;
                case 4:
                    saldoTra = Menu.Introduccion(jugador);
                    tragaperras.introducirSaldo(jugador, saldoTra);
                    Menu.saltoLinea();
                    break;
                case 5:
                    tragaperras.sacarDinero(jugador);
                    Menu.saltoLinea();
                    break;
                case 6:
                    tragaperras.mostrarAvance();
                    Menu.saltoLinea();
                    break;
                case 7:
                    System.out.println("Muchas gracias por jugar con nosotros, tenga un buen día y vuelva pronto");
                    break;
                 default:
                     System.out.println("Elija un número del menu:");
                     Menu.saltoLinea();
                     break;
                   

            }
        } while ((tragaperras.getDinero() > 0 || jugador.getDinero() > 0) && usuario != 7);


    }
    
}
