public class LongestSubarray {
    public static int longestSubArrayBrute(int []a,int k){
        int len = 0;
        int n = a.length;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=a[j];
                if(sum==k){
                    len = Math.max(len,j-i+1);
                    break;
                    //O(n^2)
                }
            }
        }
        return len;
    }

    public static int longestSubArrayBetter(int[] a,int k){
        //Hashing prefix sum
        int len = 0;

    }

    static void main(String[] args) {
        int[] a = new int[]{1,2,3,1,1,1,1,4,2,3};
        System.out.println(longestSubArrayBrute(a,4));
    }
}
