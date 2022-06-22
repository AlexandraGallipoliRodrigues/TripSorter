# TripSorter

This project is a solution of the following task:

"You are given a stack of boarding cards for various transportations that will take you from a point A to point B via several stops on the way. All of the boarding cards are out of order and you don't know where your journey starts, nor where it ends. Each boarding card contains information about seat assignment, and means of transportation (such as flight number, bus number etc).

Provide an API that lets you sort this kind of list and present back a description of how to complete your journey. For instance the API should be able to take an unordered set of boarding cards, provided in a format defined by you, and produce this list:

- Take train 78A from Madrid to Barcelona. Sit in seat 45B.
- Take the airport bus from Barcelona to Gerona Airport. No seat assignment.
- From Gerona Airport, take flight SK455 to Stockholm. Gate 45B, seat 3A. Baggage drop at ticket counter 344.
- From Stockholm, take flight SK22 to New York JFK. Gate 22, seat 7B. Baggage will we automatically transferred from your last leg.
- You have arrived at your final destination.

The list should be defined in a format that's compatible with the input format."

This approach takes a path of a JSON with the following format:

{
origin": Madrid
"destination": Barcelona
"transport": train 78A
"gate": 0
"seat":45B
}

The origin and destination can both have a null value.

# Explanation

The `BoardingCardFile`  class, which implements the `BoardingCardsReader` interface, takes a path as a parameter. The class reads the file, adding the information to a mutable list.

The `BoardingCardJsonParser` class first classifies the boarding cards. The delimiters of each card are the braces, so as long as the string is different to `{}`,  it adds the information to a `BoardingCard` data class checking if the line corresponds to the variables: `origin, destination, transport, gate or seat.`

Once the boarding tickets are initialized, the interface `BoardingCardSorter` will sort the different journeys. The algorithm implemented is based on the solitary game. So as it iterates over each path it checks the following statements:

<img width="814" alt="foto" src="https://user-images.githubusercontent.com/83506452/175073698-5606b04e-eaa5-47ea-8e1f-8c3449fcccde.png">



