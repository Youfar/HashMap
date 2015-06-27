/**
 * Created by youfar on 15/6/22.
 */
public interface StringDictionary<K,V> {
    public void insert(K key, V value);
    public V search(K key);
    public void delete(K key);
}
