package com.predefinedFunctionalInterface;

import java.util.function.Consumer;

public class ConsumerInJava {

	public static void main(String[] args) {
    /*
     * consumer:
     * =======
     * it will consume the value but won't return anything.
     * it uses accept method to accept a value.
     * it won't return anything,because it  is a void type. */
		Consumer<String>c=(s)->System.out.println(s);//we uses s as argument .
		c.accept("Hello World");
	}

}
