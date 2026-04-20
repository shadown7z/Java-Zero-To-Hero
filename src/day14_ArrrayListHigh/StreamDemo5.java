package day14_ArrrayListHigh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<String > list = new ArrayList<>();
        list.add("张三,23");
        list.add("李四,24");
        list.add("王五,25");

        Map<String,String> map = list.stream().collect(Collectors.toMap(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.split(",")[0];
            }
        }, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.split(",")[1];
            }
        }));
        System.out.println(map);
    }
}
