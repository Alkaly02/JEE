/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.*;


/**
 *
 * @author HP
 */
public class FactureDao {
//    Methode pour obtenir une connexion a la base de donnees
    private Connection getConnection() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/factures_base";
        String USER = "root";
        String PASSWORD = "";
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public void save(Facture facture){
        String query = "INSERT INTO factures (nom_client, date, total) VALUES (?, ?, ?)";
//        Connexion a la base de donnees
        try(Connection con = getConnection()){
            PreparedStatement ps = con.prepareStatement(query);
//            Insertion des informations de la facture
            ps.setString(1, facture.getNomClient());
            ps.setString(1, facture.getDate());
            ps.setDouble(3, facture.getTotal());
//            Execution de l'insertion
            int rowsAffected = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
}
