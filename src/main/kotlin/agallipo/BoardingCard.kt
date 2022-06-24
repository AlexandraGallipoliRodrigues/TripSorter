    package agallipo

    import java.io.File
    import java.io.InputStream
    //created by alex :)
    data class BoardingCard(var origin: String?, var destination: String?,  var transport: String?, var gate: String?, var seat: String?)
    //data class CardInformation(val flight: String?, val gate: String?, val seat: String?)


    class BoardingCardsFile(val pathname: String) : BoardingCardsReader {
        override fun readCards(): MutableList<String> {
            val inputStream: InputStream = File(pathname).inputStream()
            val lines = mutableListOf<String>()
            inputStream.bufferedReader().forEachLine(lines::add)
            return lines
        }
    }



    open class BoardingCardJsonParser(val pathname: String) : BoardingCardClassifier, BoardingCardSorter {
        private var boardingCardsFile = BoardingCardsFile(pathname)
        var boardingCards = parseLine(boardingCardsFile)
    }

