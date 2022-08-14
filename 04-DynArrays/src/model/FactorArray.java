package model;

public class FactorArray<T> implements IArray<T> {

    private Object[] array;
    private int factor;
    private int size;

    public FactorArray(int factor, int initLength) {
        this.factor = factor;
        array = new Object[initLength];
        size = 0;
    }

    public FactorArray() {
        this(50, 10);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        if (size() == array.length)
            resize();
        array[size] = item;
        size++;
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
            if(size() == array.length) {
                //Нужен ресайз со сдвигом
                resizeWithShift(index);
            } else {
                //Нужен только сдвиг второй части
                for(int j = size(); j > index; --j) {
                    array[j] = array[j - 1];
                }
            }

            array[index] = item;
            size = size() + 1;

        } else {
            //3.Индекс после существующего массива

        }
    }

    private void resizeWithShift(int index) {
        Object[] newArray = new Object[array.length + array.length * factor / 100];

        //Копируем 1-ю часть (до индекса вставленного/удаленного элемента)
        System.arraycopy(array, 0
                , newArray, 0
                , index);

        int srcPos = index ;
        int dstPos = index + 1;
        int length = size() - index;

        //Копируем 1-ю часть (до индекса вставленного/удаленного элемента)
        System.arraycopy(array, srcPos
                , newArray, dstPos
                , length);

        array = newArray;
    }

    @Override
    public T remove(int index) {
        T ret = get(index);
        //Не будем перевыделять память, просто удалим элемент со сдвигом
        System.arraycopy(array, index + 1
                , array, index
                , size() - index - 1);

        array[size - 1] = null;
        size--;
        return ret;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    private void resize() {
        Object[] newArray = new Object[array.length + array.length * factor / 100];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
