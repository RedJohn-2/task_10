package denis.korchagin;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<TabletPriceList> tabletPriceLists = ListUtils.createTabletPriceList(args[0]);
        int count = readIntNumbers("count");
        double minMemory = readDoubleNumbers("minimum memory");
        int minRating = readIntNumbers("minimum rating");

        printModelAndCost(tabletPriceLists,minRating,minMemory,count);
    }

    static int readIntNumbers(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input " + str + ": ");
        return scanner.nextInt();
    }

    static double readDoubleNumbers(String str) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input " + str + ": ");
        return scanner.nextDouble();
    }

    static boolean findModelsWithCorrectMemory(TabletPriceList tabletPriceList, double minMemory) {
        return  (tabletPriceList.getAmountOfMemory() >= minMemory);
    }

    static boolean findModelsWithCorrectRating(TabletPriceList tabletPriceList, int minRating) {
        return (tabletPriceList.getRatingModel() >= minRating);
    }

    static List<TabletPriceList> createCorrectList(List<TabletPriceList> tabletPriceLists, int minRating, double minMemory) {
        List<TabletPriceList> correctList = new ArrayList<>();
        for (int i = 0; i < tabletPriceLists.size(); i++) {
            if (findModelsWithCorrectMemory(tabletPriceLists.get(i), minMemory) && findModelsWithCorrectRating(tabletPriceLists.get(i), minRating)) {
                correctList.add(tabletPriceLists.get(i));
            }
        }
        return correctList;
    }

    static TabletPriceList findModelWithMinimumCost(List<TabletPriceList> correctList) {
        int memberMinCost = 0;
        for (int i = 1; i < correctList.size(); i++) {
            if (correctList.get(i).getPrice() < correctList.get(memberMinCost).getPrice()) {
                memberMinCost = i;
            }
        }
        return correctList.get(memberMinCost);
    }

    static void printModelAndCost(List<TabletPriceList> tabletPriceLists, int minRating, double minMemory, int count) {
        if (createCorrectList(tabletPriceLists, minRating, minMemory).isEmpty()) {
            System.out.print("There are no models that satisfy the condition");
        } else {
            System.out.printf("You should buy %d tablets the model of %s, you will spend %.2f", count,
                              findModelWithMinimumCost(createCorrectList(tabletPriceLists, minRating, minMemory)).getModelName(),
                              calcCostTablets(tabletPriceLists, count, minRating, minMemory));
        }

    }

    static double calcCostTablets(List<TabletPriceList> tabletPriceLists, int count, int minRating, double minMemory) {
        return findModelWithMinimumCost(createCorrectList(tabletPriceLists, minRating, minMemory)).getPrice() * count;
    }
}
