<%-- 
    Document   : facture
    Created on : 22 nov. 2024, 16:01:36
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facture</title>
        <style>
            *{
                box-sizing: border-box;
                font-family: sans-serif;
            }
            label{
                display: inline-block;
                margin-bottom: 5px;
                width: 100%;
            }
            .form_container{
                max-width: 800px;
                margin: auto;
            }
            input{
                width: 100%;
                padding: 10px;
            }
            input[type="submit"]{
                background-color: #418ec7;
                margin-top: 20px;
                cursor: pointer;
            }
            .flex{
                display: flex;
                gap: 10px;
            }
            #ajout_produit_btn{
                background-color: #a03960;
                border: none;
                border-radius: 8px;
                color: white;
                padding: 10px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div class="form_container">
            <h1>Ajouter une nouvelle facture</h1>
            <form action="index" method="POST">
                <div class="flex">
                    <label for="nom">
                    Nom client: <input id="nom" type="text" name="nom_client" />
                    </label>
                    <label for="date">
                        Date de la facture: <input id="date" type="date" name="date_facture" />
                    </label>
                </div>
                <div>
                    Liste des produits
                    <div id="products_container">
                        <div class="product_item flex">
                            <label for="nom_produit">
                                <input id="nom_produit" name="nom_produit[]" type="text" placeholder="Nom produit" />
                            </label>
                            <label for="prix_produit">
                                <input id="prix_produit" name="prix_produit[]" type="number" placeholder="Prix produit" />
                            </label>
                        </div>
                    </div>
                    <button id="ajout_produit_btn" type="button">Nouveau produit</button>
                </div>
                <input type="submit" value="Envoyer" />
            </form>
        </div>
        
        <script>
            const ajoutProduit = document.getElementById("ajout_produit_btn");
            const conteneurListeProduits = document.getElementById("products_container");
            
            ajoutProduit.addEventListener("click", () => {
                const div = document.createElement("div");
                div.setAttribute("class", "flex")
//              Creation du label et l'input du produit
                const produitNomtLabel = document.createElement("label");
                const produitNomInput = document.createElement("input");
//              Ajout des attributs a l'input
                produitNomInput.setAttribute("name", "nom_produit[]");
                produitNomInput.setAttribute("placeholder", "Nom produit");
//              Ajout de l'input nom produit dans le label
                produitNomtLabel.appendChild(produitNomInput);
//                
//              Creation du label et de l'input du produit
                const produitPrixLabel = document.createElement("label");
                const produitPrixInput = document.createElement("input");
//              Ajout des attributs a l'input
                produitPrixInput.setAttribute("name", "prix_produit[]");
                produitPrixInput.setAttribute("placeholder", "Prix produit");
//              Ajout de l'input prix produit dans le label
                produitPrixLabel.appendChild(produitPrixInput);
                
//              Ajout des deux labels dans un div
                div.appendChild(produitNomtLabel);
                div.appendChild(produitPrixLabel);
                
//              Ajout de la div dans le HTML
                conteneurListeProduits.appendChild(div);
            });
        </script>
    </body>
</html>
