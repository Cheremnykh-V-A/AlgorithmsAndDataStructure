package Seminars.Seminar3;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(2);
        list.add(8);
        list.add(11);
        list.add(1);

        list.print();
        list.quickSort();
        list.print();

    }
}
