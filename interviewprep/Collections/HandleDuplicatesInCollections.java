package CollectionsAndGenerics;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HandleDuplicatesInCollections {

    public static void main(String[] args) {

        List<String> listWithDup = new ArrayList<>();

        listWithDup.add("apple");
        listWithDup.add("banana");
        listWithDup.add("apple");
        listWithDup.add("orange");

        // remove dupl using linkedhashset to maintain order
        /*Set<String> set = new LinkedHashSet<>(listWithDup);
        List<String> listWithoutDuplicates = new ArrayList<>(set);
        System.out.println("Final List: "+listWithoutDuplicates);*/

        // using streams
        List<String> listWithoutDupl = listWithDup.stream().distinct().toList();
        System.out.println(listWithoutDupl);




    }
}
