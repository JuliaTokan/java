package parseInt;

public class Integer {
    public static int parseint(String number) {
        int res = 0;
        try {
            for (int i = 0; i < number.length(); i++) {
                char num = number.charAt(i);
                checkNumbers(num);
                res = res * 10 + (num - '0');
            }
        } catch (WrongNumberException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return res;
    }

    public static void checkNumbers(char number) throws WrongNumberException {
        if (number < '0' || number > '9')
            throw new WrongNumberException("wrong number");
    }
}
