package StudentDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("---欢迎来到学生管理系统！---");
            System.out.println("-----1、添加学生---------");
            System.out.println("-----2、删除学生---------");
            System.out.println("-----3、修改学生---------");
            System.out.println("-----4、查看所有学生------");
            System.out.println("-----5、退出------------");
            System.out.println("------------------------");
            System.out.print("请输入你的选择： ");
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    AddStudent(array);
                    break;
                case "2":
                    RemoveStudent(array);
                    break;
                case "3":
                    ChageStudent(array);
                    break;
                case "4":
                    ShowStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用！");
                    System.exit(0);
            }
        }
    }

    public static void AddStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        String sid;
        while(true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();
            boolean isUsed = IsUsed(array, sid);
            if(isUsed){
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加学生成功！");
    }

    public static void RemoveStudent(ArrayList<Student> array) {
        Scanner sc =new Scanner(System.in);
        if(array.size()==0){
            System.out.println("学生管理系统为空！请先添加学生。");
            System.out.println();
            return;
        }
        System.out.println("请输入需要修改的学生学号！");
        String s_sid = sc.nextLine();
        Student s;
        byte flag=0;
        for(int i=0;i<array.size();i++){
            s = array.get(i);
            if(s_sid.equals(s.getSid())){
                array.remove(i);
                System.out.println("删除成功！");
                flag=1;
                break;
            }
        }
        if (flag == 0){
            System.out.println("没有该成员！");
        }
    }

    public static void ChageStudent(ArrayList<Student> array) {
        Scanner sc =new Scanner(System.in);
        if(array.size()==0){
            System.out.println("学生管理系统为空！请先添加学生。");
            System.out.println();
            return;
        }
        System.out.println("请输入需要修改的学生学号！");
        String s_sid = sc.nextLine();
        Student s;
        byte flag=0;
        for(int i=0;i<array.size();i++){
            s = array.get(i);
            if(s_sid.equals(s.getSid())){
                System.out.println("请输入需要修改的学生姓名！");
                String s_name = sc.nextLine();
                s.setName(s_name);
                System.out.println("请输入需要修改的学生年龄！");
                String s_age = sc.nextLine();
                s.setAge(s_age);
                System.out.println("请输入需要修改的学生居住地！");
                String s_address = sc.nextLine();
                s.setAddress(s_address);
                System.out.println("修改成功！");
                flag = 1;
                break;
            }
        }
        if(flag==0) {
            System.out.println("没有该学生！");
        }
    }

    public static void ShowStudent(ArrayList<Student> array) {
        if(array.size()==0)
        {
            System.out.println("学生为空！");
            return;
        }
        System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t居住地");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "岁\t\t" + s.getAddress());
        }
    }
    public static boolean IsUsed(ArrayList<Student> array,String sid){
        for(int i=0;i<array.size();i++) {
            Student s = array.get(i);
            if(s.getSid().equals(sid)){
                System.out.println("该学号已经使用请重新输入！");
                return false;
            }
        }
        return true;
    }

}
