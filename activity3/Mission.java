import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Mission {
    private String missionTarget;
    private LocalDate missionDeadline;
    private int difficulty;

    public Mission() {
        Random r = new Random();
        String[] targets = { "Retrieve stolen data", "Infiltrate enemy base", "Rescue hostage" };
        int index = r.nextInt(targets.length);
        this.missionTarget = targets[index];
        this.difficulty = r.nextInt(10) + 1;
        int days = r.nextInt(24) + 7;
        this.missionDeadline = LocalDate.now().plusDays(days);
    }

    public String getMissionTarget() {
        return missionTarget;
    }

    public LocalDate getMissionDeadline() {
        return missionDeadline;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void displayMissionBriefing() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println("*** MISSION BRIEFING ***");
        System.out.println("Target: " + missionTarget);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Deadline: " + missionDeadline.format(dtf));
    }
}