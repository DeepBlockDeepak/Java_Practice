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

  public void getInfo(){
    System.out.println(
      this.name + " is spoken by " +
      this.numSpeakers + " people mainly in " +
      this.regionsSpoken + "." +
      " The language follows the word order: " +
      this.wordOrder
    );
  }

  /**
    * Based on https://www.w3schools.com/java/java_user_input.asp
    *
  */
  public void new_word_order(){

    Scanner myObj = new Scanner(System.in);

    System.out.print(
      String.format("Enter new word order facts for %s:", this.name)
    );

    String new_word_order_content = myObj.nextLine();

    this.wordOrder = new_word_order_content;

  }

}


