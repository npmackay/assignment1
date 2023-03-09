import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

 
public class App {
/**
 * 
 * @param args
 * @throws Exception
 */    public static void main(String[] args) throws Exception {
    ArrayList<String> firstWordList = readWords("res/word.txt");
    ArrayList<String> secondList = readWords("res/paragraph.txt");

    
    HashMap<String, Integer> firstHashMap = buildHashMap(firstWordList);
    HashMap<String, Integer> secondHashMap = buildHashMap(secondList);

    File sortedWords = new File("res/sortedWords.html");
    File secondWordList = new File("res/paragraph.html");

      
    createHTMLFile(firstHashMap);
    createParagraphFile(secondHashMap);
       
        ArrayList<wordFrequency> sortedList = iterateHashMap(firstHashMap);
        ArrayList<wordFrequency> secondSortedList = iterateHashMap(secondHashMap);

        Collections.sort(sortedList);
        Collections.sort(secondSortedList);

        FileWriter fileWriter = new FileWriter(sortedWords);
        fileWriter.append("<table>");
        for (wordFrequency wordFrequency : sortedList) {
        try {
          
        
            fileWriter.append(wordFrequency.toString());
        

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        
       
        }
        fileWriter.append("</table>");
        

        FileWriter secondWriter = new FileWriter(secondWordList);
        secondWriter.append(" <table  style = text-align:center; align-content:center; >");
        secondWriter.append("<th > WORD COUNTER </th> ");
        secondWriter.append("<tr> <td><b># SHOWN </td> <td> <b>WORD </td> <td> <tr> </tr>");
        for (wordFrequency wordFrequency : secondSortedList) {
        try {
          
        
            secondWriter.append(wordFrequency.toString());
        

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        
       
        }
        secondWriter.append("</table>");
        secondWriter.close(); 
        fileWriter.close(); 
        
    }
/**
 * 
 * @param fileName
 * @return
 */
    private static ArrayList<String> readWords(String fileName) {
       // step 4
     
        File file = new File(fileName);
        ArrayList<String> wordList = new ArrayList<>();
        
        {
            FileReader reader;
            try {
                reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line = bufferedReader.readLine();
                while (line != null) {
                    String[] words = line.split("[ .,]+");
                    for (String word : words) {
                        System.out.println(word.toString());
                        word = word.trim();
                        if (word.length() > 0) {
                            wordList.add(word.toLowerCase());
                        }
                    }
                    line = bufferedReader.readLine();
                }
               
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
      
        return wordList;
    }
/**
 * 
 * @param words
 * @return
 */
    private static HashMap<String, Integer> buildHashMap(ArrayList<String> words) {
    // step 5 
        HashMap<String, Integer> wordCounter = new HashMap<>();
     
        for (String word : words) {
            Integer count = wordCounter.get(word);
            if (count == null) {
                wordCounter.put(word, 1);

            } else {
                wordCounter.put(word, count + 1);
            }
        }
        
        return wordCounter;
    }

    private static void createHTMLFile(HashMap<String, Integer> wordCounter) {
        File file = new File("res/words.html");
//step 6
        try {
            FileWriter fileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();

            builder.append(
                    " <table  style = text-align:center; justify-content:center; > \n");
            builder.append("<th > WORD COUNTER </th> \n");
            builder.append(
                    "<tr> <td><b># SHOWN </td> <td> <b>WORD </td> <td> <tr> </tr>\n");
            for (String key : wordCounter.keySet()) {
                builder.append("<tr> <td>" + key + "</td><td>" + wordCounter.get(key) + "</td> </tr>\n");
            }
            builder.append(" </table>");
           
            fileWriter.append(builder.toString());

            fileWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

   
    

   
    }
    /**
     * 
     * @param wordCounter
     */
    private static void createParagraphFile(HashMap<String, Integer> wordCounter) {
        File file = new File("res/paragraph.html");
//step 6
        try {
            FileWriter fileWriter = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            for (String key : wordCounter.keySet()) {
                builder.append("<tr> <td>" + key + "</td><td>" + wordCounter.get(key) + "</td> </tr>\n");
            }
            builder.append(" </table>");
           
            fileWriter.append(builder.toString());

            fileWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

   
    

   
    }
    /**
     * 
     * @param wordList
     * @return
     */
         
    public static ArrayList<wordFrequency>iterateHashMap (HashMap<String, Integer> wordList) {
        ArrayList<wordFrequency> list = new ArrayList<>();
        for (Entry<String, Integer> entry : wordList.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            wordFrequency obj = new wordFrequency(key, value);
            list.add(obj);
            System.out.println(obj);
        }
        return list;
    }
}
