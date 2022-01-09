import java.util.Scanner;


class Language{
  
  protected String name;
  protected int numSpeakers;
  protected String regionsSpoken;
  protected String wordOrder;


  public Language(String name, int numSpeakers, String regionsSpoken, String wordOrder){
    this.name = name;
    this.numSpeakers = numSpeakers;
    this.regionsSpoken = regionsSpoken;
    this.wordOrder = wordOrder;
  }


  /**
  * Based on https://www.w3schools.com/java/java_user_input.asp
  *
  */
  public String obtain_user_input(){

      Scanner myObj = new Scanner(System.in);

      String user_input = myObj.nextLine();

      return user_input;

  }

  public void new_line_printer(int num_new_lines){
    for(int i = 0; i < num_new_lines; i++){
        System.out.println();
    }
  }



  public void getInfo(){
    System.out.println(
      this.name + " is spoken by " +
      this.numSpeakers + " people mainly in " +
      this.regionsSpoken + "." +
      " The language follows the word order: " +
      this.wordOrder
    );
  }



  public void new_regions_spoken(){
    new_line_printer(1);

    //Enter new word order facts for %s:
    System.out.println(
      String.format("--Here is %s.regionsSpoken:--\n\t%s\n", this.name, this.regionsSpoken)
    );

 
 
    System.out.println(
      String.format("--Enter new Regions Spoken content for %s:--", this.name)

    );


    this.regionsSpoken = obtain_user_input();

    System.out.println("\n--Regions Spoken has been overwritten for " + this.name + ".--\n");



  }
  
}


