import java.util.Map;
import java.util.Vector;

public class Base {
    private static Map<String, String> userdata;

    private Vector<Account> accounts;
    public Base() {
        accounts = new Vector<>();
    }

    public boolean add(String key, String value) {
        Account tmp = new Account(key,value);
        if(contains(tmp))return false;
        accounts.add(tmp);
        return true;
    }

    private boolean contains(Account cur){
        for(int i=0; i<accounts.size(); i++){
            if(cur.equals(accounts.get(i)))return true;
        }
        return false;
    }
    public boolean check(String key, String value) {
        Account tmp = new Account(key, value);
        if (contains(tmp)) return true;
        return false;
    }
}
