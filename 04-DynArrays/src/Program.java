import model.*;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        IArray arrayListWrapper = new ArrayListWrapper();
        testAddIndex0Array(arrayListWrapper, 10000000);

        //testAdd();

        //testAddIndex0Array();
        //IArray singleArray = new SingleArray();
        //IArray vectorArray = new VectorArray();
        //IArray factorArray = new FactorArray();
        //IArray matrixArray = new MatrixArray();

        //testAddIndex0Array(matrixArray, 20);

        //testAddArray(singleArray, 10_000);
        //testAddArray(vectorArray, 100_000);
        //testAddArray(factorArray, 100_000);
        //testAddArray(matrixArray, 100_000);


    }

    private static void testAdd() {
        for(int i = 1_000; i <= 10_000_000; i *= 10) {
            if(i <= 100_000) {
                IArray singleArray = new SingleArray();
                testAddArray(singleArray, i);
            }

            if(i <= 1_000_000) {
                IArray vectorArray = new VectorArray();
                testAddArray(vectorArray, i);
            }

            IArray factorArray = new FactorArray();
            testAddArray(factorArray, i);

            IArray matrixArray = new MatrixArray();
            testAddArray(matrixArray, i);

            IArray arrayListWrapper = new ArrayListWrapper();
            testAddArray(arrayListWrapper, i);
        }
    }


    private static void testAddArray(IArray data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j ++)
            data.add(new Date());

        System.out.println(data + " Elements:" + total  + " testAddArray: " +
                (System.currentTimeMillis() - start));
    }

    private static void testAddIndex0Array() {
        for(int i = 1_000; i <= 1_000_000; i *= 10) {
            if(i <= 10_000) {
                IArray singleArray = new SingleArray();
                testAddIndex0Array(singleArray, i);
            }

            if(i <= 100_000) {
                IArray vectorArray = new VectorArray();
                testAddIndex0Array(vectorArray, i);
            }

            IArray factorArray = new FactorArray();
            testAddIndex0Array(factorArray, i);

            if(i <= 100_000) {
                IArray matrixArray = new MatrixArray();
                testAddIndex0Array(matrixArray, i);
            }


            IArray arrayListWrapper = new ArrayListWrapper();
            testAddIndex0Array(arrayListWrapper, i);
        }
    }

    private static void testAddIndex0Array(IArray data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j ++)
            data.add(j, 0);

        System.out.println(data + " Elements:" + total  + " testAddIndex0Array: " +
                (System.currentTimeMillis() - start));
    }
}
