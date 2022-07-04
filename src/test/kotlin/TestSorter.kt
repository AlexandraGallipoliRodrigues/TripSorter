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
         var mock = mockk<BoardingCard>()
        val boardingCardSorter = BoardingCardSorter()
        val cards = listOf(
            BoardingCard("A", "B", "something", "", ""),
            BoardingCard("B", "C", "something", "", ""),
            BoardingCard("C", "A", "something", "", ""),
            BoardingCard("Two", "Three", "something", "", ""),
            BoardingCard("One", "Two", "something", "", ""),
            BoardingCard("Three", "Four", "something", "", ""),
        )

        val journeys = boardingCardSorter.sortTickets(cards)
        for (journey in journeys){
            assertTrue("Cards should be sorted") {
                journey.zipWithNext().all { pair ->
                    pair.first.destination == pair. second.origin
                }
            }
        }
    }
}
