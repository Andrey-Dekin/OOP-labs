import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
public class Transport {
    String type;
    String brand;
    float speed;
    int owners;

    public Transport(String type,String brand,float speed,int owners)
    {
        this.type=type;
        this.brand=brand;
        this.speed=speed;
        this.owners=owners;
    }
    public Transport(String type,String brand,float speed)
    {
        this.type=type;
        this.brand=brand;
        this.speed=speed;
        this.owners=0;
    }
    public static void printToFile(Transport[] transports){
        try {
            PrintStream out=new PrintStream(new File("D:/myJavaProj/ooplab1/src/data.txt"));
            for(Transport transport:transports){out.println(transport.type + " " + transport.brand + " " + transport.speed + " " + transport.owners);}
        }
        catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
    public static void sortBySpeed(Transport[] transports){
        //сортировка по скорости
        for (int i = 0; i < transports.length; i++) {
            int j_max = i;
            for (int j = i + 1; j < transports.length; j++) {
                if (transports[j_max].speed < transports[j].speed) {
                    j_max = j;
                }
            }
            Transport temp = transports[i];
            transports[i] = transports[j_max];
            transports[j_max] = temp;
        }
    }
    public static void sortByOwners(Transport[] transports){
        //сортировка по числу владельцев
        for (int i = 0; i < transports.length; i++) {
            int j_max = i;
            for (int j = i + 1; j < transports.length; j++) {
                if (transports[j_max].owners < transports[j].owners) {
                    j_max = j;
                }
            }
            Transport temp = transports[i];
            transports[i] = transports[j_max];
            transports[j_max] = temp;
        }
    }
    public static void main(String[] args)
    {
        Transport transports[]=new Transport[14];
        transports[0]=new Transport("Car","BMW",200,3);
        transports[1]=new Transport("Car","Audi",180,1);
        transports[2]=new Transport("Car","Skoda",185,2);
        transports[3]=new Transport("Car","Matiz",140);
        transports[4]=new Transport("truck","KAMAZ",120,6);
        transports[5]=new Transport("truck","Mercedes",140,3);
        transports[6]=new Transport("Car","Jeep",180);
        transports[7]=new Transport("Bus","Mercedes",145,9);
        transports[8]=new Transport("Bus","PAZ",120,7);
        transports[9]=new Transport("Bus","GAZ",125,4);
        transports[10]=new Transport("Car","Lada",180,3);
        transports[11]=new Transport("Car","Audi",180);
        transports[12]=new Transport("Car","Skoda",180);
        transports[13]=new Transport("Car","BMW",240);
        //сортировка по количеству владельцев
        //sortByOwners(transports);

        //сортировка по скорости
        //sortBySpeed(transports);

        //вывод в файл
        printToFile(transports);
    }
}
