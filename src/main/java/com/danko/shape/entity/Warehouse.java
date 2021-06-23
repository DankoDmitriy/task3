package com.danko.shape.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private Map<Long, ConeParameter> map = new HashMap<>();

    private Warehouse() {
    }

    private static class SingletonHolder {
        private static final Warehouse INSTANCE = new Warehouse();
    }

    public static Warehouse getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ConeParameter put(long id, ConeParameter parameter) {
        return map.put(id, parameter);
    }

    public Optional<ConeParameter> remove(long id) {
        ConeParameter coneParameter = map.remove(id);
        return (coneParameter == null ? Optional.empty() : Optional.of(coneParameter));
    }

    public Optional<ConeParameter> get(long id) {
        ConeParameter coneParameter = map.get(id);
        return (coneParameter == null ? Optional.empty() : Optional.of(coneParameter));
    }
}
