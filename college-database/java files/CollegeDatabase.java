//package collegedatabase;
import java.util.*;
//import project;
class Department 
{   String deptName;
    List<Students> studentDatabase;
    List<Staff> staffDatabase;
    List<Lab> labDatabase;
    Staff hod;
    public Department(String dept,Staff hod)
    {   this.deptName=dept;
        studentDatabase=new LinkedList<>();
        staffDatabase=new LinkedList<>();
        labDatabase=new LinkedList<>();
        this.hod=hod;
    }
}
class College
{   String name;
    public  boolean deptvalidator(String dept)
    {
        if(!this.departmentDatabase.containsKey(dept))
        { return false;
        }
        return true;
    }
    
    public  String deptprinter()
    {   String returnvalue="[";
        for(String dept:this.departmentDatabase.keySet())
        {
            returnvalue =returnvalue+dept+" ";
        }
        returnvalue=returnvalue+"]";
        return returnvalue;
    }
    public String labPrinter()
    {
        String returnValue="[";
        for(String lab:this.labDatabase.keySet())
        {
            returnValue=returnValue+" "+lab;
        }
        returnValue=returnValue+"]";
        return returnValue;
    }
     List<Students> studentDatabase=new LinkedList<>();
    List<Staff> StaffDatabase=new LinkedList<>();
    Map<String,Lab> labDatabase=new HashMap<>();
    Map<String,Department> departmentDatabase=new HashMap<>();
    public College(String name)
    {
        this.name=name;
    }
}
 
