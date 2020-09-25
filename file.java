import java.io.*;
import java.util.Scanner;

class file{
    String name,id,adress,course,branch,phone;
    void add_data(){
        Scanner in=new Scanner(System.in);

        System.out.println("Id:");
        id=in.nextLine();
        
        System.out.println("\nName:");
        name=in.nextLine();
        
        System.out.println("\nAdress:");
        adress=in.nextLine();

        System.out.println("\nCourse:");
        course=in.nextLine();

        System.out.println("\nBranch:");
        branch=in.nextLine();

        System.out.println("\nPhone:");
        phone=in.nextLine();

    }
    

    
    void create(){
        System.out.println("Enter date");
        add_data();
        try{
            File f=new File(id+".txt");
            if(f.createNewFile()){
               
                Writer data=new FileWriter(f);

                data.write("ID      :"+id);
                data.write("\nName    :"+name);
                data.write("\nAdress  :"+adress);
                data.write("\nCourse  :"+course);
                data.write("\nBranch  :"+branch);
                data.write("\nPhone   :"+phone);
                data.close();
                System.out.println("Successfully created the file\n");
            }
            else{
                System.out.println("Already exists");
            }


        }catch(IOException e){}
    }
    static void delete(){
        String file;
        System.out.println("Enter the file Id to be deleted\n");
        Scanner in =new Scanner(System.in);
        file=in.nextLine();

        File f=new File(file+".txt");
        if(f.delete()){
            System.out.println("Deleted Successfully\n");
        }
        else{
                System.out.println("File does not exists");
        } 
    }

    static void search(){
        System.out.println("Enter id of file to be searched\n");
        Scanner in=new Scanner(System.in);
        String file=in.nextLine();
        try{
            File f=new File(file+".txt");
            if(f.exists()){
                FileReader r =new FileReader(file+".txt");
                int data;
                while((data=r.read())!=-1){
                    System.out.print((char)data);
                }
            }
            else{
                f.delete();
                System.out.println("Required file does not exist");
            }
           
        }catch(IOException e){}
    }
    void change(){
        System.out.println("Enter the id of file to be modified\n");
        Scanner in=new Scanner(System.in);
        String file=in.nextLine();

        try{
           File f=new File(file+".txt");
           if(f.exists()){
               System.out.println("Enter new data\n");
               System.out.println("Please Enter same id\n");
               add_data();
               PrintWriter w=new PrintWriter(file+".txt");
               w.write("");
               Writer data=new FileWriter(file+".txt");
              
               data.write("\nID      :"+id);
               data.write("Name    :"+name);
               data.write("\nAdress  :"+adress);
               data.write("\nCourse  :"+course);
               data.write("\nBranch  :"+branch);
               data.write("\nPhone   :"+phone);
               data.close();
               System.out.println("Successfully changes the data\n");

               
           }
           else{
               System.out.println("Required file does not exists\n");
           }
        }catch(IOException e){}
    }
}



class drive{
    public static void main(String[] args){
        int choice;
       
        while(true){
            System.out.println("Enter the operation to be performed\n");
            System.out.println("1. ADD\n2. Delete\n3. Search\n4. Change\n0. Exit");
            Scanner in=new Scanner(System.in);
            choice=in.nextInt();
            switch(choice){
                case 0:return;

                case 1:file o=new file();
                       o.create();
                       break;

                case 2:file.delete();  
                       break;
                       
                       
                case 3:file.search();
                       break;
                 
                case 4:file c=new file();
                       c.change();
                       break;     
        }
    }

    }
} 