import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] playField = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', '-', '-', '-', '-', '-', '-', '-'},
                {' ', ' ', '|', '1', '|', '2', '|', '3', '|'},
                {' ', ' ', '|', '-', '-', '-', '-', '-', '|'},
                {' ', ' ', '|', '4', '|', '5', '|', '6', '|'},
                {' ', ' ', '|', '-', '-', '-', '-', '-', '|'},
                {' ', ' ', '|', '7', '|', '8', '|', '9', '|'},
                {' ', ' ', '-', '-', '-', '-', '-', '-', '-'}
        };
        drawPlayField(playField);
        boolean specifiedPositionOK;
        int numberOfIncorrectEntry = 0;
        char player = 'X';
        while (isFreePosition(playField)) {
            specifiedPositionOK = markField(player, scanner, playField);
            if (specifiedPositionOK) {
                numberOfIncorrectEntry = 0;
            } else {
                if (++numberOfIncorrectEntry == 3) {
                    System.out.println("Three incorrectly entered positions. Exit.");
                    break;
                }
            }
            drawPlayField(playField);
            if (isWin(playField)) {
                System.out.println("Player " + player + " is winner.");
                break;
            }
            if (!isFreePosition(playField)) {
                System.out.println("Can't decide. The game without a knight.");
                break;
            }
            if (specifiedPositionOK) {
                player = player == 'X' ? 'O' : 'X';
            }
        }
    }

    public static void drawPlayField(char[][] playField) {
        for (int i = 0; i < playField.length; i++) {
            for (int j = 0; j < playField[i].length; j++) {
                System.out.print(playField[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean markField(char player, Scanner scanner, char[][] playField) {
        boolean specifiedPositionOK = false;
        String specifiedPosition;
        System.out.println("Player " + player + " - enter the position number:");
        specifiedPosition = scanner.next();
        switch (specifiedPosition) {
            case "1":
                if (positionNumberCheck(specifiedPosition, playField[2][3])) {
                    playField[2][3] = player;
                    specifiedPositionOK = true;
                }
                break;
            case "2":
                if (positionNumberCheck(specifiedPosition, playField[2][5])) {
                    playField[2][5] = player;
                    specifiedPositionOK = true;
                }
                break;
            case "3":
                if (positionNumberCheck(specifiedPosition, playField[2][7])) {
                    playField[2][7] = player;
                    specifiedPositionOK = true;
                }
                break;
            case "4":
                if (positionNumberCheck(specifiedPosition, playField[4][3])) {
                    playField[4][3] = player;
                    specifiedPositionOK = true;
                }
                break;
            case "5":
                if (positionNumberCheck(specifiedPosition, playField[4][5])) {
                    playField[4][5] = player;
                    specifiedPositionOK = true;
                }
                break;
            case "6":
                if (positionNumberCheck(specifiedPosition, playField[4][7])) {
                    playField[4][7] = player;
                    specifiedPositionOK = true;
                }
                break;
            case "7":
                if (positionNumberCheck(specifiedPosition, playField[6][3])) {
                    playField[6][3] = player;
                    specifiedPositionOK = true;
                }
                break;
            case "8":
                if (positionNumberCheck(specifiedPosition, playField[6][5])) {
                    playField[6][5] = player;
                    specifiedPositionOK = true;
                }
                break;
            case "9":
                if (positionNumberCheck(specifiedPosition, playField[6][7])) {
                    playField[6][7] = player;
                    specifiedPositionOK = true;
                }
                break;
            default:
                System.out.println("Bad position " + specifiedPosition + ". A valid value is a number in the range 1-9.");

        }
        return specifiedPositionOK;
    }

    public static boolean positionNumberCheck(String positionNumber, char positionValue) {
        if (positionValue == 'X' || positionValue == 'O') {
            System.out.println("Position " + positionNumber + " is filled " + positionValue + ".");
            return false;
        }
        return true;
    }

    public static boolean isWin(char[][] playField) {
        return (// row
                (playField[2][3] == playField[2][5] && playField[2][3] == playField[2][7]) ||
                (playField[4][3] == playField[4][5] && playField[4][3] == playField[4][7]) ||
                (playField[6][3] == playField[6][5] && playField[6][3] == playField[6][7]) ||
                // column
                (playField[2][3] == playField[4][3] && playField[2][3] == playField[6][3]) ||
                (playField[2][5] == playField[4][5] && playField[2][5] == playField[6][5]) ||
                (playField[2][7] == playField[4][7] && playField[2][7] == playField[6][7]) ||
                // diagonal
                (playField[2][3] == playField[4][5] && playField[2][3] == playField[6][7]) ||
                (playField[6][3] == playField[4][5] && playField[6][3] == playField[2][7]));
    }

    public static boolean isFreePosition(char[][] playField) {
       return !((playField[2][3] == 'X' || playField[2][3] == 'O') &&
                (playField[2][5] == 'X' || playField[2][5] == 'O') &&
                (playField[2][7] == 'X' || playField[2][7] == 'O') &&
                (playField[4][3] == 'X' || playField[4][3] == 'O') &&
                (playField[4][5] == 'X' || playField[4][5] == 'O') &&
                (playField[4][7] == 'X' || playField[4][7] == 'O') &&
                (playField[6][3] == 'X' || playField[6][3] == 'O') &&
                (playField[6][5] == 'X' || playField[6][5] == 'O') &&
                (playField[6][7] == 'X' || playField[6][7] == 'O'));
    }
}