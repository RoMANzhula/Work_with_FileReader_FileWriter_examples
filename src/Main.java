import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        String fileName1 = "C:\\Users\\Admin\\Desktop\\Новий текстовий документ.txt";
        String fileName2 = "C:\\Users\\Admin\\Desktop\\Новий текстовий документ (2).txt";

        writeOnlyWordsWithDigitsToAnotherFiles(fileName1, fileName2); //вызываем метод, который записывает из первого файла
        //слова, которые содержат в себе цифры, во второй файл

    }

    public static void writeOnlyWordsWithDigitsToAnotherFiles(String fileNameFrom, String fileNameTo) throws IOException { //метод,
        // который записывает из первого файла слова, которые содержат в себе цифры, во второй файл

        FileReader fileReader = new FileReader(fileNameFrom); //открываем поток для считывания символьных данных из указанного файла
        BufferedReader bufferedReader = new BufferedReader(fileReader); //буферизируем входной поток (для оптимизации работы системы)
        FileWriter fileWriter = new FileWriter(fileNameTo); //открываем поток для записи символьных данных в указанный файл

        while (bufferedReader.ready()) { //цикл будет выполняться, пока будут данные для чтения во входящем потоке
            String line = bufferedReader.readLine(); //в строковую переменную читаем сразу целую строку
            String[] wordFromLine = line.split(" "); //прочитанную строку разделяем пробелами на слова и помещаем в массив строк
            for (int i = 0; i < wordFromLine.length; i++) { //проходимся по каждому элементу из массива слов
                for (char ch : wordFromLine[i].toCharArray()) { //с помощью for-each проходимся по каждому символу в отдельно
                    // слове (разбив его на символы с помощью метода toCharArray())
                    if (Character.isDigit(ch)) { //если в слове(разбитом на символы) хотя бы один символ будет цифрой (isDigit(ch)
                        //вернет true), то
                        fileWriter.write(wordFromLine[i] + " "); //записываем слово с цифрой в исходящий поток в указанный файл
                        break; //выполняем прерывание, т.к. слово может содержать несколько цифр и чтоб слова не задваивались
                    }
                }
            }
        }

        fileReader.close(); //очищаем ресурсы, закрываем поток чтения символов
        bufferedReader.close(); //очищаем ресурсы, закрываем буферизированный поток
        fileWriter.close(); //очищаем ресурсы, закрываем поток записи символов
    }

}