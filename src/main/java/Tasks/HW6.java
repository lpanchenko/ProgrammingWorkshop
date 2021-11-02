package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class HW6 {
//    Сегодня мы играем в крестики-нолики. Но для того, чтобы в них играть, сначала придется их написать.
//    Суть игры в следующем. Есть условное поле три-на-три, я предлагаю нумеровать клеточки следующим образом:
//            1 2 3
//            4 5 6
//            7 8 9
//    Человек играет за крестики, то есть делает ход первым. Компьютер - за нолики. Когда ходит человек, программа должна
//    просить ввести номер ячейки, на которое человек хочет поставить свой крестик. Если поле занято, компьютер должен
//    просить ввести другое число. После хода человека программа должна вывести текущее состояние поля. Например, я
//    решил поставить крестик на поле номер 5. Лог будет следующим:
//    Человек поставил крестик на клетку 5.
//            1 2 3
//            4 X 6
//            7 8 9
//    После этого компьютер спрашивает - это конец игры? Человеку надо ввести Y в случае, если кто-то победил или если на поле закончились свободные клеточки. В другом случае - N.
//    Если ввели Y, игра заканчивается, программа останавливается. Иначе начинается ход компьютера.
//    Компьютер выбирает поле по очень простому алгоритму - он занимает клеточку с наименьшею цифрой. То есть в нашем случае ходит на клеточку 1. Лог программы следующий:
//    Компьютер поставил нолик на клетку 1.
//             O 2 3
//             4 X 6
//             7 8 9
//    Далее программа снова спрашивает, закончилась ли игра. Снова вводим Y или N. Если ввели Y - игра заканчивается.
//    Иначе снова начинается ход человека, у которого программа снова должна спросить, на какую клетку он ходит.
//    Важный момент - после каждого хода, человека или компьютера, нужно распечатывать текущее состояние поля.
//    Задача решается при помощи массива из трех массивов. :)

    public static void main(String[] args) throws InterruptedException, IOException {
        {

            do {
                var state = GetInitialState();
                PrintState(state);
                do
                {
                    int cellNum = AskCellNum();
                    while (!isTheCellAvailable(state, cellNum))
                    {
                        cellNum = AskCellNum();
                    }

                    SwitchCell(state, cellNum, "X");
                    PrintState(state);
                    if (!ShouldWeContinue())
                        break;

                    cellNum = PickComputerCellNum(state);
                    SwitchCell(state, cellNum, "O");
                    PrintState(state);

                    if (!ShouldWeContinue())
                        break;
                } while(true);
            } while (ShouldWeStartAnotherGame());
        }
    }

    private static boolean isTheCellAvailable(int[][] state, int cellNum) {

        int column = getColumn(cellNum);
        int row = getRow(cellNum);

        if (state[row][column] <= 0)
            return false;
        return true;
    }

    private static int getRow(int cellNum) {

        if (cellNum <= 3)
            return 0;
        if (cellNum <= 6)
            return 1;
        return 2;
    }

    private static int getColumn(int cellNum) {
        if (cellNum <= 3)
            return cellNum - 1;
        if (cellNum <= 6)
            return cellNum - 4;
        return cellNum - 7;
    }

    private static int PickComputerCellNum(int[][] state) {

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (state[i][j] > 0)
                    return (i * 3 + j + 1);
            }
        }
        System.out.println("No available cells");
        return -1;
    }

    private static boolean ShouldWeContinue() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Should we continue? Y/N");
        String answer = br.readLine();
        if (Objects.equals(answer, "Y"))
            return true;
        return false;
    }

    private static void SwitchCell(int[][] state, int cellNum, String x) {

        int columnIdx = getColumn(cellNum);
        int rowIdx = getRow(cellNum);

        if (x.equals("X"))
            state[rowIdx][columnIdx] = state[rowIdx][columnIdx] * -1;
        else
            state[rowIdx][columnIdx] = 0;
    }

    private static int AskCellNum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Your turn, human. Enter the cell number: ");

        int answer = Integer.parseInt(br.readLine());
        return answer;
    }

    public static boolean ShouldWeStartAnotherGame() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Should we start another game? Y/N");

        String answer = br.readLine();

        if (answer.equals("Y"))
            return true;
        return false;
    }

    public static void PrintState(int[][] state) {

        for (int i = 0; i < state.length; i++)
        {
            for (int j = 0; j < state[i].length; j++)
            {
                if (state[i][j] < 0)
                    System.out.print("X");
                else
                    System.out.print(state[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] GetInitialState() {
        int state [][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        return state;
    }
}
