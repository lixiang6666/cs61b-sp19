import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BSTMap left;
    private BSTMap right;
    private K key;
    private V value;

    public void clear(){
        this.key = null;
        this.value = null;
        this.left = null;
        this.right = null;
    }
    
    public boolean containsKey(K key){
        return (findKeyRecurse(key, this) != null);
    }
    private BSTMap findKeyRecurse(K key, BSTMap map) {
        if (map == null) {
            return null;
        }else if (map.key == null) {
            return null;
        }else if (map.key.compareTo(key) == 0) {
            return map;
        } else if (map.key.compareTo(key) > 0) {
            return findKeyRecurse(key, map.left);
        } else {
            return findKeyRecurse(key, map.right);
        }
    }
    public V get(K key){
        BSTMap map = findKeyRecurse(key, this);
        if (map == null){
            return null;
        }else {
            return (V) map.value;
        }
    }
    public int size(){
        return sizeRecurse(this);
    }
    private int sizeRecurse(BSTMap map){
        if(map == null){
            return 0;
        }
        if (map.key == null){
            return 0;
        }else{
            return 1 + sizeRecurse(map.left) + sizeRecurse(map.right);
        }
    }
    public void put(K key, V value){
        putRecurse2(key, value, this);
    }
    private void putRecurse(K key, V value, BSTMap map){
        if (map.key == null){
            map.key = key;
            map.value = value;
        }else if(map.key.compareTo(key) == 0){
            map.value = value;
        }else if(map.key.compareTo(key) > 0){
            if(map.left == null){
                map.left = new BSTMap<>();
                map.left.key = key;
                map.left.value = value;
            }else{
            putRecurse(key, value, map.left);
            }
        }else if(map.key.compareTo(key) < 0){
            if(map.right== null){
                map.right = new BSTMap<>();
                map.right.key = key;
                map.right.value = value;
            }else{
                putRecurse(key, value, map.right);
            }
        }
    }
    private BSTMap putRecurse2(K key, V value, BSTMap map){
        if(map == null){
            BSTMap<K, V> temp = new BSTMap<>();
            temp.value = value;
            temp.key = key;
            return temp;
        }else if(map.key == null){
            map.key = key;
            map.value = value;
        }else if (map.key.compareTo(key) < 0) {
            map.right = putRecurse2(key, value, map.right);
        }else if (map.key.compareTo(key) > 0) {
            map.left = putRecurse2(key, value, map.left);}
        return map;
    }
    public Set<K> keySet() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    public V remove(K key) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    public V remove(K key, V value) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    public Iterator<K> iterator() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
}
