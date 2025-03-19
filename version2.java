import java.util.Scanner;
class SudokuPuzzle{
 static String [][] layout;
 int i=0,j=0;
   void displayGrid(int size,String[][] layout)
   {
     i=0;
     j=0;
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
  void fillEmptyCell(int size,Scanner sc){
  for(int row=0;row<size;row++)
  {
    for(int colunm=0;colunm<size;colunm++)
    {
      if(layout[row][colunm].equals(" "))
      {
        System.out.println(String.format("Enter a number in the empty cell at position (%d, %d):", row , colunm));

        String num=sc.nextLine();
        while (!isValid(size, row, colunm, num)) {
            System.out.println("Invalid number!! Enter another number");
            num = sc.nextLine(); 
           }
        layout[row][colunm] = String.valueOf(num);
        displayGrid(size, layout);
      }
     }
   }
    System.out.println("Congratulations!! Successfully completed....");
 }
 boolean isValid(int size, int row, int colunm, String num){
  for(int rowindex=0;rowindex<size;rowindex++){
   if(layout[rowindex][colunm].equals(num)) {
    return false;
    }
  }
  for (int colunmindex = 0; colunmindex < size; colunmindex++) {
     if(layout[row][colunmindex].equals(num)) {
      return false;
      }
   }
    return true;
    }  
  public static void main(String args[])
  {
    int size=Integer.parseInt(args[0]);
    SudokuPuzzle s= new SudokuPuzzle(size);
    s.displayGrid(size,layout);
    Scanner sc=new Scanner(System.in);
    s.fillEmptyCell(size, sc);
  }
} 
