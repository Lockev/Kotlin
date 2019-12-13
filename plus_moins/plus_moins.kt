import kotlin.math.abs

val turns = 6

fun main(args: Array<String>) {
  compare()
}


fun firstInput(): Int{
  print("Votre nombre (entre 1 et 100) à faire deviner : ")
  val value = System.console().readPassword()!!.joinToString("")
  return value.toInt()
}

fun getNumber(): Int{
  print("Votre nombre (entre 1 et 100 // STOP pour abandonner) : ")
  var value = readLine()!!
  if (value == "STOP"){
    return -777
  }
  else {
    return value.toInt()
  }

}

fun isClose(close: Int){
  when (close){
    in 25..100-> {
      println("Vous êtes froid.")
    }
    in 10..25-> {
      println("Vous êtes tiède.")
    }
    in 1..10-> {
      println("Vous êtes chaud.")
    }

  }
}

fun compare() {
  var random = firstInput()
  myLoop@ for (i in 1..turns){
    var givenNumber = getNumber()
    var remainingTurns = turns - i
    
    var remainingTurnsString = "Vous avez joué " + (turns - remainingTurns) + " tours. Il vous reste " + remainingTurns + " tour"
    if (remainingTurns > 1){
      remainingTurnsString += "s."
    }
    else {
      remainingTurnsString += "."
    }

    if (i == turns){
      println("------------------------------------------------")
      println("Vous n'avez plus de tour, vous avez PERDU HAHA !")
      println("------------------------------------------------")
    }
    else{
      when (givenNumber){
        random -> {
          println("Vous avez gagné !")
          break@myLoop
        }
        in 0..random-1 -> {
          println("Le nombre que vous cherchez est plus grand que le nom que vous avez donné.")
          isClose(abs(givenNumber - random))
          if (i < turns){
            println(remainingTurnsString)
          }
        }
        in random+1..101 -> {
          println("Le nombre que vous cherchez est plus petit que le nom que vous avez donné.")
          isClose(abs(givenNumber - random))
          if (i < turns){
            println(remainingTurnsString)
          }
        }
        -777 -> {
          println("Vous avez abandonné :( !")
          break@myLoop
        }
      }
    }

  }
  
}