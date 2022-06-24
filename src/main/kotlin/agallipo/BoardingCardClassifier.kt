package agallipo

interface BoardingCardClassifier {
    fun parseLine(boardingCardsFile: BoardingCardsFile) : MutableList<BoardingCard?> {
        var boardingCards = mutableListOf<BoardingCard?>()
        var boardingCard: BoardingCard? = BoardingCard(null,null,null,null,null)
        var lines = boardingCardsFile.readCards()

        for (line in lines ) {
            if (line.compareTo("{") != 0 && line.compareTo("}") != 0)
                setCardValues(line, boardingCard)
            if (line.compareTo("}") == 0){
                boardingCards.add(boardingCard!!.copy())
                boardingCard = BoardingCard(null,null,null,null,null)

            }
        }
        return boardingCards
    }

    fun setCardValues(line: String, boardingCard: BoardingCard?){


        if (line.contains("origin"))
            boardingCard?.origin = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)
        if (line.contains("destination"))
            boardingCard?.destination = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)
        if (line.contains("transport"))
            boardingCard?.transport = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)
        if (line.contains("gate"))
            boardingCard?.gate = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)
        if (line.contains("seat"))
            boardingCard?.seat = line.removeRange(line.indexOf("\""), line.lastIndexOf(":") + 1)

    }
}