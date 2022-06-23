package com.ioana;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

//    private List<Product> generateProducts(){
//        List<Product> catalog = new ArrayList<>();
//        Product purcari = new Wine("Purcari", 35.0, 100, 10);
//        Product chocolate = new Cake("Chocolate Cake", 75.5, 2, 1500);
//        Product cabernet = new Wine("Cabernet", 56.0, 36, 3);
//        Product tiramisu = new Cake("Tiramisu", 12.0, 10, 400);
//        catalog.add(purcari);
//        catalog.add(chocolate);
//        catalog.add(cabernet);
//        catalog.add(tiramisu);
//
//        return catalog;
//    }

    public Map<Product, Integer> readOrder() {
      //  List<Product> catalog = generateProducts();

        List<Product> catalog = new ArrayList<>();
        Product purcari = new Wine("Purcari", 35.0, 100, 10);
        Product chocolate = new Cake("Chocolate Cake", 75.5, 2, 1500);
        Product cabernet = new Wine("Cabernet", 56.0, 36, 3);
        Product tiramisu = new Cake("Tiramisu", 12.0, 10, 400);
        catalog.add(purcari);
        catalog.add(chocolate);
        catalog.add(cabernet);
        catalog.add(tiramisu);

        for (Product product : catalog) {
            System.out.println((catalog.indexOf(product) + 1) + "." + product.getName() + " " + product.getPrice() + " RON");
        }
        Map<Product, Integer> productsInCart = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean addMore = true;
        while (addMore) {
            System.out.println("Select product number + quantity");
            try {
                // String order = reader.readLine();
                String[] orderEntry = reader.readLine().split(" ");
                int productNumber = Integer.parseInt(orderEntry[0]);
                Integer quantity = Integer.parseInt(orderEntry[1]);


                switch (productNumber) {
                    case 1:
                        productsInCart.put(purcari, productsInCart.getOrDefault(purcari, 0) + quantity);
                        break;
                    case 2:
                        productsInCart.put(chocolate, productsInCart.getOrDefault(purcari, 0) + quantity);
                        break;
                    case 3:
                        productsInCart.put(cabernet, productsInCart.getOrDefault(purcari, 0) + quantity);
                        break;
                    case 4:
                        productsInCart.put(tiramisu, productsInCart.getOrDefault(purcari, 0) + quantity);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (IOException ioException) {
                System.out.println("blabla");
                ioException.printStackTrace();
            }
            System.out.println("Do you still want to buy? yes/no");
            String addMoreString = null;
            try {
                addMoreString = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            addMore = "yes".equals(addMoreString);
        }

        return productsInCart;
    }

    private int calcTotalQuantity(Map<Product, Integer> products) {
        int totalQty = 0;
        for (int i : products.values()) {
            totalQty = totalQty + i;
        }
        return totalQty;
    }

    private double calcCartTotal(Map<Product, Integer> products) {
        double total = 0;
        for (Product product : products.keySet()) {
            total = total + (product.getPrice() * products.get(product));
        }
        return total;
    }

    public void placeOrder() {
        Map<Product, Integer> productsInCart = readOrder();
        System.out.println(" ");
        System.out.println("Your order was successful! Thank you for shopping with us.");
        System.out.println("---------Order Summary ---------- ");
        System.out.println("Order Date: " + LocalDate.now());
        System.out.println(" ");
        for (Product product : productsInCart.keySet()) {
            System.out.println(product.getName() + "   Qty:  " + productsInCart.get(product) + "   Price:  " +  product.getPrice() + " RON");
        }
        System.out.println("-------------------------------------");
        System.out.println("Total Quantity: " + calcTotalQuantity(productsInCart));
        System.out.println("Order Total " + calcCartTotal(productsInCart) + " RON");

    }


// SA APARA UN CATALOG DE PRODUSE
//   VIN PRET BLA BLA -
//   SA NU CITESC SEPARAT SA PUN PRODUSUL 5SPATIU 20 SI SA SE ADAUGE IN CART
// CAND NU MAI ADAUG PRODUSE SE PLASEAZA COMANDA , SI SA APARA TOATE INFORMATIILE CA UN ORDER CONFIRMATION

}
