/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import models.Produit;

/**
 *
 * @author HP
 */
public interface IFacture {
    public Double calculerPrixTotal(List<Produit> produits);
}
