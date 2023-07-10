package Homework2;

public class Main {
    public static void main(String[] args) {
        /*
        Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).
         */

        LinkedList<Integer> list = new LinkedList<>();

        list.add(14);
        list.add(1);
        list.add(8);
        list.add(9);
        list.add(5);

        list.print();
        list.reverse();
        list.print();
    }
}
