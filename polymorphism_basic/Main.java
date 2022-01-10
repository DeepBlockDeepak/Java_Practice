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



    /**
    A simple line printer function
     */
    public static void new_line_printer(int num_new_lines){
        for(int i = 0; i < num_new_lines; i++){
            System.out.println();
        }
    }


    /**
    * Based on https://www.w3schools.com/java/java_user_input.asp

    * Great for obtaining Command Line input from user. Can easily be converted to Integer with Integer.valueOf(return)
    *
    */
    public static String obtain_user_input(){

        Scanner myObj = new Scanner(System.in);
        //System.out.println(hard_coded_message);

        String user_input = myObj.nextLine();

        return user_input;

    }


    /**
        Loops through the ArrayList<Language> and prints off the .name() attribute of each Object
     */
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


    /**
        After the user has selected the object to modify, they call the .new_regions_spoken() Lanugage() attrbute here via the 
        ArrayList<Language> datastructure's .get() method
     */
    public static void object_change_method(int obj_choice, ArrayList<Language> obj_list){

        // decrement obj_choice to achieve 0-indexing 
        obj_choice--;

        // error checking for bad user-input
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



    /**
        Function which allows the user to create a new Langage() object. Returns said object
     */
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



    /**
        Allows user to return a new Mayan() object
     */
    public static Mayan mayan_obj_creator(){
        System.out.println("\nEnter a name for your new Mayan() Obj:\n\t");
        String name = obtain_user_input();

        System.out.println(String.format("\nEnter the number of speakers for %s:\n\t", name));
        int numSpeakers = Integer.valueOf(obtain_user_input());

        Mayan new_lang_obj = new Mayan(name, numSpeakers);

        return new_lang_obj;

    }


    /**
        Allows user to return a new SinoTibetan() object
     */
    public static SinoTibetan sino_tibetan_obj_creator(){
        System.out.println("\nEnter a name for your new SinoTibetan() Obj:\n\t");
        String name = obtain_user_input();

        System.out.println(String.format("\nEnter the number of speakers for %s:\n\t", name));
        int numSpeakers = Integer.valueOf(obtain_user_input());

        SinoTibetan new_lang_obj = new SinoTibetan(name, numSpeakers);

        return new_lang_obj;

    }

    

    /**
        Function handles the user's choice from the inner_menu option #4: creating a new Language() object or Child-class
     */
    public static void add_new_object(int obj_choice, ArrayList<Language> obj_list){
        
        // declare variables for the obj attributes
        String name, regionsSpoken, wordOrder;
        int numSpeakers;


        switch(obj_choice){
        
        // Choosing the Language() Object
        case 1:
            // instance a Language object
            Language new_lang_obj = language_obj_creator();
            obj_list.add(new_lang_obj);
            break;

        // Choosing the Mayan() Object
        case 2:

            Mayan new_mayan_obj = mayan_obj_creator();
            obj_list.add(new_mayan_obj);
            break;

        // Choosing a SinoTibetan() object
        case 3:

            SinoTibetan new_sinotibetan_obj = sino_tibetan_obj_creator();
            obj_list.add(new_sinotibetan_obj);
            break;

        // Error inputs & Quits handled here in default
        default:
            System.out.println("\n\tReturning to main menu.\n");
            break;

        }
        
    }
    


    public static boolean delete_object(String obj_name, ArrayList<Language> lang_list){

        boolean found_object = false;

        /* This method doesn't work
        for(Language lang_obj: lang_list){
            if(lang_obj.name.equals(obj_name)){
                found_object = !found_object;
                lang_list.remove(lang_obj);
                System.out.println(String.format("\t*%s was removed.", obj_name));
            }
        }
        */

        for(int i = 0; i < lang_list.size(); i++){
            if(lang_list.get(i).name.equals(obj_name)){
                found_object = !found_object;
                lang_list.remove(i);
            }
        }

        return found_object;
        //System.out.println("")
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
            "5.) Delete an Object in the Language List.\n\t\t\t" +
            "6.) QUIT\n\n"
        );

        // Type conversion of the string output from Scanner to the Integer type
        int user_choice = Integer.valueOf(obtain_user_input());
        
        return user_choice;

    }


    /**
        The inner menu channels the user's main_menu() choice into function calls depending on the user_choice value 
     */
    public static void inner_menu(int user_choice, ArrayList<Language> obj_list){

        // case 3, when the user wants to update an Obj attribute
        // for case 4, when the user wants to create a new Obj
        int object_choice;

        // for case 5, when user wants to delete an Obj;
        String deletion_object_name;


        switch(user_choice){
        // Where user wants to print each .name from the list of objects
        case 1:
            print_obj_names(obj_list);
            break;
        
        // Choosing to print off all attributes of every object in the list
        case 2: 
            //call this method to get all info
            get_all_info(obj_list);
            break;

        // Overwriting an existing object's .regionsSpoken attribute with new user-inputted material
        case 3:

            new_line_printer(2);
            System.out.println(
                "--------- Which object's 'regionsSpoken' would you like to modify ---------?"
            );

            // displays choices for the user via a List printed menu. 
            print_obj_names(obj_list);
            // User choice serves as an indexing value to select the appropriate object
            object_choice = Integer.valueOf(obtain_user_input());

            // User's selected object will be picked via indexing
            object_change_method(object_choice, obj_list);
            break;

        // Adding a new object via further menu system
        case 4:

            System.out.println(
                "\n\t\tWhich Object would you like to add?:\n\t\t\t" +
                "1.) Language (parent Class) \n\t\t\t" +
                "2.) Mayan (child of Lang)\n\t\t\t" +
                "3.) SinoTibetan (child of Lang)\n\t\t\t" +
                "4.) Back to Main Menu\n\n"
            );

            object_choice = Integer.valueOf(obtain_user_input());
            
            // exit the Object creation menu and kick back to the main menu
            if(object_choice < 1 || object_choice > 3){
                break;
            }

            // the user's object choice will then go on to select the appropriate functionality within add_new_object()
            add_new_object(object_choice, obj_list);
            break;

        // Allow user to delete an object from the ArrayList<Language> based on a name search
        case 5:
            
            System.out.println("\tType the name of the Language you wish to remove:");

            deletion_object_name = obtain_user_input();

            System.out.println(
                delete_object(deletion_object_name, obj_list)   ?   String.format("\t---%s Removed---", deletion_object_name)
                                                                :   String.format("\t---%s Not Found---", deletion_object_name)
            );

            break; 
            
        
        default:
            // POSSIBLY DO NOT NEED A BREAK WITHIN DEFAULT
            System.out.println("\t***Choice Must be between [1-5]\n");
            break;
        }
    }



    /**
        LOGIC SUMMARY:

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
        Create the instanced objects, Language(), Mayan(), and SinoTibetan()
         */
        Language hooplah = new Language("Hooplah", 500, "Bay Area, Deep Dirty South","noun, verb, subject.");
        Mayan mopan = new Mayan("Mopan", 600);
        SinoTibetan mandarin = new SinoTibetan("Mandarin Chinese", 122);
        SinoTibetan burmese = new SinoTibetan("Burmese", 333);
        
        
        // Organize all objects in a ArrayList<Language> for organization and modularity throughout the script
        // Declaring the data structure and then adding all the hard-coded Objects to it 
        ArrayList<Language> language_list = new ArrayList<Language>();
        language_list.add(hooplah);language_list.add(mopan); language_list.add(mandarin); language_list.add(burmese);

        /* TEST */
        //language_list.remove(mopan);

        // var for the user's menu selection
        int user_choice = 0;
        
        // Continuous Loop for user interface from Terminal; Change value of '5' each time new user-choices are added
        while(user_choice != 6){

            // main_menu() allows the user to choose functionality
            user_choice = main_menu();

            // @note: Figure out how to '#define QUIT 5' as in C
            if(user_choice == 6){
                System.out.println("\nHave a nice day.");
                break;
                
            }

            // inner_menu() processes the user's selection and directs the function to be performed.
            inner_menu(user_choice, language_list);
            
        }      

    }

}


