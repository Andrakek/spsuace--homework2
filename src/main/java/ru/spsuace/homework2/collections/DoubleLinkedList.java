package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 * Полный балл - 6
 */
public class DoubleLinkedList<T> implements Iterable<T> {

    // ----------- 1 балл -----------
    Element first;
    Element last;
    int size;

    private class Element<T> {
        private Element<T> prev;
        private Element<T> next;
        private T value;

        Element(T value) {
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        return indexOf((T) o) != -1;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int indexOf(T o) {
        Element<T> newNode = first;
        if (o.equals(null)) {
            throw new NullPointerException();
        }
        for (int i = 0; i <= size - 1; i++) {
            if (o.equals(newNode.value)) {
                return i;
            }
            newNode = newNode.next;
        }
        return -1;
    }

    // ----------- 1 балл -----------

    public void add(int index, T element) {
        if (index == size) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
        } else {
            Element<T> newNode = new Element(element);
            Element<T> tempNode = getElement(index);

            newNode.prev = tempNode.prev;
            newNode.next = tempNode;

            tempNode.prev.next = newNode;
            tempNode.prev = newNode;
            size++;
        }
    }

    public void addLast(T element) {
        Element<T> newNode = new Element(element);
        if (size == 0) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void addFirst(T element) {
        Element<T> newNode = new Element(element);
        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    private Element getElement(int index) {
        if (index >= size || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException();
        }
        assert first != null;
        Element temp = first.next;
        if (index == 0) {
            return first;
        }
        if (index == size - 1) {
            return last;
        }
        if (index > 0 && index <= size / 2) {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else if (index > (size) / 2 && index < size) {
            temp = last;
            for (int i = size; i > index; i--) {
                temp = temp.prev;
            }
            return temp.next;
        }

        return null;
    }

    // ----------- 1 балл -----------

    public T set(int index, T element) {

        Element<T> var = getElement(index);
        T res = var.value;
        var.value = element;
        return res;
    }

    public T get(int index) {
        return (T) getElement(index).value;
    }

    public T remove(int index) {
        Element<T> element = getElement(index);
        if (index == 0) {
            element.next.prev = null;
            first = element.next;
        } else if (index == size - 1) {
            element.prev.next = null;
            last = element.prev;
        } else {
            element.prev.next = element.next;
            element.next.prev = element.prev;
        }
        size--;
        return element.value;
    }

    /**
     * Надо реализовать свой итератор, который будет последовательно идти с первого по последний элемент
     * 3 балла
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
