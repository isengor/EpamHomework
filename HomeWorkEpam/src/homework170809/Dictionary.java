package homework170809;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
August 9, 2017
Dictionary:
1) make it generic //done
2) reduce hash() invocation in put()
3) automatic resize //done
4) benchmark:  compare  1000  10000  100000 //done
5) implement delete (optional)
 */

public class Dictionary<K, V> implements Iterable<Dictionary<K, V>.Pair> {

    private static final int MAX = 10;
    private int existsDataIndex = 0;

    List<Pair>[] data = new List[MAX];

    public Dictionary() {
        data = new List[MAX];
    }

    public Dictionary(int size) {
        data = new List[size];
    }

    public void put(K key, V value) {

        int index = hash(key);

        if (data[index] == null) {

            if (existsDataIndex > data.length * 0.9)  //if data overflow > 90%, double length
            {
                resize();
            }
            data[index] = new ArrayList<>();
            existsDataIndex++;
        }

        Pair pair = getPair(key);

        if (pair == null) {
            data[index].add(new Pair(key, value));
            return;
        }

        pair.value = value;

    }

    private void resize() {
        List<Pair> oldData[] = data;
        List<Pair> newData[] = new List[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].size(); j++) {
                if (oldData[i] != null) {
                    newData[i].addAll(oldData[i]);
                }
            }
        }

        data = newData;
    }

    private int hash(K key) {
        return key.hashCode() & 0x7FFFFFFF % data.length;
    }

    public V get(K key) {
        Pair pair = getPair(key);
        return pair == null ? null : pair.value;
    }

    private Pair getPair(K key) {
        int index = hash(key);
        List<Pair> list = data[index];
        if (list == null) { // guard condition
            return null;
        }
        for (Pair pair : list) {
            if (pair.key.equals(key)) {
                return pair;
            }
        }

        return null;
    }

    @Override
    public Iterator<Pair> iterator() {
        return new Iterator<Pair>() {
            int currentElement = -1;
            Iterator<Pair> listIterator = null;

            @Override
            public boolean hasNext() {

                if (listIterator != null && listIterator.hasNext()) {
                    return true;
                }

                listIterator = null;

                for (++currentElement; listIterator == null
                        && currentElement < data.length; currentElement++) {
                    List<Pair> list = data[currentElement];
                    if (list == null) {
                        continue;
                    }
                    listIterator = list.iterator();
                    if (!listIterator.hasNext()) {
                        continue;
                    }
                    return listIterator.hasNext();
                }

                return false;
            }

            @Override
            public Pair next() {
                if (!hasNext()) {
                    throw new IllegalArgumentException();
                }
                return listIterator.next();
            }
        };
    }

    protected class Pair {

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
    }

}
