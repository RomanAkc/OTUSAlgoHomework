package OTUSHomework;

import java.util.LinkedList;

public class PQueue<T> {
    private static class InnerListItem<T> {
        public int priority;
        public LinkedList<T> array;

        public InnerListItem(int priority, T item) {
            this.priority = priority;
            this.array = new LinkedList<>();
            this.array.add(item);
        }
    }

    //Список списков (0-й список - с максимальным приоритетом, 1-й - с приоритетом меньшим чем в 0-м и т. д.)
    private final LinkedList<InnerListItem<T>> data = new LinkedList<>();

    public void enqueue(int priority, T item) {
        //Итерируемся по спискам, чтобы найти место вставки
        for(int i = 0; i < data.size(); ++i) {
            int curPriority = data.get(i).priority;

            //Приоритет в текущем списка больше, чем у вставляемого элемента
            //Продолжаем поиск места вставки
            if(curPriority > priority)
                continue;

            //Есть список с совпадающим приоритетом, добавим в него
            if(curPriority == priority) {
                data.get(i).array.add(item);
                return;
            }

            //Нашли место вставки и списка с таким приоритетом нет -> надо добавить новый список
            InnerListItem<T> innerList = new InnerListItem<>(priority, item);
            data.add(i, innerList);
            return;
        }

        //Ничего не вставили - либо data пуст, либо приоритет самый низкий
        InnerListItem<T> innerList = new InnerListItem<>(priority, item);
        data.add(innerList);
    }

    public T dequeue() {
        if(data.size() == 0) {
            return null;
        }

        //Если data будет пуст, то тут будет брошено исключение
        T item = data.get(0).array.pop();

        if(data.get(0).array.isEmpty())
            data.pop();

        return item;
    }

}
