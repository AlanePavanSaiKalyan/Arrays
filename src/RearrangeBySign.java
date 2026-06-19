import java.util.ArrayList;
import java.util.List;

public class RearrangeBySign {
    public static void arrange(int[] a){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
      for(int n:a){
          if(n<0){
              neg.add(n);
          }
          else {
              pos.add(n);
          }
      }
      int i = 0;
      int n=0;
      int p=0;
      while(p<pos.size() && n<neg.size()){
          a[i++] = pos.get(p++);
          a[i++] = neg.get(n++);
      }
      while(p<pos.size()){
          a[i++] = pos.get(p++);
      }
      while (n<neg.size()){
          a[i++] =neg.get(n++);
      }

    }

    static void main(String[] args) {
        int a[] = new int[]{-4,-5,-6,3,4,-6,-3,0};
    arrange(a);
    for (int n:a){
        System.out.println(n);
    }
    }
}
