import java.io.*;

public class BackupFiles {
    public static void main(String[] args) {
        // Создаем объекты File для текущей директории и директории резервных копий
        File directory = new File(".");
        File backupDirectory = new File("./backup");

        // Создаем директорию резервных копий, если ее еще нет
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        // Получаем все файлы в текущей директории
        File[] files = directory.listFiles();

        // Копируем каждый файл в директорию резервных копий
        for (File file : files) {
            if (file.isFile()) { // Проверяем, что файл является файлом, а не директорией
                try {
                    // Создаем потоки ввода/вывода для копирования файла
                    FileInputStream inputStream = new FileInputStream(file);
                    FileOutputStream outputStream = new FileOutputStream(backupDirectory + "/" + file.getName());

                    byte[] buffer = new byte[1024];
                    int length;

                    // Копируем файл по частям, пока не закончится
                    while ((length = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, length);
                    }

                    // Закрываем потоки ввода/вывода
                    inputStream.close();
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println("Error copying file: " + e.getMessage());
                }
            }
        }

        System.out.println("Backup completed successfully!");
    }
}