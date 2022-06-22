package agallipo


fun main(args: Array<String>) {
    val pathname = "/Users/cxb0507/Desktop/example.json"
    var boardingCardJsonParser = BoardingCardJsonParser(pathname)
    var myVar = boardingCardJsonParser.sortTickets(boardingCardJsonParser.boardingCards)
    for (my in myVar){
        println("MY:" + my)
    }

}
