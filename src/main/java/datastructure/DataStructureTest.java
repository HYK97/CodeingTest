package datastructure;

import org.junit.jupiter.api.Test;

/**
 * packageName :  datastructure
 * fileName : DataStructureTest
 * author :  ddh96
 * date : 2022-12-06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-06                ddh96             최초 생성
 */
public class DataStructureTest {
    @Test
    public void checkPalindrome() {
        //given
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Character> list3 = new LinkedList<>();
        LinkedList<Character> list4 = new LinkedList<>();
        //when
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);

        list2.add(1);
        list2.add(2);
        list2.add(3);

        list3.add('a');
        list3.add('b');
        list3.add('c');
        list3.add('b');
        list3.add('a');

        list4.add('a');
        list4.add('a');
        list4.add('c');

        //then
        System.out.println("checkPalindrome1 = " + LinkedList.checkPalindrome(list));
        System.out.println("checkPalindrome2 = " + LinkedList.checkPalindrome(list2));
        System.out.println("checkPalindrome3 = " + LinkedList.checkPalindrome(list3));
        System.out.println("checkPalindrome4 = " + LinkedList.checkPalindrome(list4));

    }

    @Test
    public void dataCollect() {
        //given
        LinkedList.dataCollect(new String[] {"apple", "banana", "car", "air", "cc"});
        //when

        //then

    }

}
