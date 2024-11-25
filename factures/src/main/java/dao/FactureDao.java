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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Facture;
import models.Produit;

/**
 *
 * @author HP
 */
public class FactureDao {
    
    public Facture save(Facture facture){
        
        String query = "INSERT INTO factures (nom_client, date_facture, total_prix) VALUES (?, ?, ?)";
        try(Connection connection = DbConnection.getConnection()){
            try( PreparedStatement prepare = connection.prepareStatement(query)){
                prepare.setString(1, facture.getNomClient());
                String dateStr = facture.getDateFacture(); // Exemple: "2024-11-22"
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(dateStr); // Conversion en date
                prepare.setDate(2,  new java.sql.Date(date.getTime()));
                prepare.setDouble(3, facture.getTotal());
    //            sauvegare
                prepare.executeUpdate();
    //            Recuperer l'id de la facture enregistrer
                PreparedStatement prepare2 = connection.prepareStatement("SELECT MAX(id) as id_facture FROM factures");
                ResultSet result = prepare2.executeQuery();
                while(result.next()){
                    facture.setId(result.getLong("id_facture"));
                }
    //            sauvegarder les produits relatifs a cette facture
                ProduitDao produitDao = new ProduitDao();
                List<Produit> savedProduits = new ArrayList<>();
                for(Produit produit : facture.getProduits()){
                    savedProduits.add(produitDao.save(produit, facture.getId(), connection));
                }
//              Mise a jour du model facure
                facture.setProduits(savedProduits);
            }catch(Exception e){
                System.out.println("dao.FactureDao.save()");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return facture;
    }
    
    public List<Facture> getAll(){
        List<Facture> factures = new ArrayList<>();
        
        try(Connection connection = DbConnection.getConnection()){
//          Recuperer toutes les factures
            PreparedStatement prepare = connection.prepareStatement("SELECT * FROM factures");
            ResultSet result = prepare.executeQuery();
            
            while(result.next()){
                Facture facture = new Facture();
                facture.setId(result.getLong("id"));
                facture.setNomClient(result.getString("nom_client"));
//              Recuperation de la date
                java.sql.Date date_facture = result.getDate("date_facture");
//              Formattage
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                
                facture.setDateFacture(formatDate.format(date_facture));
                facture.setTotal(result.getDouble("total_prix"));
                
//              Ajout de la facture dans le tableau
                factures.add(facture);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return factures;
    }
}
