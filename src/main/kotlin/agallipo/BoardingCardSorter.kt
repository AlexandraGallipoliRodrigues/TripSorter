package agallipo

class BoardingCardSorter {
    private var boardingCards : List<BoardingCard>

    constructor (boardingCardReference : List<BoardingCard>) {
        boardingCards=  setBoardingCard(boardingCardReference)
    }

    fun setBoardingCard(boardingCardReference : List<BoardingCard>) : List<BoardingCard>{
        boardingCards = boardingCardReference
        return boardingCards
    }

    fun sortTickets() : List<journey> {
        var journeysGenerator =  JourneysGenerator()
        var allJourneys = listOf<journey>()

        for (boardingCard in boardingCards) {
            if (!matchFlightPath(boardingCard, journeysGenerator.auxJourneys))
                journeysGenerator.auxJourneys.add(mutableListOf(boardingCard))
            allJourneys = checkJoinFlightPath(journeysGenerator)
        }
        return allJourneys
    }

    private fun matchFlightPath(boardingCard : BoardingCard, auxJourneys : MutableList<mutableJourney>) : Boolean {
        for (path in auxJourneys) {
            if (boardingCard.destination == path[0].origin && boardingCard.destination != null) {
                path.add(0,boardingCard)
                return true
            }
            if (boardingCard.origin == path[path.size - 1].destination && boardingCard.origin != null) {
                path.add(boardingCard)
                return true
            }
        }
        return false
    }

    private fun checkJoinFlightPath(journeysGenerator : JourneysGenerator) :  List<journey>{
        var allJourneys = journeysGenerator.copyJourneys()
        var i = 0
        var j : Int

        while (i < journeysGenerator.auxJourneys.size - 1) {
            j = i + 1
            while (j < journeysGenerator.auxJourneys.size) {
                if (journeysGenerator.auxJourneys[i][0].origin == journeysGenerator.auxJourneys[j][journeysGenerator.auxJourneys[j].size - 1].destination &&
                    journeysGenerator.auxJourneys[i][0].origin != null) {
                    allJourneys = journeysGenerator.joinJourney(j, i)
                    return allJourneys
                }
                j++
            }
            i++
        }
        return allJourneys
    }
}