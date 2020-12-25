package denis.korchagin;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class ListUtils {

    public static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines.toArray(new String[0]);
    }

    public static String[] toStringArray(String str) {
        String[] arr = str.split("[,;]");
        return arr;
    }

    public static List<TabletPriceList> createTabletPriceList(String fileName) throws FileNotFoundException {
        String[] lines = readLinesFromFile(fileName);
        List<TabletPriceList> tabletPriceLists = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            tabletPriceLists.add(new TabletPriceList());
            String[] words = toStringArray(lines[i]);
            tabletPriceLists.get(i).setModelName(words[0]);
            tabletPriceLists.get(i).setAmountOfMemory(Double.parseDouble(words[1].trim()));
            tabletPriceLists.get(i).setRatingModel(Integer.parseInt(words[2].trim()));
            tabletPriceLists.get(i).setPrice(Double.parseDouble(words[3].trim()));
        }
        return tabletPriceLists;
    }

}
