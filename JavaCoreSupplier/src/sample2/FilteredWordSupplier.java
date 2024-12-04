package sample2;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FilteredWordSupplier implements Supplier<String>{
	private final List<String> words;
    private final Predicate<String> predicate;
    private int index = 0;

    public FilteredWordSupplier(List<String> words, Predicate<String> predicate) {
        this.words = words;
        this.predicate = predicate;
    }

    @Override
    public String get() {
        while (index < words.size()) {
            String word = words.get(index++);
            if (predicate.test(word)) {
                return word;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
    	  List<String> words = List.of("Hello", "world", "Java", "code");
    	    Predicate<String> startsWithUppercase = word -> Character.isUpperCase(word.charAt(0));
    	    Supplier<String> supplier = new FilteredWordSupplier(words, startsWithUppercase);

    	    String word;
    	    while ((word = supplier.get()) != null) {
    	        System.out.println(word);
    	    }
    	}
    }

