package presentation;


import domain.ClientCo2;
import domain.ClientTemp;

public class Main {

    public static void main(String[] args) {

        ClientTemp clientTemp = new ClientTemp("127.0.0.1", 4000);
        System.out.println(clientTemp.getName());
        System.out.println(clientTemp.getValue());

        ClientCo2 clientCo2 = new ClientCo2("127.0.0.1", 5000);
        System.out.println(clientCo2.getName());
        System.out.println(clientCo2.getValue());












    }
}
