<%-- 
    Document   : facture
    Created on : 25 nov. 2024, 18:25:23
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
                                <input id="nom_produit" name="produit1" type="text" placeholder="Nom produit" />
                            </label>
                            <label for="prix_produit">
                                <input id="prix_produit" name="prix1" type="number" placeholder="Prix produit" />
                            </label>
                        </div>
                        <div class="product_item flex">
                            <label for="nom_produit">
                                <input id="nom_produit" name="produit2" type="text" placeholder="Nom produit" />
                            </label>
                            <label for="prix_produit">
                                <input id="prix_produit" name="prix2" type="number" placeholder="Prix produit" />
                            </label>
                        </div>
                        <div class="product_item flex">
                            <label for="nom_produit">
                                <input id="nom_produit" name="produit3" type="text" placeholder="Nom produit" />
                            </label>
                            <label for="prix_produit">
                                <input id="prix_produit" name="prix3" type="number" placeholder="Prix produit" />
                            </label>
                        </div>
                    </div>
                </div>
                <input type="submit" value="Envoyer" />
            </form>
        </div>
        
    </body>
</html>
