import java.io.*;

public class Sonnet18 {

    Caesar caesar;

    StringBuilder sonnet = new StringBuilder();

    public Sonnet18(int shift) {
        this.caesar = new Caesar(shift);
    }

    public String readFile(String filepath){
        String result = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line = "";
            while ((line = br.readLine()) != null) {
                result += line + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        System.out.println(result);
        return result.substring(0, result.length() - 1);
    }


    public void writeFile(String filepath,String sonnet) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
            bw.write(sonnet);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }


    }

    public StringBuilder getSonnet() {
        return sonnet;
    }

    public static void main(String[] args) {
        Sonnet18 sonnet18 = new Sonnet18(0);
        String currentProjectDirectory = System.getProperty("user.dir");
        String fileName = currentProjectDirectory + "/Crypto/resource/sonnet18.txt";
        System.out.println(fileName);
        String test = sonnet18.readFile(fileName);
        System.out.println(test);
    }

}
