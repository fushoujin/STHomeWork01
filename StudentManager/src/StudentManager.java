import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    //主要的App方法
    public static void App() {
        ArrayList<Student> array = new ArrayList<Student>();

        while (true) {
            System.out.println("请选择操作：\n");
            System.out.println("*****************************************************\n");
            System.out.println("*                      1 查找                        *\n");
            System.out.println("*                      2 插入                        *\n");
            System.out.println("*                      3 删除                        *\n");
            System.out.println("*                      4 修改                        *\n");
            System.out.println("*                      5 输出                        *\n");
            System.out.println("*                      6 退出                        *\n");
            System.out.println("*****************************************************\n");

            Scanner scanner = new Scanner(System.in);
            String choiceString = scanner.nextLine();

            switch (choiceString) {
                case "1"://查找
                    findStudent(array);
                    break;
                case "2"://插入
                    addStudent(array);
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
        int id;
        boolean flag = false;
        //判定是否存在已输入的数据
        if (array.isEmpty()) {
            System.out.println("无可供查询的学号，请重新操作。");
            return;
        }

        System.out.println("请输入要查询的学生学号：");
        id = scanner.nextInt();

        for (int i = 0; i < array.size(); i ++) {
            Student s = array.get(i);

            if (id == s.getID()) {
                System.out.println("学号\t\t姓名\t\t生日\t\t性别");
                System.out.println(s.getID() + "\t" + s.getName() + "\t" + s.getBirDate() + "\t" + s.getGender());
                flag = true;
            }
            if(!flag) {
                System.out.println("无效的学号，请重新操作。");
            }
        }
    }
    //插入学生方法
    public static void addStudent(ArrayList<Student> array) {
        Scanner scanner = new Scanner(System.in);
        int id;
        //判定学号是否已经存在
        while (true) {
            System.out.println("请输入学生学号：");
            id = scanner.nextInt();
            boolean flag = false;

            for(int i = 0; i < array.size(); i ++) {
                Student student = array.get(i);

                if (student.getID() == id) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("你输入的学号已经存在，请重新操作。");
            } else {
                break;
            }
        }

        System.out.println("请输入学生名字：");
        String Name = scanner.nextLine();
        System.out.println("请输入学生生日：");
        String BirDate = scanner.nextLine();
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
        System.out.println("请输入想要删除的学生的学号：");
        int id = scanner.nextInt();

        for (int i = 0; i < array.size(); i ++) {
            Student student = array.get(i);

            if (student.getID() == id) {
                array.remove(i);
                flag = true;
                System.out.println("删除学生成功。");
            }
        }

        if (!flag) {
            System.out.println("该学号不存在，请重新操作。");
        }
    }
    //修改学生方法
    public static void updateStudent(ArrayList<Student> array) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        System.out.println("请输入想要修改学生的学号:");
        int id = scanner.nextInt();
        int index = -1;
        //判定查询数据是否存在
        for (int i = 0; i < array.size(); i ++) {
            Student student = array.get(i);
            if(student.getID() == id) {
                index = i;
                flag = true;
            }
        }

        if(!flag) {
            System.out.println("该学号不存在，请重新操作。");
        }else {
            System.out.println("请输入新的学生名字:");
            String Name = scanner.nextLine();
            System.out.println("请输入新的学生生日: ");
            String BirDate = scanner.nextLine();
            System.out.println("请输入新的学生性别: ");
            boolean Gender = scanner.nextBoolean();

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
            System.out.println("无可供查询的学号,请重新操作。");
            return;
        }

        System.out.println("学号\t\t姓名\t\t生日\t\t性别");
        for (int i = 0; i < array.size(); i ++) {
            Student s = array.get(i);
            System.out.println(s.getID() + "\t" + s.getName() + "\t" + s.getBirDate() + "\t" + s.getGender());
        }
    }
    //主方法调用App方法
    public static void main(String[] args) {
        App();
    }
}
