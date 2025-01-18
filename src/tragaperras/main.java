
package tragaperras;
import java.util.Scanner;
/*    
49) Simula una m�quina tragaperras con 3 casillas. En cada casilla se mostrar� un n�mero.
El usuario meter� una cantidad de euros y, para cada partida, tendr� que gastarse 0.5 euros.
Si las 3 casillas coinciden, se ganar� 50 euros.
Si coinciden 2 casillas, se ganar� 5 euros.
Si el n�mero que representa las 3 casillas es divisible entre 3, se tendr� 2 avances.
Si el n�mero que representa las 3 casillas es divisible entre 5, se tendr� 3 avances.
Si el n�mero que representa las 3 casillas es divisible entre 10, se tendr� 4 avances.
Una casilla solo puede avanzarse 2 veces.
Un avance lo que har� ser� generar otro n�mero aleatorio.
Se indicar� qu� casilla se quiere avanzar (0, 1 y 2). Se pondr� -1 si no se quiere consumir todos los avances y terminar la partida. 
Si se obtiene premio, se a�adir� al saldo que se tenga.
Tendr� que haber un men� en el que se pida jugar o bien recoger el dinero (se terminar� el juego).
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
                    System.out.println("Muchas gracias por jugar con nosotros, tenga un buen d�a y vuelva pronto");
                    break;
                 default:
                     System.out.println("Elija un n�mero del menu:");
                     Menu.saltoLinea();
                     break;
                   

            }
        } while ((tragaperras.getDinero() > 0 || jugador.getDinero() > 0) && usuario != 7);


    }
    
}
