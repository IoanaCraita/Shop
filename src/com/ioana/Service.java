package com.ioana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

    public void method(){

        Cart cart = new Cart();

        List<Product> catalog = new ArrayList<>();
        Product purcari = new Wine("Purcari",35.0,100,10);
        Product chocolate = new Cake("Chocolate Cake",75.5,2,1500);
        Product cabernet = new Wine("Cabernet",56.0,36,3);
        Product tiramisu = new Cake("Tiramisu", 12.0, 10, 400);
        catalog.add(purcari);
        catalog.add(chocolate);
        catalog.add(cabernet);
        catalog.add(tiramisu);

        for (Product product :catalog){
            System.out.println( (catalog.indexOf(product)+1) + "." +  product.getName() +" " + product.getPrice() + " RON");
        }
        Map<Product,Integer> productsInCart = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean addMore = true;
        while (addMore){
            System.out.println("Select product number + quantity");
            try {
               // String order = reader.readLine();
                String[] orderEntry = reader.readLine().split(" ");
                int productNumber = Integer.parseInt(orderEntry[0]);
                Integer quantity = Integer.parseInt(orderEntry[1]);
                switch (productNumber){
                    case 1:
                        productsInCart.put(purcari,quantity);
                        break;
                    case 2:
                        productsInCart.put(chocolate,quantity);
                        break;
                    case 3:
                        productsInCart.put(cabernet,quantity);
                        break;
                    case 4:
                        productsInCart.put(tiramisu,quantity);
                    default:
                        System.out.println("Invalid option");
                }
            } catch (IOException ioException) {
                System.out.println("blabla");
                ioException.printStackTrace();
            }

        }
    }







// SA APARA UN CATALOG DE PRODUSE
//   VIN PRET BLA BLA -
//   SA NU CITESC SEPARAT SA PUN PRODUSUL 5SPATIU 20 SI SA SE ADAUGE IN CART
// CAND NU MAI ADAUG PRODUSE SE PLASEAZA COMANDA , SI SA APARA TOATE INFORMATIILE CA UN ORDER CONFIRMATION

}
