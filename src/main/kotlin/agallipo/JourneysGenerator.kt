package agallipo

typealias journey = List<BoardingCard>
typealias mutableJourney = MutableList<BoardingCard>

open class JourneysGenerator {

    fun joinJourney(journeysReference : MutableList<mutableJourney>, destIndexJourney : Int, toJoinIndexJourney : Int) : List<journey> {
        val allJourneys : List<journey>

        journeysReference[destIndexJourney].addAll(journeysReference[toJoinIndexJourney])
        journeysReference.removeAt(toJoinIndexJourney)
        allJourneys = journeysReference.toList()
        return allJourneys
    }

    fun addJourney(journeysReference : MutableList<mutableJourney>, boardingCard : BoardingCard) : List<journey> {
        val allJourneys : List<journey>

        journeysReference.add(mutableListOf(boardingCard))
        allJourneys = journeysReference.toList()
        return allJourneys
    }

    fun copyJourneys(journeysReference : MutableList<mutableJourney>) : List<journey> {
        val allJourneys : List<journey>

        allJourneys = journeysReference.toList()
        return allJourneys
    }

    fun removeInvalidJourneys(allJourneys: List<journey>) : List<journey> {
        val validJourneys = allJourneys.toMutableList()

        for ((i, journey) in validJourneys.withIndex()){
            if (journey[0].origin == null || journey[journey.size - 1].destination == null)
                validJourneys.removeAt(i)
        }
        return validJourneys.toList()
    }
}