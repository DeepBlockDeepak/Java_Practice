class SinoTibetan extends Language{
  //is 'public' needed for below definition?
  SinoTibetan(String name, int numSpeakers){

    super(name, numSpeakers, "Asia", "subject-object-verb");

    if(this.name.toLowerCase().contains("Chinese".toLowerCase())){
      this.wordOrder = "subject-verb-object";
    }

  }
}