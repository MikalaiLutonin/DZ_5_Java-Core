import java.io.*;

public class TicTacToe {
    public static void main(String[] args) {
        int[] field = {1, 0, 2, 3, 2, 1, 0, 3, 1}; // Пример игрового поля

        // Записываем игровое поле в файл
        try {
            FileOutputStream outputStream = new FileOutputStream("field.txt");
            for (int i = 0; i < field.length; i++) {
                outputStream.write(field[i]);
            }
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Считываем игровое поле из файла
        int[] importedField = new int[9];
        try {
            FileInputStream inputStream = new FileInputStream("field.txt");
            int value;
            int i = 0;
            while ((value = inputStream.read()) != -1) {
                importedField[i++] = value;
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        // Выводим игровое поле на экран
        for (int i = 0; i < importedField.length; i++) {
            switch (importedField[i]) {
                case 0:
                    System.out.print("• ");
                    break;
                case 1:
                    System.out.print("X ");
                    break;
                case 2:
                    System.out.print("O ");
                    break;
                default:
                    System.out.print("? ");
                    break;
            }
            if ((i + 1) % 3 == 0) { // Перенос строки после каждой тройки элементов
                System.out.println();
            }
        }
    }
}
