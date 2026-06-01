import java.util.*;

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


    public static List<Integer> intersectionBruteforce(int a[],int b[]){
        List<Integer> intersection = new ArrayList<>();
        int n1 = a.length;
        int n2 = b.length;
        for(int i = 0;i<n1;i++){
            for(int j = 0;j<n2;j++){
                if(a[i] == b[j]){
                    if(intersection.isEmpty() || intersection.get(intersection.size()-1) !=a[i]){
                        intersection.add(a[i]);
                        break;
                    }
                }
                if(b[j]>a[i]){
                    break;
                }
            }
        }
        return intersection;
    }

    public static List<Integer> intersectionOptimal(int a[],int b[]){
        List<Integer> intersection = new ArrayList<>();
        int j = 0;
        int i = 0;
        int n = a.length;
        int m = b.length;
        while(i<n && j<m){
            if(a[i] <b[j]){
                i++;
            }
            else if(a[i]>b[j]){
                j++;
            }
            else{
                    intersection.add(a[i]);
                    i++;
                    j++;
            }
        }
        return intersection;
    }


    public static int missingNumber(int[] a,int n){
        int xor1=0;;
        int xor2=0;
        for(int i = 0;i<a.length;i++) {
            xor2^=a[i];
            xor1^=i+1;

        }
        xor1^=n;
        return xor1^xor2;
    }
    public static List<Integer> unionBruteforce(int a[],int b[]){
        Set<Integer> set = new TreeSet<>();
        int n1 = a.length;
        int n2 = b.length;
        for(int i = 0;i<n1;i++) {
            set.add(a[i]);
        }
        for(int j = 0;j<n2;j++){
            set.add(b[j]);
        }
        return new ArrayList<>(set);

    }

    public static List<Integer> unionOptimal(int a[],int b[]){
        List<Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n1= a.length;
        int n2 = b.length;

        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                if(union.isEmpty() || union.get(union.size()-1)!=a[i]){
                    union.add(a[i]);

                }
                i++;
            }
           else if(a[i]>b[j]){
                if(union.isEmpty() || union.get(union.size()-1) != b[j]){
                    union.add(b[j]);

                }
                j++;
            }
            else {
               if(union.isEmpty() || union.get(union.size()-1)!=a[i]){
                   union.add(a[i]);
                               } i++;
                j++;
            }
        }

        while (i<n1){
            if(union.isEmpty() || union.get(union.size()-1)!=a[i]){
                union.add(a[i]);
            }
            i++;
        }
        while (j<n2){
            if(union.isEmpty() || union.get(union.size()-1)!=b[j]){
                union.add(b[j]);
            }
            j++;
        }
        return union;
    }

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
//        int a[] = new int[]{1,1,2,3,4,6,8};
//        int b[] = new  int[]{1,2,3,4,5,6,7};
 //        int last = removeDuplicates(a);
//        pushZeroesToEnd(a);
//        ArrayList<Integer> res= new ArrayList<>(intersectionOptimal(a,b));
//        for(int i = 0;i<a.length;i++){
//            System.out.print(a[i]+", ");
//        }
//        System.out.println(res);
        System.out.println(missingNumber(new int[]{1,4,3,5},5));
    }
}
