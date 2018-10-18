package developer3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Developer[] list = {
                new JuniorDeveloper("Mike", 500, 0),
                new JuniorDeveloper("Dima", 500, 1),
                new SeniorDeveloper("Jack", 500, 5),
                new TeamLeadDeveloper("Robby", 500, 7)
        };

        Developer[] juniorDevelopers = new Developer[list.length];
        Developer[] seniorDevelopers = new Developer[list.length];
        Developer[] teamLeadDevelopers = new Developer[list.length];

        int indexJuniorDevelopers = 0;
        int indexSeniorDevelopers = 0;
        int indexTeamLeadDevelopers = 0;

        for (Developer developer : list) {
            if (developer instanceof JuniorDeveloper) {
                juniorDevelopers[indexJuniorDevelopers] = developer;
                indexJuniorDevelopers++;
            } else if (developer instanceof SeniorDeveloper) {
                seniorDevelopers[indexSeniorDevelopers] = developer;
                indexSeniorDevelopers++;
            } else if (developer instanceof TeamLeadDeveloper) {
                teamLeadDevelopers[indexTeamLeadDevelopers] = developer;
                indexTeamLeadDevelopers++;
            }

        }

        juniorDevelopers = Arrays.copyOfRange(juniorDevelopers, 0, indexJuniorDevelopers);
        seniorDevelopers = Arrays.copyOfRange(seniorDevelopers, 0, indexSeniorDevelopers);
        teamLeadDevelopers = Arrays.copyOfRange(teamLeadDevelopers, 0, indexTeamLeadDevelopers);

        System.out.println("JuniorDevelopers:");
        printList(juniorDevelopers);

        System.out.println("SeniorDevelopers:");
        printList(seniorDevelopers);

        System.out.println("TeamLeadDevelopers:");
        printList(teamLeadDevelopers);
    }

    public static void printList(Developer[] developers) {
        StringBuilder sb;
        for (Developer developer : developers) {
            sb = new StringBuilder()
                    .append(developer.getName())
                    .append(": ")
                    .append(developer.getBasicSalary())
                    .append(" -> ")
                    .append(developer.getSalary());
            System.out.println(sb.toString());
        }
    }
}
