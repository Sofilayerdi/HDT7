package com.example;

public class BinaryTreeNode<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private BinaryTreeNode<K, V> leftChild;
    private BinaryTreeNode<K, V> rightChild;
    private BinaryTreeNode<K, V> parent;
    private boolean isRightChild;

    public BinaryTreeNode(K key, V value, BinaryTreeNode<K, V> parent, boolean isRightChild) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        this.isRightChild = isRightChild;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Getters and Setters
    public K get_key() {
        return key;
    }

    public void set_key(K key) {
        this.key = key;
    }

    public V get_value() {
        return value;
    }

    public void set_value(V value) {
        this.value = value;
    }

    public BinaryTreeNode<K, V> get_leftChild() {
        return leftChild;
    }

    public void set_leftChild(BinaryTreeNode<K, V> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<K, V> get_rightChild() {
        return rightChild;
    }

    public void set_rightChild(BinaryTreeNode<K, V> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<K, V> get_parent() {
        return parent;
    }

    public void set_parent(BinaryTreeNode<K, V> parent) {
        this.parent = parent;
    }

    public boolean isRightChild() {
        return isRightChild;
    }

    public void setIsRightChild(boolean isRightChild) {
        this.isRightChild = isRightChild;
    }
}