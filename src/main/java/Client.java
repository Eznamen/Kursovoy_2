import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        InetAddress addr = InetAddress.getByName(host);
        ArrayList<String> aaa = new ArrayList<>();
        aaa.add("{\"title\": \"булка\", \"date\": \"2022.02.08\", \"sum\": 200}");
        aaa.add("{\"title\": \"колбаса\", \"date\": \"2022.22.09\", \"sum\": 456}");
        aaa.add("{\"title\": \"тапки\", \"date\": \"2021.22.09\", \"sum\": 1500}");
        aaa.add("{\"title\": \"мыло\", \"date\": \"2022.01.09\", \"sum\": 120}");
        aaa.add("{\"title\": \"омывайка\", \"date\": \"2022.03.09\", \"sum\": 500}");
        aaa.add("{\"title\": \"курица\", \"date\": \"2022.01.09\", \"sum\": 3049}");
        aaa.add("{\"title\": \"акции\", \"date\": \"2022.01.09\", \"sum\": 15000}");
        String name;

        for (String a : aaa) {
            try (Socket clientSocket = new Socket(addr, 8989);) {

                try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    System.out.println("New connected accepted");
                    out.println(a);
                    name = in.readLine();
                    System.out.println(name);

                }
            }
        }
    }
}