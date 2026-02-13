import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class SecretAgent {
    private String agentId;
    private String codename;
    private int clearanceLevel;
    private boolean onMission;
    private LocalDateTime lastMissionCompletionTime;

    public SecretAgent(String agentId, String codename, int clearanceLevel) {
        this.agentId = agentId;
        this.codename = codename;

        if (clearanceLevel >= 1 && clearanceLevel <= 5) {
            this.clearanceLevel = clearanceLevel;
        } else {
            System.out.println("Invalid clearance level. Setting to default level 1.");
            this.clearanceLevel = 1;
        }
        
        this.onMission = false;
        this.lastMissionCompletionTime = null;
    }
    
    public String getAgentId() {
        return agentId;
    }
    
    public String getCodename() {
        return codename;
    }
    
    public int getClearanceLevel() {
        return clearanceLevel;
    }
    
    public boolean isOnMission() {
        return onMission;
    }
    
    public LocalDateTime getLastMissionCompletionTime() {
        return lastMissionCompletionTime;
    }
    
    public void setCodename(String newCodename) {
        this.codename = newCodename;
    }
    
    public void setClearanceLevel(int level) {
        if (level >= 1 && level <= 5) {
            this.clearanceLevel = level;
        } else {
            System.out.println("Invalid clearance level. Clearance level must be between 1 and 5.");
        }
    }
    
    public void startMission() {
        this.onMission = true;
    }
    
    public void completeMission() {
        this.onMission = false;
        this.lastMissionCompletionTime = LocalDateTime.now();
    }

    static class Mission {
        private String missionTarget;
        private LocalDate missionDeadline;
        private int difficulty;
        
        public Mission() {
            Random random = new Random();
            
            String[] possibleMissions = {
                "Retrieve stolen data",
                "Infiltrate enemy base", 
                "Rescue hostage",
                "Unlock Firewall",
                "Eliminate target",
                "Protect the warehouse",
                "Sabotage enemy communications",
                "Gather information",
                "Disarm security"
            };
            
            int targetIndex = random.nextInt(possibleMissions.length);
            this.missionTarget = possibleMissions[targetIndex];
            this.difficulty = random.nextInt(10) + 1;
            int daysToAdd = random.nextInt(24) + 7; 
            this.missionDeadline = LocalDate.now().plusDays(daysToAdd);
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            String formattedDeadline = missionDeadline.format(formatter);
            ;
            System.out.println("         *** Mission briefing ***");
            System.out.println("Target:     " + missionTarget);
            System.out.println("Difficulty: " + difficulty);
            System.out.println("Deadline:   " + formattedDeadline);
            System.out.println("-".repeat(40));
        }
    }
    
    public static void main(String[] args) {
        System.out.println("      *** Mission control system ***");
        System.out.println();
     
         SecretAgent agent = new SecretAgent("007", "Noir", 5);
        

        System.out.println("Agent status report");
        System.out.println("-".repeat(20));
        System.out.printf("Agent ID:          %s%n", agent.getAgentId());
        System.out.printf("Codename:          %s%n", agent.getCodename());
        System.out.printf("Clearance Level:   %d%n", agent.getClearanceLevel());
        System.out.printf("On Mission:        %s%n", agent.isOnMission() ? "Yes" : "No");
        
        LocalDateTime lastMissionTime = agent.getLastMissionCompletionTime();
        String lastMissionStr = (lastMissionTime == null) 
            ? "No missions completed" 
            : lastMissionTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.printf("Last Mission:      %s%n", lastMissionStr);
        
        Mission mission = new Mission();
        mission.displayMissionBriefing();
        
        System.out.println("\n Mission authorization check");
        System.out.println("-".repeat(30));
        System.out.printf("Agent Clearance:   Level %d%n", agent.getClearanceLevel());
        System.out.printf("Mission Difficulty: Level %d%n", mission.getDifficulty());
        
        boolean isAuthorized = agent.getClearanceLevel() >= mission.getDifficulty();
        
        if (isAuthorized) {
            System.out.println("\n Authorization granted");
            System.out.println("Agent " + agent.getAgentId() + " is cleared for mission.");
            agent.startMission();
        } else {
            System.out.println("\n Authorization denied");
            System.out.println("Agent " + agent.getAgentId() + "'s clearance is too low for this mission.");
            System.out.println("\nMission aborted. Returning to base.");
            return;
        }
        
        System.out.println("\n agent update");
        System.out.println("-".repeat(20));
        System.out.printf("Agent ID:   %s%n", agent.getAgentId());
        System.out.printf("On Mission: %s%n", agent.isOnMission() ? "Yes [Active]" : "No");
        
        System.out.println("\n" + "-".repeat(50));
        System.out.println("Mission in progress ...");
        System.out.println("-".repeat(50));
        
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            Thread.sleep(500);
            System.out.println("\n");
        } catch (InterruptedException e) {
            System.out.println("\nMission simulation interrupted.");
        }
        
        agent.completeMission();
        System.out.println("Mission complete.");
        
        System.out.println("\n Agent Status");
        System.out.println("-".repeat(20));
        System.out.printf("Agent ID:   %s%n", agent.getAgentId());
        System.out.printf("On Mission: %s%n", agent.isOnMission() ? "Yes" : "No [Standby for more orders]");
        
        LocalDateTime completionTime = agent.getLastMissionCompletionTime();
        if (completionTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' HH:mm:ss");
            String formattedTime = completionTime.format(formatter);
            System.out.printf("Completed:  %s%n", formattedTime);
        }
        
    }
}