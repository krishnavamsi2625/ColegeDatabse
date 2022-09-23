//package collegedatabase;
import java.util.*;
class Lab 
{
     String deptName,labName;
     LinkedList<Assistant> assistantDatabase;
     public Lab(String deptName,String labName)
     {
         this.labName=labName;
         this.deptName=deptName;
         assistantDatabase=new LinkedList<>();
     }
}