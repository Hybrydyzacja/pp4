package pl.azieba.creditcard;

import java.util.Collections;

public class App {
    public static void main(String[] args) {
        var name = "Aleksandra";

//        System.out.println(name);
        var message = String.format("Hello %s", name);

        var names = Collections.singletonList("Aleksandra Zieba");

        System.out.println(message);
    }
}
