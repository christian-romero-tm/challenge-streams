package dev.rom.stream;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> bingo = new ArrayList<>(75);

        int start = 1;
        for (Character a : "BINGO".toCharArray()){
            for(int i = start; i < (start + 15); i++)
                bingo.add(""+ a + i);
            start+=15;
        }

        //bingo.sort(Comparator.naturalOrder());

        var streamB = Stream.iterate(1, n -> n < 16, n -> n + 1)
                .map(n -> "B" + n);

        var streamI = Stream.iterate(16, n -> n + 1)
                        .limit(15)
                                .map(n -> "I" + n);

        String[] arrayN = new String[15];
        Arrays.setAll(arrayN, i -> "N" + (i + 31));
        var streamN = Arrays.stream(arrayN);

        var streamG = Stream.of("G46","G50","G60");

        var streamO = Stream.generate(() -> new Random().nextInt(61, 76))
                .distinct()
                .limit(15)
                .map(i -> "O" + i)
                .sorted();

        var streamBI = Stream.concat(streamB, streamI);
        var streamBIN = Stream.concat(streamBI, streamN);
        var streamBING = Stream.concat(streamBIN, streamG);
        Stream.concat(streamBING, streamO).forEach(System.out::println);


    }

    public void streamTest(){
        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;

        for(char c : "BINGO".toCharArray()){
            for(int i = start; i < (start + 15); i++){
                bingoPool.add(""+ c + i);
                //System.out.println("" + c + i);
            }
            start+=15;
        }
        Collections.shuffle(bingoPool);

        //List<String> firstOnes = bingoPool.subList(0, 15);
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15));
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {
            if(s.charAt(0) == 'G' || s.charAt(0) == 'O'){
                return s.charAt(0) + "-" + s.substring(1);
            }
            return s;
        });

        System.out.println("-".repeat(20));
        System.out.println(firstOnes);

        System.out.println("-".repeat(20));
        System.out.println(bingoPool);

        System.out.println("Now with streams --------------");

        bingoPool.stream()
                .limit(15)
                .filter(s -> s.charAt(0) == 'G' || s.charAt(0) == 'O')
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        System.out.println("-".repeat(20) + " Was bingoPool modified?");
        System.out.println(bingoPool);

        String[] numbers = {"One","Two","Three"};

        var firstStream = Stream.of("BABA","TSLA","VOO","VTG").sorted(Comparator.reverseOrder());
        System.out.println("-".repeat(20));

        Stream.concat(firstStream, Arrays.stream(numbers))
                .map(s -> s.charAt(0) + "-" + s)
                .forEach(System.out::println);
    }
}
