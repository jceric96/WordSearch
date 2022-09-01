public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    // cannot using index+1,beacuse it might use twice the same cell
                    if (findword(word, index, i, j, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean findword(String word, int index, int startX, int startY, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        if (startX < 0 || startX >= board.length ||
                startY < 0 || startY >= board[0].length ||
                board[startX][startY] != word.charAt(index)) {
            return false;
        }
        // remember it can use temp variable to avoid using double
        char temp = board[startX][startY];
        board[startX][startY] = '!';
        boolean findNext = (findword(word, index + 1, startX + 1, startY, board)
                || findword(word, index + 1, startX - 1, startY, board)
                || findword(word, index + 1, startX, startY + 1, board)
                || findword(word, index + 1, startX, startY - 1, board));
        board[startX][startY] = temp;
        return findNext;
    }

    public static void main(String[] args) throws Exception {
        WordSearch recur = new WordSearch();

        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };
        String word = "ABCB";
        System.out.println(recur.exist(board, word));

    }
}
