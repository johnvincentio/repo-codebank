   public class CoinValueVisitor extends CoinVisitor {
     void visitPenny(Coin4 c){
       System.out.println("A penny has value = 1.");
     }
     void visitNickel(Coin4 c){
       System.out.println("A nickel has value = 5.");
     }
     void visitDime(Coin4 c) {
       System.out.println("A dime has value = 10.");
     }
     void visitQuarter(Coin4 c) {
       System.out.println("A quarter has value = 25.");
     }
   }
