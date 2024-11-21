/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.util.List;
import models.Produit;
import interfaces.IFacture;

/**
 *
 * @author HP
 */
public class FactureMetier implements IFacture{

    @Override
    public Double calculerPrixTotal(List<Produit> produits) {
        Double total = 0.0;
        for(Produit produit: produits){
            total += produit.getPrix();
        }
        return total;
    }
    
}
