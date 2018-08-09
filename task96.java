/*  In a casino, all the playing cards got mixed up, and some of them got lost.
    You have to collect as many full decks as possible.
    You get N mixed up French playing cards as your input.
    The cards are of the following ranks:
    2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A
    The four suits are:
    S - Spade (♠), C - Club(♣), H - Heart(♥), D - Diamond(♦)
    The cards are given using their rank followed by their suit:
    2 of Spades: 2S
    Ace of Clubs: AC
    10 of Hearts: TH
    Write a function that will accept an array of cards and return the number of full
    decks contained in the array.
     Examples:
    a)  ['9C', 'KS', 'AC', 'AH', '8D', '4C', 'KD', 'JC', '7D', '9D', '2H',
        '7C', '3C', '7S', '5C', '6H', 'TH']

        -> 0
    b)  ['2S', '2C', '2D', '2H', '3S', '3C', '3D', '3H', '4S', '4C', '4D', '4H', '5S',
        '5C', '5D', '5H', '6S', '6C', '6D', '6H', '7S', '7C', '7D', '7H', '8S', '8C',
        '8D', '8H', '9S', '9C', '9D', '9H', 'TS', 'TC', 'TD', 'TH', 'JS', 'JC', 'JD',
        'JH', 'QS', 'QC', 'QD', 'QH', 'KS', 'KC', 'KD', 'KH', 'AS', 'AC', 'AD', 'AH',
        '2S', '2C', '2D', '2H', '3S', '3C', '3D', '3H', '4S', '4C', '4D', '4H', '5S',
        '5C', '5D', '5H', '6S', '6C', '6D', '6H', '7S', '7C', '7D', '7H', '8S', '8C',
        '8D', '8H', '9S', '9C', '9D', '9H', 'TS', 'TC', 'TD', 'TH', 'JS', 'JC', 'JD',
        'JH', 'QS', 'QC', 'QD', 'QH', 'KS', 'KC', 'KD', 'KH', 'AS', 'AC', 'AD', 'AH',
        '2S', '2C', '2D', '2H', '3S', '3C', '3D', '3H', '4S', '4C', '4D', '4H', '5S',
        '5C', '5D', '5H', '6S', '6C', '6D', '6H', '7S', '7C', '7D', '7H', '8S', '8C',
        '8D', '8H', '9S', '9C', '9D', '9H', 'TS', 'TC', 'TD', 'TH', 'JS', 'JC', 'JD',
        'JH', 'QS', 'QC', 'QD', 'QH', 'KS', 'KC', 'KD', 'KH', 'AS', 'AC', 'AD']

        -> 2    */
		
public class Casino {

    static int fullDecks(String[] cards) {
        int[] frequencies = new int[52];
        for (String card : cards)
            frequencies[encodeCard(card)]++;
        int minValue = Integer.MAX_VALUE;
        for (int f : frequencies)
            if (minValue > f)
                minValue = f;
        return minValue;
    }

    static int encodeCard(String card) {
        int code = 0;
        char c = card.charAt(0);
        switch (c) {
            case 'T': code = 8; break;
            case 'J': code = 9; break;
            case 'Q': code = 10; break;
            case 'K': code = 11; break;
            case 'A': code = 12; break;
            default: code = Integer.parseInt(String.valueOf(c)) - 2;
        }
        code *= 4;
        c = card.charAt(1);
        switch (c) {
            case 'S': break;
            case 'C': code++; break;
            case 'H': code += 2; break;
            case 'D': code += 3;
        }
        return code;
    }

    public static void main(String[] args) {
        String[] cards = {"2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S",
                "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C",
                "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD",
                "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "AH",
                "2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S",
                "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C",
                "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD",
                "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "AH",
                "2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S",
                "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C",
                "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD",
                "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD"};
        System.out.println(fullDecks(cards));
    }
}