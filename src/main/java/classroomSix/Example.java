package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("This is maven project");
        Employee employeeOne = new Employee("Jānis", "Programmētājs", 1000.32);
        System.out.println(employeeOne.toString());
        Faker faker = new Faker();
        Employee employeeTwo = new Employee(faker.name().firstName(), faker.company().profession(),
                faker.number().randomDouble(2, 100,2000));
        System.out.println(employeeTwo.toString());

        Employee employeeThree = new Employee();
        System.out.println(employeeThree);


        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());

        System.out.println(faker.beer().name());
        System.out.println(faker.pokemon().name());
        System.out.println(faker.ancient().titan());

//        uztaisit ciklu, kas uztaisis 100 jaunus emplayees un katru izvadis uz ekrana.

//        for (int i=0; i < 100; i++) {
//            Employee employee = new Employee();
//            System.out.println(employee);
//        }


    }
}
