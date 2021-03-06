package com.hy.array;

public class ordArray {

    private long[] arr;
    private int nElems;

    public ordArray(int max) {
        arr = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    /**
     * 按大小有序排列的
     * @param searchKey
     * @return
     */
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while (true) {
            curIn = (lowerBound+upperBound)/2;
            if (arr[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;//can't find it
            } else {
                if (arr[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    /**
     *
     * @param value
     */
    public void insert(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (arr[i] > value) {
                break;
            }
        }
        for (int j = nElems; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        nElems++;
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean delete(long value) {
        int i = find(value);
        if (i == nElems) {
            return false;
        } else {
            for (int j = i; j < nElems; j++) {
                arr[j] = arr[j + 1];
            }
            nElems--;
            return true;
        }
    }

    /**
     *
     */
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}
