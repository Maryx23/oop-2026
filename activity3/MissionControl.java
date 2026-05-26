import java.time.format.DateTimeFormatter;

public class MissionControl {
    public static void main(String[] args) {
        SecretAgent agent = new SecretAgent("007", "James Bond", 5);

        System.out.println("Agent ID: " + agent.getAgentId());
        System.out.println("Codename: " + agent.getCodename());
        System.out.println("Clearance: " + agent.getClearanceLevel());
        System.out.println("On Mission: " + agent.isOnMission());
        System.out.println();

        Mission m = new Mission();
        m.displayMissionBriefing();
        System.out.println();

        if (agent.getClearanceLevel() >= m.getDifficulty()) {
            System.out.println("Agent 007 is cleared for mission.");
            agent.startMission();
            System.out.println("Updated Mission Status: " + agent.isOnMission());
            System.out.println();

            System.out.println("Simulating mission passing...");
            agent.completeMission();
            System.out.println();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("Final Mission Status: " + agent.isOnMission());
            System.out.println("Completed: " + agent.getLastMissionCompletionTime().format(formatter));
        } else {
            System.out.println("Agent 007's clearance is too low for this mission.");
        }
    }
}