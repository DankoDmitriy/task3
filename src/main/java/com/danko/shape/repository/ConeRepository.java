package com.danko.shape.repository;

import com.danko.shape.entity.Cone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ConeRepository {
    private List<Cone> cones = new ArrayList<>();

    private ConeRepository() {
    }

    private static class SingletonHolder {
        private static final ConeRepository INSTANCE = new ConeRepository();
    }

    public static ConeRepository getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public int size() {
        return cones.size();
    }

    public boolean isEmpty() {
        return cones.isEmpty();
    }

    public boolean contains(Object object) {
        return cones.contains(object);
    }

    public boolean add(Cone cone) {
        return cones.add(cone);
    }

    public boolean remove(Object object) {
        return cones.remove(object);
    }

    public void clear() {
        cones.clear();
    }

    public Cone get(int index) {
        return cones.get(index);
    }

    public Cone set(int index, Cone element) {
        return cones.set(index, element);
    }

    public void add(int index, Cone element) {
        cones.add(index, element);
    }

    public Cone remove(int index) {
        return cones.remove(index);
    }

    public boolean containsAll(Collection<?> collection) {
        return cones.containsAll(collection);
    }

    public boolean addAll(Collection<? extends Cone> collection) {
        return cones.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Cone> collection) {
        return cones.addAll(index, collection);
    }

    public void sort(Comparator<? super Cone> collection) {
        cones.sort(collection);
    }
}
