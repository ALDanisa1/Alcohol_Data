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
        //store the alcohol data
        ArrayList<String> alcohol_data = new ArrayList<>();

        while(fileline.hasNext()){
            alcohol_data.add(fileline.nextLine());
        }
        HashMap<String,String> info = new HashMap<>();
        info = create_Map(alcohol_data.get(0));

        System.out.println("Which country you would like to get alcohol consumption information about? ");
        String country = input.next();

        String country_info = "";
        for (int i = 0; i < alcohol_data.size(); i++) {
            if(alcohol_data.get(i).contains(country)){
               country_info = get_info(alcohol_data.get(i));
            }
        }

    }
    public static HashMap<String,String> create_Map(String details){
        HashMap<String,String> details_map = new HashMap<>();
        String[] types = details.split(",");
        for (int i = 0; i < types.length; i++) {
            details_map.put(types[i],(types[i].substring(0)) );
        }
        return details_map;
    }
}
