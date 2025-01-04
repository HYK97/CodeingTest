package neetcode;

import java.util.Arrays;

public class Products_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int lastIndex = nums.length - 1;
        int post = nums[lastIndex];
        for (int i = lastIndex - 1; i >= 0; i--) {
            result[i] = result[i] * post;
            post = post * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Products_of_Array_Except_Self productsOfArrayExceptSelf = new Products_of_Array_Except_Self();
        int[] ints = productsOfArrayExceptSelf.productExceptSelf(new int[]{2,2,4,6});
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
}
