class Animalerie{
  var allAnimals = mutableListOf<Animal>()

  fun add(isWhat: Animal){
    allAnimals.add(isWhat)
  }

  fun affiche(){
    for (i in allAnimals) {
      i.quiSuisJe()
      i.parler()
      // println(i)
    }
  }

}