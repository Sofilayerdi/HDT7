package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<String, Producto> bst;
    
    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
    }
    
    @Test
    public void testInsertAndSearch() {
        Producto p1 = new Producto("SKU001", 100.0, 90.0, "Producto 1", "Categoría A");
        Producto p2 = new Producto("SKU002", 200.0, 180.0, "Producto 2", "Categoría B");
        
        // Verificar inserción
        bst.insert(p1.getSku(), p1);
        bst.insert(p2.getSku(), p2);
        
        assertEquals(2, bst.count());
        
        // Verificar búsqueda
        assertEquals(p1, bst.search("SKU001"));
        assertEquals(p2, bst.search("SKU002"));
        assertNull(bst.search("SKU999"));
    }
    
    @Test
    public void testEmptyTree() {
        assertTrue(bst.isEmpty());
        assertEquals(0, bst.count());
        assertNull(bst.search("ANY"));
    }
    
    @Test
    public void testUpdateProduct() {
        Producto p1 = new Producto("SKU001", 100.0, 90.0, "Producto 1", "Categoría A");
        Producto p1Updated = new Producto("SKU001", 110.0, 95.0, "Producto 1 Actualizado", "Categoría A");
        
        bst.insert(p1.getSku(), p1);
        assertEquals(1, bst.count());
        
        bst.insert(p1Updated.getSku(), p1Updated);
        assertEquals(1, bst.count());
        
        Producto result = bst.search("SKU001");
        assertEquals("Producto 1 Actualizado", result.getProductName());
        assertEquals(110.0, result.getPriceRetail());
    }
}