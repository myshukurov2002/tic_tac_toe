public class Main {
    public static void main(String[] args) {
            char[][] game_board = {
                    {'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '8'}
            };
        System.out.println(game_board[0][0] + "|" + game_board[0][1] + "|" + game_board[0][2]);
        System.out.println("-----");
        System.out.println(game_board[1][0] + "|" + game_board[1][1] + "|" + game_board[1][2]);
        System.out.println("-----");
        System.out.println(game_board[2][0] + "|" + game_board[2][1] + "|" + game_board[2][2]);
    }

}
