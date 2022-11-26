import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        File txtFile = new File("categories.tsv");
        File jsonFile = new File("order.json");

        ArrayList<Pokupki> allBuy = new ArrayList<>();
        Map<String, String> try1;
        Map<String, Integer> try2;

        try (ServerSocket serverSocket = new ServerSocket(8989);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключени€
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    String order = in.readLine();
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    Pokupki pokupki = gson.fromJson(order, Pokupki.class);
                    allBuy.add(pokupki);
                    try1 = Answer.Categ(txtFile);
                    try2 = Answer.Answ(allBuy, try1);
                    Map.Entry mapEntry = Category.MaxM(try2);
                    Category category = new Category(mapEntry);
                    MaxCategory maxCategory = new MaxCategory(category);
                    Gson gson1 = new Gson();
                    String maxJ = gson1.toJson(maxCategory);
                    out.println(maxJ);


                }
            }
        } catch (IOException e) {
            System.out.println("Ќе могу стартовать сервер");
            e.printStackTrace();
        }
    }
}