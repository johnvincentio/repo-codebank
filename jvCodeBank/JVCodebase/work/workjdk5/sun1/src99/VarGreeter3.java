   public class VarGreeter3 {

       public static void printGreeting(String... names) {
          for (String n : names) {
               System.out.println("Hello " + n + ". "); 
          }
       }

       public static void main(String... args) {
          printGreeting(args);
       }
   }
