/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author HP
 */
public class Facture implements Serializable{
    private Long id;
    private String nomClient;
    private String date;
    private Double total;
    private List<String> produits;
    private List<Double> prix;
    
    public Facture(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<String> getProduits() {
        return produits;
    }

    public void setProduits(List<String> produits) {
        this.produits = produits;
    }

    public List<Double> getPrix() {
        return prix;
    }

    public void setPrix(List<Double> prix) {
        this.prix = prix;
    }
//    Methode pour calculer le total a partir des prix
    public Double calculerTotal(List<Produit> produits){
//      Initialisation de la somme total
        Double totalFacture = 0.0;
//      Parcourir la liste des produit pour calculer le total
        for(Produit produit : produits){
            totalFacture += produit.getPrix();
        }
        return totalFacture;
    }
    
}
