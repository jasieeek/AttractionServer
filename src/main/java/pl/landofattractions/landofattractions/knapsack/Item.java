package pl.landofattractions.landofattractions.knapsack;

import java.util.Comparator;

public class Item {

   public static Comparator<Item> byLabel() {
      return new Comparator<Item>() {
         public int compare(Item i1, Item i2) {
            return i1.label - i2.label;
         }
      };
   }
   
   public static Comparator<Item> byRatio() {
      return new Comparator<Item>() {
         public int compare(Item i1, Item i2) {
            return Double.compare(i2.getRatio(), i1.getRatio());
         }
      };
   }
   
   public int label;
   public double value;
   public double weight;
   
   public double getRatio() {
      return Math.sqrt(weight) / value;
   }

   @Override
   public String toString() {
      return "Item{" +
              label + "; " +
              value + "; " +
              weight + "; " +
              getRatio() + "}\n";
   }
}
