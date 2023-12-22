import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char[][] BOARD =
            {{' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}};
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Random random = new Random();
    private static boolean HAS_CONTINUE = true;

    public static void main(String[] args) {
        begin();
    }

    private static void begin() {
        while (HAS_CONTINUE) {
            show();
            switch (INPUT.nextLine()) {
                case "1" -> playWithBot();
                case "2" -> playWithFriend();
                case "0", "exit", "Exit", "e", "ex" -> HAS_CONTINUE = false;
                default -> System.err.println("WRONG SYMBOL, INPUT AGAIN (1 or 2), for exit -> (exit, Exit, 0)");
            }
        }
    }

    private static void playWithBot() {
        while (true) {
            playerMove('❌');
            if (isGameFinished()) {
                break;
            }
            printBoard();

            botMove();
            if (isGameFinished()) {
                break;
            }
            printBoard();
        }
    }

    private static void show() {

        System.out.println("--------------------------------");
        System.out.println("--  1 - PLAY WITH AIBOT 🤖 --");
        System.out.println("--  2 - PLAY WITH FRIEND 🧑‍💻👩‍🚀 --");
        System.out.println("--- 0 - EXIT ----");
        System.out.println("--------------------------------");
        System.out.print(">> ");
    }

    private static void playWithFriend() {
        System.out.println("🎺🎺🎺 GAME STARTED !!! 🎺🎺🎺");
        printBoard();

        while (true) {
            XPlayerMove();
            if (isGameFinished()) {
                break;
            }
            printBoard();

            OPlayerMove();
            if (isGameFinished()) {
                break;
            }
            printBoard();
        }

    }

    private static void OPlayerMove() {
        System.out.print("PLAYER ⭕ ");
        playerMove('⭕');
    }

    private static void XPlayerMove() {
        System.out.print("PLAYER  ❌ ");
        playerMove('❌');
    }


    private static boolean isGameFinished() {

        if (hasSomeOneWin('❌')) {
            printBoard();
            System.out.println("==========================");
            System.out.println("=== ❌ PLAYER WINS! 🎺 ===");
            System.out.println("==========================");
            System.out.println("👏👏👏👏👏👏👏👏👏👏👏👏");
            return true;
        }

        if (hasSomeOneWin('⭕')) {
            printBoard();
            System.out.println("==========================");
            System.out.println("=== ⭕ PLAYER WINS! 🎺 ===");
            System.out.println("==========================");
            System.out.println("👏👏👏👏👏👏👏👏👏👏👏👏");
            return true;
        }

        for (int i = 0; i < BOARD.length; i++) {
            for (int j = 0; j < BOARD[i].length; j++) {
                if (BOARD[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard();
        System.out.println("==================================");
        System.out.println("== THE GAME ENDED DRAW! ❌🤝⭕ ==");
        System.out.println("==================================");
        return true;
    }

    private static boolean hasSomeOneWin(char symbol) {
        if ((BOARD[0][0] == symbol && BOARD[0][1] == symbol && BOARD[0][2] == symbol) || (BOARD[1][0] == symbol && BOARD[1][1] == symbol && BOARD[1][2] == symbol) || (BOARD[2][0] == symbol && BOARD[2][1] == symbol && BOARD[2][2] == symbol) ||

            (BOARD[0][0] == symbol && BOARD[1][0] == symbol && BOARD[2][0] == symbol) || (BOARD[0][1] == symbol && BOARD[1][1] == symbol && BOARD[2][1] == symbol) || (BOARD[0][2] == symbol && BOARD[1][2] == symbol && BOARD[2][2] == symbol) ||

            (BOARD[0][0] == symbol && BOARD[1][1] == symbol && BOARD[2][2] == symbol) || (BOARD[0][2] == symbol && BOARD[1][1] == symbol && BOARD[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    private static void botMove() {
        int computerMove;
        do {
            computerMove = random.nextInt(0, 10);
        } while (!isValidMove(Integer.toString(computerMove)));
        System.out.println("BOT HAS CHOSEN " + computerMove + " 🤖");
        move(Integer.toString(computerMove), '⭕');
    }

    private static boolean isValidMove(String position) {

        switch (position) {
            case "1":
                return (BOARD[0][0] == ' ');
            case "2":
                return (BOARD[0][1] == ' ');
            case "3":
                return (BOARD[0][2] == ' ');
            case "4":
                return (BOARD[1][0] == ' ');
            case "5":
                return (BOARD[1][1] == ' ');
            case "6":
                return (BOARD[1][2] == ' ');
            case "7":
                return (BOARD[2][0] == ' ');
            case "8":
                return (BOARD[2][1] == ' ');
            case "9":
                return (BOARD[2][2] == ' ');
            default:
                System.err.println("WRONG INPUT, INPUT AGAIN!!!");
                return false;
        }
    }

    private static void playerMove(char symbol) {
        String userInput;
        while (true) {
            System.out.println("INPUT NUMBER (interval 1-9)");
            System.out.print(">> ");
            userInput = INPUT.nextLine();
            if (userInput.startsWith("e") || userInput.contains("E")) {
                HAS_CONTINUE = false;
                begin();
            }
            if (isValidMove(userInput)) {
                break;
            } else {
                System.err.println(userInput + " IS INVALID, INPUT AGAIN !!!  or input (exit, Exit, e, ex) for exit");
            }
        }
        move(userInput, symbol);
    }

    private static void move(String position, char symbol) {
        switch (position) {
            case "1" -> BOARD[0][0] = symbol;
            case "2" -> BOARD[0][1] = symbol;
            case "3" -> BOARD[0][2] = symbol;
            case "4" -> BOARD[1][0] = symbol;
            case "5" -> BOARD[1][1] = symbol;
            case "6" -> BOARD[1][2] = symbol;
            case "7" -> BOARD[2][0] = symbol;
            case "8" -> BOARD[2][1] = symbol;
            case "9" -> BOARD[2][2] = symbol;
            default -> System.err.println("WRONG SYMBOL");
        }
    }

    private static void printBoard() {
        System.out.println("- - - - - - - - - -");
        System.out.println("| " + BOARD[0][0] + " | " + BOARD[0][1] + " | " + BOARD[0][2] + " |");
        System.out.println("- - - - - - - - - -");
        System.out.println("| " + BOARD[1][0] + " | " + BOARD[1][1] + " | " + BOARD[1][2] + " |");
        System.out.println("- - - - - - - - - -");
        System.out.println("| " + BOARD[2][0] + " | " + BOARD[2][1] + " | " + BOARD[2][2] + " |");
        System.out.println("- - - - - - - - - -");
    }
}
