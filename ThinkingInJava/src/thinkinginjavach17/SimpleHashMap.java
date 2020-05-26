package thinkinginjavach17;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
//import net.mindview.util.Countries;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    // В качестве размера хеш-таблицы следует выбрать
    // простое число, чтобы обеспечить равномерность роспределения
    static final int SIZE = 997;
    
    // Физический массив обобщений создать нельзя, но можно
    // прийти к нему через восходящее преобразование
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
    
    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // заменяем старое значение новым
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }
    
    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            /*for (MapEntry<K, V> mpair : bucket) {
                set.add(mpair);
            }*/
            bucket.forEach((mpair) -> {
                set.add(mpair);
            });
        }
        return set;
    }
    
    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        //m.putAll(Countries.capitals(25));
        m.putAll(Countries.capitals(200));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.get("UKRAINE"));
        System.out.println(m.entrySet());
    }
}
