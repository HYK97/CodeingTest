class Solution {
    fun trap(height: IntArray): Int {
        var lmax=0;
        var rmax=0;
        var l = 0;
        var r = height.size - 1;
        var result = 0;
        while (l != r) {
            if (height[r] > rmax){
                rmax=height[r]
            }
            if (height[l] > lmax){
                lmax=height[l]
            }
            if (height[l] <= height[r]) {
                result += lmax - height[l]
                l++
                continue
            }
            if(height[l]>height[r]){
                result += rmax - height[r]
                r--
                continue
            }
        }
        return result
    }
}