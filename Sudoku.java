public class Sudoku {
    private int[][] board;
    private boolean[][] fixed;

    public Sudoku() {
        board = new int[9][9];
        fixed = new boolean[9][9];
    }

    // Carregar dados no formato "0,0;4;false"
    public void loadBoard(String[] data) {
        for (String entry : data) {
            String[] parts = entry.split(";");
            String[] pos = parts[0].split(",");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            int val = Integer.parseInt(parts[1]);
            boolean isFixed = Boolean.parseBoolean(parts[2]);
            board[y][x] = val;
            fixed[y][x] = isFixed;
        }
    }

    public boolean setValue(int x, int y, int val) {
        if (!fixed[y][x] && isValidMove(x, y, val)) {
            board[y][x] = val;
            return true;
        }
        return false;
    }

    public boolean isValidMove(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == val || board[i][x] == val)
                return false;
        }

        int bx = (x / 3) * 3;
        int by = (y / 3) * 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[by + i][bx + j] == val)
                    return false;

        return true;
    }

    public void display() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(board[y][x] == 0 ? ". " : board[y][x] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getBoard() {
        return board;
    }

}
