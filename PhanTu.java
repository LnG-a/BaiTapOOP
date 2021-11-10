import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PhanTu<T extends Comparable> {
    private T value;

    PhanTu(T value){
        this.value=value;
    }

    public <T extends Comparable<T>> boolean isGreaterThan(T a){
       if (a.compareTo((T) value)>0){
           return false;
       }
       return true;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        String path= "input.txt";
        List<PhanTu> a= new ArrayList<>();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Integer data = scanner.nextInt();
                a.add(new PhanTu(data));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            File file = new File("output.txt");
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file);
            for (int i=0;i<a.size();i++){
                myWriter.write(a.get(i).getValue()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
