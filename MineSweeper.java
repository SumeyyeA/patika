import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    private int rowSize;
    private int columnSize;
    private int[][] board;
    private boolean[][] revealed;
    private boolean gameOver;
    
    public MineSweeper(int rowSize, int columnSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        this.board = new int[rowSize][columnSize];
        this.revealed = new boolean[rowSize][columnSize];
        this.gameOver = false;
    }
    
    public void run() {
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        initializeBoard();
        printBoard();
        
        while (!gameOver) {
            int row = getRowInput();
            int column = getColumnInput();
            revealCell(row, column);
            printBoard();
            
            if (gameOver) {
                System.out.println("Game Over!!");
            } else if (isGameWon()) {
                System.out.println("Oyunu Kazandınız !");
            }
        }
    }
    
    private void initializeBoard() {
        int totalCells = rowSize * columnSize;
        int totalMines = totalCells / 4;
        Random random = new Random();
        
        for (int i = 0; i < totalMines; i++) {
            int row, column;
            
            do {
                row = random.nextInt(rowSize);
                column = random.nextInt(columnSize);
            } while (board[row][column] == -1);
            
            board[row][column] = -1;
        }
        
        calculateCellValues();
    }
    
    private void calculateCellValues() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (board[i][j] != -1) {
                    int count = 0;
                    
                    if (i > 0 && board[i - 1][j] == -1) // Up
                        count++;
                    if (i < rowSize - 1 && board[i + 1][j] == -1) // Down
                        count++;
                    if (j > 0 && board[i][j - 1] == -1) // Left
                        count++;
                    if (j < columnSize - 1 && board[i][j + 1] == -1) // Right
                        count++;
                    if (i > 0 && j > 0 && board[i - 1][j - 1] == -1) // Top Left
                        count++;
                    if (i > 0 && j < columnSize - 1 && board[i - 1][j + 1] == -1) // Top Right
                        count++;
                    if (i < rowSize - 1 && j > 0 && board[i + 1][j - 1] == -1) // Bottom Left
                        count++;
                    if (i < rowSize - 1 && j < columnSize - 1 && board[i + 1][j + 1] == -1) // Bottom Right
                        count++;
                    
                    board[i][j] = count;
                }
            }
        }
    }
    
    private void revealCell(int row, int column) {
        if (row < 0 || row >= rowSize || column < 0 || column >= columnSize || revealed[row][column])
            return;
        
        revealed[row][column] = true;
        
        if (board[row][column] == -1) {
            gameOver = true;
        } else if (board[row][column] == 0) {
            revealCell(row - 1, column); // Up
            revealCell(row + 1, column); // Down
            revealCell(row, column - 1); // Left
            revealCell(row, column + 1); // Right
            revealCell(row - 1, column - 1); // Top Left
            revealCell(row - 1, column + 1); // Top Right
            revealCell(row + 1, column - 1); // Bottom Left
            revealCell(row + 1, column + 1); // Bottom Right
        }
    }
    
    private int getRowInput() {
        Scanner scanner = new Scanner(System.in);
        int row;
        
        do {
            System.out.print("Satır Giriniz: ");
            row = scanner.nextInt();
        } while (row < 0 || row >= rowSize);
        
        return row;
    }
    
    private int getColumnInput() {
        Scanner scanner = new Scanner(System.in);
        int column;
        
        do {
            System.out.print("Sütun Giriniz: ");
            column = scanner.nextInt();
        } while (column < 0 || column >= columnSize);
        
        return column;
    }
    
    private void printBoard() {
        System.out.println("===========================");
        
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (revealed[i][j]) {
                    if (board[i][j] == -1)
                        System.out.print("* ");
                    else
                        System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            
            System.out.println();
        }
        
        System.out.println("===========================");
    }
    
    private boolean isGameWon() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (board[i][j] != -1 && !revealed[i][j])
                    return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        MineSweeper game = new MineSweeper(3, 3);
        game.run();
    }
}
