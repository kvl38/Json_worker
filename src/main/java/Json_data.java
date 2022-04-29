import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Json_data {
    @SuppressWarnings("unchecked")
    public static JSONArray json_data()
    {
        Scanner in_amount = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int amount = in_amount.nextInt();

        JSONArray studentList = new JSONArray();

        for(int i = 0; i < amount; i++)
        {
            Scanner in_is_student = new Scanner(System.in);
            System.out.print("Is he a student? (true/false) : ");
            boolean is_student = in_is_student.nextBoolean();

            Scanner in_name = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String name = in_name.nextLine();

            Scanner in_age = new Scanner(System.in);
            System.out.print("Enter student age: ");
            int age = in_age.nextInt();

            JSONObject student = new JSONObject();
            student.put("is student", is_student);
            student.put("name", name);
            student.put("age", age);

            JSONObject studentObject = new JSONObject();
            studentObject.put("student", student);


            studentList.add(studentObject);

        }
//        System.out.println(studentList);
        return studentList;
    }
}
