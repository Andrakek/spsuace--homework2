package ru.spsuace.homework2.collections;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Написать структуру данных, реализующую интерфейс мапы + набор дополнительных методов.
 * 2 дополнительных метода должны вовзращать самый популярный ключ и его популярность.
 * Популярность - это количество раз, который этот ключ (или значение) учавствовал в методах мапы containsKey,
 * containsValue, get, put, remove в качестве аргумента или возвращаемого значения.
 * Читайте документацию к методам (ctrl + Q) для понимания, что где возвращается.
 * Считаем, что null я вам не передю ни в качестве ключа, ни в качестве значения
 * <p>
 * Важный момент, вам не надо реализовывать мапу, вы должны использовать композицию.
 * Вы можете использовать любые коллекции, которые есть в java. Перечислю реализации основных типов коллекций:
 * List -> {@link java.util.ArrayList}
 * Set -> {@link java.util.HashSet}
 * Map -> {@link java.util.HashMap}
 * Stack -> {@link java.util.Stack}
 * Queue -> {@link java.util.LinkedList}
 * Deque -> {@link java.util.ArrayDeque}
 * Для быстрого перехода в нужный класс или метод, просто зажмите ctrl и щелкните по нему мышкой, или просто щелкните
 * колесиком. Бывает удобно, когда нужно переходить из одной точки кода в другую
 * <p>
 * Помните, что по мапе тоже можно итерироваться
 * <p>
 * for (Map.Entry<K, V> entry : map.entrySet()) {
 * entry.getKey();
 * entry.getValue();
 * }
 * <p>
 * <p>
 * Полный балл за все: 7
 *
 * @param <K> - тип ключа
 * @param <V> - тип значения
 */
public class PopularMap<K, V> implements Map<K, V> {

    private final Map<K, V> map;

    public PopularMap() {
        this.map = new HashMap<>();
    }

    public PopularMap(Map<K, V> map) {
        this.map = map;
    }

    private final Map<K, Integer> keyPop = new HashMap<>();

    private final Map<V, Integer> valuePop = new HashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    private <T> void count(Object o, Map<T, Integer> popularity) {
        int tmp = popularity.getOrDefault((T) o, 0);
        popularity.put((T) o, ++tmp);
    }

    @Override
    public boolean containsKey(Object key) {
        count(key, keyPop);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        count(value, valuePop);
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        V value = map.get(key);
        count(key, keyPop);
        count(value, valuePop);
        return value;
    }

    @Override
    public V put(K key, V value) {
        V putValue = map.put(key, value);
        count(value, valuePop);
        count(putValue, valuePop);
        count(key, keyPop);
        return putValue;
    }

    @Override
    public V remove(Object key) {
        V value = map.remove(key);
        count(key, keyPop);
        count(value, valuePop);
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    public <T> T getPopular(Map<T, Integer> popMap) {
        int count = 0;
        T popularObject = null;
        for (Map.Entry<T, Integer> entry : popMap.entrySet()) {
            if (entry.getValue() >= count) {
                popularObject = entry.getKey();
                count = entry.getValue();
            }
        }
        return popularObject;
    }

    /**
     * Возвращает самый популярный, на данный момент, ключ
     * 1 балл
     */
    public K getPopularKey() {
        return getPopular(keyPop);
    }

    /**
     * Возвращает количество использование ключа
     * 1 балла
     */
    public int getKeyPopularity(K key) {
        return keyPop.getOrDefault(key, 0);
    }

    /**
     * Возвращает самое популярное, на данный момент, значение. Надо учесть что значени может быть более одного
     * 1 балл
     */
    public V getPopularValue() {
        return getPopular(valuePop);
    }

    /**
     * Возвращает количество использований значений в методах: containsValue, get, put (учитывается 2 раза, если
     * старое значение и новое - одно и тоже), remove (считаем по старому значению).
     * 1 балл
     */
    public int getValuePopularity(V value) {
        return valuePop.getOrDefault(value, 0);
    }

    /**
     * Вернуть итератор, который итерируется по значениям (от самых НЕ популярных, к самым популярным)
     * 2 балла (Сортировать можно через метод Collections.sort() с использованием Comparator (как с фильтрами)
     */
    public Iterator<V> popularIterator() {
        return null;
    }
}
