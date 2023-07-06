package Homework1;

import java.util.Arrays;

public class HeapSorting {
    /*
    Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
     */
    public static void main(String[] args) {
        int[] someArray = {124, 23, 5135, 18, -6, 5, 214};

        heapSort(someArray);

        System.out.println(Arrays.toString(someArray));
    }

    public static void heapSort(int[] someArray){
        int n = someArray.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n/2 - 1; i >= 0 ; i--)
            heapify(someArray, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n-1; i >= 0 ; i--){

            // Перемещаем текущий корень в конец
            int temp = someArray[i];
            someArray[i] = someArray[0];
            someArray[0] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(someArray, i, 0);
        }

    }

//   Метод в котором будет меняться структура данных
//   так чтоб родитель был максимальны элементом по сравнению
//   со своими детьми в дереве
    private static void heapify(int[] some_arrray, int n, int i){
//        Инициализируем наибольший элемент как корень
        int largest = i;
//        Левый дочерний элемент
        int left = 2*i + 1;
//        Правый дочерний элемент
        int right = 2*i + 2;

//        Если левый дочерний элемент больше корня
        if (left < n && some_arrray[left] > some_arrray[largest]){
            largest = left;
        }

//        Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && some_arrray[right] > some_arrray[largest]){
            largest = right;
        }

//        Если самый большой элемент не корень
        if(largest != i){
            int swap = some_arrray[i];
            some_arrray[i] = some_arrray[largest];
            some_arrray[largest] = swap;

//            Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(some_arrray, n, largest);
        }
    }
}
