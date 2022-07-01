package agallipo

class BoardingCardSorter : Journeys() {

    fun sortTickets(boardingCards : List<BoardingCard>) : List<journey> {
        var auxJourneys =  mutableListOf<mutableJourney>()
        var allJourneys = listOf<journey>()

        for (boardingCard in boardingCards) {
            if (!matchFlightPath(boardingCard, auxJourneys))
                allJourneys = addJourney(auxJourneys, boardingCard)
            checkJoinFlightPath(auxJourneys)
        }
        return allJourneys
    }

    fun matchFlightPath(boardingCard : BoardingCard, auxJourneys : MutableList<mutableJourney>) : Boolean {
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

    fun checkJoinFlightPath(auxJourneys : MutableList<mutableJourney>) :  List<journey>{
        var allJourneys = listOf<journey>()
        var i = 0
        var j : Int

        while (i < auxJourneys.size - 1) {
            j = i + 1
            while (j < auxJourneys.size) {
                if (auxJourneys[i][0].origin == auxJourneys[j][auxJourneys[j].size - 1].destination &&
                    auxJourneys[i][0].origin != null) {
                    allJourneys = joinJourney(auxJourneys, j, i)
                    return allJourneys
                }
                j++
            }
            i++
        }
        return allJourneys
    }
}