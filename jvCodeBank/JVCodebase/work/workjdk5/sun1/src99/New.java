   import java.util.*;

   public class New {
     public static void main(String args[]) {
       List<String> list = Arrays.asList(args);
       for (String element : list) {
         System.out.println(element + " / " + element.length());
       }
     }
   }
