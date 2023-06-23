package org.homework.HwFin;

//Для превращения данного дерева в левостороннее красно-черное дерево необходимо дополнить класс Node
// свойствами цвета и родительской ноды. Также в класс Tree нужно добавить метод добавления новых элементов.
// Пример реализации класса Tree с учетом красно-черного дерева:

public class RedBlackTree<V extends Comparable<V>> {
    private Node root;

    private class Node {
        private V value;
        private Node left;
        private Node right;
        private Node parent;
        private boolean isRed;

        Node(V value, Node parent) {
            this.value = value;
            this.parent = parent;
            isRed = true; // новый элемент всегда красный
        }
    }

    public boolean contains(V value) {
        if (root == null){
            return false;
        }
        return contains(root, value);
    }

    private boolean contains(Node node, V value) {
        if (node.value.equals(value)){
            return true;
        } else {
            if (node.value.compareTo(value) > 0){
                return contains(node.left, value);
            } else {
                return contains(node.right, value);
            }
        }
    }

    public void add(V value) {
        if (root == null) {
            root = new Node(value, null);
            root.isRed = false; // корень всегда черный
            return;
        }
        Node currentNode = root;
        while (true) {
            if (value.compareTo(currentNode.value) < 0) {
                if (currentNode.left == null) {
                    currentNode.left = new Node(value, currentNode);
                    balanceAfterAdd(currentNode.left);
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new Node(value, currentNode);
                    balanceAfterAdd(currentNode.right);
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    private void balanceAfterAdd(Node addedNode) {
        Node parentNode = addedNode.parent;
        if (parentNode == null) {
            addedNode.isRed = false; // корень всегда черный
            return;
        }
        if (!parentNode.isRed) { // если родительская нода черная - дерево остается сбалансированным
            return;
        }
        Node grandparentNode = parentNode.parent;
        if (grandparentNode == null) {
            return; // если нет дедушки, то дальнейшие действия невозможны
        }
        Node uncleNode = getUncleNode(addedNode);
        if (uncleNode == null || !uncleNode.isRed) { // случай 1
            rotateForCase1(addedNode, parentNode, grandparentNode);
        } else { // случай 2
            rotateForCase2(addedNode, parentNode, grandparentNode, uncleNode);
        }
    }

    private void rotateForCase1(Node addedNode, Node parentNode, Node grandparentNode) {
        if (parentNode == grandparentNode.left) {
            if (addedNode == parentNode.right) {
                rotateLeft(parentNode);
                addedNode = addedNode.left;
            }
            rotateRight(grandparentNode);
        } else {
            if (addedNode == parentNode.left) {
                rotateRight(parentNode);
                addedNode = addedNode.right;
            }
            rotateLeft(grandparentNode);
        }
        parentNode.isRed = false;
        grandparentNode.isRed = true;
        balanceAfterAdd(addedNode);
    }

    private void rotateForCase2(Node addedNode, Node parentNode, Node grandparentNode, Node uncleNode) {
        parentNode.isRed = false;
        uncleNode.isRed = false;
        grandparentNode.isRed = true;
        balanceAfterAdd(grandparentNode);
    }

    private Node getUncleNode(Node node) {
        if (node.parent == null || node.parent.parent == null) {
            return null;
        }
        if (node.parent == node.parent.parent.left) {
            return node.parent.parent.right;
        } else {
            return node.parent.parent.left;
        }
    }

    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }
}

//    В данном примере реализованы все критерии левостороннего красно-черного дерева.
//    Если мы добавляем элемент в дерево, то после добавления происходит его балансировка
//    с помощью метода balanceAfterAdd. В нем реализованы все 3 случая балансировки.
//    Для балансировки используются 2 малых поворота (левый и правый) и смена цвета.
//    Также реализован метод getUncleNode, который получает ноду "дядю" добавленной ноды,
//    а методы rotateLeft и rotateRight реализуют малые повороты.