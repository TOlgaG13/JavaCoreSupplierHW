package sample3;
import java.util.function.IntSupplier;
public class ArrayIntSupplier implements IntSupplier{
    private final int[] numbers;
    private int index = 0;

    public ArrayIntSupplier(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int getAsInt() {
        if (index < numbers.length) {
            return numbers[index++];
        }
        throw new RuntimeException("Elements are out"); 
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        IntSupplier supplier = new ArrayIntSupplier(array);

        try {
            while (true) {
                System.out.println(supplier.getAsInt());
            }
        } catch (RuntimeException e) {
            System.out.println("Elements are out!");
        }
    }
}
