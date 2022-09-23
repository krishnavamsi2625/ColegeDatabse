//package collegedatabase;
class InvalidMailTypeException extends Throwable
{
    InvalidMailTypeException(String desc)
    {
        System.out.println(desc);
    }
}
class InputGetter
{   
    public static void  emailThrower() throws InvalidMailTypeException
    {
        throw new InvalidMailTypeException("Cant end with .");
        
    }
    College college;
    public InputGetter(College temp)
    {
        this.college=temp;
    }
    public  Students  studentInputer(String designation) throws InvalidMailTypeException
    {
        int age;
        String name,gender,email,course,department,dob,number;
        System.out.print("\nEnter name:- ");
        name =Project.stringinput();
        System.out.print("\nEnter gender:- ");
        gender =Project.stringinput();
        do
        {
            System.out.print("\nEnter email:- ");
            email =Project.stringinput();
            if(Project.emailvalidator(email)==false)
            {
                System.out.print("\nInvalid Email\n");
            }
        }while(Project.emailvalidator(email)==false);

        if(email.charAt(email.length()-1)=='.')
        { 
            emailThrower();

        }
        
        System.out.print("\nEnter Contact number:- ");
        number=Project.numbervalidator("\nEnter Contact number:- ");
        System.out.print("\nEnter Course:- ");
        course =Project.stringinput();
        do
        {
            System.out.print("\nEnter Department "+college.deptprinter()+":- ");
            department =Project.stringinput();
            //Department dept;
            if(!college.deptvalidator(department))
            {
                System.out.print("\nInvalid department\n");
            }
        }while(!college.deptvalidator(department));
        Department dept=college.departmentDatabase.get(department);
        System.out.print("\nEnter date of birth[DD/MM/YYYY]: ");  
        dob=Project.dobValidator("Enter date of birth[DD/MM/YYYY]: ");
        age=Project.age(dob);
        System.out.print("\nEnter the cgpa:- ");
        double cgpa=Project.doubleinput("Enter the cgpa:- ");
        int fees=Students.Feecaluclator(cgpa);
        int rno=Students.rid;
        //Students.rid++;
        Students stu = new Students(rno, name, gender, email, number, course, dept, dob, age, fees, cgpa, designation);
        Students.rid++;
        return stu;
    }
    public  Staff staffInputer(String designation) throws InvalidMailTypeException
    {
           
        int age;
        String name,gender,email,qualification,department,dob,number;
        System.out.print("\nEnter name:- ");
        name =Project.stringinput();
        System.out.print("\nEnter gender:- ");
        gender =Project.stringinput();
        do
        {
            System.out.print("\nEnter email:- ");
            email =Project.stringinput();
            if(Project.emailvalidator(email)==false)
            {
                System.out.print("\nInvalid Email\n");
            }
        }while(Project.emailvalidator(email)==false);
        if(email.charAt(email.length()-1)=='.')
        { 
            // throw new InvalidMailTypeException("Cant end with .");
            emailThrower();
        }
        
        
        System.out.print("\nEnter Contact number:- ");
        number=Project.numbervalidator("\nEnter Contact number:- ");
        System.out.print("\nEnter Qualification:- ");
        qualification =Project.stringinput();
        do
        {
            System.out.print("\nEnter Department "+college.deptprinter()+":- ");
            department =Project.stringinput();
            //System.out.println("test");
            if(!college.deptvalidator(department))
            {
                System.out.print("\nInvalid department\n");
            }
        }while(!college.deptvalidator(department));
        System.out.print("\nEnter date of birth[DD/MM/YYYY]: ");  
        dob=Project.dobValidator("Enter date of birth[DD/MM/YYYY]: ");
        age=Project.age(dob);
        int fid=Staff.fid;
        if(designation.equals("staff"))
        {
            Staff fac=new Staff(fid, age, name, qualification, dob, number, email, department, designation,gender);
            Staff.fid++;
            return fac;
        }
        else if(designation.equalsIgnoreCase("professor"))
        {   String classhandled;
            System.out.print("\nEnter the class handled : ");
            classhandled=Project.stringinput();
            //int fid=Integer.valueOf(Staff.fid);
            Staff fac=new Professor(fid, age, name, qualification, dob, number, email, department, designation,gender,classhandled);
            Staff.fid++;
            return fac;
        }  
        String labHandled;
        System.out.print("\nEnter the Lab handled : "+ college.labPrinter()+": ");
        labHandled=Project.stringinput();
        Lab temp=null;
        for(String labName:college.labDatabase.keySet())
        {
            if(labName.equalsIgnoreCase(labHandled))
            {
                temp=college.labDatabase.get(labName);
                break;
            }
        }
    //int fid=Integer.valueOf(Staff.fid);
        Staff fac=new Assistant(fid, age, name, qualification, dob, number, email, department, designation,gender,temp);
        Staff.fid++;
        return fac;
        
    } 
    public  Staff  staffInputer(String designation,String department) throws InvalidMailTypeException
    {   
        int age;
        String name,gender,email,qualification,dob,number;
        System.out.print("\nEnter name:- ");
        name =Project.stringinput();
        System.out.print("\nEnter gender:- ");
        gender =Project.stringinput();
        do
        {
            System.out.print("\nEnter email:- ");
            email =Project.stringinput();
            if(Project.emailvalidator(email)==false)
            {
                System.out.print("\nInvalid Email\n");
            }
        }while(Project.emailvalidator(email)==false);
        try
        {
            if(email.charAt(email.length()-1)=='.')
            { 
                //throw new InvalidMailTypeException("Cant end with .");
                emailThrower();

            }
        }
        catch ( InvalidMailTypeException e)
        {
            e.printStackTrace();
            //continue;
        }
        finally
        {
            System.out.println("Complete email validation yet to be developed");
        }
        System.out.print("\nEnter Contact number:- ");
        number=Project.numbervalidator("\nEnter Contact number:- ");
        System.out.print("\nEnter Qualification:- ");
        qualification =Project.stringinput();
        System.out.print("\nEnter date of birth[DD/MM/YYYY]: ");  
        dob=Project.dobValidator("Enter date of birth[DD/MM/YYYY]: ");
        age=Project.age(dob);
        int fid=Integer.valueOf(Staff.fid);
        Staff fac=new Staff(fid, age, name, qualification, dob, number, email, department, designation,gender);
        Staff.fid++;
        return fac;
        
    }  
}