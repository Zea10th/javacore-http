package org.example;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws IOException {
        List<CatFact> facts = JSONParser.getFacts(ClientService.getServerResponse()).stream()
                .filter(value -> value.getUpvotes() != null && value.getUpvotes() > 0)
                .collect(Collectors.toList());

        facts.forEach(System.out::println);
    }
}
