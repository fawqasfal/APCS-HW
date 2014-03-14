public class Knight {
    private int[][] board;
    private int n;
    private int counter;
    private boolean solved;
    static int[][] pairs = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}}; //move pairs

    public static void main(String[] args) throws NumberFormatException {
		int setNum = 8;
		if (args.length == 0) 
			System.out.println("You can pass a board-size as a parameter if you want. Just run 'java Knight $int'. I'll use 8 for now.");
		else
			setNum = Integer.parseInt(args[0]);
		Knight newKnight = new Knight(setNum);
		System.out.println("The board, with each number N on the grid being the Nth spot the Knight goes to");
		newKnight.dfs(0,0);
		System.out.println(newKnight.toString());
	}

    public Knight(int n) {
    	board = new int[n][n];
		this.n = n;
    }

    public void dfs(int x, int y) {
		boolean inBounds = x >= 0 && x < n && y >= 0 && y < n;
		if (!inBounds || board[x][y] != 0 || solved) 
	    	return;
	    
	    this.board[x][y] = counter++;
	    if (counter == n*n) 
	    	solved = true;

	    //instead of wall-of-tail-recursive-calls, i put them in a loop
	   	for (int i = 0; i < pairs.length && !solved; i ++)  
	    	dfs(x + pairs[i][0],y + pairs[i][1]);
	
		//necessary backtrack resetting
		if (!solved) {
			board[x][y] = 0;
			counter--;
		}
 	}


    public String toString() {
		String answer = new String();
		for (int x = 0; x < n; x++) {
	 	   for (int y = 0; y < n; y++)
			answer += equalSize(board[x][y] + 1) + " ";
		answer += "\n";
		}
		return answer;
    }

    public String equalSize(int num) {
		/* insert spaces into smaller digits to 
		align print-out of board so it's rectangular and each digit takes up the same amt of space regardless of size 
		('555' takes same amt of space as '  1') */
		String answer = new String();
		int extraSpace = (int) Math.log10(this.n * this.n) - (int) Math.log10(num); //amt of digits of maxNum - amts of digits of thisNum = needed spaces
		for (int i = 0; i < extraSpace; i++)
			answer += ' ';
		return answer + num;
	}
    
}
	