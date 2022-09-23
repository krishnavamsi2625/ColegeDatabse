import java.util.*;
import java.time.LocalDate;  
import java.time.Period;  
import java.util.regex.*;
import java.lang.*;
class InvalidNumberLengthException extends Throwable 
{
    InvalidNumberLengthException(String desc)
    {
        super(desc);
    }
}
class InvalidNumberTypeException extends Throwable 
{
    InvalidNumberTypeException(String desc)
    {
        super(desc);
    }
}
class Student
{
    String name,gender,email,course,department,dob,number;
    int age,rno;
    public Student(int rno,String name,String gender,String email,String number,String course,String department,String dob,int age)
    {
        this.name=name;
        this.gender=gender;
        this.email=email;

        this.course=course;
        this.department=department;
        this.dob=dob;
        this.rno=rno;
        this.age=age;
        this.number=number;
    }
    public Student()
    {

    }
    public String toString()
    {

        return  "|Roll No:"+this.rno+
        "|\n|Name:"+this.name+
        "|\n|Date of Birth:"+
        this.dob+"|\n|Gender:"+
        this.gender+"|\n|Email:"+
        this.email+"|\n|Number"+
        this.number+"|\n|Age:"+
        this.age+"|\n|Department:"+
        this.department+"|\n|Course:"+
        this.course+"|\n";
    }
}
class Project 
{   
    static LinkedList<Student> database= new LinkedList<>();
  
    public static String  dobValidator(String temp)
    {   String dob="";
        try
        {   dob=stringinput();
            age(dob);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Invalid DOB");
            System.out.print(temp);
            dob=dobValidator(temp);
        }
        return dob;

    }
    
    public static String stringinput()
    {   
        Scanner sc =new Scanner(System.in);
        String returnvalue;
        returnvalue=sc.next();
        //sc.close();
        return returnvalue;
    }
   
    public static double doubleinput(String temp)
    {   double returnvalue=0;
        //int f=0;
        Scanner sc =new Scanner(System.in);
        try 
        {   
            returnvalue = sc.nextDouble();
        }
        catch (Exception e) 
        {   e.printStackTrace();
            System.out.println("Invalid input type !!!!!");
            System.out.print(temp);
            returnvalue=integerinput(temp);
        }
        return returnvalue;     
        
        
    }

    public static int integerinput(String temp)
    {
        Scanner sc=new Scanner(System.in);
        int returnvalue=0;
        try 
        {
            returnvalue = sc.nextInt();
        }
        catch (InputMismatchException e) 
        {   e.printStackTrace();
            System.out.println("Invalid input type !!!!!");
            System.out.print(temp);
            returnvalue=integerinput(temp);
        }
        
        return returnvalue;
    }
    
    public static int     age(String dobb)
    {
        String [] temp=dobb.split("/");
        String   dob=temp[2]+"-"+temp[1]+"-"+temp[0];
        //System.out.println(dob);
        LocalDate input = LocalDate.parse(dob); 
        LocalDate curDate = LocalDate.now();  
        return Period.between(input, curDate).getYears();  

    }
   
    public static  void    printall()
    {   if(database.isEmpty())
        {
            System.out.print("No records found!!");
            return;
        }
        for(Student x:database)
        {
            System.out.print(x);
            System.out.println();
        }
    }
   
    public  static void    inputs(int rno)
    {   
        int age;
        String name,gender,email,course,department,dob,number;
        System.out.print("Enter name:- ");
        name =stringinput();
        System.out.print("Enter gender:- ");
        gender =stringinput();
        do
        {
            System.out.print("Enter email:- ");
            email =stringinput();
            if(emailvalidator(email)==false)
            {
                System.out.print("\nInvalid Email\n");
            }
        }while(emailvalidator(email)==false);
        System.out.print("\nEnter Contact number:- ");
        number=numbervalidator("\nEnter Contact number:- ");
        System.out.print("Enter Course:- ");
        course =stringinput();
        do
        {
            System.out.print("Enter Department:- ");
            department =stringinput();
            if(deptvalidator(department)==1)
            {
                System.out.print("\nInvalid department\n");
            }
        }while(deptvalidator(department)==1);
        System.out.print("Enter date of birth[DD/MM/YYYY]: ");  
        dob=stringinput();
        age =age(dob);
        Student   stu= new Student(rno,name,gender,email,number,course,department,dob,age);
        database.add(stu);
    }
   
