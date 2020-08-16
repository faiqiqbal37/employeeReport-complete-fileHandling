import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class employeeTest {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Employee>arrayList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n\nPress (1) To Add Employee Data To File");
            System.out.println("Press (2) Search From The File");                   // Menu For The User To Select A Choice!
            System.out.println("Press (3) Read The Data From File");
            System.out.println("Press (4) To Exit");

            choice = input.nextInt();
                                                                                    // Initializing choices for the menu through Switch...
            switch (choice) {
                case 1: {

                    Employee employee = new Employee();
                    employee.setName();
                    employee.setEmpID();
                    employee.setHourlyIncome();
                    arrayList.add(employee);






                    try(FileOutputStream fOut = new FileOutputStream("source.ser");
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fOut)){
                        /*
                        FileWriter fileWriter = new FileWriter("source.txt",true);
                        PrintWriter fileInput = null;
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        fileInput = new PrintWriter(bufferedWriter);
                        fileInput.append(arrayList.toString()).append("\n");     // This block is for storing the data in String format.
                        fileInput.flush();
                        fileInput.close();
                        bufferedWriter.close();

                         */






                        for(int i = 0; i<arrayList.size(); i++){
                            objectOutputStream.writeObject(arrayList.get(i));               // THIS BLOCK IS USED TO STORE DATA IN SERIALIZED FORM.....!
                        }
                        objectOutputStream.close();
                        System.out.println("The Object Has Been Successfully Serialized!");
                        break;



                    }



                }
                case 2:{
                    int id;
                    int flag1 = 0;
                    System.out.println("Please Enter The ID To Be Searched: ");
                    id = input.nextInt();
                    FileInputStream fin = null;
                    ObjectInputStream objectInputStream;
                    try {
                        ArrayList<Employee> arrayList1 = new ArrayList<>();
                        fin = new FileInputStream("source.ser");
                        objectInputStream = new ObjectInputStream(fin);

                        for (int i = 0; i < arrayList.size(); i++) {
                            arrayList1.add((Employee) objectInputStream.readObject());
                            if (id == arrayList1.get(i).getEmpID()) {
                                flag1 = 1;
                            }


                        }
                        if (flag1 == 0) {
                            System.out.println("Record Not Found!!!");

                        }
                        else{
                            System.out.println("Record Found Successfully!!!");
                        }
                    }
                    catch (IOException | ClassNotFoundException e){
                        if(fin!=null)fin.close();

                    }
                    break;


                }
                case 3:{
                    FileInputStream fin = null;
                    ObjectInputStream objectInputStream;
                    try{
                        ArrayList<Employee> arrayList1 = new ArrayList<>();
                        fin = new FileInputStream("source.ser");
                        objectInputStream = new ObjectInputStream(fin);

                        for (int i = 0; i<arrayList.size(); i++){
                            arrayList1.add((Employee)objectInputStream.readObject());
                        }
                        System.out.println(arrayList1);
                    }
                    catch (IOException | ClassNotFoundException e){
                        assert fin != null;
                        fin.close();

                    }
                    break;


                }
                case 4:{
                    return;
                }
                default:{
                    System.out.println("Invalid Input!!\nPlease Try Again");
                    break;
                }
            }
        }while(true);
    }
}
