package com.example;

public class BinarySearchTree<K extends Comparable<K>, V> {
    private BinaryTreeNode<K, V> root;
    private int count;

    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    public int count() {
        return count;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(K key, V value) {
        if (isEmpty()) {
            root = new BinaryTreeNode<>(key, value, null, false);
            count++;
        } else {
            insertNode(root, key, value);
        }
    }

    private void insertNode(BinaryTreeNode<K, V> node, K key, V value) {
        int comparison = key.compareTo(node.get_key());
        
        if (comparison < 0) {
            if (node.get_leftChild() == null) {
                node.set_leftChild(new BinaryTreeNode<>(key, value, node, false));
                count++;
            } else {
                insertNode(node.get_leftChild(), key, value);
            }
        } else if (comparison > 0) {
            if (node.get_rightChild() == null) {
                node.set_rightChild(new BinaryTreeNode<>(key, value, node, true));
                count++;
            } else {
                insertNode(node.get_rightChild(), key, value);
            }
        } else {
            node.set_value(value); // Actualiza el valor si la clave ya existe
        }
    }

    public V search(K keyToFind) {
        return searchNode(root, keyToFind);
    }

    private V searchNode(BinaryTreeNode<K, V> node, K keyToFind) {
        if (node == null) {
            return null;
        }

        int comparison = keyToFind.compareTo(node.get_key());
        
        if (comparison == 0) {
            return node.get_value();
        } else if (comparison < 0) {
            return searchNode(node.get_leftChild(), keyToFind);
        } else {
            return searchNode(node.get_rightChild(), keyToFind);
        }
    }

    public void inOrderAscending() {
        inOrderAscending(root);
    }
    
    private void inOrderAscending(BinaryTreeNode<K, V> node) {
        if (node != null) {
            inOrderAscending(node.get_leftChild());
            System.out.println(node.get_value());
            inOrderAscending(node.get_rightChild());
        }
    }
    
    public void inOrderDescending() {
        inOrderDescending(root);
    }
    
    private void inOrderDescending(BinaryTreeNode<K, V> node) {
        if (node != null) {
            inOrderDescending(node.get_rightChild());
            System.out.println(node.get_value());
            inOrderDescending(node.get_leftChild());
        }
    }
}