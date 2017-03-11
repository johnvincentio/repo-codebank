   class PreVarGridLayout {

      PreVarGridLayout() {
         this(1, 1);
      }

      PreVarGridLayout(int rows, int cols) {
         this(rows, cols, 0, 0);
      }  

      PreVarGridLayout(int rows, int cols, int hgap, int vgap) {
         System.out.println("Create a grid with rows = "
         + rows + " and cols = " + cols + ", the hgap = "
         + hgap + " and the vgap = " + vgap + ".");
      }

      public static void main(String[] args) {
         System.out.println("Call no arg constructor:");
         new PreVarGridLayout();
         System.out.println("Call two arg constructor: 2,3");
         new PreVarGridLayout(2, 3);
         System.out.println
            ("Call four arg constructor: 4,5,6,7");
         new PreVarGridLayout(4, 5, 6, 7);
      }
   }

