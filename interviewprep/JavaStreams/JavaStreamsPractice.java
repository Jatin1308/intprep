package JavaStreams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsPractice {

    public static void main(String[] args) {

        // immutable list, allows nulls
        var immutableList = Stream.of("red","green",null,"black").toList();
//        immutableList.add("hello"); -> compile time error

        // modifiable list, allows nulls
        var mutableList = Stream.of("red","green","black",null).collect(Collectors.toList());
        mutableList.add("OK"); // here i can update


        record Product(String name, String category, int price){};

        Stream<Product> products = Stream.of(
                new Product("Laptop","electronics",1000),
                new Product("TV","electronics",1500),
                new Product("Sofa","Furniture",700),
                new Product("Table","Furniture",300),
                new Product("Lamp","Home Decor",50)
        );

        // grouping products by category

//        System.out.println(products.collect(Collectors.groupingBy(Product::category)));
//        Map<String,List<Product>> groupByCategories = products.collect(Collectors.groupingBy(Product::category));
//        System.out.println(groupByCategories);

        // calculate total product in each category

//        Map<String,Integer> sumBasedOnCateg = products
//                                                .collect(Collectors.groupingBy
//                                                        (Product::category,
//                                                                Collectors.summingInt(Product::price)));
//        System.out.println(sumBasedOnCateg);

        // average price in each category

//        Map<String,Double> avgPriceInCateg = products
//                                                .collect(Collectors.groupingBy
//                                                        (Product::category,
//                                                                Collectors.averagingInt(Product::price)));
//        System.out.println(avgPriceInCateg);


        // filtering: products with price greater than 50
//        List<Product> priceFilter = products.filter(p -> p.price() > 1000).toList();
//        System.out.println(priceFilter);

        // extracting product name
//        var names = products.map(Product::name).toList();
//        System.out.println(names);

        // partition into expensive and cheap
//        var partitionedProd = products.collect(Collectors.partitioningBy(p -> p.price() > 999));
//        System.out.println(partitionedProd);

        // summary statistics - for each category -> sum,average, min,max,count

        Map<String, IntSummaryStatistics> summary = products
                                                .collect(Collectors.groupingBy
                                                        (Product::category,
                                                                Collectors.summarizingInt(Product::price)));
        System.out.println(summary);


    }
}
