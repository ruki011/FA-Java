package coll1;

import java.util.*;

public class zad1 {
    public static void main(String[] strings) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(2);
        System.out.println(deletingDuplicates(arrayList));
    }

    public static <T> Collection<T> deletingDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }

}
