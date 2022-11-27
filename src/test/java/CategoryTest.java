import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Stream;

public class CategoryTest {
    @ParameterizedTest
    @MethodSource("getArguments")
    void getMaxM(Map map, Map.Entry expectedResult) {
        Assertions.assertEquals(expectedResult, Category.MaxM(map));
    }

    @ParameterizedTest
    @MethodSource("getMap")
    void Statistic(Map.Entry mapE, Category expextedResult) {
        Category actual = new Category(mapE);
        Assertions.assertEquals(expextedResult.category, actual.category);
    }

    private static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of(Map.of("финансы", 15000, "одежда", 1200)
                        , new AbstractMap.SimpleEntry<String, Integer>("финансы", 15000))
        );
    }

    private static Stream<Arguments> getMap() {
        return Stream.of(
                Arguments.of(new AbstractMap.SimpleEntry<String, Integer>("финансы", 15000),
                        new Category(Category.MaxM(Map.of("финансы", 15000, "одежда", 1200)))
                ));
    }
}