package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 성적이낮은순서로학생출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] data = new Student[N];
        for (int i = 0; i < N; i++) {
            String[] sData = br.readLine().split(" ");
            data[i] = new Student(Integer.parseInt(sData[1]), sData[0]);
        }

        //람다식을 이용해도됌
        //Arrays.sort(data,(i,j)->i.getGrade()-j.getGrade());
        Arrays.sort(data, Comparator.comparingInt(Student::getGrade));

        for (Student datum : data) {
            System.out.print(datum.getName() + " ");
        }
    }

    static class Student {
        int grade;
        String name;

        public Student(int grade, String name) {
            this.grade = grade;
            this.name = name;
        }

        public int getGrade() {
            return grade;
        }

        public String getName() {
            return name;
        }


    }
}
