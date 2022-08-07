package LuckyTickets;

import java.util.HashMap;

public class LuckyTicketsCalculator {

    public long getCountLuckyTickets(long N) {
        long count = 0;

        var countTicketsBySumAllNumbers = generateTableCountTicketsBySumAllNumbers(N);
        for (var obj : countTicketsBySumAllNumbers.entrySet()) {
            count += obj.getValue() * obj.getValue();
        }

        return count;
    }

    private HashMap<Long, Long> generateTableCountTicketsBySumAllNumbers(long N) {
        var setTablesByN = new HashMap<Long, HashMap<Long, Long>>();

        for(long currentN = 1; currentN <= N; ++currentN) {
            setTablesByN.put(currentN, new HashMap<>());
            long maxSumAllNumbers = 9 * currentN;

            for(long sumAllNumbers = 0; sumAllNumbers <= maxSumAllNumbers; ++sumAllNumbers) {
                if(currentN == 1) {
                    setTablesByN.get(currentN).put(sumAllNumbers, 1L);
                } else {
                    long sumTickets = getCountTicketsBySumAllNumbers(sumAllNumbers, setTablesByN.get(currentN - 1));
                    setTablesByN.get(currentN).put(sumAllNumbers, sumTickets);
                }
            }
        }

        return setTablesByN.get(N);
    }

    private long getCountTicketsBySumAllNumbers(long sumAllNumbers, HashMap<Long, Long> prevTable) {
        long sumTickets = 0;

        for(long index = sumAllNumbers; index >= 0; index--) {
            if((sumAllNumbers - index) == 10) //Cумма 10 элементов предыдущей таблицы, у которых индекс <= нужному значению
                break;

            if(!prevTable.containsKey(index))
                continue;

            sumTickets += prevTable.get(index);
        }

        return sumTickets;
    }
}
