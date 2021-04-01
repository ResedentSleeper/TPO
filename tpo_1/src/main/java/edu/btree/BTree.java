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
                } else if (currentNode.getValues().size() < 4 ) { //Крайний узел у кторого нет детей и элементов меньше 4
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

        while (!currentNode.getValues().contains(value)) { //пока не нашли значение дём по дереву
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
        if (!currentNode.hasChilds()) { // узел просто удаляется, если не имеет потомков
            if (currentNode == rootNode) // если узел - корень, то дерево очищается
                rootNode.removeValue(value);
            else if (isLeftChild)
                parentNode.getLeftChild().removeValue(value); // если нет - узел отсоединяется, от родителя
            else
                parentNode.getRightChild().removeValue(value);

        } else if (currentNode.getRightChild() == null) { // узел заменяется левым поддеревом, если правого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getLeftChild());
            else
                parentNode.setRightChild(currentNode.getLeftChild());
        } else if (currentNode.getLeftChild() == null) { // узел заменяется правым поддеревом, если левого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getRightChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getRightChild());
            else
                parentNode.setRightChild(currentNode.getRightChild());
        } else { // если есть два потомка, узел заменяется преемником
            Node heir = receiveHeir(currentNode);// поиск преемника для удаляемого узла
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return true; // элемент успешно удалён
    }

    // метод возвращает узел со следующим значением после передаваемого аргументом.
    // для этого он сначала переходим к правому потомку, а затем
    // отслеживаем цепочку левых потомков этого узла.
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }

        if (heirNode != node.getRightChild()){
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;
    }


    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValues().toString()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}