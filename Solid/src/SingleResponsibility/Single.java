package SingleResponsibility;
class Manager
{
    int id;
    Employee e;
    Manager(int id,Employee e)
    {
        this.id=id;
        this.e=e;
    }
    public void display()
    {
        System.out.println("manager id: "+id+"\nEmployee under him is  "+e.eid+" in project "+e.project);
    }

}

class Employee
{
    int eid;
    String role,project;
    Employee(int eid,String role,String project)
    {
        this.eid=eid;
        this.role=role;
        this.project=project;
    }
    void updateProject(String project)
    {
        this.project=project;
    }
}

public class Single {
public static void main(String[] args)
{
    Employee e1= new Employee(23,"Developer","MobileApp");
    Manager m=new Manager(1,e1);
    m.display();
    e1.updateProject("MobileApp2");
    m.display();
}
}
