
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int x = 0;
        String y="a";


        int a,a2=0,b,b2=0,c,d;

        int xa,xa2=0,xb,xb2=0,xc,xd;

        try (BufferedReader br = Files.newBufferedReader(Paths.get("przyklad.txt"))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");



                if(line.charAt(0) == line.charAt(line.length()-1)) {
                    x++;
                    if(x==1){
                        y = line;
                    }
                }

                a = Integer.parseInt(line);
                b=0;
                c = a;
                d=2;
                while(c>1){
                    if(c%d==0){
                        c=c/d;
                        d=2;
                        ++b;
                    }
                    else{
                        ++d;
                    }
                }
                if(b>b2){
                    b2=b;
                    a2=a;
                }




                xa = Integer.parseInt(line);
                xb=0;
                xc = xa;
                xd=2;
                while(xc>1 && xd<20){
                    if(xc%xd==0){
                        xc=xc/xd;
                        ++xb;

                    }
                    ++xd;

                }
                if(xb>xb2){
                    xb2=xb;
                    xa2=xa;
                }


            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        System.out.println(sb);
        System.out.println("ilość: "+x);
        System.out.println("pierwsza: "+y);
        System.out.println("najdzielniejsza: "+a2);
        System.out.println("dzielności: "+b2);
        System.out.println("rozna najdzielniejsza: "+a2);
        System.out.println("rozne dzielności: "+b2);


    }

}
