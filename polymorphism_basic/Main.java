import java.util.Scanner;
import java.util.ArrayList;


/**
Contains the driver script as well as useful methods.
Some of the methods are identical to those defined in Language.java. I'm not sure how to resolve that redundancy.
 */
class Main{

    /**
    get_all_info for calling .getInfo() method on each Language() object in the array
    */
    public static void get_all_info(ArrayList<Language> language_array){
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

    public static void print_obj_names(ArrayList<Language> obj_list){
        new_line_printer(1);
        System.out.println("The Languages are:\n");
        
        // Print the object names
        for(int i = 0; i < obj_list.size(); i++){
            System.out.println(
                "\t" + String.valueOf(i + 1) + ".) " + obj_list.get(i).name // modified from obj_list[i].name, after changing obj_list from Language[] type to ArrayList
            );
        }
    }

    public static void object_change_method(int obj_choice, ArrayList<Language> obj_list){

        // decrement obj_choice to achieve 0-indexing 
        obj_choice--;

        if(obj_choice < 0 || obj_choice > (obj_list.size() - 1)){
            System.out.println(
                String.format(
                    "\n**Choice must be between 1 and %d.", obj_list.size()
                )
            );
        }

        // update the appropirate object from the list
        else{
            obj_list.get(obj_choice).new_regions_spoken(); // changed from "obj_list[obj_choice].new_regions_spoken()" after ArrayList change
        }
    
    }

    public static Language language_obj_creator(){

        System.out.println("\nEnter a name for your new Language() Obj:\n\t");
        String name = obtain_user_input();

        System.out.println(String.format("\nEnter the number of speakers for %s:\n\t", name));
        int numSpeakers = Integer.valueOf(obtain_user_input());

        System.out.println(String.format("\nEnter the regions spoken for %s:\n\t", name));
        String regionsSpoken = obtain_user_input();

        System.out.println(String.format("\nEnter the word ordering for %s:\n\t", name));
        String wordOrder = obtain_user_input();

        Language new_lang_obj = new Language(name, numSpeakers, regionsSpoken, wordOrder);

        return new_lang_obj; 

    }


    public static Mayan mayan_obj_creator(){
        System.out.println("\nEnter a name for your new Mayan() Obj:\n\t");
        String name = obtain_user_input();

        System.out.println(String.format("\nEnter the number of speakers for %s:\n\t", name));
        int numSpeakers = Integer.valueOf(obtain_user_input());

        Mayan new_lang_obj = new Mayan(name, numSpeakers);

        return new_lang_obj;

    }

    public static SinoTibetan sino_tibetan_obj_creator(){
        System.out.println("\nEnter a name for your new SinoTibetan() Obj:\n\t");
        String name = obtain_user_input();

        System.out.println(String.format("\nEnter the number of speakers for %s:\n\t", name));
        int numSpeakers = Integer.valueOf(obtain_user_input());

        SinoTibetan new_lang_obj = new SinoTibetan(name, numSpeakers);

        return new_lang_obj;

    }

    

    public static void add_new_object(int obj_choice, ArrayList<Language> obj_list){
        
        // declare variables for the obj attributes
        String name, regionsSpoken, wordOrder;
        int numSpeakers;

        switch(obj_choice){
        case 1:
            // instance a Language object
            //  * need the String name, int numSpeakers, String regionsSpoken, String wordOrder
        
            Language new_lang_obj = language_obj_creator();
            obj_list.add(new_lang_obj);

            break;

        case 2:
            // instance a Mayan object
            //  * need a String name, int numSpeakers

            Mayan new_mayan_obj = mayan_obj_creator();
            obj_list.add(new_mayan_obj);

            break;

        case 3:

            SinoTibetan new_sinotibetan_obj = sino_tibetan_obj_creator();
            obj_list.add(new_sinotibetan_obj);

            break;

        default:
            System.out.println("\n\tReturning to main menu.\n");
            break;

        }
        
    }
    


    /**
        Ask user for choice. Return that int value for processing.
     */
    public static int main_menu(){
        
        System.out.println(
            "\n\t\tWhat would you like to do:\n\t\t\t" +
            "1.) Print the Object Names\n\t\t\t" +
            "2.) Get Info of Entire List\n\t\t\t" +
            "3.) Update an Object's 'Regions Spoken' attribute.\n\t\t\t" +
            "4.) Add a new Object to the Language List.\n\t\t\t" +
            "5.) QUIT\n\n"
        );

        int user_choice = Integer.valueOf(obtain_user_input());
        
        return user_choice;

    }


    public static void inner_menu(int user_choice, ArrayList<Language> obj_list){

        // case 3, when the user wants to update an Obj attribute
        int update_obj_choice;
        // for case 4, when the user wants to create a new Obj
        int new_object_choice = 0;

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

        case 4:
        
            System.out.println(
                "\n\t\tWhich Object would you like to add?:\n\t\t\t" +
                "1.) Language (parent Class) \n\t\t\t" +
                "2.) Mayan (child of Lang)\n\t\t\t" +
                "3.) SinoTibetan (child of Lang)\n\t\t\t" +
                "4.) Back to Main Menu\n\n"
            );

            new_object_choice = Integer.valueOf(obtain_user_input());
            
            // exit the Object creation menu and kick back to the main menu
            if(new_object_choice < 1 || new_object_choice > 3){
                break;
            }

            /* Do OBJ adding stuff */
            add_new_object(new_object_choice, obj_list);

            
            break;

        default:
            // POSSIBLY DO NOT NEED A BREAK WITHIN DEFAULT
            System.out.println("\t***Choice Must be between [1-5]\n");
            break;
        }
    }



    /**
        1.) Hard Code some objects from the cwd .java files: Language() & SinoTibetan() class objects are created

        2.) Store these objects in an ArrayList<Lanugage>. 

        3.) The while() loop allows the user to interact with a Menu that provides multiple options:
            i.) View the object names within the ArrayList<Language> language_list
            ii.) View the full information of the objects' attributes within the language_list
            iii.) Modify the contents of the .regionsSpoken attribute of any chosen Object within the language_list
            iv.) Add a new Object (along with entering it's attribute values) to the language_list.
                    * note: this option takes the user to a new menu where they can choose which Class Object to create:
                            Language(), Mayan(), or SinoTibetan() .... or to quit this option and return to main menu
            v.) Quit the program   
     */
    public static void main(String[] args){

        /**
        Create the instanced objects, Mayan() and SinoTi
         */
        Language hooplah = new Language("Hooplah", 500, "Bay Area, Deep Dirty South","noun, verb, subject.");
        Language mopan = new Mayan("Mopan", 600);
        SinoTibetan mandarin = new SinoTibetan("Mandarin Chinese", 122);
        SinoTibetan burmese = new SinoTibetan("Burmese", 333);
        
        
        // Organize all objects in a Language ArrayList for organization and modularity throughout the script
        // Declaring the data structure and then adding all the hard-coded Objects to it 
        ArrayList<Language> language_list = new ArrayList<Language>();
        language_list.add(hooplah);language_list.add(mopan); language_list.add(mandarin); language_list.add(burmese);

        // var for the user's menu selection
        int user_choice = 0;
        
        // Continuous Loop for user interface from Terminal
        while(user_choice != 5){

            // main_menu() allows the user to choose functionality
            user_choice = main_menu();

            if(user_choice == 5){
                System.out.println("\nHave a nice day.");
                break;
                
            }

            // inner_menu() processes the user's selection and directs the function to be performed.
            inner_menu(user_choice, language_list);
            
        }      

    }

}


