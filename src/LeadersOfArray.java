import java.util.ArrayList;
import java.util.Collections;

public class LeadersOfArray {
    public static ArrayList<Integer> leaders(int []a){
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        if(a.length==0) {
            return res;
        }
        for(int i = a.length-1;i>=0;i--){
            if(a[i]>max){
                res.add(a[i]);
                max = a[i];
            }
        }
        Collections.reverse(res);
        return res;
    }
}
