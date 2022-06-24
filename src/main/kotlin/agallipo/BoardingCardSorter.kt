    package agallipo

    import java.io.ObjectInputFilter.merge
    //created by alex :)
    interface BoardingCardSorter {

        //This function divides  all the boarding cards into lists of flight-paths, iterating over all the boarding cards,
        //it first checks if the boarding card can be joined to any journey, if not, it creates a new element in the
        //list of flighPaths. Then it looks over if any flight path can be joined

        fun sortTickets(boardingCards: MutableList<BoardingCard?>): MutableList<MutableList<BoardingCard?>> {
            var flightPaths = mutableListOf<MutableList<BoardingCard?>>()
            for (boardingCard in boardingCards) {
                if (!matchFlightPath(boardingCard, flightPaths))
                    flightPaths.add(mutableListOf<BoardingCard?>(boardingCard))
                checkJoinFlightPath(flightPaths)
            }
            /*for (flight in flightPaths){
                checkJoinFlightPath(flightPaths)
            }*/
            return flightPaths
        }

        //This function iterates over the flight paths and checks,returning a boolean, if the given boarding card as a
        // parameter can be added at the end or beginning of any journey.
        fun matchFlightPath(boardingCard: BoardingCard?, flightPaths: MutableList<MutableList<BoardingCard?>>): Boolean {
            for (path in flightPaths) {
                if (boardingCard!!.origin == path[path.size - 1]!!.destination) {
                    path.add(0, boardingCard)
                    return true
                }
                if (boardingCard!!.destination == path[0]!!.origin) {
                    path.add(boardingCard)
                    return true
                }
            }
            return false
        }

        //This function iterates over all the flight paths and looks over if any of them can be joined, if that occurs it
        //would modify the list of flightPaths adding the elements that matches to the corresponding journey and before
        // deleting the list element that matches
        fun checkJoinFlightPath(flightPaths: MutableList<MutableList<BoardingCard?>>) {
            var i = 0
            var j: Int

            while (i < flightPaths.size - 1) {
                j = i + 1
                while (j < flightPaths.size) {
                    if (flightPaths[i][0]!!.origin == flightPaths[j][flightPaths[j].size - 1]!!.destination) {
                        flightPaths[j].addAll(flightPaths[i])
                        flightPaths.removeAt(i)
                        return
                    }
                    j++
                }
                i++
            }
        }
    }


        //The topological sort algorithm was the firs approach to this problem, bus as whe have more than one journey it
        //can't be applied
        /*
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
    }*/

