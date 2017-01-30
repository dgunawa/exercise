package com.orangetree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dgunawan on 1/29/17.
 */
public class IntersectionTest {
    public enum Order {
        ASC, DESC;
    }

    public static class MyClass implements Comparable
    {
        private int a;
        private Integer b;
        private Integer c;
        private String s;

        public MyClass(int a, Integer b, Integer c, String s) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.s = s;
        }

        // This method is stubbed.  Assume all real classes properly implement the compareTo method
        @Override
        public int compareTo(final Object o) {
            return 0;
        }

        // Assume all real classes properly implement the equals() method
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            final MyClass myClass = (MyClass) o;

            if (a != myClass.a) {
                return false;
            }
            if (b != null ? !b.equals(myClass.b) : myClass.b != null) {
                return false;
            }
            if (c != null ? !c.equals(myClass.c) : myClass.c != null) {
                return false;
            }
            if (s != null ? !s.equals(myClass.s) : myClass.s != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + (b != null ? b.hashCode() : 0);
            result = 31 * result + (c != null ? c.hashCode() : 0);
            result = 31 * result + (s != null ? s.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return a + "-" + b + "-" + c + "-" + s;
        }
    }


    public static void main(String args[]) {
        List<String> listOne = new ArrayList();
        List<String> listTwo = new ArrayList();
        List<String> listThree = new ArrayList();

        Set<Integer> numSetOne = new HashSet();
        Set<Integer> numSetTwo = new HashSet();
        Set<Integer> numSetThree = new HashSet();

        /**
         * each Collection above is saturated with random data here
         */
        numSetOne.add(1);
        numSetOne.add(2);
        numSetOne.add(3);
        numSetOne.add(4);
        numSetOne.add(5);

        numSetTwo.add(6);
        numSetTwo.add(7);
        numSetTwo.add(8);
        numSetTwo.add(1);
        numSetTwo.add(2);

        numSetThree.add(9);
        numSetThree.add(10);
        numSetThree.add(11);
        numSetThree.add(12);
        numSetThree.add(2);

        listOne.add("A");
        listOne.add("A");
        listOne.add("B");
        listOne.add("B");
        listOne.add("C");
        listOne.add("C");
        listOne.add("D");
        listOne.add("G");

        listTwo.add("D");
        listTwo.add("A");
        listTwo.add("E");
        listTwo.add("E");
        listTwo.add("F");
        listTwo.add("F");
        listTwo.add("G");
        listTwo.add("G");

        listThree.add("H");
        listThree.add("H");
        listThree.add("I");
        listThree.add("I");
        listThree.add("J");
        listThree.add("J");
        listThree.add("K");
        listThree.add("D");
        listThree.add("D");
        listThree.add("A");

        YourClassAPI<String> ycS = new YourClassImpl<String>();

        Collection<String> result1 = ycS.functionX(listOne, listTwo);
        Collection<String> result2 = ycS.functionX(listOne, listTwo, listThree);


        YourClassAPI<Integer> ycI = new YourClassImpl<Integer>();
        Collection<Integer> result3 = ycI.functionX(numSetOne, numSetTwo);
        Collection<Integer> result4 = ycI.functionX(numSetOne, numSetTwo, numSetThree);

        Collection<Integer> result5 = ycI.functionY(numSetOne, numSetTwo);
        Collection<Integer> result6 = ycI.functionY(numSetOne, numSetTwo, numSetThree);

        Collection<String> result7 = ycS.function(Order.ASC, listOne, listTwo, listThree);
        Collection<Integer> result8 = ycI.function (Order.DESC, numSetOne, numSetTwo, numSetThree);


        YourClassAPI<MyClass> ycMc = new YourClassImpl<MyClass>();
        Collection<MyClass> mcOne = new TreeSet<MyClass>((o1, o2) -> o1.hashCode() - o2.hashCode());
        Collection<MyClass> mcTwo = new TreeSet<MyClass>((o1, o2) -> o1.hashCode() - o2.hashCode());
        Collection<MyClass> mcThree = new TreeSet<MyClass>((o1, o2) -> o1.hashCode() - o2.hashCode());
        Collection<MyClass> mcFour = new TreeSet<MyClass>((o1, o2) -> o1.hashCode() - o2.hashCode());

        mcOne.add(new IntersectionTest.MyClass(1,2,3,"A"));
        mcOne.add(new IntersectionTest.MyClass(2,3,4,"B"));
        mcOne.add(new IntersectionTest.MyClass(3,4,5,"C"));
        mcOne.add(new IntersectionTest.MyClass(4,5,6,"D"));
        mcOne.add(new IntersectionTest.MyClass(1,2,3,"A"));

        System.out.println("mcOne = " + mcOne);

        mcTwo.add(new IntersectionTest.MyClass(1,2,3,"A"));
        mcTwo.add(new IntersectionTest.MyClass(2,4,4,"B"));
        mcTwo.add(new IntersectionTest.MyClass(4,4,5,"C"));
        mcTwo.add(new IntersectionTest.MyClass(4,5,6,"D"));
        mcTwo.add(new IntersectionTest.MyClass(1,2,3,"A"));

        System.out.println("mcTwo = " + mcTwo);

        mcThree.add(new IntersectionTest.MyClass(1,2,3,"A"));
        mcThree.add(new IntersectionTest.MyClass(3,3,4,"B"));
        mcThree.add(new IntersectionTest.MyClass(3,5,5,"C"));
        mcThree.add(new IntersectionTest.MyClass(4,5,6,"D"));
        mcThree.add(new IntersectionTest.MyClass(1,2,3,"A"));

        System.out.println("mcThree = " + mcThree);

        mcFour.add(new IntersectionTest.MyClass(1,2,3,"A"));
        mcFour.add(new IntersectionTest.MyClass(2,3,5,"B"));
        mcFour.add(new IntersectionTest.MyClass(3,4,5,"A"));
        mcFour.add(new IntersectionTest.MyClass(4,5,6,"D"));
        mcFour.add(new IntersectionTest.MyClass(1,2,3,"A"));

        System.out.println("mcFour = " + mcFour);

        /**
         * each Collection above is saturated with random data here
         */
        Collection<MyClass> result9 = ycMc.functionX(mcOne, mcTwo, mcThree, mcFour);
        Collection<MyClass> result10 = ycMc.functionY(mcOne, mcTwo, mcThree, mcFour);
        Collection<MyClass> result11 = ycMc.function(Order.ASC, mcOne, mcTwo, mcThree, mcFour);
//        Collection<MyClass> result11 = ycMc.function(Order.DESC, mcThree, mcFour);

        System.out.println("result1 " + result1);
        System.out.println("result2 " + result2);
        System.out.println("result3 " + result3);
        System.out.println("result4 " + result4);
        System.out.println("result5 " + result5);
        System.out.println("result6 " + result6);
        System.out.println("result7 " + result7);
        System.out.println("result8 " + result8);
        System.out.println("result9 " + result9);
        System.out.println("result10 " + result10);
        System.out.println("result11 " + result11);

    }

}