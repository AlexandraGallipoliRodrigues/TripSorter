import agallipo.*

fun main(args: Array<String>) {
    var pathname = "examples/test1.json"
    var boardingCardsFile = BoardingCardsFile(pathname)
    var boardingCards = boardingCardsFile.parseFile(pathname)
    val boardingCardSorter = BoardingCardSorter()
    var flightPaths = boardingCardSorter.sortTickets(boardingCards)
    val journeyPrinter = JourneyPrinter()

    journeyPrinter.printJourneys(flightPaths)

    pathname = "examples/test2.json"
    boardingCardsFile = BoardingCardsFile(pathname)
    boardingCards = boardingCardsFile.parseFile(pathname)
    flightPaths = boardingCardSorter.sortTickets(boardingCards)
    journeyPrinter.printJourneys(flightPaths)

    pathname = "examples/test3.json"
    boardingCardsFile = BoardingCardsFile(pathname)
    boardingCards = boardingCardsFile.parseFile(pathname)
    flightPaths = boardingCardSorter.sortTickets(boardingCards)
    journeyPrinter.printJourneys(flightPaths)

    pathname = "examples/test4.json"
    boardingCardsFile = BoardingCardsFile(pathname)
    boardingCards = boardingCardsFile.parseFile(pathname)
    flightPaths = boardingCardSorter.sortTickets(boardingCards)
    journeyPrinter.printJourneys(flightPaths)
}
