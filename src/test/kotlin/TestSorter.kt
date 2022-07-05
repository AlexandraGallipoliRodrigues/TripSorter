import agallipo.BoardingCard
import agallipo.BoardingCardSorter
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestSorter {
    @Test
    fun test() {
        val cards = listOf(
            BoardingCard("A", "B", "something", "", "", "", ""),
            BoardingCard("B", "C", "something", "", "", "", ""),
            BoardingCard("C", "A", "something", "", "", "", ""),
            BoardingCard("Two", "Three", "something", "", "", "", ""),
            BoardingCard("One", "Two", "something", "", "", "", ""),
            BoardingCard("Three", "Four", "something", "", "", "", ""),
        )
        val boardingCardSorter = BoardingCardSorter(cards)
        val journeys = boardingCardSorter.sortTickets()
        for (journey in journeys){
            assertTrue("Cards should be sorted") {
                journey.zipWithNext().all { pair ->
                    pair.first.destination == pair. second.origin
                }
            }
        }
    }
}
