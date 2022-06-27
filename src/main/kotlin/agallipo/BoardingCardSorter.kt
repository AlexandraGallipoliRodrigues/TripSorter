package agallipo

import java.io.ObjectInputFilter.merge

class BoardingCardSorter {

    fun sortTickets(boardingCards: List<BoardingCard?>) : MutableList<MutableList<BoardingCard?>> {
        var flightPaths = mutableListOf<MutableList<BoardingCard?>>()
        for (boardingCard in boardingCards) {
            if (!matchFlightPath(boardingCard, flightPaths))
                flightPaths.add(mutableListOf<BoardingCard?>(boardingCard))
            checkJoinFlightPath(flightPaths)
        }
        return flightPaths
    }

    fun matchFlightPath(boardingCard: BoardingCard?, flightPaths : MutableList<MutableList<BoardingCard?>>) : Boolean {
        for (path in flightPaths) {
            if (boardingCard!!.destination == path[0]!!.origin) {
                path.add(0,boardingCard)
                return true
            }
            if (boardingCard!!.origin == path[path.size - 1]!!.destination) {
                path.add(boardingCard)
                return true
            }
        }
        return false
    }

    fun checkJoinFlightPath(flightPaths : MutableList<MutableList<BoardingCard?>>) {
        var i = 0
        var j : Int

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