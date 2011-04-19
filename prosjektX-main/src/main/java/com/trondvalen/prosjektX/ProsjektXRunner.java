package com.trondvalen.prosjektX;

import java.util.Arrays;
import java.util.List;
import java.util.ServiceLoader;

public class ProsjektXRunner {

    private static ServiceLoader<ElementReverser> serviceLoader = ServiceLoader.load(ElementReverser.class);

    public static void main(String[] args) {
        System.out.println("Implementors");
        ElementReverser reverser = null;
        for (ElementReverser implementor : serviceLoader) {
            if (implementor != null) {
                reverser = implementor;
            }
            System.out.println(implementor.getClass().getCanonicalName());
        }
        if (reverser == null) {
            System.out.println("Couldn't find an implementor. Exiting");
            return;
        }
        List<String> list = Arrays.asList(new String[]{"ball", "agnesisenga", "effekt", "frakt"});
        System.out.println("Result: " + reverser.work(list));
    }
}
