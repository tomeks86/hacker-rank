import com.google.common.collect.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class GuavaTest {

    public static void main(String[] args) {
        //List<String> guavaList = Lists.newArrayList();
        List<String> guavaList = Lists.newArrayList("el1", "el2", "el3");
        for (String s : guavaList) {
            System.out.println(s);
        }
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("Kowalski", "Jan");
        multimap.put("Kowalski", "Stefan");
        multimap.put("Nowak", "Tomasz");
        for (String key : multimap.keySet()) {
            System.out.println(multimap.get(key));
        }
        System.out.println(multimap.containsEntry("Kowalski", "Jan"));

        BiMap<String, String> bimap = HashBiMap.create();
        bimap.put("Jan", "Kowalski");
        bimap.put("Adam", "Nowak");
        bimap.put("Adam", "Kafka");
        for (String s : bimap.keySet()) {
            System.out.println(s + " " + bimap.get(s));
        }
        bimap.inverse();
        System.out.println();
        for (String s : bimap.keySet()) {
            System.out.println(s + " " + bimap.get(s));
        }

        HashMap<Integer, String> aMap = new HashMap<>();
        aMap.put(null, null);
        aMap.put(null, null);
        aMap.put(1, null);
        aMap.put(2, null);
        aMap.put(null, "jeden");
        aMap.put(null, "dwa");
        System.out.println(aMap.size());
        System.out.println(aMap);
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println("a" + System.getProperty("line.separator") + "b");
        System.out.println(System.getProperties());
        System.setProperty("user.dir","/home/tomasz");
        File dir = new File(System.getProperty("user.dir"));
        File[] fileList = dir.listFiles();
        for (File file : fileList) {
            System.out.println(file.getName());
        }
    }
}
