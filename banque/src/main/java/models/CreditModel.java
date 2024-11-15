/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author HP
 */
public class CreditModel {
    private double montant;
    private double taux;
    private int duree;
    private double mensualite;
    
    public CreditModel(){
        
    }

    public CreditModel(double montant, double taux, int duree, double mensualite) {
        this.montant = montant;
        this.taux = taux;
        this.duree = duree;
        this.mensualite = mensualite;
    }

    public double getMontant() {
        return montant;
    }

    public double getTaux() {
        return taux;
    }

    public int getDuree() {
        return duree;
    }

    public double getMensualite() {
        return mensualite;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setMensualite(double mensualite) {
        this.mensualite = mensualite;
    }
    
    
}
