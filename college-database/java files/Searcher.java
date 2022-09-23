//package collegedatabase;
import java.util.*;
class Searcher
{   College college;
    public Searcher(College temp)
    {
        this.college=temp;
    }

    public void databaseSearcher()
    {
        System.out.print("\n1)Print Staff\n2)Print Professor\n3)Print Assistant\n4)Print HOD\n5)Print Students\n6)Search\nEnter your chice:- ");
        int ch=0;
        ch=Project.integerinput("Enter you choice: ");
        switch(ch)
        {
            case 1:
                Project.clearscreen();
                facultyPrinter();
                break;
            case 2:
                Project.clearscreen();
                professorPrinter();
                break;
            case 3:
                Project.clearscreen();
                assistantPrinter();
                break;
            case 4:
                Project.clearscreen();
                facultyPrinter("hod");
                break;
            case 5:
                Project.clearscreen();
                studentPrinter();
                break;
            case 6:
                Project.clearscreen();
                searcher();
                break;
            default :
                System.out.print("INVALID INPUT !!!");
        }



    }
    public  void studentPrinter()
    {   System.out.print("\n1)Print all \n2)Print based on department ");
        int ch=0;
        ch=Project.integerinput("Enter you choice: ");
        List<Students> studentDatabase=null;
        if(college.studentDatabase.isEmpty())
        {
            System.out.print("\nNO RECORDS FOUNDD!!!\n");
            return;
        }
        switch(ch)
        {
            case 1:
                studentDatabase=college.studentDatabase;
                break;
            case 2:
                System.out.print("Enter the department to print "+college.deptprinter()+":- ");
                String dept=Project.stringinput();
                studentDatabase=college.departmentDatabase.get(dept).studentDatabase;
                break;
            default :
                System.out.print("INVALID INPUT!!");
        }
        if(studentDatabase==null)
        {
            return;
        }
        for(Students stu:studentDatabase)
        {
            System.out.print(stu+"\n________________________________________________________________________________________\n");
        }
    }
    public  void facultyPrinter()
    {
        System.out.print("\n1)Print all \n2)Print based on department ");
        int ch=0;
        ch=Project.integerinput("Enter you choice: ");
        List<Staff> staffDatabase=null;
        if(college.StaffDatabase.isEmpty())
        {
            System.out.print("\nNO RECORDS FOUNDD!!!\n");
            return;
        }
        switch(ch)
        {
            case 1:
                staffDatabase=college.StaffDatabase;
                break;
            case 2:
                System.out.print("Enter the department to print "+college.deptprinter()+":- ");
                String dept=Project.stringinput();
                staffDatabase=college.departmentDatabase.get(dept).staffDatabase;
                break;
            default :
                System.out.print("INVALID INPUT!!");
        }
        if(staffDatabase==null)
        {
            return;
        }
        for(Staff fac:staffDatabase)
        {
            if(fac.designation.equalsIgnoreCase("staff"))
            {
                System.out.print("\n"+fac+"_________________________________________________________________________________\n");
            }
        }
    }
    public  void professorPrinter()
    {
        System.out.print("\n1)Print all \n2)Print based on department ");
        int ch=0;
        ch=Project.integerinput("Enter you choice: ");
        List<Staff> staffDatabase=null;
        if(college.StaffDatabase.isEmpty())
        {
            System.out.print("\nNO RECORDS FOUNDD!!!\n");
            return;
        }
        switch(ch)
        {
            case 1:
                staffDatabase=college.StaffDatabase;
                break;
            case 2:
                System.out.print("Enter the department to print "+college.deptprinter()+":- ");
                String dept=Project.stringinput();
                staffDatabase=college.departmentDatabase.get(dept).staffDatabase;
                break;
            default :
                System.out.print("INVALID INPUT!!");
        }
        if(staffDatabase==null)
        {
            return;
        }
        for(Staff  fac:staffDatabase)
        {
            if(fac.designation.equalsIgnoreCase("professor"))
            {
                System.out.print("\n"+(Professor)fac+"_________________________________________________________________________________\n");
            }
        }
    }
    public  void assistantPrinter()
    {
        System.out.print("\n1)Print all \n2)Print based on department ");
        int ch=0;
        ch=Project.integerinput("Enter you choice: ");
        List<Staff> staffDatabase=null;
        if(college.StaffDatabase.isEmpty())
        {
            System.out.print("\nNO RECORDS FOUNDD!!!\n");
            return;
        }
        switch(ch)
        {
            case 1:
                staffDatabase=college.StaffDatabase;
                break;
            case 2:
                System.out.print("Enter the department to print "+college.deptprinter()+":- ");
                String dept=Project.stringinput();
                staffDatabase=college.departmentDatabase.get(dept).staffDatabase;
                break;
            default :
                System.out.print("INVALID INPUT!!");
        }
        if(staffDatabase==null)
        {
            return;
        }
        for(Staff fac:staffDatabase)
        {
            if(fac.designation.equalsIgnoreCase("assistant"))
            {
                System.out.print("\n"+(Assistant)fac+"_________________________________________________________________________________\n");
            }
        }
    } 
    public  void facultyPrinter(String designation)
    {   
        for(Staff fac:college.StaffDatabase)
        {
            if(fac.designation.equalsIgnoreCase(designation))
            {
                System.out.print("\n"+fac+"_________________________________________________________________________________\n");
            }
        }

    }
    public void studentSearcher(int rno)
    {
        int f=0;
        for(Students stu:college.studentDatabase)
        {
            if(stu.rno==rno)
            {
                System.out.print("\n_____________________________________________________\n");
                System.out.print(stu+"\n____________________________________________________________\n");
                f=1;
            }
        }
        if(f==0)
        {
            System.out.print("Record Not Found!!!!!!");
        }
    }
    public void studentSearcher(String number)
    {
        int f=0;
        for(Students stu:college.studentDatabase)
        {
            if(stu.number.equalsIgnoreCase(number))
            {
                System.out.print("\n_____________________________________________________\n");
                System.out.print(stu+"\n____________________________________________________________\n");
                f=1;
            }
        }
        if(f==0)
        {
            System.out.print("Record Not Found!!!!!!");
        }
    }
    public void staffSearcher(int id)
    {
        int f=0;
        for(Staff fac:college.StaffDatabase)
        {
            if(fac.id==id)
            {
                
                System.out.print("\n_____________________________________________________\n");
                System.out.print(fac+"\n____________________________________________________________\n");
                f=1;
            }
        }
        if(f==0)
        {
            System.out.print("Record Not Found!!!!!!");
        }
    }
    public void staffSearcher(String number)
    {
        int f=0;
        for(Staff fac:college.StaffDatabase)
        {
            if(fac.number.equals(number))
            {
                
                System.out.print("\n_____________________________________________________\n");
                System.out.print(fac+"\n____________________________________________________________\n");
                f=1;
            }
        }
        if(f==0)
        {
            System.out.print("Record Not Found!!!!!!");
        }
    }
    public void searcher()
    {
        System.out.print("\n1)Student\n2)Staff\nEnter you choice:- ");
        int ch=Project.integerinput("Enter you choice: ");
        switch(ch)
        {
            case 1:
                System.out.print("\n1)Rno search \n2)Phone number search\nEnter your choice:- ");
                int ch1=Project.integerinput("Enter you choice: ");
                switch(ch1)
                {
                    case 1:
                        System.out.print("\nEnter Rno: ");
                        int rno=Project.integerinput("Enter Rno: ");
                        studentSearcher(rno);
                        break;
                    case 2:
                        System.out.print("Enter Number:- ");
                        String number=Project.stringinput();
                        studentSearcher(number);
                        break;
                    default:
                        System.out.print("INVALID INPUT!!!");
                }
                break;
            case 2:
            System.out.print("\n1)Rno search \n2)Phone number search\nEnter your choice:- ");
            int ch2=Project.integerinput("Enter you choice: ");
            switch(ch2)
            {
                case 1:
                    System.out.print("\nEnter ID: ");
                    int rno=Project.integerinput("Enter ID: ");
                    staffSearcher(rno);
                    break;
                case 2:
                    System.out.print("Enter Number:- ");
                    String number=Project.stringinput();
                    staffSearcher(number);
                    break;
                default:
                    System.out.print("INVALID INPUT!!!");
            }
            break;
                
        }
        
    }
}