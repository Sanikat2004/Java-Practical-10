class SudokuPuzzle{
 static String [][] layout;
 int i=0,j=0;
   void displayGrid(int size,String[][] layout)
   {
     for(int ln=1;ln<=2*size+1;ln++)
     {
       for(int symbols=1;symbols<=2*size+1;symbols++)
       {
         if(size<10){
         if(ln%2!=0&&symbols%2!=0)
         {
           System.out.print(" ");
         }
         else if(ln%2==0&&symbols%2!=0)
         {
           System.out.print("|");
         }
         else if(ln%2==0&&symbols%2==0)
         {
           if(j==size)
           {
             i++;
             j=0;
           }
           System.out.print(layout[i][j]);
           j++;
          } 
         else if(symbols%2==0&&ln%2!=0)
         {
            System.out.print("_");
         }
       }
      else{
      if(ln%2!=0&&symbols%2!=0)
         {
           System.out.print(" ");
         }
         else if(ln%2==0&&symbols%2!=0)
         {
           System.out.print("|");
         }
          else if(ln%2==0&&symbols%2==0)
         {
           if(j==size)
           {
             i++;
             j=0;
           }
           System.out.printf("%2s",layout[i][j]);
           j++;
          } 
         else if(symbols%2==0&&ln%2!=0)
         {
            System.out.print("__");
         }
        }
      }
       System.out.println();
     }
   }
 SudokuPuzzle(int size)
  {
    layout=new String[size][size];
    for(int i=0;i<size;i++)
    {
      for(int j=0;j<size;j++)
      {
        layout[i][j]=String.valueOf((i+j)%size+1);
      }
    }
    removeElements(size,layout);
  }
  String[][] removeElements(int size, String[][] layout)
  {
    int remove_elements=(size)*(size)/3;
    for(int value=1; value<=remove_elements;value++)
    {
     layout[(int)System.nanoTime()%layout.length][(int)System.nanoTime()%layout.length]=" ";
    }
    return layout;
  }       
  public static void main(String args[])
  {
    int size=Integer.parseInt(args[0]);
    SudokuPuzzle s= new SudokuPuzzle(size);
    s.displayGrid(size,layout);
  }
} 
