class Mayan extends Language{
  //is 'public' needed for below definition?
  Mayan(String name, int numSpeakers){
    super(name, numSpeakers, "Central America", "verb-object-subject");
  }

  @Override
  public void getInfo(){
    System.out.println(
      this.name +
      " is spoken by "
      + this.numSpeakers +
      " people mainly in " +
      this.regionsSpoken + "." +
      " The language follows the word order: "+
      this.wordOrder +
      "\nFun fact: Ki'che' is an ergative language."
    );

  }

}