package hashmap;

import lombok.Data;

@Data
public class HashMap<K, V> {
    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry<K, V>[] table;
    private int capacity;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    public void put(K key, V value) {
        int index = key.hashCode() % capacity;
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEntry;
        }
    }

    // Implement get, remove, and containsKey methods
}