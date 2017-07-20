package com.xianjj.structures;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-10 17:19.
 */
public class ArrayTest {
    //找最大值
    public static void findMaxValue(){
        int[] nElements = {1,2,5,23,6,3,6,9};

        for(int i = 0; i < nElements.length-1; i++){
            nElements = exchange(nElements, i);
        }
    }

    // 冒泡
    public static void bubbleSort(){
        int[] nElements = {11,12,1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7};
        for (int j = nElements.length-1; j>0; j--){
            for (int i = 0; i < j; i++){
                nElements = exchange(nElements, i);
            }
        }
        for (int element:nElements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args){
        bubbleSort();
    }

    public static int[] exchange(int[] nElements, int i){
        int temp;
        if (nElements[i] > nElements[i+1]) {
            temp = nElements[i];
            nElements[i] = nElements[i+1];
            nElements[i+1] = temp;
        }
        return nElements;
    }
}
