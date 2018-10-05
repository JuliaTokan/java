package developer2;

public class Main {

    public static void main(String[] args) {
        Developer[] list = {
                new JuniorDeveloper("Mike", 500, 0),
                new JuniorDeveloper("Dima", 500, 1),
                new MiddleDeveloper("Vova", 500, 3),
                new SeniorDeveloper("Jack", 500, 5),
                new TeamLeadDeveloper("Robby", 500, 7)
        };
        StringBuilder sb;
        for (Developer d : list) {
            if (d instanceof SeniorDeveloper && d.getSalary() > 1500) {
                sb = new StringBuilder()
                        .append(d.getName())
                        .append(": ")
                        .append(d.getBasicSalary())
                        .append(" -> ")
                        .append(d.getSalary());
                System.out.println(sb.toString());
            }
        }
    }
}
