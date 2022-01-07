class Main{

    /**
    get_all_info for calling .getInfo() on each Language() object in the array
    */
    public static void get_all_info(Language[] language_array){
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




    public static void main(String[] args){

        Language hooplah = new Language("Hooplah", 500, "Bay Area, Deep Dirty South","noun, verb, subject.");
        Language mopan = new Mayan("Mopan", 600);
        SinoTibetan mandarin = new SinoTibetan("Mandarin Chinese", 122);
        SinoTibetan burmese = new SinoTibetan("Burmese", 333);

        
        /*
        hooplah.getInfo();
        System.out.println();

        mopan.getInfo();
        System.out.println();

        mandarin.getInfo();
        System.out.println();
        burmese.getInfo();
        */

        Language[] language_list = {hooplah, mopan, mandarin, burmese};


        get_all_info(language_list);

        new_line_printer(2);

        burmese.new_word_order();

        

        new_line_printer(1);

        get_all_info(language_list);
        





    }

}


