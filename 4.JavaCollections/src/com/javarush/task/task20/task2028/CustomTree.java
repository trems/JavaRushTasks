package com.javarush.task.task20.task2028;

import java.io.Closeable;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Stream;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    final Entry<String> root;
    int size;
    Queue<Entry> queue;

    public CustomTree() {
        this.root = new Entry<>("0");
        this.size = -1;
    }

    @Override
    public boolean add(String elementName) {
        Entry parent = findLastElement();
        if (parent != null) {
            if (parent.availableToAddLeftChildren) {
                parent.leftChild = new Entry(elementName);
                parent.availableToAddLeftChildren = false;
                parent.leftChild.parent = parent;
                return true;
            } else if (parent.availableToAddRightChildren) {
                parent.rightChild = new Entry(elementName);
                parent.availableToAddRightChildren = false;
                parent.rightChild.parent = parent;
                return true;
            }
        } else {
            Entry element = null;
            ArrayDeque<Entry> queue = new ArrayDeque<>();
            queue.add(root);
            while ((element = queue.poll()) != null) {
                if (element.leftChild == null && !element.availableToAddLeftChildren) {
                    element.availableToAddLeftChildren = true;
                    return add(elementName);
                } else if (element.rightChild == null && !element.availableToAddRightChildren) {
                    element.availableToAddRightChildren = true;
                    return add(elementName);
                }
                if (element.leftChild != null) queue.add(element.leftChild);
                if (element.rightChild != null) queue.add(element.rightChild);
            }
        }

        return false;
    }

    @Override
    public int size() {
        size = -1;
        Entry element;
        queue = new ArrayDeque<>();
        queue.add(root);
        while ((element = queue.poll()) != null) {
            size++;
            if (element.leftChild != null) queue.add(element.leftChild);
            if (element.rightChild != null) queue.add(element.rightChild);
        }
        return size;
    }
    public Entry findLastElement() {
        Entry element = root;
        ArrayDeque<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        while ((element = queue.poll()) != null) {
            if (element.availableToAddLeftChildren) return element;
            else if (element.availableToAddRightChildren) return element;
            if (element.leftChild != null) queue.add(element.leftChild);
            if (element.rightChild != null) queue.add(element.rightChild);
        }
        return null;
    }
    public String getParent(String elementName) {
        Entry element;
        queue = new ArrayDeque<>();
        queue.add(root);
        while ((element = queue.poll()) != null) {
            if (element.elementName.equals(elementName)) return element.parent.elementName;
            if (element.leftChild != null) queue.add(element.leftChild);
            if (element.rightChild != null) queue.add(element.rightChild);
        }
        return "null";
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        Entry element;
        queue = new ArrayDeque<>();
        queue.add(root);
        while ((element = queue.poll()) != null) {
            if (element.elementName.equals(o)) {
                if (element.parent.leftChild == element) element.parent.leftChild = null;
                else if (element.parent.rightChild == element) element.parent.rightChild = null;
                element = null;
                return true;
            }
            if (element.leftChild != null) queue.add(element.leftChild);
            if (element.rightChild != null) queue.add(element.rightChild);
        }
        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
