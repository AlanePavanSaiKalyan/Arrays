import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Arrays_Easy {
    public static int getLargest(int []a){
        int largest  = a[0];
        for(int i =1;i<a.length;i++ ){
            if(a[i]>largest){
                largest = a[i];
            }
        }
        return largest;
    }

    public static Integer getSecondLargest(Vector<Integer> a,int n){
        Integer largest = a.getFirst();
        Integer secondLargest = Integer.MIN_VALUE;
        for(int i = 1;i<a.size();i++){
            if(a.get(i)>largest){
                secondLargest = largest;
                largest = a.get(i);
            }
            else if(a.get(i)<largest && a.get(i)>secondLargest){
                secondLargest = a.get(i);
            }
        }
        return secondLargest;
    }

    public static Integer getSecondSmallest(Vector<Integer> a,int n){
        int smallest = a.getFirst();
        int secondSmallest = Integer.MAX_VALUE;
        for(int i = 1;i<n;i++){
            if(a.get(i)<smallest){
                secondSmallest = smallest;
                smallest = a.get(i);
            } else if (a.get(i)>smallest && a.get(i)<secondSmallest) {
                secondSmallest = a.get(i);
            }
        }
        return  secondSmallest;
    }

    public static int removeDuplicates(int[] a){
    // Two pointer example
     int i = 0;
        for(int j=1;j<a.length;j++){
            if(a[j]!=a[i]){
               a[i+1]=a[j];
               i++;
            }
        }
        return i+1;
    }

    public static boolean isSorted(int []a){
        for(int i = 0;i<a.length-1;i++){
            if(a[i]>a[i+1]) return false;
        }
        return true;

    }

    public static void singleLeftRotateArray(int[] a){
        int temp = a[0];
        for(int i =1;i<a.length-1;i++) {
            a[i-1] = a[i];
        }
        a[a.length-1] =temp;

    }

    public static void leftRotationByN(int a[],int n){
        //Bruteforce
        int d = n%a.length;
        int temp[] = new int[d];
        for(int i = 0;i<d;i++){
            temp[i] = a[i];
        }
        for(int i = d;i<a.length;i++){
            a[i-d] =  a[i];
        }
        for (int i = a.length-d;i<a.length;i++ ){
            a[i] = temp[i-(a.length-d)];
        }
    }

    public static void leftRotationByN_optimal(int[] a,int d){
        d = d%a.length;
        reverse(a,0,d-1);
        reverse(a,d,a.length-1);
        reverse(a,0,a.length-1);
    }

    public static void reverse(int[]a,int start,int end){
        while (start<=end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void rightRotationByN(int []a,int n){
        int d = n%a.length;
        int temp[] = new int[d];
        for(int i = a.length-d;i<a.length;i++){
            temp[i-(a.length-d)] = a[i];
        }
        for(int i = a.length-d-1;i>=0;i--){
            a[i+d] = a[i];
        }
        for(int i = 0;i<temp.length;i++){
            a[i] = temp[i];
        }

    }

    public static void rightRotationByNOptimal(int[] a,int n){
        int d= n%a.length;
        reverse(a,0,a.length-d-1);
        reverse(a,a.length-d,a.length-1);
        reverse(a,0,a.length-1);
    }

    public static void pushZeroesToEnd(int[] a){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0;i<a.length;i++){
            if(a[i]!=0){
                temp.add(a[i]);
            }
        }
        for(int i = 0;i<temp.size();i++){
            a[i] = temp.get(i);
        }
        for(int i = temp.size();i<a.length;i++){
            a[i] = 0;
        }

    }
//
//    public static int[] union(int[] a,int[] b){
//        ArrayList<Integer> res= new ArrayList<>();
//        int j = 0;
//       int i = 0;
//       while(i<a.length && j<b.length){
//
//       }
//    }

    public static void pushZeroesToEndOptimal(int[]a){
      int start = -1;
      for(int i = 0;i<a.length;i++){
          if(a[i] == 0){
              start = i;
              break;
          }
      }
      if(start == -1) return;
      for(int i = start+1;i<a.length;i++){
          if(a[i]!=0){
              int temp = a[start];
              a[start] = a[i];
              a[i] = temp;
              start++;
      }
      }
    }



    public static Vector<Integer> getSeconOrderElements(Vector<Integer> a,int n){
        int secondLargest = getSecondLargest(a,n);
        int secondSmallest = getSecondSmallest(a,n);
        return new Vector<>(Arrays.asList(secondLargest,secondSmallest));
    }

    static void main(String[] args) {
//        System.out.println(getSeconOrderElements(new Vector<>(Arrays.asList(6,1,7,6,2)),5));
        int a[] = new int[]{0,0,4,3,5,0,5,4,1,3,0};
//        int last = removeDuplicates(a);
        pushZeroesToEnd(a);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+", ");
        }
    }
}
