import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;

public class StudentManager {
    //主要的App方法
    public static void App() {
        ArrayList<Student> array = new ArrayList<>();

        while (true) {
            System.out.println("请选择操作：\n");
            System.out.println("*****************************************************\n");
            System.out.println("*                      1 插入                        *\n");
            System.out.println("*                      2 查找                        *\n");
            System.out.println("*                      3 删除                        *\n");
            System.out.println("*                      4 修改                        *\n");
            System.out.println("*                      5 输出                        *\n");
            System.out.println("*                      6 退出                        *\n");
            System.out.println("*****************************************************\n");

            Scanner scanner = new Scanner(System.in);
            String choiceString = scanner.nextLine();

            switch (choiceString) {
                case "1"://插入
                    addStudent(array);
                    break;
                case "2"://查找
                    findStudent(array);
                    break;
                case "3"://删除
                    deleteStudent(array);
                    break;
                case "4"://修改
                    updateStudent(array);
                    break;
                case "5"://输出
                    outputStudent(array);
                    break;
                case "6":
                    /*System.out.println("谢谢你的使用！");
                    break;*/
                default://退出
                    System.out.println("谢谢你的使用！");
                    System.exit(0);
                    break;
            }
        }
    }
    //查找学生方法
    public static void findStudent(ArrayList<Student> array) {
        Scanner scanner = new Scanner(System.in);
        String Name;
        boolean flag = false;
        //判定是否存在已输入的数据
        if (array.isEmpty()) {
            System.out.println("无可供查询的学号，请重新操作。");
            return;
        }

        System.out.println("请输入要查询的学生姓名：");
        Name = scanner.nextLine();

        for (int i = 0; i < array.size(); i ++) {
            Student s = array.get(i);

            if (Name.equals(s.getName())) {
                System.out.println("学号\t\t\t姓名\t\t生日\t\t\t性别");
                System.out.println(s.getID() + "\t" + s.getName() + "\t" + s.getBirDate() + "\t" + s.getGender());
                flag = true;
            }
            if(!flag) {
                System.out.println("无效的姓名，请重新操作。");
            }
        }
    }
    //插入学生方法
    public static void addStudent(ArrayList<Student> array) {
        Scanner scanner = new Scanner(System.in);
        String Name;
        //判定姓名是否已经存在
        while (true) {
            System.out.println("请输入学生姓名：");
            Name = scanner.nextLine();
            boolean flag = false;

            for(int i = 0; i < array.size(); i ++) {
                Student student = array.get(i);

                if (student.getName().equals(Name)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("你输入的姓名已经存在，请重新操作。");
            } else {
                break;
            }
        }

        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        int id = sc1.nextInt();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入学生生日：");
        String BirDate = sc2.nextLine();

        Scanner sc3 = new Scanner(System.in);
        System.out.println("请输入学生性别：");
        boolean Gender = scanner.nextBoolean();

        Student student = new Student();
        student.setID(id);
        student.setName(Name);
        student.setBirDate(BirDate);
        student.setGender(Gender);
        array.add(student);
        System.out.println("添加学生成功！");
    }
    //删除学生方法
    public static void deleteStudent(ArrayList<Student> array) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        System.out.println("请输入想要删除的学生的姓名：");
        String Name = scanner.nextLine();

        for (int i = 0; i < array.size(); i ++) {
            Student student = array.get(i);

            if (student.getName().equals(Name)) {
                array.remove(i);
                flag = true;
                System.out.println("删除学生成功。");
            }
        }

        if (!flag) {
            System.out.println("该姓名不存在，请重新操作。");
        }
    }
    //修改学生方法
    public static void updateStudent(ArrayList<Student> array) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        System.out.println("请输入想要修改学生的姓名:");
        String Name = scanner.nextLine();
        int index = -1;
        //判定查询数据是否存在
        for (int i = 0; i < array.size(); i ++) {
            Student student = array.get(i);
            if(student.getName().equals(Name)) {
                index = i;
                flag = true;
            }
        }

        if(!flag) {
            System.out.println("该姓名不存在，请重新操作。");
        }else {
            Scanner sc4 = new Scanner(System.in);
            System.out.println("请输入新的学生学号:");
            int id = sc4.nextInt();

            Scanner sc5 = new Scanner(System.in);
            System.out.println("请输入新的学生生日: ");
            String BirDate = sc5.nextLine();

            Scanner sc6 = new Scanner(System.in);
            System.out.println("请输入新的学生性别: ");
            boolean Gender = sc6.nextBoolean();

            Student student = new Student();
            student.setID(id);
            student.setName(Name);
            student.setBirDate(BirDate);
            student.setGender(Gender);
            array.set(index, student);
            System.out.println("修改成功。");
        }
    }
    //输出学生方法
    public static void outputStudent(ArrayList<Student> array) {
        if(array.isEmpty()) {
            System.out.println("无可供查询的学生,请重新操作。");
            return;
        }

        Collections.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getID()-o2.getID();
            }
        });

        System.out.println("学号\t\t\t姓名\t\t生日\t\t\t性别");
        for (int i = 0; i < array.size(); i ++) {
            Student s = array.get(i);
            System.out.println(s.getID() + "\t" + s.getName() + "\t" + s.getBirDate() + "\t" + s.getGender());
        }
    }
}
