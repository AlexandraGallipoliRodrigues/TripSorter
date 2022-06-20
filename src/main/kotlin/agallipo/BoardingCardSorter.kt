package agallipo

interface BoardingCardSorter {
    //This function will divide all the boarding cards into lists of flight-paths, then it would apply the topSort
    //function to each list, and once it's sorted it would join all the list (with a flatMap) for returning the all the
    //sorted tickets
   /* fun sortTickets(boardingCards: MutableList<BoardingCard?>, pathname: String) : MutableList<BoardingCard?>{

        for (boardingCard in boardingCards){
            if ()
        }
    }*/

    //This function sorts topologically a list of boarding cards, but as the problem may have more than one flight-path
    //(graph) the function may be called for each route.
    //It returns the sorted boarding tickets.
    fun topSort(boardingCards: MutableList<BoardingCard?>, pathname: String) : MutableList<BoardingCard?> {
        var sortedStack = mutableListOf<BoardingCard?>()
        var visited = mutableListOf<BoardingCard?>()
        for (boardingCard in boardingCards){
            if (visited.contains(boardingCard))
                continue
            topSortUtil(boardingCard, sortedStack, visited, boardingCards)
        }
        return sortedStack
    }
    //This functions is called recursively, taking the current ticket, searches for all the flight connections until it
    //reaches the final destination or null. Then it adds all the connections to the sorted list
    fun topSortUtil(boardingCard: BoardingCard?, sortedStack: MutableList<BoardingCard?>, visited: MutableList<BoardingCard?>, boardingCards: MutableList<BoardingCard?>){
        visited.add(boardingCard)
        var nextDestinations = getAllDestinations(boardingCard,boardingCards)
        for (next in getAllDestinations(boardingCard,boardingCards)){
            if (visited.contains(next))
                continue
            topSortUtil(next, sortedStack, visited, boardingCards)
        }
        sortedStack.add(0, boardingCard)
    }

    //This function returns a list of all the connections flight of a boarding card
    fun getAllDestinations(boardingCard: BoardingCard?, boardingCards: MutableList<BoardingCard?>): List<BoardingCard?>{
        var nextDestination = hasNextDestination(boardingCard, boardingCards)
        var allDestinations = mutableListOf<BoardingCard>()
        while (nextDestination != null){
            allDestinations.add(nextDestination)
            nextDestination = hasNextDestination(nextDestination, boardingCards)
        }
        return allDestinations
    }

    //This function returns the next
    fun hasNextDestination(boardingCard: BoardingCard?, boardingCards: MutableList<BoardingCard?>) : BoardingCard?{
        if (boardingCard!!.destination == null)
            return null
        for (card in boardingCards){
            if (card!!.origin.equals(boardingCard!!.destination) && card != boardingCard)
                return card.copy()
        }
        return null
    }
}