//package collegedatabase;
class Students extends Student 
{   static int  rid=1;
    double cgpa;
    int fees;
    String designation;
    Department dept;
    
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
        this.dept.deptName+"|\n|Course:"+
        this.course+"|\n|CGPA: "+
        this.cgpa+"|\n|Fees: "+
        this.fees+"|\n";
    }
    
    public Students(int rno,String name,String gender,String email,String number,String course,Department department,String dob,int age,int fees,double cgpa,String designation)
    {
        this.name=name;
        this.gender=gender;
        this.email=email;
        this.course=course;
        this.dept=department;
        this.dob=dob;
        this.rno=rid;
        this.age=age;
        this.number=number;
        this.cgpa=cgpa;
        this.designation=designation;
        this.fees=fees;
    }
    
    public static int Feecaluclator(double cgpa)
    {
        int fees =5000;
        if(cgpa>9)
        {
            fees= fees-((fees*10)/100);
        }
        else if (cgpa>=8)
        {
            fees= fees-((fees*7)/100);
        }
        else if (cgpa>=7)
        {
            fees= fees-((fees*5)/100);
        }
        return fees;
    }
}