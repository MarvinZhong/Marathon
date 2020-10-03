//姓名 : 鍾明智
//學號 : 107213067
import java.util.*;
public class Marathon {
    private static void findSum(int[] arr, int n, Vector<Integer> v, int sum) {
        if (sum == 0) { // If remaining sum is 0, then print all
            for (int i=0;i<v.size();i++) // elements of current subset.
                System.out.print( v.get(i) + " ");
            System.out.println();
            return;
        }
        if (n == 0) // If no remaining elements,
            return;
        // We consider two cases for every element.
        // a) We do not include last element.
        // b) We include last element in current subset.
        findSum(arr, n - 1, v, sum);
        Vector<Integer> v1=new Vector<>(v);
        v1.add(arr[n - 1]);
        findSum(arr, n - 1, v1, sum - arr[n - 1]);
    }
    private static void printAll(int[] arr, int n, int sum){ // Wrapper over printAllSubsetsRec()
        Vector<Integer> v= new Vector<>(); //create v as int vector
        findSum(arr, n, v, sum);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //input n
        int target = input.nextInt(); //input target
        int [] data = new int[n];
        for (int i = 0; i < n; i++){ //input data
            data[i] = input.nextInt();
        }
        printAll(data, n, target);
    }
}