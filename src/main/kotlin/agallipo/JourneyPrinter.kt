package agallipo

class JourneyPrinter {
    fun printJourneys(journeys : List<journey>) {
        for ((i, journey) in journeys.withIndex()){
            println("Journey nº $i")
            for (boardingCard in journey) {
                print("From ${boardingCard.origin}, take ${boardingCard.transport} to ${boardingCard.destination}. ")
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