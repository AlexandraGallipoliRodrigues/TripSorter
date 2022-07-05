package agallipo

class JourneyPrinter {
    fun printJourneys(journeys : List<journey>) {
        for ((i, journey) in journeys.withIndex()){
            println("Journey nº $i")
            if (journey[0].origin == null || journey[journey.size - 1].destination == null) {
                println(" is not valid because it has a null destination or origin")
                continue
            }
            for (boardingCard in journey) {
                print("From ${boardingCard.origin}, take ${boardingCard.transport} to ${boardingCard.destination}. Date: ${boardingCard.date} at ${boardingCard.hour}. ")
                if (boardingCard.gate != null)
                    print("Gate: ${boardingCard.gate}.")
                if (boardingCard.seat != null)
                    print("Seat: ${boardingCard.seat}.")
                else
                    print("No seat assignment.")
                print("\n")
            }
        }
    }
}