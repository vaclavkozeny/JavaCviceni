package src.leto.cv12;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Rekurze {
    public static void main(String[] args) throws IOException {
//        for (int i = 1; i < 19; i++) {
//            System.out.println(i + "! = " + factorial(i));
//        }
//        for (int i = 1; i < 32; i++) {
//            System.out.println("-2^" + i + " = " + mocnina(-2, i));
//        }
//        System.out.println(mocnina(-2,-6));
//        System.out.println(mocnina(9,2));
//        towerOfHanoi(3, 'A', 'B', 'C');
        System.out.println(fileTree("D:\\Steam\\"));
    }
    public static long factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n-1);
    }
    public static double mocnina(double n, int m) {
        if (m == 1) return n;
        if (m == 0) return 1;
        if(m < 0) return 1 / mocnina(n, -m);
        return n * mocnina(n, m-1);
    }
    public static void towerOfHanoi(int n, char z, char na, char pom) {
        if(n > 0){
            towerOfHanoi(n-1, z, pom, na);
            System.out.println("Presun disk " + n + " z " + z + " na " + na);
            towerOfHanoi(n-1, pom, na, z);
        }

    }
    public static int fileTree(String path) throws IOException {
//        Path p = Path.of(path);
//        for (var f : p.toFile().listFiles()) {
//            if(f.isDirectory()){
//                System.out.println( "------------------------------ " + f.getName() + " ------------------------------");
//                fileTree(f.getAbsolutePath());
//            }else {
//                System.out.println(f.getName());
//            }
//        }
        int ps = 0;
        DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(Path.of(path));
        for(Path p : pathDirectoryStream){
            if(Files.isDirectory(p)){
                ps += fileTree(p.toString());
            }else{
                ps++;
            }
        }
        return ps;
    }
}
