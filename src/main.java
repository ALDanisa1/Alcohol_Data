import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input =  new Scanner(System.in);
        System.out.println("Enter the name of a file");
        String filename = input.nextLine();
        File file = new File("src/"+filename);
        Scanner fileline = new Scanner(file);
        ArrayList<String> alcohol_data = new ArrayList<>();

        while(fileline.hasNext()){
            alcohol_data.add(fileline.nextLine());
        }
        HashMap<String,String> info = new HashMap<>();
        //info = create_Map(alcohol_data.get(0));

    }
}
