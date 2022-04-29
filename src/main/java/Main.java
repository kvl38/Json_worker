import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;

public class Main
{
    public static void main( String[] args )
    {
        int end = 1000;
        while (end != 0) {
            System.out.println("Select the action number to work with the json file!");
            System.out.println("1. Create and write file\n" +
                    "2. Read file to console\n" +
                    "3. Delete a file\n" +
                    "4. Finish the file");

            Scanner in = new Scanner(System.in);
            System.out.print("Enter action number: ");
            int choice = in.nextInt();

            switch (choice)
            {
                case (1):
                    Scanner in_file_name = new Scanner(System.in);
                    System.out.print("Enter a name for the new json file, without type: ");
                    String file_name = in_file_name.nextLine() + ".json";

                    JSONArray new_employeeList = new JSONArray();
                    new_employeeList = Json_data.json_data();

                    //Write JSON file
                    try (FileWriter file = new FileWriter(file_name)) {
                        //We can write any JSONArray or JSONObject instance to the file
                        file.write(new_employeeList.toJSONString());
                        file.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case (2):
                    Read_json.main();
                    break;

                case (3):
                    Scanner in_file_name2 = new Scanner(System.in);
                    System.out.print("Enter the name of the file to be deleted: ");
                    String file_name2 = in_file_name2.nextLine() + ".json";

                    File file = new File(file_name2);
                    if(file.delete())
                    {
                        System.out.println(file_name2 + " has been deleted");
                    }
                    else System.out.println("Error: File "+ file_name2 + " not found!!!");
                    break;

                case (4):
                    end = 0;
                    break;

                default:
                    System.out.print("Error: You entered a non-existent action number!!!");
                    break;
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}