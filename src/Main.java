import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName1 = "C:\\Users\\Admin\\Desktop\\Новий текстовий документ.txt";
        String fileName2 = "C:\\Users\\Admin\\Desktop\\Новий текстовий документ (2).txt";

        writeOnlyWordsWithDigitsToAnotherFiles(fileName1, fileName2);
        
        writeOnlyWordsWithLengthMoreThan(fileName1, fileName2, 7);
    }

    public static void writeOnlyWordsWithDigitsToAnotherFiles(String fileNameFrom, String fileNameTo) throws IOException { 
        
        FileReader fileReader = new FileReader(fileNameFrom);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileNameTo);

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] wordFromLine = line.split(" ");
            for (int i = 0; i < wordFromLine.length; i++) { 
                for (char ch : wordFromLine[i].toCharArray()) {
                    if (Character.isDigit(ch)) { 
                        fileWriter.write(wordFromLine[i] + " ");
                        break;
                    }
                }
            }
        }

        fileReader.close();
        bufferedReader.close();
        fileWriter.close();
    }

    public static void writeOnlyWordsWithLengthMoreThan(String fileNameFrom, String fileNameTo, int lengthOfWords) throws IOException {
        FileReader fileReader = new FileReader(fileNameFrom);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileNameTo);

        String finalWords = "";
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] wordFromLine = line.split(" ");
            for (int i = 0; i < wordFromLine.length; i++) {
                if (wordFromLine[i].length() > lengthOfWords) {
                    finalWords += (wordFromLine[i] + ",");
                }
            }
        }
        fileWriter.write(finalWords.substring(0, finalWords.length() - 1));

        fileReader.close();
        bufferedReader.close();
        fileWriter.close();

    }

}
