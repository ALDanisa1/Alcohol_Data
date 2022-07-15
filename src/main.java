import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        HashMap<Integer,String> info = new HashMap<>();
        info = create_Map(alcohol_data.get(0));

        System.out.println("Which country you would like to get alcohol consumption information about? ");
        String country = input.nextLine();

        //create the list for the choice of country
        List<String> country_info = new ArrayList<>(); ;
        for (int i = 0; i < alcohol_data.size(); i++) {
            if(alcohol_data.get(i).contains(country)){
               country_info = get_info(alcohol_data.get(i));
            }
        }
        //merging the lists to store the results
        HashMap<String,String> merged_map = new HashMap<>();
        merged_map = merge_maps(country_info,info);

        System.out.println("\nWhat would like to know about the country you choose?");
        System.out.println("choose your answer from the list below and indicate by number.");
        System.out.println("You can also confirm the country you choose by number 0.");

        System.out.println(info);
        int like_to_know = input.nextInt();

        System.out.println("\nIn " + country + " The value of " + info.get(like_to_know) + " is " + merged_map.get(info.get(like_to_know)) + " .");
    }
    private static HashMap<Integer,String> create_Map(String details){
        HashMap<Integer,String> details_map = new HashMap<>();
        String[] types = details.split(",");
        for (int i = 0; i < types.length; i++) {
            details_map.put(i,types[i]);
        }
        return details_map;
    }

    private static List<String> get_info(String country_info){
        List<String> info = new ArrayList<>();
        String[] details = country_info.split(",");
        for (int i = 0; i < details.length ; i++) {
                info.add(details[i]);
        }
        return info;
    }

    private static HashMap<String,String> merge_maps(List<String> country_info,HashMap<Integer,String> inf ){
        HashMap<String,String> merged_map = new HashMap<>();
        for (int i = 0; i < country_info.size(); i++) {
            merged_map.put(inf.get(i),country_info.get(i));
        }
        return merged_map;
    }
}
