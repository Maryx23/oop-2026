import java.util.Collections;

public class TournamentDemo {
    public static void main(String[] args) {
        Tournament<Athlete> tournament = new Tournament<>();

        Athlete a1 = new Athlete("Alice", 85);
        Athlete a2 = new Athlete("Bob", 95);
        Athlete a3 = new Athlete("Charlie", 85);

        a1.addTrophy("Gold Medal");
        a2.addTrophy("Silver Medal");

        tournament.addParticipant(a1);
        tournament.addParticipant(a2);
        tournament.addParticipant(a3);

        System.out.println("--- Before Sorting ---");
        tournament.showAll();
        System.out.println();

        Collections.sort(tournament.getParticipants());

        System.out.println("--- After Sorting (Descending Score, Alphabetical Name Tie-Breaker) ---");
        tournament.showAll();
        System.out.println();

        System.out.println("--- Testing Clone (Deep Copy) ---");
        Athlete original = a1;
        Athlete clone = original.clone();
        clone.addTrophy("Championship Cup");

        System.out.println("Original: " + original);
        System.out.println("Clone:    " + clone);
        System.out.println();

        System.out.println("--- Testing Competitor Interface Methods ---");
        original.playMatch();
        original.reportStatus();
        
        System.out.println("Is score 95 valid? " + Competitor.isValidScore(95));
        System.out.println("Is score 105 valid? " + Competitor.isValidScore(105));
    }
}