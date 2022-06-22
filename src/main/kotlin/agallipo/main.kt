package agallipo


fun main(args: Array<String>) {
    val pathname = "/Users/cxb0507/Desktop/example.json"
    var boardingCardJsonParser = BoardingCardJsonParser(pathname)
    var flightPaths = boardingCardJsonParser.sortTickets(boardingCardJsonParser.boardingCards)
    for (flightPath in flightPaths){
        println("MY:" + flightPath)
    }

}
