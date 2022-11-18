package Lesson3.Task2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection<T> implements Collection<T> {
    private int capacity;
    private int size = 0;
    private Object[] collection;

    public MyCollection() {
        this(10);
    }

    public MyCollection(int capasity) {
        this.capacity = capasity;
        collection = new Object[capasity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (collection[i] == null) {
                if (collection[i] == o)
                    return true;
            } else {
                if (((T) collection[i]).equals(o))
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) collection[index++];
            }

        };
    }

    @Override
    public Object[] toArray() {
        Object[] newcollection = new Object[size];
        // #region копируем данные в новый массив
        System.arraycopy(collection, 0, newcollection, 0, size);
        // #endregion
        return newcollection;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(collection, size, a.getClass());
        System.arraycopy(collection, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(T e) {
        check_capacity(size + 1);
        collection[size++] = e;
        return true; // коллекция допускает добавление любых элементов
    }

    public void remove(int index) {
        rangeCheck(index);
        System.arraycopy(collection, index + 1, collection, index, size - index - 1);
        collection[--size] = null;

    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (collection[i] == null) {
                    remove(i);
                    return true;
                }
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(collection[i])) {
                    remove(i);
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T element;
        for (Object object : c) {
            if (!contains(object))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (Object object : c) {
            add((T) object);
        }
        return c.size() > 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int t_size = size;
        for (Object object : c) {
            remove(object);
        }
        return t_size != size;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int t_size = size;
        for (int i = 0; i < size; i++) {
            for (Object object : c) {
                if (remove(object)) {
                    i--;
                    break;
                }
            }
        }
        return t_size != size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            collection[i] = null;
        }
        size = 0;
    }

    /**
     * Проверка на достижение конца размера массива коллекции и выделение новой
     * памяти...
     * 
     * @param max_index
     */
    private void check_capacity(int new_size) {
        if (capacity >= new_size)
            return;
        capacity += (capacity >> 1);
        Object[] newcollection = new Object[capacity];
        System.arraycopy(collection, 0, newcollection, 0, size);
        collection = newcollection;
    }

    /**
     * проверка на выход индекса за границы
     * 
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
    }

}
