package programmers.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * packageName :  programmers.greedy
 * fileName : 무지의먹방라이브
 * author :  ddh96
 * date : 2022-11-22
 * description : 프로그래머스 무지의 먹방라이브
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-22                ddh96             최초 생성
 */
public class MujiEatingLive {

    public static void main(String[] args) {
        MujiEatingLive MujiEatingLive = new MujiEatingLive();
        int solution = MujiEatingLive.solution(new int[]{3, 5, 20, 12}, 21);
        System.out.println("solution = " + solution);
    }


    public int solution(int[] food_times, long k) {

        PriorityQueue<Job> job = new PriorityQueue<>();
        long allTime = 0;

        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] > 0) {
                job.offer(new Job(i + 1, food_times[i]));
                allTime += food_times[i];
            }
        }
        if (allTime <= k) {
            return -1;
        }

        long spend = 0;
        long previous = 0;
        long foodCount = food_times.length;

        while (spend + ((job.peek().getFoodTime() - previous) * foodCount) <= k) {

            //이전사용시간
            //      +                                              두개더해서 k보다 작아야함
            //현재사용시간 ={(현재음식시간 - 이전음식먹은시간) * 남은 음식개수}

            long currentTime = job.poll().getFoodTime(); //현재음식시간
            spend += (currentTime - previous) * foodCount; //현재음식시간을 먹기위해 총 소비되는시간
            foodCount -= 1;
            previous = currentTime;
        }

        ArrayList<Job> result = new ArrayList<>();
        while (!job.isEmpty()) {
            result.add(job.poll());
        }
        Collections.sort(result, Comparator.comparingInt(Job::getIndex));
        // 남은시간(k - spend) / 음식개수 의 인덱스를 구함
        return result.get((int) ((k - spend) % foodCount)).getIndex();

    }

    static class Job implements Comparable<Job> {
        private int index;
        private int foodTime;

        public Job(int index, int foodTime) {
            this.index = index;
            this.foodTime = foodTime;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getFoodTime() {
            return foodTime;
        }

        public void minusFoodTime() {
            this.foodTime = this.foodTime - 1;
        }

        @Override
        public int compareTo(Job job) {
            return Integer.compare(this.getFoodTime(), job.getFoodTime());
        }
    }


    /**
     * 시간초과 답안.
     * */
    /*public int solution(int[] food_times, long k) {

        int answer = 0;
        Queue<Job> job = new LinkedList<>();
        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] > 0) {
                job.add(new Job(i + 1, food_times[i]));
            }

        }

        int currentTime = 0;
        int result = -9;
        while (!job.isEmpty()) {
            if (k == currentTime) {
                result = job.peek().getIndex();
                break;
            }
            Job currentJob = job.poll();
            currentJob.minusFoodTime();
            if (currentJob.getFoodTime() > 0) {
                job.add(currentJob);
            }
            currentTime++;
        }
        if (job.isEmpty()) {
            result = -1;
        }
        System.out.println("result = " + result);
        return result;
    }

    static class Job {
        private int index;
        private int foodTime;

        public Job(int index, int foodTime) {
            this.index = index;
            this.foodTime = foodTime;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getFoodTime() {
            return foodTime;
        }

        public void minusFoodTime() {
            this.foodTime = this.foodTime - 1;
        }
    }*/
}
