package edu.btree;

import java.util.*;

public class BTree {

    private Node rootNode;

    public BTree() {
        rootNode = null;
    }


    public boolean insertValue(Integer value) {
        Node newNode;
        if (rootNode == null) {
            rootNode = new Node(value);
            return true;
        } else {
            Node currentNode = rootNode;

            while (true) {
                ArrayList<Integer> tmp = currentNode.getValues();

                if (currentNode.hasChilds()) { //Если у нода есть потомки, то проверяем по какой из веток можем пойти
                    if (currentNode.getValues().contains(value)) {//Такой элемент уже есть
                        System.out.println("Such element already exist");
                        return false;
                    }
                    if (currentNode.isNewValueLower(value)) {
                        newNode = currentNode.getLeftChild();
                    } else {
                        newNode = currentNode.getRightChild();
                    }
                    currentNode = newNode;
                } else if (currentNode.getValues().size() < 4) { //Крайний узел у кторого нет детей и элементов меньше 4
                    if (currentNode.getValues().contains(value)) {//Такой элемент уже есть
                        System.out.println("Such element already exist");
                        return false;
                    }
                    currentNode.addValue(value);
                    return true;
                } else { //Как только у крайнего нода становится элементов больше 3, создаём новые ноды и перестраиваем текущий
                    tmp.add(value);
                    Collections.sort(tmp);

                    Node newLeftNode = new Node(tmp.get(0));
                    Node newRightNode = new Node(tmp.get(2));
                    newRightNode.addValue(tmp.get(3));

                    currentNode.setLeftChild(newLeftNode);
                    currentNode.setRightChild(newRightNode);
                    currentNode.addValue(tmp.get(1));

                    return true;
                }
            }
        }
    }


    public boolean deleteValue(int value) {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;

        while (!currentNode.getValues().contains(value)) {
            parentNode = currentNode;
            if (currentNode.isNewValueLower(value)) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            //узел не найден
            if (currentNode == null)
                return false;
        }
        if (!currentNode.hasChilds()) {
            if (isLeftChild)
                parentNode.getLeftChild().removeValue(value);
            else
                parentNode.getRightChild().removeValue(value);

        } else {

            Node next = receiveHeir(currentNode);
            if (currentNode == rootNode)
                rootNode = next;
            else if (isLeftChild)
                parentNode.setLeftChild(next);
            else
                parentNode.setRightChild(next);
        }
        return true;
    }

    // метод возвращает узел со следующим значением после передаваемого аргументом.
    // для этого он сначала переходим к правому потомку, а затем
    // отслеживаем цепочку левых потомков этого узла.
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node nextNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode != null) {
            parentNode = nextNode;
            nextNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        return nextNode;
    }

}