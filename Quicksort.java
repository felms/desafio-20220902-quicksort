import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort {

    private static int partition(List<Treta> a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;

        while (true) {

            while (a.get(++i).compareTo(a.get(lo)) < 0) { // Find item that
                if (i == hi) break;       // is < than pivot
            }

            while (a.get(lo).compareTo(a.get(--j)) < 0) { // Find item that
                if (j == lo) break;       // is > than pivot
            }

            if (i >= j) { // If i cross j the partition
                break;    // is ordered in relation to the pivot
            }

            swap(a, i, j); // Exchange the smaller than pivot
            // and the greater than pivot
            // items places
        }

        swap(a, lo, j);  // Puts pivot in his place on the collection

        return j; // return index of pivot now known to be in place
    }

    public static void sort(List<Treta> a) {
        sort(a, 0, a.size() - 1);
    }

    private static void sort(List<Treta> a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static void swap(List<Treta> a, int i, int j) {
        Treta aux = a.get(i);
        a.set(i, a.get(j));
        a.set(j, aux);
    }

    public static void main(String[] args) {

        List<Treta> tretas = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("tretas.txt"));

            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.contains("treta")) {
                    tretas.add(new Treta(line));
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e);
        } catch (ParseException e) {
            System.err.println("Parse exception: " + e);
        }


        System.out.println("Before:");
        tretas.forEach(System.out::println);

        Quicksort.sort(tretas);
        System.out.println("\nAfter");
        tretas.forEach(System.out::println);
    }
}