    public static void    deptprint()
  {
      
      Map<String,List<Student>> deptvise = new HashMap<>();
      deptvise=deptwisegenerator();
      System.out.print("Enter the dept to print");
      String dept=stringinput();
      if(deptvise.containsKey(dept))
      {
          for(Student s:deptvise.get(dept))
          {
            System.out.println(s.name);
          }
      }
      else
      {
        System.out.println("no dept");
      }
  }
   
    public static  void    update()
{   
    printall();
    System.out.print("Enter the roll no to be changed");
    int no=integerinput("Enter the roll no to be changed ");
    int ch;
    for(Student x:database)
    {
        if(x.rno==no)
        {
            System.out.print("1)Name\n2)DOB\n3)Email\n4)Phone number\n5)Department\n6)Course\n");
            ch=integerinput("Enter you choice: ");
        switch(ch)
        {
             case 1:
                System.out.print("Enter new name:- ");
                String newname;
                newname=stringinput();
                x.name=newname;
         //deptwise.get(x.name)
                break;
            case 2:
                System.out.print("Enter new DOB:- ");
                String newdob=stringinput();
                int newage=age(newdob);
                x.dob=newdob;
                x.age=newage;
                break;
            case 3:
                String email; 
                do
                {
                    System.out.print("Enter  new email:- ");
                    email =stringinput();
                    if(emailvalidator(email)==false)
                    {
                        System.out.print("\nInvalid Email\n");
                     }
                }while(emailvalidator(email)==false);
                x.email=email;
                break;
            case 4:
                String number;
                System.out.print("\nEnter Contact number:- ");
                number=numbervalidator("\nEnter Contact number:- ");
                x.number=number;
                break;
            case 5:
                String newdepart;
                do
                    {   
                        System.out.print("Enter new Department:- ");
                        newdepart=stringinput();
                        if(deptvalidator(newdepart)==1)
                        {
                            System.out.print("\nInvalid number\n");
                        }
                    }while(deptvalidator(newdepart)==1);
                x.department=newdepart;
            case 6:
                System.out.print("Enter new course:- ");
                String newcourse= stringinput();
                x.course=newcourse;
            default:
                System.out.println("invalid input");
    }
}

    }
}
    
    public  static void    search()
{
    
    System.out.print("Search by? 1) roll no 2)Name \nEnter you choice:- ");
    int ch=integerinput("Enter you choice: ");
    int f=1;
    if(database.isEmpty())
        {
            System.out.print("No records found!!");
            return;
        }

    if(ch==1)
    { clearscreen();
        System.out.print("Enter the roll no to be searched:- ");
        int rollno=integerinput("Enter the roll no to be searched:-  ");
        for(Student x:database)
        {
            if(x.rno==rollno)
            {System.out.print(x);
            f=0;}
        }
    }
    else
    {
        System.out.print("Enter name to be searched:- ");
        String namess=stringinput();
        for(Student x:database)
        {
            if(x.name.equals(namess))
            {
                System.out.println(x);
                f=0;
            }
        }
    }
    if(f==1)
    System.out.print("Not found!!!");
}
    
    public  static  boolean emailvalidator(String a)
{
    String regex = "^(.+)@(.+)$";  
    Pattern pattern = Pattern.compile(regex);  
    Matcher matcher = pattern.matcher(a);
    return matcher.matches();
}
    
    public static void    clearscreen()
{
    System.out.print("\033[H\033[2J");
    System.out.flush();

}
    
    public static  void    delete()
{
    
    printall();
    System.out.print("Enter the roll no to be deleted ");
    int deleted=integerinput("Enter the roll no to be deleted:- ");
    for(Student x:database)
    {
        if(x.rno==deleted)
        {
            //String dept= x.department;
            database.remove(x);
            //deptwise.get(dept).remove(x);
        }
    }

}
    
    public static  void    sortedname()
{
    TreeSet<String> names=new TreeSet<>();
    for(Student x:database)
    names.add(x.name);
    System.out.println(names); 
}
    
