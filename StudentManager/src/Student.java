public class Student {
    private int ID;
    private String name;
    private String birDate;
    private boolean gender;

    public Student(int ID, String name, String birDate, boolean gender) {
        this.ID = ID;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }

    public Student() {
    }
    //设置学生属性
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    //获取学生属性
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getBirDate() {
        return birDate;
    }
    public boolean getGender() {
        return gender;
    }
}
