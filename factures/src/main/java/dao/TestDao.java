/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import models.Facture;
import models.Produit;

/**
 *
 * @author HP
 */
public class TestDao {
    public static void main(String[] args){ 
        FactureDao dao1 = new FactureDao();
        
        List<Produit> produits = new ArrayList<>();
        produits.add(new Produit("Manioc", 250.0));
        produits.add(new Produit("The", 250.0));
        produits.add(new Produit("Pomme", 250.0));
        
        FactureDao factureDao = new FactureDao();
//        dao1.save(new Facture("Alkaly", "12-02-2024", produits, 2500.0));
       List<Facture> factures = new ArrayList<>();
//      Recuperation des factures
       factures = factureDao.getAll();
       for(Facture factureItem : factures){
           System.out.println("Nom client: " + factureItem.getNomClient());
       }
    }
}
