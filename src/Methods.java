import java.io.BufferedReader;
import java.io.FileReader;

public class Methods {
public static void main(String[] args){
    Methods methods = new Methods();
    methods.display();
}
    public void display() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Downloads\\familinx-anon\\familinx-anon\\familinx\\relations-anon.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String data[] = new String[2];
                data = s.split("\t");
                for (int i = 0; i < 2; i++) {
                    System.out.print(data[i] + "\t");
                }
                System.out.println();
            }
        }
        catch(Exception e){
        }
    }
}
