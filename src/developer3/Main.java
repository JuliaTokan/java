package developer3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Developer[] list = {
                new JuniorDeveloper("Mike", 500, 0),
                new JuniorDeveloper("Dima", 500, 1),
                new MiddleDeveloper("Vova", 500, 3),
                new SeniorDeveloper("Jack", 500, 5),
                new TeamLeadDeveloper("Robby", 500, 7)
        };

        System.out.println("JuniorDevelopers:");
        Developer[] juniorDevelopers = sortJuniorDevelopers(list);
        printList(juniorDevelopers);

        System.out.println("MiddleDevelopers:");
        Developer[] middleDevelopers = sortMiddleDevelopers(list);
        printList(middleDevelopers);

        System.out.println("SeniorDevelopers:");
        Developer[] seniorDevelopers = sortSeniorDevelopers(list);
        printList(seniorDevelopers);

        System.out.println("TeamLeadDevelopers:");
        Developer[] teamLeadDevelopers = sortTeamLeadDevelopers(list);
        printList(teamLeadDevelopers);
    }

    public static Developer[] sortJuniorDevelopers(Developer[] developers) {
        Developer[] juniorDevelopers = new Developer[developers.length];
        int index = 0;
        for (Developer developer : developers) {
            if (developer instanceof JuniorDeveloper) {
                juniorDevelopers[index] = developer;
                index++;
            }
        }
        return Arrays.copyOfRange(juniorDevelopers, 0, index);
    }

    public static Developer[] sortMiddleDevelopers(Developer[] developers) {
        Developer[] middleDevelopers = new Developer[developers.length];
        int index = 0;
        for (Developer developer : developers) {
            if (developer instanceof MiddleDeveloper) {
                middleDevelopers[index] = developer;
                index++;
            }
        }
        return Arrays.copyOfRange(middleDevelopers, 0, index);
    }

    public static Developer[] sortSeniorDevelopers(Developer[] developers) {
        Developer[] seniorDevelopers = new Developer[developers.length];
        int index = 0;
        for (Developer developer : developers) {
            if (developer instanceof MiddleDeveloper) {
                seniorDevelopers[index] = developer;
                index++;
            }
        }
        return Arrays.copyOfRange(seniorDevelopers, 0, index);
    }

    public static Developer[] sortTeamLeadDevelopers(Developer[] developers) {
        Developer[] teamLeadleDevelopers = new Developer[developers.length];
        int index = 0;
        for (Developer developer : developers) {
            if (developer instanceof MiddleDeveloper) {
                teamLeadleDevelopers[index] = developer;
                index++;
            }
        }
        return Arrays.copyOfRange(teamLeadleDevelopers, 0, index);
    }

    public static void printList(Developer[] developers){
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
