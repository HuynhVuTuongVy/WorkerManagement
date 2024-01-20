package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Student;

public class StudentManageController {
    
    public ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void loadData(){
        try{
        BufferedReader br = new BufferedReader(new FileReader("student.txt"));
        String line = null;
            while((line = br.readLine()) != null){
                String [] parts = line.split("\\|");
                if(parts.length == 4){
                    studentList.add(new Student(Integer.parseInt(parts[0]), parts[1].trim(), Integer.parseInt(parts[2]), parts[3]));
                }
            }
            br.close();
        }catch(Exception e){
            System.out.println("error: " + e.getMessage());
        }
    }
    
    public void saveStudent(ArrayList<Student> ar){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
            for(Student stu : ar)
                bw.write(stu.toString() + "\n");
            bw.close();
        }
        catch(Exception e){
            System.out.println("error: "+e.getMessage());
        }
    }
    
    public ArrayList<Student> addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input semester: ");
        sc.nextLine();
        int semester = sc.nextInt();
        System.out.println("Input course name: ");
        String coursName = sc.nextLine();

        studentList.add(new Student(id, name, semester, coursName));
        return studentList;
    }
    
    public void display() {
        for (Student stu : studentList) {
            System.out.println(stu.toString());
        }
    }
    
    public ArrayList<Student> searchName(String name){
        ArrayList<Student> st = new ArrayList<>();
        for(Student t : studentList){
            if(t.getStudentName().equals(name))
                st.add(t);
        }
        return st;
    }
    
    public ArrayList<Student> deleteStudentbyID() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> delete = new ArrayList<>();
        System.out.println("Input id: ");
        int id = sc.nextInt();
        for (int i = 0; i < studentList.size(); i++) {
            Student bi = studentList.get(i);
            if(bi.getId() == id){
                studentList.remove(i);
                i--;
            }
        }
        saveStudent(studentList);
        return delete;
    }
    
    public void updateStudentID() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the old ID: ");
        int oldID = sc.nextInt();
        ArrayList<Student> students = searchID(oldID);

        if (!students.isEmpty()) {
            System.out.println("Enter student new ID: ");
            int newID = sc.nextInt();
            
            for (Student student : students) {
                student.setId(newID);
            }
        } else {
            throw new Exception("Student with old ID not found");
        }
    }
    
    
    public ArrayList<Student> searchID(int ID){
        ArrayList<Student> st = new ArrayList<>();
        for(Student t : studentList){
            if(t.getId() == ID)
                st.add(t);
        }
        return st;
    }
    
    public void generateReport() {
        Map<String, Map<String, Integer>> reportMap = new HashMap<>();

        for (Student student : studentList) {
            String studentName = student.getStudentName();
            String courseName = student.getCourseName();

            if (!reportMap.containsKey(studentName)) {
                reportMap.put(studentName, new HashMap<>());
            }

            Map<String, Integer> coursesMap = reportMap.get(studentName);
            coursesMap.put(courseName, coursesMap.getOrDefault(courseName, 0) + 1);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : reportMap.entrySet()) {
            String studentName = entry.getKey();
            Map<String, Integer> coursesMap = entry.getValue();

            for (Map.Entry<String, Integer> courseEntry : coursesMap.entrySet()) {
                String courseName = courseEntry.getKey();
                int totalCourses = courseEntry.getValue();

                System.out.println(studentName + " | " + courseName + " | " + totalCourses);
            }
        }
    }
    
    
    
    
    
}
