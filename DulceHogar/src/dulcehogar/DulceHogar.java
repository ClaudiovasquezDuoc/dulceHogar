/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dulcehogar;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author claud
 */
public class DulceHogar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tc= new Scanner(System.in);
        int menu=0;
            do{
            menu=Integer.parseInt( JOptionPane.showInputDialog("\n Bienvenido"
            +"\n 1.Registrar Socio"
            +"\n 2.Ver datos del socio"
            +"\n 3.Cancelar cuota"
            +"\n 4.Consultar cuota cancelada"
            +"\n 5.Consultar Total de cuotas pagadas por el socio" 
            +"\n 6.Salir del programa"
            ));
        
            switch(menu){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Gracias");
                    break;
            }                
        }while(menu!=6);                    
    }
    
}
