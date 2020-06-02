import java.util.Scanner;

public class Sudoku {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int num = scanner.nextInt();
        scanner.nextLine();
        int size = num * num;
        int[][] sudoku = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int put = scanner.nextInt();
                if (put > size || put < 1) {
                    System.out.println("NO");
                    return;
                }
                sudoku[i][j] = put;
            }
        }

        boolean isCorrect = true;
        int[] setNumbers = new int[size];
        int[] checkNumbers = new int[size];

        int index = 1;
        for (int i = 0; i < setNumbers.length; i++) {
            setNumbers[i] = index;
            checkNumbers[i] = index;
            index++;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (sudoku[i][j] > size || sudoku[i][j] <= 0) {
                        System.out.println("NO");
                        return;
                    } else if (sudoku[i][j] == setNumbers[k]) {
                        if (checkNumbers[k] == -1) {
                            isCorrect = false;
                            break;
                        }
                        checkNumbers[k] = -1;
                    }
                }
            }
            if (!isCorrect) {
                break;
            }
            setNumberArray(checkNumbers);
        }

        setNumberArray(setNumbers);
        setNumberArray(checkNumbers);

        int[][] reverseSudoku = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                reverseSudoku[i][j] = sudoku[j][i];
            }
        }

        boolean isR = isReverse(size, sudoku, setNumbers);
        boolean isRR = isReverse(size, reverseSudoku, setNumbers);
        if (isR && isRR) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (reverseSudoku[i][j] > size || reverseSudoku[i][j] <= 0) {
                        System.out.println("NO");
                        return;
                    } else if (reverseSudoku[i][j] == setNumbers[k]) {
                        if (checkNumbers[k] == -1) {
                            isCorrect = false;
                            break;
                        }
                        checkNumbers[k] = -1;
                    }
                }
            }
            if (!isCorrect) {
                break;
            }
            setNumberArray(checkNumbers);
        }
        if (isCorrect) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isReverse(int size, int[][] sudoku, int[] setNumbers) {
        boolean isR = false;
        for (int i = 0; i < size - 1; i++) {
            if (sudoku[0][i + 1] - 1 == setNumbers[i]) {
                isR = true;
            } else {
                isR = false;
                break;
            }
        }
        return isR;
    }

    private static void setNumberArray(int[] setNumbers) {
        int index = 1;
        for (int i = 0; i < setNumbers.length; i++) {
            setNumbers[i] = index;
            index++;
        }
    }
}
