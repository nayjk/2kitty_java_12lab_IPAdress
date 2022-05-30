import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите IP адрес: ");
        String ip = in.nextLine();
        Pattern pattern = Pattern.compile("" +
                "\\b([01]?\\d\\d?|2[0-4]\\d|25[0-5])" +
                "\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])" +
                "\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])" +
                "\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\b");
        Matcher m = pattern.matcher(ip);
        if(m.find()){
            System.out.println("Верный IP адрес: ");
            System.out.println(m.group());
            try(FileWriter a = new FileWriter("cat.txt")){
                a.write("Верный адрес: " + m.group());
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            try(FileWriter a = new FileWriter("cat.txt")){
                a.write("НЕВЕРНЫЙ АДРЕС!!!!!!!!!!!!!! ");
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Не найден верный IP адрес");
        }
    }
}