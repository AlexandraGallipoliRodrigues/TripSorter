package agallipo

class BoardingCardSorter {

    fun sortTickets(boardingCards : List<BoardingCard>) : List<journey> {
        var auxJourneys =  mutableListOf<mutableJourney>()
        var allJourneys = listOf<journey>()

        for (boardingCard in boardingCards) {
            if (!matchFlightPath(boardingCard, auxJourneys))
                auxJourneys.add(mutableListOf(boardingCard))
            allJourneys = checkJoinFlightPath(auxJourneys)
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

    private fun checkJoinFlightPath(auxJourneys : MutableList<mutableJourney>) :  List<journey>{
        val journeyGenerator = JourneysGenerator()
        var allJourneys = journeyGenerator.copyJourneys(auxJourneys)
        var i = 0
        var j : Int

        while (i < auxJourneys.size - 1) {
            j = i + 1
            while (j < auxJourneys.size) {
                if (auxJourneys[i][0].origin == auxJourneys[j][auxJourneys[j].size - 1].destination &&
                    auxJourneys[i][0].origin != null) {
                    allJourneys = journeyGenerator.joinJourney(auxJourneys, j, i)
                    return allJourneys
                }
                j++
            }
            i++
        }
        return allJourneys
    }
}