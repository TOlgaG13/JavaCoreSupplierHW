package sample1;

import java.util.function.Supplier;

public class WordSupplier implements Supplier<String>{
	private final String[] words;
    private int index = 0;

    public WordSupplier(String input) {
        this.words = input.split(" ");
    }

    @Override
    public String get() {
        if (index < words.length) {
            return words[index++];
        }
        return null; 
    }

    public static void main(String[] args) {
    	WordSupplier supplier = new WordSupplier("Hello world this is Java");
        
        String word;
        while ((word = supplier.get()) != null) {
            System.out.println(word);
        }
    }
}