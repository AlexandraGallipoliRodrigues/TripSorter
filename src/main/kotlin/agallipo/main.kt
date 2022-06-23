    package agallipo

    //created by alex :)
    fun main(args: Array<String>) {
        val pathname = "examples/example.json"
        var boardingCardJsonParser = BoardingCardJsonParser(pathname)
        var flightPaths = boardingCardJsonParser.sortTickets(boardingCardJsonParser.boardingCards)
        for (flightPath in flightPaths){
            println("MY:" + flightPath)
        }

    }
