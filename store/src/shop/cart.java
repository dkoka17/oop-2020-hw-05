package shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class cart {

    private Map<String, object> base = new HashMap<String, object>();
    private double res =0;

    public void addProduct(product p) {
        if(base.containsKey(p.getProdId())) {
            object cur = base.get(p.getProdId());
            cur.changeNumber(cur.getNumb()+1);
            product helper = cur.getProd();
            res+=helper.getPrice();
        }else {
            object cur = new object(p,1);
            base.put(p.getProdId(),cur);
            product helper = cur.getProd();
            res+=helper.getPrice();
        }
    }
    public void change(product p, int number) {
        object cur = base.get(p.getProdId());
        res-=p.getPrice()*cur.getNumb();
        cur.changeNumber(number);
        res+=p.getPrice()*number;
    }
    public double value() {
        return res;
    }

    public Vector<object> savedItems(){
        Vector<object> res = new Vector<object>();
        for (String key : base.keySet()) {
            object cur = base.get(key);
            if(cur.getNumb()>0)res.add(cur);
        }
        return res;
    }

    public boolean containsId(String id){
       return base.containsKey(id);

    }
}
