package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<String, Producto> productTree = CSVReader.loadProductsFromCSV("datos.csv");        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Buscar producto por SKU");
            System.out.println("2. Listar productos ordenados por SKU (ascendente)");
            System.out.println("3. Listar productos ordenados por SKU (descendente)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
                continue;
            }
            
            switch (option) {
                case 1:
                    searchProduct(scanner, productTree);
                    break;
                    
                case 2:
                    System.out.println("\n--- PRODUCTOS ORDENADOS ASCENDENTE ---");
                    productTree.inOrderAscending();
                    break;
                    
                case 3:
                    System.out.println("\n--- PRODUCTOS ORDENADOS DESCENDENTE ---");
                    productTree.inOrderDescending();
                    break;
                    
                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void searchProduct(Scanner scanner, BinarySearchTree<String, Producto> productTree) {
        System.out.print("\nIngrese el SKU a buscar: ");
        String sku = scanner.nextLine().trim();
        
        Producto producto = productTree.search(sku);
        
        if (producto != null) {
            System.out.println("\n--- PRODUCTO ENCONTRADO ---");
            System.out.println("SKU: " + producto.getSku());
            System.out.println("Nombre: " + producto.getProductName());
            System.out.println("Categoría: " + producto.getCategory());
            System.out.printf("Precio Retail: %.2f%n", producto.getPriceRetail());
            System.out.printf("Precio Actual: %.2f%n", producto.getPriceCurrent());
            
            if (producto.getPriceCurrent() < producto.getPriceRetail()) {
                System.out.printf("¡OFERTA! Ahorro: %.2f%n", 
                    producto.getPriceRetail() - producto.getPriceCurrent());
            }
        } else {
            System.out.println("Producto con SKU " + sku + " no encontrado.");
        }
    }
}