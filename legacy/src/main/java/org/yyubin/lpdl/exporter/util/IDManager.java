package org.yyubin.lpdl.exporter.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class IDManager {
    private final Map<String, AtomicLong> counters;

    public IDManager() {
        this.counters = new HashMap<>();
    }

    public long nextId(String table) {
        return counters
            .computeIfAbsent(table, k -> new AtomicLong(0))
            .incrementAndGet();
    }

    public long getCurrentId(String table) {
        AtomicLong counter = counters.get(table);
        return counter != null ? counter.get() : 0;
    }

    public void resetTable(String table) {
        counters.remove(table);
    }

    public void resetAll() {
        counters.clear();
    }

    public int getTableCount() {
        return counters.size();
    }
}
