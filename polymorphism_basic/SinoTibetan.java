class SinoTibetan extends Language{
  //is 'public' needed for below definition?
  SinoTibetan(String name, int numSpeakers){

    super(name, numSpeakers, "Asia", "subject-object-verb");

    // If statement looks for any string of 'chinese' in the initilization of the .name attribute
    if(this.name.toLowerCase().contains("Chinese".toLowerCase())){
      this.wordOrder = "subject-verb-object";
    }

  }
}