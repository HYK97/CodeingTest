package leetcode.learn;

import java.util.ArrayList;
import java.util.List;
/*
*https://leetcode.com/problems/fizz-buzz/description/
* */
public class No412 {
    public List<String> fizzBuzz(int n) {
        List<String> result =new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean isFactorOf3 = i % 3 == 0;
            boolean isFactorOf5 = i % 5 == 0;
            if (isFactorOf3 && isFactorOf5) {
                result.add("FizzBuzz");
                continue;
            }
            if (isFactorOf3) {
                result.add("Fizz");
                continue;
            }
            if (isFactorOf5) {
                result.add("Buzz");
                continue;
            }
            result.add(String.valueOf(i));
        }
        return result;
    }
}