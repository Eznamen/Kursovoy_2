import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Answer {

    String title;
    int sum;
    public static final File txtFile = new File("categories.tsv");

    Integer allSum;


    public static Map<String, String> Categ(File txtFile) throws IOException {
        Map<String, String> categories = new HashMap<>();
        try (Scanner scanner = new Scanner(txtFile)) {
            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split("\\P{IsAlphabetic}+");
                String key = parts[0];
                String value = parts[1];
                categories.put(key, value);
            }
//            System.out.println(categories.toString());
        }
        return categories;
    }

    public static Map<String, Integer> Answ(ArrayList<Pokupki> pokupki, Map<String, String> map) {
        Map<String, Integer> map1 = new HashMap<>();
        String category = null;
        Integer allSum = null;
        for (Pokupki pokupka :
                pokupki) {
            if (map.containsKey(pokupka.getTitle())) {
                category = map.get(pokupka.getTitle());
//                System.out.println(category + "cat");
                if (allSum == null) {
                    allSum = pokupka.getSum();
                } else {
                    allSum += pokupka.getSum();
//                    System.out.println(allSum + "sum");
                }
                map1.put(category, allSum);
                allSum = null;
            } else {
                category = "другое";
                if (allSum == null) {
                    allSum = pokupka.getSum();
                } else {
                    allSum += pokupka.getSum();
//                    System.out.println(allSum + "sum");
                }
                map1.put(category, allSum);
                allSum = null;
            }
        }
        return map1;
    }
}