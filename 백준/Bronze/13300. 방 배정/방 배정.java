import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName :  baekjoon.array
 * fileName : No3273
 * author :  ddh96
 * date : 2023-11-28 
 * description : https://www.acmicpc.net/problem/3273
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-11-28                ddh96             최초 생성
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int studentCount = Integer.parseInt(data[0]);
        double maxRoomCount = Integer.parseInt(data[1]);

        int[][] students = new int[6][2];
        for (int i = 0; i < studentCount; i++) {
            String[] studentData = sc.nextLine().split(" ");
            int gender = Integer.parseInt(studentData[0]);
            int grade = Integer.parseInt(studentData[1]);
            students[grade-1][gender]++;
        }
        int result = 0;

        for (int[] student : students) {
            double boy = student[0] / maxRoomCount == 0 ? 0 : + Math.ceil((double)student[0] /maxRoomCount);
            double girl= student[1] / maxRoomCount == 0 ? 0 :  + Math.ceil((double)student[1] /maxRoomCount);
            result+= (int)(boy+girl);
        }
        System.out.println(result);
    }
}
