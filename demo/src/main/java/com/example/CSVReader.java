package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static BinarySearchTree<String, Producto> loadProductsFromCSV(String filePath) {
        BinarySearchTree<String, Producto> bst = new BinarySearchTree<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); 
            
            while ((line = br.readLine()) != null) {
                try {
                    String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); 
                    if (values.length >= 5) {
                        String sku = values[0].trim().replace("\"", "");
                        double priceRetail = Double.parseDouble(values[1].trim().replace("\"", ""));
                        double priceCurrent = Double.parseDouble(values[2].trim().replace("\"", ""));
                        String productName = values[3].trim().replace("\"", "");
                        String category = values[4].trim().replace("\"", "");
                        
                        Producto producto = new Producto(sku, priceRetail, priceCurrent, productName, category);
                        bst.insert(sku, producto);
                    }
                } catch (Exception e) {
                    System.err.println("Error procesando línea: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        }
        
        return bst;
    }
}