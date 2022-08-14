package model;

public class SingleArray<T> implements IArray<T> {

    private Object[] array;

    public SingleArray () {
        array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
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
            resizeWithShift(size() + 1, index);
            array[index] = item;
        } else {
            //3.Индекс после существующего массива

        }
    }

    private void resizeWithShift(int newSize, int index) {
        Object[] newArray = new Object[newSize];

        //Копируем 1-ю часть (до индекса вставленного/удаленного элемента)
        System.arraycopy(array, 0
                , newArray, 0
                , index);

        boolean isAdd = newSize > size();
        int srcPos = isAdd ? index : index + 1;
        int dstPos = isAdd ? index + 1 : index;
        int length = isAdd ? size() - index : size() - index - 1;

        //Копируем 1-ю часть (до индекса вставленного/удаленного элемента)
        System.arraycopy(array, srcPos
                , newArray, dstPos
                , length);

        array = newArray;
    }

    @Override
    public T remove(int index) {
        T ret = get(index);
        resizeWithShift(size() - 1, index);
        return ret;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T)array[index];
    }

    private void resize() {
        Object[] newArray = new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
//        for (int j = 0; j < size(); j ++)
//            newArray[j] = array[j];
        array = newArray;
    }
}
