package com.orangetree

import spock.lang.Specification

/**
 * Created by dgunawan on 1/29/17.
 */
class YourClassSpec extends Specification {
    def "functionX List<String> test"() {
        given:
        def yourClassImpl = new YourClassImpl<String>()
        def yourClassImpl2 = new YourClassImpl2<String>()

        when:
        def collRes = yourClassImpl.functionX(coll1, coll2, coll3)
        def collRes2 = yourClassImpl2.functionX(coll1, coll2, coll3)

        then:
        assert collRes == res
        assert collRes2 == res

        where:
        coll1                                                   |   coll2                                                  |   coll3                                                              |   res
        ["A","A","B","B","C","C","D","G"] as ArrayList<String>  |   ["D","A","E","E","F","F","G","G"] as ArrayList<String> |   ["H","H","I","I","J","J","K","D","D","A","G"] as ArrayList<String> |   ["A", "D", "G"] as Collection<String>
        ["A","A","B","B","C","C","D"] as ArrayList<String>      |   ["D","A","E","E","F","F","G","G"] as ArrayList<String> |   ["H","H","I","I","J","J","K","D","D","A"] as ArrayList<String>     |   ["A", "D"] as Collection<String>


    }

    def "functionX Set<Integer> test"() {
        given:
        def yourClassImpl = new YourClassImpl<Integer>()
        def yourClassImpl2 = new YourClassImpl2<Integer>()

        when:
        def collRes = yourClassImpl.functionX(coll1, coll2, coll3)
        def collRes2 = yourClassImpl2.functionX(coll1, coll2, coll3)

        then:
        assert collRes == res
        assert collRes2 == res

        where:
        coll1                           |   coll2                           |   coll3                                |   res
        [1,2,3,4,5] as HashSet<Integer> |   [6,7,8,1,2] as HashSet<Integer> |   [9,1,10,11,12,2] as HashSet<Integer> |   [1,2] as Collection<Integer>
        [1,2,3,4,5] as HashSet<Integer> |   [6,7,8,1,2] as HashSet<Integer> |   [9,10,11,12,2] as HashSet<Integer>   |   [2] as Collection<Integer>


    }

