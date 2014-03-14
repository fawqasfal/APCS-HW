/*
ID: omarbic1
LANG: JAVA
PROG: checker
*/
import java.util.*;
import java.io.*;

public class checker {
	static boolean[] canCol;
	static boolean[] leftDiag;
	static boolean[] rightDiag;
	static int[] answer;
	static int boardSize;
	static int printTime;
	public static void main(String[] args) throws IOException, NumberFormatException, ArrayIndexOutOfBoundsException {
		long startTime = System.currentTimeMillis();
		boardSize = 8;
		if (args.length == 0)
			System.out.println("You can pass a unique N arg when you run the program. If you don't (as you haven't now), I'll just use 8.");
		else
			boardSize = Integer.parseInt(args[0]);
		System.out.println("The board is arranged as such : ");
		for (int i = 1; i <= boardSize; i++) {
			String answer = new String();
			for (int k = 1; k <= boardSize; k++) {
				answer += k + "," + i + " ";
			}
			answer += "\n";
			System.out.print(answer);
		}
		System.out.println("Each answer is represented by it's own line and consists of " + boardSize + " pairs, each representing the coordinate" + 
			"of a queen on the board.");
		System.out.println("-------------");
		canCol = new boolean[boardSize];
		answer = new int[boardSize];
		leftDiag = new boolean[boardSize * 2];
		rightDiag = new boolean[boardSize * 2];
		printTime = 0;
		queenIt(0);
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + ((endTime - startTime) / 1000.0) + " seconds to calculate");
		System.exit(0);
	}
	public static void queenIt(int column) {
		if (column == boardSize) {
				for (int p = 0; p < boardSize - 1; p++)
					System.out.print((p + 1) + "," + (answer[p] + 1) + " ");
				System.out.print((boardSize) + "," + (answer[boardSize - 1] + 1) + "\n");
				printTime++;
				return;
			}		
		for (int row = 0; row < boardSize; row++) {
			if (!canCol[row] && !rightDiag[row + column] && !leftDiag[row - column + boardSize]) {
				canCol[row] = rightDiag[row + column] = leftDiag[row - column + boardSize] = true;
				answer[column] = row;
				queenIt(column + 1);
				canCol[row] = rightDiag[row + column] = leftDiag[row - column + boardSize] = false;
			}
		}
		return;
	}

}
