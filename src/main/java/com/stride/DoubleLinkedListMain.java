package com.stride;

public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        System.out.println("Empty list!");
        System.out.println("list.empty() = " + list.isEmpty());

        list.append(3);
        list.prepend(2);
        list.append(4);
        list.append(5);
        list.append(6);
        list.prepend(1);
        list.prepend(0);
        list.prepend(-1);
        list.append(null);

        System.out.println("\nWith data!");
        System.out.println("list = " + list);
        System.out.println("list.isEmpty() = " + list.isEmpty());
        System.out.println("list.size() = " + list.size());
        System.out.println("list.indexOf(0) = " + list.indexOf(0));
        System.out.println("list.indexOf(5) = " + list.indexOf(5));
        System.out.println("list.indexOf(null) = " + list.indexOf(null));
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.get(5) = " + list.get(5));

        System.out.println("\nReplace data in the 8th position");
        list.set(8, 7);
        System.out.println("list = " + list);
        System.out.println("list.first() = " + list.first());
        System.out.println("list.last() = " + list.last());

        System.out.println("\nRemove first item");
        System.out.println("list.remove(0) = " + list.remove(0));
        System.out.println("list.size() = " + list.size());
        System.out.println("list = " + list);

        System.out.println("\nRemove last item");
        System.out.println("list.remove(list.size() - 1) = " + list.remove(list.size() - 1));
        System.out.println("list.size() = " + list.size());
        System.out.println(list);

        System.out.println("\nClearing list");
        list.clear();
        System.out.println("list = " + list);
    }
}
