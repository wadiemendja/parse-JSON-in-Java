package jsonparser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Wadie MENDJA
 */
public class JsonParser {

    static String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        int c = reader.read();
        String fileContent = "";
        while (c != -1) {
            fileContent += (char) c;
            c = reader.read();
        }
        return fileContent;
    }

    public static void main(String[] args) throws Exception {
        String jsonString = readFile("data.json"); // reading the JSON file
        JSONObject obj = new JSONObject(jsonString); // Parsing it
        // take a look at the "data.json" file before reading the rest of the code
        String author = obj.getJSONObject("book").getString("author"); // book => author
        String title = obj.getJSONObject("book").getString("title"); // book => title
        int pages = obj.getJSONObject("book").getInt("pages"); // book => pages
        JSONArray chapters = obj.getJSONObject("book").getJSONArray("chapters"); // book => chapters[]
        // printing the data that we got
        System.out.println("Author : " + author);
        System.out.println("title : " + title);
        System.out.println("pages : " + pages);
        System.out.println("chapters :" + chapters);
    }

}
