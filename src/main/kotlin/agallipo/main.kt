import agallipo.BoardingCardSorter
import agallipo.BoardingCardsFile
import agallipo.Journeys
import agallipo.journey

fun main(args: Array<String>) {
    val pathname = "examples/example.json"
    val boardingCardsFile = BoardingCardsFile(pathname)
    val boardingCards = boardingCardsFile.parseFile(pathname)
    val boardingCardSorter = BoardingCardSorter()
    val flightPaths =boardingCardSorter.sortTickets(boardingCards)


    for (i in flightPaths){
        println("MY flight-path:" + i)
    }
}
