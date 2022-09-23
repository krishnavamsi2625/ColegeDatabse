//import java.util.*;
class Main
{
    public static void main(String [] args) throws InvalidMailTypeException
    {
        int ch=0;
        College obj2= new College("XYZ");
        AllFunction obj = new AllFunction(obj2);
        do
        {
            System.out.print("\n1)Add Dept\n2)Add Person\n3)Search\n4)Add lab\n5)Exit\nEnter you choice: ");
            ch=Project.integerinput("Enter you choice:");
            switch(ch)
            {
                case 1:
                    obj.addDept();
                    break;
                case 2:
                    if(obj2.departmentDatabase.isEmpty())
                    {
                        System.out.print("NO DEPARTMENS!!!!\nADD DEPARTMENTS FIRST");
                        break;
                    }
                    obj.adder();
                    break;
                case 3:
                    Searcher obj1=new Searcher(obj2);
                    Project.clearscreen();
                    obj1.databaseSearcher();
                    break;

                case 4:
                    obj.addLab();
                    break;
                case 5:
                    System.out.print("\n+++++++++++++++++CLOSING!!++++++++++++");
                    break;
                default:
                    System.out.print("Invalid input");
            }
        }while(ch!=5); 
        
    }
}