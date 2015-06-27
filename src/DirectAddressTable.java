/**
 * Created by youfar on 15/6/22.
 */
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Vector;
public class DirectAddressTable<K,V> implements StringDictionary<K,V> {
    protected Vector<K> keys;//key
    protected Vector<V> elements;//

    public DirectAddressTable(int size){
        this.keys = new Vector<K>(size);
        this.elements = new Vector<V>(size);
        this.keys.setSize(size);
        this.elements.setSize(size);
    }

    public Enumeration<K> keys() {
        return this.keys.elements();
    }

    public Enumeration<V> elements() {
        return this.elements.elements();
    }

    public void insert(K key,V value){
        int i = keys.indexOf(key);
        if (i != -1) {
            this.elements.setElementAt((V) value, i);

        } else {
            this.keys.addElement((K) key);
            this.elements.addElement((V) value);

        }
    }
    public V search(K key){
        int i = keys.indexOf(key);
        return this.elements.get(i);
    }
    public void delete(K key){
        int i = this.keys.indexOf(key);
        if (i != -1) {
            this.keys.removeElementAt(i);
            this.elements.removeElementAt(i);
        }
    }


}


