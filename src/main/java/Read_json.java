import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read_json
{
    @SuppressWarnings("unchecked")
    public static void main()
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        Scanner in_file_name2 = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file_name2 = in_file_name2.nextLine() + ".json";

        try (FileReader reader = new FileReader(file_name2))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray studentList = (JSONArray) obj;
            System.out.println(studentList);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeObject(JSONObject student)
    {
        //Get employee object within list
        JSONObject student_obj = (JSONObject) student.get("student");

        //Get employee first name
        String name = (String) student_obj.get("name");
        System.out.println(name);

        //Get employee last name
        String age = (String) student_obj.get("age");
        System.out.println(age);

        //Get employee website name
        String is_student = (String) student_obj.get("is student");
        System.out.println(is_student);
    }
}