    public static  void    deptsearch()
{

    Map<String,List<Student>> deptwise = new HashMap<>();
    deptwise=deptwisegenerator();
    String dept;
    System.out.print("Enter the department you need:- ");
    dept=stringinput();
    int ch;
    if(!deptwise.containsKey(dept))
    {
        System.out.println("No record found");
        return;
    }
    System.out.print("\n 1) name 2) Roll no 3)email 4)phone no 5) course 6) DOB 7) Gender 8) age\nEnter you choice: ");
    ch=integerinput("Enter you choice: ");
    System.out.print("Enter the value to search:- " );
    int srno=0;
    String search="";
    if (ch==8 || ch==2)
    {
        srno=integerinput("Enter the value to search:- ");
    }
    else
    { 
        search=stringinput();
    }
    int f=0;
    for(Student x:deptwise.get(dept))
    {
        switch(ch)
        {
            case 1:
                if(search.equals(x.name))
                {
                    System.out.print(x);
                }
                f=1;
                break;
            case 2:
                if(srno==x.rno)
                {
                    System.out.print(x);
                }
                f=1;
                break;
            case 3:
                if(search.equals(x.email))
                {   
                    System.out.print(x);
                }
                f=1;
                break;
            case 4:
                if(search.equals(x.number))
                {   System.out.print(x);
                }
                f=1;
                break;
            case 5:
                if(search.equals(x.course))
                {
                    System.out.print(x);
                }
                f=1;
                break;
                case 6:
                if(search.equals(x.dob))
                 {
                     System.out.print(x);
                 }
                f=1;
                break;
            case 7:
                if(search.equals(x.gender))
                {
                    System.out.print(x);
                }
                f=1;
                break;
            case 8:
                if(srno==x.age)
                {
                    System.out.print(x);
                }
                f=1;
                break;
        }
        if(f==0)
        {
            System.out.print("Not Found");
        }
    }



}
    
    public static  int     deptvalidator(String a)
{
    List<String> depts= new  ArrayList<>();
    depts.add("ece");
    depts.add("cse");
    depts.add("it");
    depts.add("eee");
    int x=depts.indexOf(a);
    //System.out.print(x);
    if(x!=-1)
    {
        return 0;
    }
    return 1;
}
 
    public static  String      numbervalidator(String temp)
{
    String  number="";
    try
    {
        number=stringinput();
        for(int i=0;i<number.length();i++)
        {
            char ch=number.charAt(i);
            if(!Character.isDigit(ch))
            {
                throw new InvalidNumberTypeException("Only numbers");
            }
        }
        if(number.length()<9)
        {   
            throw new InvalidNumberLengthException("Insuffcient number length");
        }

    }
    catch(InvalidNumberTypeException  | InvalidNumberLengthException e)
    {
        e.printStackTrace();
        System.out.print("\n"+temp);
        number=numbervalidator(temp);
    }
    return number;
    
}
    
    public static  Map     deptwisegenerator()
{ 
    Map<String,List<Student>> deptvise = new HashMap<>();
    String department;
    for(Student stu:database)
    {
        department=stu.department;
        if(!deptvise.containsKey(department))
        {
            deptvise.put(department,new ArrayList<Student>());
        }
        //int pos =database.indexOf(stu);
         deptvise.get(department).add(stu);
    }
    return deptvise;

}
}
class Mainprog
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i=1;
        int ch=0;
        Project test=new Project();
        while (ch!=10)
        {
            System.out.println("\n1) add 2)print data 3) Dept print  4) clrscr 5) Search 6) deptsearch 7) update 8) delete 9) sortedname 10) exit ");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                test.inputs(i);
                i++;
                //System.out.print("\033[H\033[2J");
                //System.out.flush();
                break;
                case 2 :
                test.printall();
                break;
                case 3:
                test.deptprint();
                break;
                case 4:
                test.clearscreen();
                break;
                case 5:
                test.search();
                break;
                case 6:
                test.deptsearch();
                break;
                case 7 :
                test.update();
                break;
                case 8:
                test.delete();
                break;
                case 9:
                test.sortedname();
                break;
                case 10:
                System.out.print("++++++++closing+++++++++");
                break;
                default:
                System.out.print("invalid");
            }
       
        }

    }
}

