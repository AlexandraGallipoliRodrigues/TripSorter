package agallipo

typealias journey = List<BoardingCard>
typealias mutableJourney = MutableList<BoardingCard>

open class JourneysGenerator {

    var auxJourneys =  mutableListOf<mutableJourney>()

    fun joinJourney(destIndexJourney : Int, toJoinIndexJourney : Int) : List<journey> {
        val allJourneys : List<journey>

        auxJourneys[destIndexJourney].addAll(auxJourneys[toJoinIndexJourney])
        auxJourneys.removeAt(toJoinIndexJourney)
        allJourneys = auxJourneys.toList()
        return allJourneys
    }

    fun addJourney(boardingCard : BoardingCard) : List<journey> {
        val allJourneys : List<journey>

        auxJourneys.add(mutableListOf(boardingCard))
        allJourneys = auxJourneys.toList()
        return allJourneys
    }

    fun copyJourneys() : List<journey> {
        val allJourneys : List<journey>

        allJourneys = auxJourneys.toList()
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