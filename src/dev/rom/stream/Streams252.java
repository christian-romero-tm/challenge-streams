package dev.rom.stream;

import java.util.stream.IntStream;

public class Streams252 {
    public static void main(String[] args) {

        IntStream.iterate((int) 'A', i -> i<=(int)'z', i -> i + 1)
                .forEach(a -> System.out.printf("%c", a));

    }
}
