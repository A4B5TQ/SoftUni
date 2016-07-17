package javaOOPAdvance.generics.pr07and08and09.models;

class Sorter {
    static <E extends Comparable<E>> void sort(MyList<E> myList){
        for (int i = 0; i < myList.size(); i++) {
            E current = myList.get(i);
            for (int j = i + 1; j < myList.size(); j++) {
                E next = myList.get(j);
                if (current.compareTo(next)> 0) {
                    myList.swap(i, j);
                }
            }
        }
    }
}
