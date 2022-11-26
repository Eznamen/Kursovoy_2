import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Category {
    Object category;
    Object sum;

    public Category(Map.Entry maxMap) {
        this.category = maxMap.getKey();
        this.sum = maxMap.getValue();
    }

    public static Map.Entry MaxM(Map<String, Integer> map) {
        Map.Entry maxM = Collections.max(map.entrySet(), Comparator.comparing(Map.Entry::getValue));
        return maxM;
    }

    @Override
    public String toString() {
        return "{" +
                "maxCategory{" +
                "category : " + category +
                ", sum : " + sum +
                '}' +
                '}';
    }
}