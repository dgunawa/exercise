package com.orangetree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dgunawan on 1/29/17.
 */
public class YourClassImpl<T> implements YourClassAPI<T> {

    @Override
    public Collection<T> functionX(Collection<T>... collections) {
        List<Set<T>> distinctElementLists = new ArrayList<>();
        for (Collection collection : collections) {
            if (collection instanceof List) {
                // use TreeSet because it orders the elements by its natural order
                TreeSet<T> treeSet = new TreeSet();
                for (int i = 0; i < collection.size(); i++) {
                    treeSet.add((T)((List) collection).get(i));
                }
                distinctElementLists.add(treeSet);
            }
            else if (collection instanceof Set) {
                // set already have distinct elements
                distinctElementLists.add((Set)collection);
            }
        }
        List<T> intersectionList = sort(IntersectionTest.Order.ASC, new ArrayList(distinctElementLists.get(0)));
        for (Set<T> set : distinctElementLists) {
            intersectionList = intersect(intersectionList,sort(IntersectionTest.Order.ASC, new ArrayList(set)));
        }
        return intersectionList;
    }

    @Override
    public Collection<T> functionY(Collection<T>... collections) {
        Collection<T> unionCollection = function(IntersectionTest.Order.ASC, collections);
        Collection<T> intersectionCollection = functionX(collections);
        return outerIntersect((List<T>) unionCollection, (List<T>)intersectionCollection);
    }

    @Override
    public Collection<T> function(IntersectionTest.Order order, Collection<T>... collections) {
        List<Set<T>> distinctElementLists = new ArrayList<>();
        for (Collection collection : collections) {
            if (collection instanceof List) {
                // use TreeSet because it naturally ordering the elements
                TreeSet<T> treeSet = new TreeSet();
                for (int i = 0; i < collection.size(); i++) {
                    treeSet.add((T)((List) collection).get(i));
                }
                distinctElementLists.add(treeSet);
            }
            else if (collection instanceof Set) {
                distinctElementLists.add((Set)collection);
            }
        }
        List<T> unionList = new ArrayList<T>();
        for (Set<T> set : distinctElementLists) {
            unionList = union(unionList, sort(IntersectionTest.Order.ASC, new ArrayList(set)));
        }
        return sort(order, unionList);
    }

    private List<T> sort(IntersectionTest.Order order, List<T> list) {
        return quickSort(order, list,0,list.size() - 1);
    }

    private List<T> quickSort(IntersectionTest.Order order, List<T> list, int low, int high) {
        int middle = low + (high - low) / 2;
        int pivot = list.get(middle).hashCode();
        int i = low, j = high;
        while (i <= j) {
            switch (order) {
                case ASC:
                    while (list.get(i).hashCode() < pivot) {
                        i++;
                    }
                    while (list.get(j).hashCode() > pivot) {
                        j--;
                    }
                    break;
                case DESC:
                    while (list.get(i).hashCode() > pivot) {
                        i++;
                    }
                    while (list.get(j).hashCode() < pivot) {
                        j--;
                    }
                    break;
            }

            if (i <= j) {
                T temp = list.get(i);
                list.set(i,list.get(j));
                list.set(j,temp);
                i++;
                j--;
            }

        }
        if (low < j) {
            quickSort(order, list, low, j);
        }
        if (high > i) {
            quickSort(order, list, i, high);
        }
        return list;
    }

    private List<T> intersect(List<T> list1, List<T> list2) {
        int i = 0;
        int j = 0;
        List<T> list = new ArrayList();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).hashCode() < list2.get(j).hashCode()) {
                i++;
            }
            else if (list1.get(i).hashCode() > list2.get(j).hashCode()) {
                j++;
            }
            else if (list1.get(i).equals(list2.get(j))) {
                list.add(list1.get(i));
                j++;
                i++;
            }
            else {
                j++;
                i++;
            }
        }
        return list;
    }

    private List<T> outerIntersect(List<T> list1, List<T> list2) {
        int i = 0;
        int j = 0;
        List<T> list = new ArrayList();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).hashCode() < list2.get(j).hashCode()) {
                list.add(list1.get(i));
                i++;
            }
            else if (list1.get(i).hashCode() > list2.get(j).hashCode()) {
                list.add(list2.get(j));
                j++;
            }
            else {
                j++;
                i++;
            }
        }
        while(i < list1.size()) {
            list.add(list1.get(i));
            i++;
        }
        while(j < list2.size()) {
            list.add(list2.get(j));
            j++;
        }
        return list;
    }

    private List<T> union(List<T> list1, List<T> list2) {
        int i = 0;
        int j = 0;
        List<T> list = new ArrayList();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).hashCode() < list2.get(j).hashCode()) {
                list.add(list1.get(i));
                i++;
            }
            else if (list1.get(i).hashCode() > list2.get(j).hashCode()) {
                list.add(list2.get(j));
                j++;
            }
            else {
                list.add(list1.get(i));
                j++;
                i++;
            }
        }
        while(i < list1.size()) {
            list.add(list1.get(i));
            i++;
        }
        while(j < list2.size()) {
            list.add(list2.get(j));
            j++;
        }
        return list;
    }
}