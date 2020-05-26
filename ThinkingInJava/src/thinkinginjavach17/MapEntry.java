package thinkinginjavach17;

import java.util.Map;
import java.util.Objects;

public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;
    
    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }
    
    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^
               (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MapEntry)) {
            return false;
        }
        MapEntry me = (MapEntry)obj;
        return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
               (value == null ? me.getValue() == null : value.equals(me.getValue()));
        /*if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MapEntry<?, ?> other = (MapEntry<?, ?>) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;*/
    }
    
    @Override
    public String toString() {
        return key + "=" + value;
     }    
}
