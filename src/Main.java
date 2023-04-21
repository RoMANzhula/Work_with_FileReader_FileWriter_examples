import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName1 = "C:\\Users\\Admin\\Desktop\\Новий текстовий документ.txt";
        String fileName2 = "C:\\Users\\Admin\\Desktop\\Новий текстовий документ (2).txt";

        writeOnlyWordsWithDigitsToAnotherFiles(fileName1, fileName2); //вызываем метод, который записывает из первого файла
        //слова, которые содержат в себе цифры, во второй файл
        writeOnlyWordsWithLengthMoreThan(fileName1, fileName2, 7);//вызываем метод, который будет считывать символьные данные
        //из одного файла и будет записывать слова, которые имеют количество символов больше, чем мы установим, в другой файл.
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


    public static void writeOnlyWordsWithLengthMoreThan(String fileNameFrom, String fileNameTo, int lengthOfWords) throws IOException { //метод
        //который будет считывать символьные данные из одного файла и будет записывать слова, которые имеют количество символов
        //больше, чем мы установим, в другой файл.
        FileReader fileReader = new FileReader(fileNameFrom); //открываем поток для считывания символьных данных из указанного файла
        BufferedReader bufferedReader = new BufferedReader(fileReader); //буферизируем входной поток (для оптимизации работы системы)
        FileWriter fileWriter = new FileWriter(fileNameTo); //открываем поток для записи символьных данных в указанный файл


        String finalWords = ""; //создаем строковую переменную, в которую будем складывать считанные слова (можно использовать StringBuilder,
        //но для более понятного примера воспользуемся строкой)
        while (bufferedReader.ready()) { //цикл будет выполняться, пока во входящем потоке будут символы для чтения
            String line = bufferedReader.readLine(); //создаем строковую переменную, в которую будем читать данные целыми строками
            String[] wordFromLine = line.split(" "); //считанную строку разбиваем на массив из слов с помощью разделителя пробел - " "
            for (int i = 0; i < wordFromLine.length; i++) { //проходим по каждому слову в массиве
                if (wordFromLine[i].length() > lengthOfWords) { //если длина слова(количество символов) будет превышать указанный нами размер, то
                    finalWords += (wordFromLine[i] + ","); //добавляем это слово в нашу строку и следом ставим запятую
                }
            }
        }
        fileWriter.write(finalWords.substring(0, finalWords.length() - 1)); //с помощью исходящего(записывающего) потока пишем
        //все слова через запятую в указанный файл и отбрасываем последнюю запятую

        fileReader.close(); //очищаем ресурсы, закрываем поток чтения символов
        bufferedReader.close(); //очищаем ресурсы, закрываем буферизированный поток
        fileWriter.close(); //очищаем ресурсы, закрываем поток записи символов

    }

}