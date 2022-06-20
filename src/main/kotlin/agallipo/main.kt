package agallipo


fun main(args: Array<String>) {
    val pathname = "/Users/cxb0507/Desktop/example.json"
    var boardingCardJsonParser = BoardingCardJsonParser(pathname)
    println(boardingCardJsonParser.boardingCards)
    var sorted = boardingCardJsonParser.topSort(boardingCardJsonParser.boardingCards, pathname)
    println(sorted)

}
