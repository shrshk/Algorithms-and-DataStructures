package leetcodeContests.contest176;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

    List<Integer> prods;
    int p;
    public ProductOfNumbers() {
        prods = new ArrayList<>();
        p=1;        
    }
    
    public void add(int num) {
        if(num == 0) {
            prods = new ArrayList<>();
            p = 1;
            return;
        }
        p*=num;
        prods.add(p);
    }
    
    public int getProduct(int k) {
        if (prods.size()<k)
            return 0;
        if (prods.size()==k)
            return prods.get(prods.size()-1);    
        return prods.get(prods.size()-1)/prods.get(prods.size()-1-k);
    }
}
