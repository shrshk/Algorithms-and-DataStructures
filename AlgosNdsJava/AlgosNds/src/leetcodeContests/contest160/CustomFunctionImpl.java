package leetcodeContests.contest160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 class CustomFunction {
     // Returns f(x, y) for any given positive integers x and y.
     // Note that f(x, y) is increasing with respect to both x and y.
     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     public int f(int x, int y) {
    	 return x+y; // could be x * y or something else
     }
 };

public class CustomFunctionImpl {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i=1; i<=1000; i++) {
            for (int j=1; j<=1000; j++) {
                if (customfunction.f(i,j)==z) {
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return res;
    }
}
