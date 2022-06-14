package agallipo

import java.io.File
import java.io.InputStream

data class BoardingCard(var origin: String?, var destination: String?,  var transport: String?, var gate: String?, var seat: String?)
//data class CardInformation(val flight: String?, val gate: String?, val seat: String?)

interface BoardingCardsReader {
    fun readCards() : MutableList<String>
}

class BoardingCardsFile(val pathname: String) : BoardingCardsReader {
    override fun readCards(): MutableList<String> {
        val inputStream: InputStream = File(pathname).inputStream()
        val lines = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine(lines::add)
        return lines
    }
}

interface BoardingCardClassifier {
    fun parseLine(boardingCardsFile: BoardingCardsFile) : MutableList<BoardingCard?> {
        var boardingCards = mutableListOf<BoardingCard?>()
        var boardingCard: BoardingCard? = BoardingCard(null,null,null,null,null)
        var lines = boardingCardsFile.readCards()

        for (line in lines ) {
            if (line.compareTo("{") != 0 && line.compareTo("}") != 0)
               setCardValues(line, boardingCard)
            if (line.compareTo("}") == 0)
                boardingCards.add(boardingCard)
        }
        return boardingCards
    }

    fun setCardValues(line: String, boardingCard: BoardingCard?){


        if (line.contains("origin"))
            boardingCard?.origin = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)
        if (line.contains("destination")) {
            println(line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1))

            boardingCard?.destination = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)
            println(boardingCard?.destination)
        }
        if (line.contains("transport"))
            boardingCard?.transport = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)
        if (line.contains("gate"))
            boardingCard?.gate = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)
        if (line.contains("seat"))
            boardingCard?.seat = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)

    }
}

class BoardingCardJsonParser(val pathname: String) : BoardingCardClassifier {
    var boardingCardsFile = BoardingCardsFile(pathname)
    var boardingCards = parseLine(boardingCardsFile)


}

