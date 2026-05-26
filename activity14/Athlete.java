import java.util.ArrayList;

public class Athlete implements Competitor, Comparable<Athlete>, Cloneable {
    private String name;
    private int score;
    private ArrayList<String> trophies;

    public Athlete(String name, int score) {
        this.name = name;
        this.score = score;
        this.trophies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getTrophies() {
        return trophies;
    }

    public void addTrophy(String trophy) {
        trophies.add(trophy);
    }

    @Override
    public void playMatch() {
        System.out.println(name + " is playing a match.");
    }

    @Override
    public int compareTo(Athlete other) {
        int scoreCompare = Integer.compare(other.score, this.score);
        if (scoreCompare != 0) {
            return scoreCompare;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public Athlete clone() {
        try {
            Athlete cloned = (Athlete) super.clone();
            cloned.trophies = new ArrayList<>(this.trophies);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Athlete [Name: " + name + ", Score: " + score + ", Trophies: " + trophies + "]";
    }
}