package agallipo

typealias journey = List<BoardingCard>
typealias mutableJourney = MutableList<BoardingCard>

open class Journeys {

    fun joinJourney(journeysReference : MutableList<mutableJourney>, destIndexJourney : Int, toJoinIndexJourney : Int) : List<journey> {
        var allJourneys : List<journey>

        journeysReference[destIndexJourney].addAll(journeysReference[toJoinIndexJourney])
        journeysReference.removeAt(toJoinIndexJourney)
        allJourneys = journeysReference.toList()
        return allJourneys
    }

    fun addJourney(journeysReference : MutableList<mutableJourney>, boardingCard : BoardingCard) : List<journey> {
        var allJourneys : List<journey>

        journeysReference.add(mutableListOf(boardingCard))
        allJourneys = journeysReference.toList()
        return allJourneys
    }

    fun copyJourneys(journeysReference : MutableList<mutableJourney>) : List<journey> {
        var allJourneys : List<journey>

        allJourneys = journeysReference.toList()
        return allJourneys
    }
}