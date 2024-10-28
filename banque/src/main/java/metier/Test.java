/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author HP
 */
public class Test {
    public static void main(String[] args){
        CreditMetierImplementation metier = new CreditMetierImplementation();
        double capital = 200000;
        double duree=240;
        double taux=4.5;
        double resultat = metier.calculerMensualiteCredit(capital, taux, duree);
        System.out.print("Le taux est: " + resultat);
    }
}
