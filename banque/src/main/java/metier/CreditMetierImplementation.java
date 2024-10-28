/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author HP
 */
public class CreditMetierImplementation implements ICreditMetier {

    @Override
    public double calculerMensualiteCredit(double capital, double taux, double duree) {
        double t = taux / 100;
        double t1 = capital * t/ 12;
        double t2 = 1-Math.pow(1+t/12, -duree);
        return t1/t2;
    }
   
}
