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

    }


    public static Vector<Integer> getSeconOrderElements(Vector<Integer> a,int n){
        int secondLargest = getSecondLargest(a,n);
        int secondSmallest = getSecondSmallest(a,n);
        return new Vector<>(Arrays.asList(secondLargest,secondSmallest));
    }

    static void main(String[] args) {
//        System.out.println(getSeconOrderElements(new Vector<>(Arrays.asList(6,1,7,6,2)),5));
        int a[] = new int[]{1,1,2,2,3,3,4,4,4,5,5,5};
//        int last = removeDuplicates(a);
        singleLeftRotateArray(a);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+", ");
        }
    }
}
