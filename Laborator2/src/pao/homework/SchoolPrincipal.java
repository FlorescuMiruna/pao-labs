package pao.homework;

//4. Implement a Singleton class as you learned in the course.

public class SchoolPrincipal {
    private static String name;
    private static int age;
    private static SchoolPrincipal schoolPrincipal;

    private SchoolPrincipal(){
        name = "Mr.Oliver King";
        age = 52;
    }

    public static SchoolPrincipal getSchoolPrincipal(){
        if(schoolPrincipal == null)
            schoolPrincipal = new SchoolPrincipal();

        return  schoolPrincipal;
    }
    public static void showSchoolPrincipal(){
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
