package com.orangetree;

import java.util.Collection;

/**
 * Created by dgunawan on 1/29/17.
 */
public interface YourClassAPI<T> {

    public Collection<T> functionX(Collection<T>... collections);

    public Collection<T> functionY(Collection<T>... collections);

    public Collection<T> function(IntersectionTest.Order order, Collection<T>... collections);
}