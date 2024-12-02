import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Path.of("C:\\Users\\nicki\\Documents\\AdventOfCode24\\AdventOfCode24\\Day1\\src\\input.txt"));

        ArrayList<String> list1 = new ArrayList<>(), list2 = new ArrayList<>();

        for(String i : input) {
            String[] splitted = i.split(" +");
            list1.add(splitted[0]);
            list2.add(splitted[1]);
        }

        List<Integer> listASorted = list1.stream().map(Integer::valueOf).sorted().toList();
        List<Integer> listBSorted = list2.stream().map(Integer::valueOf).sorted().toList();

        int sum = 0;

        for(int i = 0; i < listASorted.size(); ++i) {
            int numberCount = 0;
            int currentNumber = listASorted.get(i);
            for(int x : listBSorted) {
                if(x == currentNumber) {
                    numberCount++;
                }
            }
            sum += listASorted.get(i) * numberCount;
        }

        System.out.println(sum);
    }
}