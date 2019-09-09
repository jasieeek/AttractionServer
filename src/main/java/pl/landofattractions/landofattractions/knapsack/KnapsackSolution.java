package pl.landofattractions.landofattractions.knapsack;

import java.util.Collections;
import java.util.List;

public class KnapsackSolution {
   
   String approach;
   List<Item> items;
   double weight;
   double value;
   
   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append(approach);
      builder.append(": ");
      builder.append(value);
      builder.append(" ");
      builder.append(weight);
      builder.append("\n");
      
      Collections.sort(items, Item.byLabel());
      
      for (Item item : items) {
         builder.append(item.label);
         builder.append(" ");
      }
      
      return builder.toString();
   }
}
