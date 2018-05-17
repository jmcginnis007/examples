package com.example.exercises;

public class Matrix {

	public static void main(String[] args) {
		int rowSize = 10;
		int colSize = 10;
		for (int startRow = 0; startRow < rowSize; startRow++)
			for (int startCol = 0; startCol < colSize; startCol++)
				for (int destRow = 0; destRow < rowSize; destRow++)
					for (int destCol = 0; destCol < colSize; destCol++)
					{
						System.out.print("moves from (" + startRow + "," + startCol + ") to (" + destRow + "," + destCol + ")=");
						System.out.println(getMoves(startRow, startCol, destRow, destCol));
					}
						
	}
	
	private static int getMoves(int startRow, int startCol, int destRow, int destCol)
	{
		int moves = 0;
		
		if (startRow == destRow) return Math.abs(startCol - destCol);
		if (startCol == destCol) return Math.abs(startRow - destRow);
		
		int rowIncrementer = 1;
		int colIncrementer = 1;
		if (startRow > destRow) rowIncrementer = -1;
		if (startCol > destCol) colIncrementer = -1;
		
		int currentRow = startRow;
		int currentCol = startCol;
		
		while (currentRow != destRow && currentCol!= destCol)
		{
			currentRow+= rowIncrementer;
			currentCol+= colIncrementer;
			moves++;
		}
		moves+= Math.abs(currentCol - destCol) +  Math.abs(currentRow - destRow);
		
		return moves;
	}
	

}
