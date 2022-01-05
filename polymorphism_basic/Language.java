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
      this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + "." + " The language follows the word order: " + this.wordOrder
    );
  }


  public static void main(String[] args){

    Language hooplah = new Language("Hooplah", 500, "Bay Area, Deep Dirty South", "noun, verb, subject.");
    Language mopan = new Mayan("Mopan", 600);
    SinoTibetan mandarin = new SinoTibetan("Mandarin Chinese", 122);
    SinoTibetan burmese = new SinoTibetan("Burmese", 333);


    hooplah.getInfo();
    System.out.println();

    mopan.getInfo();
    System.out.println();

    mandarin.getInfo();
    System.out.println();
    burmese.getInfo();


  }
}


