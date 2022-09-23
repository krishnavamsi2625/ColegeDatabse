//package collegedatabase;

//import java.util.LinkedList;
//import java.util.List;

class AllFunction
{   College college;
    InputGetter obj=null;
    public AllFunction(College temp)
    {
        this.college=temp;
        obj=new InputGetter(temp);
    }
    public void adder() 
    {
       System.out.print("Enter the Designation[student/staff/professor/assistant]:- ");
       String designation =Project.stringinput();
       if(designation.equalsIgnoreCase("student"))
       {
           try 
           {
               Students stu =obj.studentInputer(designation);
               college.studentDatabase.add(stu);
               String department=stu.dept.deptName;
               college.departmentDatabase.get(department).studentDatabase.add(stu);
           }
           catch (InvalidMailTypeException e)
           {
               e.printStackTrace();
               //continue;
           }
           finally
           {
               System.out.println("Complete email validation yet to be developed");
           }

       }
       else if(designation.equalsIgnoreCase("staff")  || designation.equalsIgnoreCase("professor"))
       {    
            if(designation.equalsIgnoreCase("professor"))
            {
                try
                {
                    Staff fac= obj.staffInputer(designation);
                    college.StaffDatabase.add(fac);
                    String department=fac.dept;
                    college.departmentDatabase.get(department).staffDatabase.add(fac);
                }
                catch (InvalidMailTypeException e)
                {
                    e.printStackTrace();
                    //continue;
                }
                finally
                {
                    System.out.println("Complete email validation yet to be developed");
                }

            }
            else 
            {
                try
                {
                    Staff fac= obj.staffInputer(designation);
                    college.StaffDatabase.add(fac);
                    String department=fac.dept;
                    college.departmentDatabase.get(department).staffDatabase.add(fac);
                }
                catch (InvalidMailTypeException e)
                {
                    e.printStackTrace();
                    //continue;
                }
                finally
                {
                    System.out.println("Complete email validation yet to be developed");
                }
            }
           
        }
  
       else if(designation.equalsIgnoreCase("assistant"))
       {
           if(college.labDatabase.isEmpty())
           {
               System.out.print("\nNo Lab Found !!!!!\nADD LAB FIRST!!");
               return;
           }
          try
          {
               Assistant fac= (Assistant) obj.staffInputer(designation);
                //fac= fac;
                college.StaffDatabase.add(fac);
                String department=fac.dept;
                String labName=fac.lab.labName;
                college.departmentDatabase.get(department).staffDatabase.add(fac);
                college.labDatabase.get(labName).assistantDatabase.add(fac);
            }
            catch (InvalidMailTypeException e)
            {
                e.printStackTrace();
                //continue;
            }
            finally
            {
                System.out.println("Complete email validation yet to be developed");
            }

        }
       else
       {
        System.out.print("INVALID INPUT!!!");
       }
         
    }
    public void addDept() throws InvalidMailTypeException
    {
        String dept;
        System.out.print("\nEnter the Department name: ");
        dept=Project.stringinput();
        System.out.print("\nEnter the HOD Details");
        Staff hod= obj.staffInputer("hod",dept);
        college.StaffDatabase.add(hod);
        Department temp=new Department(dept,hod);
        college.departmentDatabase.put(dept, temp);
        college.departmentDatabase.get(dept).staffDatabase.add(hod);
    }
    public void addLab()
    {   System.out.print("\nEnter the department to be added"+college.deptprinter()+": ");
        String department=Project.stringinput();
        System.out.print("\nEnter the lab name: ");
        String labName=Project.stringinput();
        Lab temp=new Lab(department, labName);
        college.labDatabase.put(labName,temp);
        college.departmentDatabase.get(department).labDatabase.add(temp);
    }

}