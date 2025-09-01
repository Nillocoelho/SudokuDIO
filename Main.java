import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();

        // Exemplo de tabuleiro (adicione todos os dados que você enviou)
        String[] boardData = {
            "0,0;4;false", "1,0;7;false", "2,0;9;true", "3,0;5;false", 
            "4,0;8;true", "5,0;6;true", "6,0;2;true", "7,0;3;false", "8,0;1;false",
            "0,1;1;false", "1,1;3;true", "2,1;5;false" // ... completar
        };

        sudoku.loadBoard(boardData);

        Scanner sc = new Scanner(System.in);
        while (true) {
            sudoku.display();
            System.out.print("Coluna (0-8): ");
            int x = sc.nextInt();
            System.out.print("Linha (0-8): ");
            int y = sc.nextInt();
            System.out.print("Valor (1-9): ");
            int val = sc.nextInt();

            if (sudoku.setValue(x, y, val)) {
                System.out.println("Valor adicionado!");
            } else {
                System.out.println("Movimento inválido!");
            }
        }
    }
}
