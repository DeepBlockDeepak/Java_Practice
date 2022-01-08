import java.util.Scanner;


class Main{

    /**
    get_all_info for calling .getInfo() on each Language() object in the array
    */
    public static void get_all_info(Language[] language_array){
        new_line_printer(1);

        for(Language obj: language_array){
            obj.getInfo();
            System.out.println();
        }
    }


    public static void new_line_printer(int num_new_lines){
        for(int i = 0; i < num_new_lines; i++){
            System.out.println();
        }
    }


    /**
    * Based on https://www.w3schools.com/java/java_user_input.asp
    *
    */
    public static String obtain_user_input(){

        Scanner myObj = new Scanner(System.in);
        //System.out.println(hard_coded_message);

        String user_input = myObj.nextLine();

        return user_input;

    }

    public static void print_obj_names(Language[] obj_list){
        new_line_printer(1);
        System.out.println("The Languages are:\n");
        
        // Print the object names
        for(int i = 0; i < obj_list.length; i++){
            System.out.println(
                "\t" + String.valueOf(i + 1) + ".) " + obj_list[i].name
            );
        }
    }

    public static void object_change_method(int obj_choice, Language[] obj_list){

        // decrement obj_choice to achieve 0-indexing 
        obj_choice--;

        if(obj_choice < 0 || obj_choice > (obj_list.length - 1)){
            System.out.println(
                String.format(
                    "Choice must be between 1 and %d.", obj_list.length
                )
            );
        }

        // update the appropirate object from the list
        else{
            obj_list[obj_choice].new_regions_spoken();
        }
        

    }



    public static int main_menu(){
        
        System.out.println(
            "\n\t\tWhat would you like to do:\n\t\t\t" +
            "1.) Print the Object Names\n\t\t\t" +
            "2.) Get Info of Entire List\n\t\t\t" +
            "3.) Update an Object's 'Regions Spoken' attribute.\n\t\t\t" +
            "4.) QUIT\n\n"
        );

        int user_choice = Integer.valueOf(obtain_user_input());
        
        //System.out.println(String.format("User choice was %d", user_choice));

        return user_choice;

    }


    public static void inner_menu(int user_choice, Language[] obj_list){

        // case 3, when the user wants to update an Obj attribute
        int update_obj_choice;

        switch(user_choice){
        case 1:
            print_obj_names(obj_list);

            break;
        
        case 2: 

            //call this method to get all info
            get_all_info(obj_list);

            break;
        
        case 3:

            new_line_printer(2);
            System.out.println(
                "--------- Which object's 'regionsSpoken' would you like to modify ---------?"
            );

            print_obj_names(obj_list);
            update_obj_choice = Integer.valueOf(obtain_user_input());
            object_change_method(update_obj_choice, obj_list);

            break;

        default:
            // POSSIBLY DO NOT NEED A BREAK WITHIN DEFAULT
            System.out.println("How did you get to the inner_menu() switch default?");
            break;
        }
    }



    public static void main(String[] args){

        /**
        Create the instanced objects
         */
        Language hooplah = new Language("Hooplah", 500, "Bay Area, Deep Dirty South","noun, verb, subject.");
        Language mopan = new Mayan("Mopan", 600);
        SinoTibetan mandarin = new SinoTibetan("Mandarin Chinese", 122);
        SinoTibetan burmese = new SinoTibetan("Burmese", 333);
        
        
        // Organize all objects in language_list[] for organization and modularity
        Language[] language_list = {hooplah, mopan, mandarin, burmese};

        // var for the user's menu selection
        int user_choice = 0;
        
        while(user_choice != 4){

            user_choice = main_menu();

            if(user_choice == 4){
                System.out.println("Have a nice day.");
                break;
                
            }

            inner_menu(user_choice, language_list);
            

            
        }       


    }

}


