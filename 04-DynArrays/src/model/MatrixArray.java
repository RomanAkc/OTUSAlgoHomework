package model;

public class MatrixArray<T> implements IArray<T> {

    private int size;
    private int vector;
    private IArray<IArray<T>> array;

    public MatrixArray(int vector) {
        this.vector = vector;
        array = new SingleArray<>();
        size = 0;
    }

    public MatrixArray() {
        this(10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vector)
            array.add(new VectorArray<T>(vector));
        array.get(size / vector).add(item);
        size ++;
    }

    @Override
    public void add(T item, int index) {
//Возможны 3 ситуации:
        //1.Индекс в конце существующего массива
        //2.Индекс в середине уже существующего массива
        //3.Индекс после существующего массива

        if(index == size()) {
            //1.Индекс в конце существующего массива
            add(item);
        } else if(index < size()) {
            //2.Индекс в середине уже существующего массива
            int start = index / vector;
            for(int i = start; i < array.size(); ++i) {
                if(i == array.size() - 1) {
                    //Последний массив
                    T last = null;
                    if(array.get(i).size() == vector) {
                        //Если последний массив имеет размерность = vector => при вставке надо сдвинуть последний
                        //элемент в новый массив, запомним его
                        last = array.get(i).remove(array.get(i).size() - 1);
                    }

                    array.get(i).add(item, index % vector);

                    if(last != null) {
                        add(last);
                        return; //Чтобы не делать size++ после цикла
                    }
                } else {
                    //Массив не последний: извлекаем последний элемент в массиве
                    var last = array.get(i).remove(array.get(i).size() - 1);
                    //Вставляем в середину элемент
                    array.get(i).add(item, index % vector);
                    //На следующей итерации вставляем бывший "последний" элемент текущего массива в следующий массив в начало
                    item = last;
                    index = 0;
                }
            }
            size++;
        } else {
            //3.Индекс после существующего массива

        }
    }

    @Override
    public T remove(int index) {
        if(size < vector) {
            //Всего 1 массив, просто вызовем remove в массиве
            size--;
            return array.get(0).remove(index);
        }

        if(index / vector == array.size() - 1) {
            //Последний массив, просто удалим из него элемент
            size--;
            return array.get(array.size() - 1).remove(index % vector);
        }

        T val = get(index);

        int end = index / vector;
        //Извлекаем первый элемент из последнего массива
        T first = array.get(array.size() - 1).remove(0);
        for(int i = array.size() - 2; i >= end; --i) {
            //Из предпоследнего массива извлекаем первый элемент
            T newFist = array.get(i).remove(i == end ? index % vector : 0);
            //Добавляем в конец предпоследнего массива первый элемент последнего
            array.get(i).add(first, vector - 1);
            //Обновляем первый элемент для следующей итерации
            first = newFist;
        }

        size--;
        return val;
    }

    @Override
    public T get(int index) {
        return array.get(index / vector).get(index % vector);
    }
}
