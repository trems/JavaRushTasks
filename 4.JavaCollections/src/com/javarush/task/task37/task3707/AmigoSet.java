package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {

    private static final Object PRESENT = new Object();
    transient private HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }
    public AmigoSet(Collection<? extends E> collection) {
        int capacity = Math.max(16, (int)(collection.size() / .75f)+1);
        map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    public boolean add(E element) {
        return map.put(element, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public AmigoSet<E> clone() {
        AmigoSet<E> clonedSet;
        try {
            clonedSet = new AmigoSet<>();
            clonedSet.map = (HashMap<E, Object>) this.map.clone();
        } catch (Exception e) {
            throw new InternalError("Can't clone set");
        }
        return clonedSet;
    }

    private void writeObject(ObjectOutputStream oos) {
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int capacity = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        try {
            oos.defaultWriteObject();
            oos.writeFloat(loadFactor);
            oos.writeInt(capacity);
            oos.writeInt(this.map.size());
            for (E elem : this.map.keySet()) {
                oos.writeObject(elem);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            float loadFactor = ois.readFloat();
            int capacity = ois.readInt();
            int mapSize = ois.readInt();
            map = new HashMap<>(capacity, loadFactor);
            for (int i = 0; i < mapSize; i++) {
                E e = (E) ois.readObject();
                map.put(e, PRESENT);
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AmigoSet<?> amigoSet = (AmigoSet<?>) o;

        return map != null ? map.equals(amigoSet.map) : amigoSet.map == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (map != null ? map.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("ddd");
        hashSet.add("rrrr");
        AmigoSet amigoSet = new AmigoSet(hashSet);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(amigoSet);
        objectOutputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        AmigoSet amigoSet1 = (AmigoSet)  objectInputStream.readObject();
        System.out.println(amigoSet.equals(amigoSet1));
        System.out.println(amigoSet);
        System.out.println("________");
        System.out.println(amigoSet1);
    }
}
