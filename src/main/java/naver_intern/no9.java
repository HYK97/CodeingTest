package naver_intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName :  naver_intern
 * fileName : no9
 * author :  ddh96
 * date : 2022-12-14 
 * description : https://www.acmicpc.net/problem/7568
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-14                ddh96             최초 생성
 */
public class no9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            list.add(new Person(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
        int rank = 1;
        for (int i = 0; i < N; i++) {
            Person currentPerson = list.get(i);
            for (int j = 0; j < N; j++) {
                Person nextPerson = list.get(j);
                // 아이디어 나보다 큰사람들의 개수를 카운트
                //                true                                  false    false         비김
                //                true                                  true      true         내가더 작음 ++;
                //               false                                  false        false     내가더 큼
                if (currentPerson.weight < nextPerson.weight && currentPerson.height < nextPerson.height) {
                    rank++;
                }
            }
            currentPerson.rank = rank;
            rank = 1;
        }
        for (Person person : list) {
            System.out.print(person.rank + " ");
        }
    }

    static class Person {
        int height;
        int weight;
        int rank;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

    }
}
