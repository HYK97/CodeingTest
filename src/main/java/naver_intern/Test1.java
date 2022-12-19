package naver_intern;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName :  naver_intern
 * fileName : Test1
 * author :  ddh96
 * date : 2022-12-17 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-17                ddh96             최초 생성
 */
public class Test1 {
    public static void main(String[] args) {

        int[] periods = new int[] {24, 59, 59, 60};
        int[][] payments = new int[][] {
            {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
            {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
            {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
            {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}
        };
        int[] estimates = new int[] {350000, 50000, 40000, 50000};
        solution(periods, payments, estimates);
    }

    public static int[] solution(int[] periods, int[][] payments, int[] estimates) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < periods.length; i++) {
            int currentTotalPay = 0;
            int nextTotalPay = 0;
            for (int j = 0; j < payments[i].length; j++) {
                currentTotalPay += payments[i][j];

            }
            System.out.println(currentTotalPay);
            for (int j = 1; j < payments[i].length; j++) {
                nextTotalPay += payments[i][j];
            }
            nextTotalPay += estimates[i];
            users.add(new User(periods[i], currentTotalPay, nextTotalPay));
        }
        System.out.println(users);

        int nextVipCount = 0;
        int nextNonVipCount = 0;
        for (User user : users) {
            System.out.println(user.isCurrentVip());
            System.out.println(user.isNextVip());
            System.out.println(user);
            //이번달에 vip이고 다음달에 vip가 아닌경우
            //false //true
            //true
            if (user.isCurrentVip()) {
                if (!user.isNextVip()) {
                    nextVipCount++;
                }
            }
            //이번달에 vip가 아니고 다음달에 vip인경우
            if (!user.isCurrentVip()) {
                if (user.isNextVip()) {
                    nextNonVipCount++;
                }
            }
        }
        System.out.println(nextVipCount + " " + nextNonVipCount);
        return new int[] {nextVipCount, nextNonVipCount};

    }

    static class User {
        int currentTotalPay;
        int currentMonth;
        int nextMonth;
        int nextTotalPay;

        public User(int currentMonth, int currentTotalPay, int nextTotalPay) {
            this.currentMonth = currentMonth;
            this.currentTotalPay = currentTotalPay;
            this.nextMonth = currentMonth + 1;
            this.nextTotalPay = nextTotalPay;
        }

        //이번달 vip인경우
        public boolean isCurrentVip() {
            if (currentMonth >= 24 && currentMonth < 60) {
                return currentTotalPay >= 900000;
            }
            if (currentMonth >= 60) {
                return currentTotalPay >= 600000;
            }
            return false;
        }

        //다음달 vip인경우
        public boolean isNextVip() {
            if (nextMonth >= 24 && nextMonth < 60) {
                return nextTotalPay >= 900000;
            }
            if (nextMonth >= 60) {
                return nextTotalPay >= 600000;
            }
            return false;
        }

        @Override
        public String toString() {
            return "User{" +
                "currentTotalPay=" + currentTotalPay +
                ", currentMonth=" + currentMonth +
                ", nextMonth=" + nextMonth +
                ", nextTotalPay=" + nextTotalPay +
                '}';
        }
    }

}
