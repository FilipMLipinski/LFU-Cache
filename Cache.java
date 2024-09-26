import java.util.HashMap;
import java.util.TreeSet;

class Cache{
    private TreeSet<MyPair> set = new TreeSet<MyPair>();
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
    private Integer maxsize;
    private Integer cursize = 0;
    public static void sayHello(){
        System.out.println("hello cache");
    }

    public Cache(Integer _maxsize){
        maxsize = _maxsize;
    }

    public boolean query(Integer q){
        Integer freq = map.get(q);
        if(freq!=null){
            MyPair old = new MyPair(freq, q);
            MyPair newp = new MyPair(freq+1, q);
            set.remove(old);
            set.add(newp);
            map.put(q, freq+1);
            return true;
        }
        else{
            if(cursize==maxsize){
                // kick out least frequently used.
                MyPair f = set.first();
                set.remove(f);
                map.remove(f.val);
                cursize--;
            }
            map.put(q, 1);
            MyPair newp = new MyPair(1, q);
            set.add(newp);
            cursize++;
            return false;
        }
    }

    public String toString(){
        if(set==null){
            return "empty cache";
        }
        return set.toString();
    }
}