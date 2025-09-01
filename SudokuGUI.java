import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI extends JFrame {
    private JTextField[][] cells = new JTextField[9][9];
    private Sudoku sudoku;

    public SudokuGUI(Sudoku sudoku) {
        this.sudoku = sudoku;
        setTitle("Sudoku DIO");
        setSize(500, 500);
        setLayout(new GridLayout(9, 9));

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                JTextField tf = new JTextField();
                tf.setHorizontalAlignment(JTextField.CENTER);
                tf.setFont(new Font("Arial", Font.BOLD, 18));
                int finalX = x;
                int finalY = y;
                tf.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent e) {
                        String text = tf.getText();
                        if (!text.isEmpty() && text.matches("\\d")) {
                            int val = Integer.parseInt(text);
                            sudoku.setValue(finalX, finalY, val);
                            refreshBoard();
                        }
                    }
                });
                cells[y][x] = tf;
                add(tf);
            }
        }

        refreshBoard();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void refreshBoard() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                int val = sudoku.getBoard()[y][x];
                cells[y][x].setText(val == 0 ? "" : String.valueOf(val));
            }
        }
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        // Adicione os dados do tabuleiro
        String[] boardData = { "0,0;4;false", "1,0;7;false", "2,0;9;true" /* ... completar */ };
        sudoku.loadBoard(boardData);

        new SudokuGUI(sudoku);
    }
}
