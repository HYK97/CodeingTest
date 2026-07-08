// 문제 조건 
// nums1에 정렬된 값이 있어야함 -> 추가 적인 공간 쓰지말라고는 안되어 있으나 nums1에 답을 복사해야햄
// nums1 은 실제 길이는 1이나 0으로 나올 수 있음 m = 0 일때 size는 1
// o의n으로 풀어야 하기 때문에
// for 문 x
// 두 배열 모두 내림 차순으로 정렬 되어 있다.
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // m = 0 인 경우 제외
        int [] result = new int[m+n];
        if (m==0){
            for(int i =0; nums2.length > i; i++){
                nums1[i] = nums2[i];
            }
        }
        int realNums1Index = nums1.length - n;

        //아닌 경우에는 이제 nums1첫번째와 nums2 를 각각 비교해서 작은걸 가져오도록 해야함

        int i = 0; // nums1 index
        int j = 0; // nums2 index
        int resultIndex = 0;
        while (true){
            // 2개를 뽑아서 비교후 작은 값을 result에 넣고 큰 값은 보류 -> index 그대로
            if(i < realNums1Index && j < n){
                if (nums1[i]<nums2[j]){
                    result[resultIndex] = nums1[i];
                    resultIndex++;
                    i++;
                    continue;
                }
                result[resultIndex] = nums2[j];
                resultIndex++;
                j++;
                continue;
            }else if (i < realNums1Index){
                result[resultIndex] = nums1[i];
                resultIndex++;
                i++;
                continue;
            }else if (j < n){
                result[resultIndex] = nums2[j];
                resultIndex++;
                j++;
                continue;
            }else{
                break;
            }
        }
        
        for(int k = 0; k<m+n;k++){
            nums1[k]=result[k];
        }

    }
}