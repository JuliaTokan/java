package url;

public class Main {

    public static void main(String[] args) {
        URLAddress urlAddress = new URLAddress("http://www.examples.com/search?category=shoe&brand=nike&color=red&size=5&pricefrom=10&priceto=1000#10");
        urlAddress.print();
    }
}
