//package collegedatabase;
class  Staff
{   public static int fid=1;
    int id,age;
    String name,qualification,dob,number,email,dept,designation,gender;
    public Staff(int id,int age,String name,String qualification,String dob,String number,String email,String dept,String designation,String gender)
    {
        this.id=id;
        this.age=age;
        this.name=name;
        this.qualification=qualification;
        this.dob=dob;
        this.number=number;
        this.email=email;
        this.dept=dept;
        this.designation=designation;
        this.gender=gender;
    }
    public Staff()
    {

    }
    public String toString()
    {
        return  "|Staff Id:"+this.id+
        "|\n|Name:"+this.name+
        "|\n|Date of Birth:"+
        this.dob+"|\n|Gender:"+
        this.gender+"|\n|Email:"+
        this.email+"|\n|Number"+
        this.number+"|\n|Age:"+
        this.age+"|\n|Department:"+
        this.dept+"|\n|Qualification:"+
        this.qualification+"|\n|Designation: "+
        this.designation+"|\n";
        
    }
}
class Professor extends Staff
{
    String classHandled;
    public String toString()
    {
        return  "|Staff Id:"+this.id+
        "|\n|Name:"+this.name+
        "|\n|Date of Birth:"+
        this.dob+"|\n|Gender:"+
        this.gender+"|\n|Email:"+
        this.email+"|\n|Number"+
        this.number+"|\n|Age:"+
        this.age+"|\n|Department:"+
        this.dept+"|\n|Qualification:"+
        this.qualification+"|\n|Designation: "+
        this.designation+"|\n|Class Handled: "+
        this.classHandled+"|\n";
        
    }
    
    public Professor(int id,int age,String name,String qualification,String dob,String number,String email,String dept,String designation,String gender,String classhandled)
    {
        this.id=id;
        this.age=age;
        this.name=name;
        this.qualification=qualification;
        this.dob=dob;
        this.number=number;
        this.email=email;
        this.dept=dept;
        this.designation=designation;
        this.gender=gender;
        this.classHandled=classhandled;
    }
}
class Assistant extends Staff
{
    Lab lab;
    public String toString()
    {
        return  "|Staff Id:"+this.id+
        "|\n|Name:"+this.name+
        "|\n|Date of Birth:"+
        this.dob+"|\n|Gender:"+
        this.gender+"|\n|Email:"+
        this.email+"|\n|Number"+
        this.number+"|\n|Age:"+
        this.age+"|\n|Department:"+
        this.dept+"|\n|Qualification:"+
        this.qualification+"|\n|Designation: "+
        this.designation+"|\n|Lab Handled: "+
        this.lab.labName+"|\n";
        
    }
    
    public Assistant(int id,int age,String name,String qualification,String dob,String number,String email,String dept,String designation,String gender,Lab labHandled)
    {
        this.id=id;
        this.age=age;
        this.name=name;
        this.qualification=qualification;
        this.dob=dob;
        this.number=number;
        this.email=email;
        this.dept=dept;
        this.designation=designation;
        this.gender=gender;
        this.lab=labHandled;
    }
} 