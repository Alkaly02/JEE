/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Produit;

/**
 *
 * @author HP
 */
public class ProduitDao {
    
    public Produit save(Produit produit, Long facture_id, Connection connection){
        String query = "INSERT INTO produits (nom, prix, id_facture) VALUES(?, ?, ?)";
        try{
            PreparedStatement prepare = connection.prepareStatement(query);
            prepare.setString(1, produit.getNom());
            prepare.setDouble(2, produit.getPrix());
            prepare.setLong(3, facture_id);
//            sauvegare
            prepare.executeUpdate();
            
//            Recuperer l'id du produit qui vient d'etre ajoute
            PreparedStatement prepare2 = connection.prepareStatement("SELECT MAX(id) as max_id FROM produits");
            ResultSet result = prepare2.executeQuery();
            while(result.next()){
                produit.setId(result.getLong("max_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return produit;
    }
}
