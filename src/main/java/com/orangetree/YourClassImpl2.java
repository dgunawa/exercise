package com.orangetree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dgunawan on 1/29/17.
 */
public class YourClassImpl2<T> implements YourClassAPI<T> {

    @Override
    public Collection<T> functionX(Collection<T>... collections) {
        List<List<T>> distinctElementLists = new ArrayList<>();
        for (Collection collection : collections) {
            distinctElementLists.add((List)collection.stream().distinct().sorted().collect(Collectors.toList()));
        }
        List<T> intersectionList = distinctElementLists.get(0);
        for (List<T> list : distinctElementLists) {
            intersectionList.retainAll(list);
        }
        return intersectionList;
    }

    @Override
    public Collection<T> functionY(Collection<T>... collections) {
        Collection<T> unionCollection = function(IntersectionTest.Order.ASC, collections);
        Collection<T> intersectionCollection = functionX(collections);
        unionCollection.removeAll(intersectionCollection);
        return unionCollection;
    }

    @Override
    public Collection<T> function(IntersectionTest.Order order, Collection<T>... collections) {
        List<Set<T>> distinctElementLists = new ArrayList<>();
        for (Collection collection : collections) {
            distinctElementLists.add((Set)collection.stream().distinct().collect(Collectors.toSet()));
        }
        List unionList = new ArrayList();
        for (Set<T> set : distinctElementLists) {
            unionList.addAll(set);
        }
        List resultList = null;
        switch (order) {
            case ASC:   resultList = (List)unionList.stream().distinct().sorted().collect(Collectors.toList());
                break;
            case DESC:  resultList = (List)unionList.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                break;
        }
        return resultList;
    }
}