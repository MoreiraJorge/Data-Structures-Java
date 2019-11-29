package UnorderedArrayListPkg;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ArrayListIterator<T> extends ArrayList<T> implements Iterator<T>{

    private int current;
    private int expectedModCount;

    public ArrayListIterator() {
        this.expectedModCount = modCount;
        this.current = 0;

    }

    @Override
    public boolean hasNext() {
        if (expectedModCount != modCount) {
            throw new ConcurrentModificationException();
        }

        return (current < rear);
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        T tmp = (T) array[current];
        current++;
        return tmp;
    }
}
