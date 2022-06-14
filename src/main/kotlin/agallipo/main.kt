package agallipo


fun main(args: Array<String>) {
    var boardingCardJsonParser = BoardingCardJsonParser("/Users/cxb0507/Desktop/example.json")
    print(boardingCardJsonParser.boardingCards)
}
