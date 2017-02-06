import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Maciej on 2016-12-13.
 */
public class Test {
    public static void main(String[] args) {
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("programowanie");
        stringHashSet.add("abstrakcyjne");
        stringHashSet.add("java");
        stringHashSet.add("y");
        Iterator i = stringHashSet.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        stringHashSet.forEach(System.out::println);
        System.out.println("OK-------");
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.addAll(stringHashSet);



    }
}