    def "function List<String> test"() {
        given:
        def yourClassImpl = new YourClassImpl<String>()
        def yourClassImpl2 = new YourClassImpl2<String>()

        when:
        def collResAsc = yourClassImpl.function(IntersectionTest.Order.ASC, coll1, coll2, coll3)
        def collResDesc = yourClassImpl.function(IntersectionTest.Order.DESC, coll1, coll2, coll3)
        def collResAsc2 = yourClassImpl2.function(IntersectionTest.Order.ASC, coll1, coll2, coll3)
        def collResDesc2 = yourClassImpl2.function(IntersectionTest.Order.DESC, coll1, coll2, coll3)

        then:
        assert collResAsc == resAsc
        assert collResDesc == resDesc
        assert collResAsc2 == resAsc
        assert collResDesc2 == resDesc

        where:
        coll1                                                   |   coll2                                                  |   coll3                                                          | resAsc                                                                       | resDesc
        ["A","A","B","B","C","C","D","G"] as ArrayList<String>  |   ["D","A","E","E","F","F","G","G"] as ArrayList<String> |   ["H","H","I","I","J","J","K","D","D","A"] as ArrayList<String> | ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"] as ArrayList<String> | ["K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"] as ArrayList<String>
        [1,2,3,4,5] as HashSet<Integer>                         |   [6,7,8,1,2] as HashSet<Integer>                        |   [9,1,10,11,12,2] as HashSet<Integer>                           | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] as ArrayList<Integer>                | [12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1] as ArrayList<Integer>
    }

    def "functionY Set<Integer> test"() {
        given:
        def yourClassImpl = new YourClassImpl<String>()
        def yourClassImpl2 = new YourClassImpl2<String>()

        when:
        def collRes = yourClassImpl.functionY(coll1, coll2, coll3)
        def collRes2 = yourClassImpl2.functionY(coll1, coll2, coll3)

        then:
        assert collRes == res
        assert collRes2 == res

        where:
        coll1                           |   coll2                           |   coll3                                |   res
        [1,2,3,4,5] as HashSet<Integer> |   [6,7,8,1,2] as HashSet<Integer> |   [9,1,10,11,12,2] as HashSet<Integer> |   [3, 4, 5, 6, 7, 8, 9, 10, 11, 12] as Collection<String>
        [1,2,3,4,5] as HashSet<Integer> |   [6,7,8,1,2] as HashSet<Integer> |   [9,10,11,12,2] as HashSet<Integer>   |   [1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] as Collection<String>

    }

    def "functionY List<String> test"() {
        given:
        def yourClassImpl = new YourClassImpl<String>()
        def yourClassImpl2 = new YourClassImpl2<String>()

        when:
        def collRes = yourClassImpl.functionY(coll1, coll2, coll3)
        def collRes2 = yourClassImpl2.functionY(coll1, coll2, coll3)

        then:
        assert collRes == res
        assert collRes2 == res

        where:
        coll1                                                   |   coll2                                                  |   coll3                                                              |   res
        ["A","A","B","B","C","C","D","G"] as ArrayList<String>  |   ["D","A","E","E","F","F","G","G"] as ArrayList<String> |   ["H","H","I","I","J","J","K","D","D","A","G"] as ArrayList<String> |   ["B", "C", "E", "F", "H", "I", "J", "K"] as Collection<String>
        ["A","A","B","B","C","C","D"] as ArrayList<String>      |   ["D","A","E","E","F","F","G","G"] as ArrayList<String> |   ["H","H","I","I","J","J","K","D","D","A"] as ArrayList<String>     |   ["B", "C", "E", "F", "G", "H", "I", "J", "K"] as Collection<String>

    }

    def "functionX HashSet<MyClass> test"() {
        given:
        def yourClassImpl = new YourClassImpl<IntersectionTest.MyClass>()
        def yourClassImpl2 = new YourClassImpl2<IntersectionTest.MyClass>()

        when:
        def collRes = yourClassImpl.functionX(mcOne, mcTwo, mcThree, mcFour)
        def collRes2 = yourClassImpl2.functionX(mcOne, mcTwo, mcThree, mcFour)

        then:
        assert collRes == res
        assert collRes2 == res

        where:
        mcOne                                                                                                                                                                                                                                             | mcTwo                                                                                                                                                                                                                                              | mcThree                                                                                                                                                                                                                                            | mcFour                                                                                                                                                                                                                                             | res
        [new IntersectionTest.MyClass(1,2,3,"A"), new IntersectionTest.MyClass(2,3,4,"B"),new IntersectionTest.MyClass(3,4,5,"C"), new IntersectionTest.MyClass(4,5,6,"D"), new IntersectionTest.MyClass(1,2,3,"A")] as HashSet<IntersectionTest.MyClass> | [new IntersectionTest.MyClass(1,2,3,"A"), new IntersectionTest.MyClass(2,4,4,"B"), new IntersectionTest.MyClass(4,4,5,"C"), new IntersectionTest.MyClass(4,5,6,"D"), new IntersectionTest.MyClass(1,2,3,"A")] as HashSet<IntersectionTest.MyClass> | [new IntersectionTest.MyClass(1,2,3,"A"), new IntersectionTest.MyClass(3,3,4,"B"), new IntersectionTest.MyClass(3,5,5,"C"), new IntersectionTest.MyClass(4,5,6,"D"), new IntersectionTest.MyClass(1,2,3,"A")] as HashSet<IntersectionTest.MyClass> | [new IntersectionTest.MyClass(1,2,3,"A"), new IntersectionTest.MyClass(2,3,5,"B"), new IntersectionTest.MyClass(3,4,5,"A"), new IntersectionTest.MyClass(4,5,6,"D"), new IntersectionTest.MyClass(1,2,3,"A")] as HashSet<IntersectionTest.MyClass> | [new IntersectionTest.MyClass(1,2,3,"A"), new IntersectionTest.MyClass(4,5,6,"D")] as Collection<IntersectionTest.MyClass>


    }
}