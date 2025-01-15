/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tragaperras;
import java.util.Scanner;
/**
 *
 * @author baske
 */
public class Menu {
    static Scanner teclado = new Scanner(System.in);

    public static double Introduccion(Jugador jugador) {
        double usuario;
        System.out.println("Buenas, dime la cantidad de dinero que quieres introducir en la tragaperras");
        do {

            usuario = teclado.nextDouble();
            if (usuario > jugador.getDinero()) {
                System.out.println("No dispones de tanto dinero, ahora mismo en tu cartera hay: " + jugador.getDinero() + " euros");
            } else if (usuario < 0) {
                System.out.println("No pueden introducirse numeros negativos, pruebe otra vez");
            }
        } while (usuario > jugador.getDinero() || usuario < 0);
        return usuario;
    }
    
    
    
    public static int eleccionUsuario() {
        int usuario;

        System.out.println("""
                           Que deseas hacer?
                           1-Comprobar cartera
                           2-Tirar ruleta
                           3-comprobar saldo tragaperras
                           4-Introducir saldo
                           5-Sacar saldo
                           6-Comprobar avances
                           7-Salir
                           """);
        usuario = teclado.nextInt();
        return usuario;
    }
    
    public static boolean menuCarrusel() {
        boolean usar;
        int usuario;
        do {
            System.out.println("Quieres usar un avance?\n1-Si\n2-No");
            usuario = teclado.nextInt();
        } while (usuario < 1 || usuario > 2);
        if (usuario == 1) {
            usar = true;
        } else {
            usar = false;
        }
        return usar;
    }
    
}
