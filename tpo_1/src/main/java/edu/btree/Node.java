package edu.btree;

import java.util.ArrayList;
import java.util.Collections;

public class Node {

    private ArrayList<Integer> values = new ArrayList<>();
    private Node leftChild;
    private Node rightChild;

    public Node(Integer value) {
        values.add(value);
    }



    public boolean hasChilds() {
        if (leftChild == null && rightChild == null)
            return false;
        return true;
    }

    public boolean isNewValueLower(Integer value) {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > value)
                return true;
        }
        return false;
    }

    public void addValue(Integer value) {
            if (this.values.size() < 4) {
                this.values.add(value);
                Collections.sort(this.values);
            } else {
                this.values.clear();
                this.values.add(value);
            }
    }

    public void removeValue(Integer value) {
        values.remove(value);
    }

    public ArrayList<Integer> getValues() {
        return values;
    }
    public Node getLeftChild() {
        return this.leftChild;
    }
    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }
    public Node getRightChild() {
        return this.rightChild;
    }
    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }

}
