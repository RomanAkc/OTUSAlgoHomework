package OTUSHomework;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        int N = 20000000;
        ArrayList<Integer> arrayNotSorted = getArrayNotSorted(N);
        int[] randomNumbers = GetNRandomNumbers(N / 10);
        int[] randomElements = GetNRandomElementsFromArray(arrayNotSorted, N / 10);


        SimpleBST bstNotSorted = new SimpleBST();
        System.out.println("Adding " + N + " elements to BST in random order, time: " + AddElementsToBST(bstNotSorted, arrayNotSorted));
        System.out.println("Search " + N / 10 + " numbers in random filled BST, time: " + FindElementsInBST(bstNotSorted, randomNumbers));
        System.out.println("Remove " + N / 10 + " numbers in random filled BST, time: " + RemoveElementsFromBST(bstNotSorted, randomElements));


        ArrayList<Integer> arraySorted = getArraySorted(arrayNotSorted);
        SimpleBST bstSorted = new SimpleBST();
        System.out.println("Adding " + N + " elements to BST in sorted order, time: " + AddElementsToBST(bstSorted, arraySorted));
        System.out.println("Search " + N / 10 + " numbers in BST, which was filled by sorted elements, time: " + FindElementsInBST(bstSorted, randomNumbers));
        System.out.println("Remove " + N / 10 + " numbers in BST, which was filled by sorted elements, time: " + RemoveElementsFromBST(bstSorted, randomElements));
    }

    private static ArrayList<Integer> getArraySorted(ArrayList<Integer> arrayNotSorted) {
        ArrayList<Integer> arraySorted = new ArrayList<>(arrayNotSorted);
        Collections.sort(arraySorted);
        return arraySorted;
    }

    private static ArrayList<Integer> getArrayNotSorted(int N) {
        ArrayList<Integer> arrayNotSorted = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int value = (int)(Math.random() * Integer.MAX_VALUE);
            arrayNotSorted.add(value);
        }
        return arrayNotSorted;
    }

    private static long AddElementsToBST(SimpleBST bst, ArrayList<Integer> array) {
        int N = array.size();
        long start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            bst.insert(array.get(i));
        }
        return System.currentTimeMillis() - start;
    }

    private static long FindElementsInBST(SimpleBST bst, int[] numbers) {
        int N = numbers.length;
        long start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            bst.search(numbers[i]);
        }
        return System.currentTimeMillis() - start;
    }

    private static long RemoveElementsFromBST(SimpleBST bst, int[] elements) {
        int N = elements.length;
        long start = System.currentTimeMillis();
        for(int i = 0; i < N; i++) {
            bst.remove(elements[i]);
        }
        return System.currentTimeMillis() - start;
    }

    private static int[] GetNRandomNumbers(int N) {
        int[] random = new int[N];
        for(int i = 0; i < N; ++i)
            random[i] = (int)(Math.random() * Integer.MAX_VALUE);
        return random;
    }

    private static int[] GetNRandomElementsFromArray(ArrayList<Integer> arraySource, int N) {
        ArrayList<Integer> arr = new ArrayList<>(arraySource);
        Collections.shuffle(arr);

        int[] random = new int[N];
        for(int i = 0; i < N; i++) {
            random[i] = arr.get(i);
        }

        return random;
    }


}
