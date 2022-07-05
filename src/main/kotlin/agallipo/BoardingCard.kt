package agallipo

import com.google.gson.Gson
import java.io.File
import java.io.InputStream

data class BoardingCard(var origin : String?, var destination : String?,  var transport : String, var date : String, var hour : String, var gate : String?, var seat : String?)

class BoardingCardsFile(val pathname: String) {

   fun parseFile(pathname: String) : List<BoardingCard> {
       val gson = Gson()
       val reader = File(pathname).inputStream().bufferedReader()
       var boardingCards = gson.fromJson(reader, Array<BoardingCard>::class.java).asList()

       return boardingCards
   }
}


