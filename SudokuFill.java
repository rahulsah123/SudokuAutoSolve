import java.util.Scanner;
import java.lang.String;
class SudokuFill
{
	static Scanner sc = new Scanner(System.in);
	
     int r1=0;int c1=0;
	boolean solveSudoku(int[][] grid){
	int row=0,column=0;
	if(!isTherenNoPalceToFill(grid))
		return true;
	row=r1;column=c1;
	for(int i=1;i<=9;i++)
		{
	    if(canPlace(grid,row,column,i)){
		grid[row][column]=i;
		if(solveSudoku(grid))
			return true;
		grid[row][column]=0;
		}
	}
	return false;
	}
     boolean isTherenNoPalceToFill(int[][] grid){
	 for(int i=0;i<9;i++)
		 for(int j=0;j<9;j++)
		 if(grid[i][j]==0)
		 {r1=i;c1=j;return true;}
	 return false;
	 }

	 boolean isInRow(int[][] grid,int r,int num){
	 for(int i=0;i<9;i++){
	 if(grid[r][i]==num)
		 return true;
	 }
	 return false;
	 }
	 
	 
	 boolean isInCol(int[][] grid,int c,int num){
	 for(int i=0;i<9;i++){
	 if(grid[i][c]==num)
		 return true;
	 }
	 return false;
	 }

	 boolean isInBox(int[][] grid,int r,int c,int num){
	 for(int i=0;i<3;i++){
	 for(int j=0;j<3;j++){
		 if(grid[i+r][j+c]==num)
			 return true;
	        }
	    }
	 return false;
	 }


	 boolean canPlace(int[][] grid,int row,int col,int num){
	 if(!isInRow(grid,row,num)&&!isInCol(grid,col,num)&&!isInBox(grid,row-row%3,col-col%3, num))
		 return true;
	 return false;
	 }


	public static void main(String[] args)throws Exception{
	int[][] grid=new int[9][9];
	int t=1;
	try{
	while(t==1)
		{
		System.out.println("Enter (x,y) and value:");
		int a=sc.nextInt();a=a-1;
		int b=sc.nextInt();b=b-1;
		int value=sc.nextInt();
		grid[a][b]=value;
		System.out.println("Do you want again if yes hit 1 else hit any key");
		t=sc.nextInt();
	}
	}
	catch(Exception e){}
	SudokuFill sk=new SudokuFill();
	if(sk.solveSudoku(grid)==true)
		{
		for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
		System.out.print(grid[i][j]+" ");
		}System.out.println();
		}
	}
	else
		System.out.println("There is no solutions:");
	}
}