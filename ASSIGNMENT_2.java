package AP_Assignment;
import java.util.*;
import java.util.Scanner;
import java.util.Date;
import java.util.Map;
import java.lang.*;

// This is for instructor
interface Instructor{
    void Add_material(int a,ArrayList<String>s1,ArrayList<String>s2,String s,int n);
    void Add_assessment(int a,ArrayList<String>A);

//    public void View_Lecture_material();//This is common in both instructor and student
//    public void View_assessment();//This is common in both instructor and student
     void Grade_assessment(String S);
     void close_assessment();

//    public void View_comments();//This is common in both instructor and student

//    public void Add_comments();//This is common in both instructor and student

//    public void Logout();

}

class work implements Instructor {
//    public HashMap<String,String> Add_material(int demand,HashMap<String,String>S_material,HashMap<String,String>V_material)
//    public void Add_material(int demand,HashMap<String,String>S_material,HashMap<String,String>V_material,String inst,HashMap<String,String>Upload)
//    public void Add_material(int demand,HashMap<String,String>S_material,HashMap<String,String>V_material,ArrayList<String>M_date,HashMap<String,Integer>Upload)

    //public void Add_material(int demand,HashMap<String,String>S_material,HashMap<String,String>V_material,ArrayList<String>M_date,ArrayList<String>inst,String prof,int num)
    public void Add_material(int demand, ArrayList<String> M_date, ArrayList<String> inst, String prof, int num) {//Whatever require to execute this i will define it in the main part
        Scanner s = new Scanner(System.in);
        ASSIGNMENT_2 am = new ASSIGNMENT_2();
        if (demand == 1) {
            System.out.println("Enter the topic of Slide");
            String topic_slide = s.next();
            System.out.println("Enter the number of Slides");
            int n = s.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println("Enter the content of Slide" + (i + 1));
                String content = s.next();
                am.Slide_material.put(content, topic_slide);
//                S_material.put(content,topic_slide);
//                return S_material;
                System.out.println(am.Slide_material.keySet());
            }
//            java.util.Date date=new java.util.Date();
//            System.out.println(date);
        } else {
            System.out.println("Enter the topic of video");
            String topic_video = s.next();
            System.out.println("Enter the file name");
            String file_name = s.next();
            if (file_name.contains(".mp4")) {
                am.Video_material.put(file_name, topic_video);
//                    V_material.put(file_name,topic_video);
//                    return V_material;
                System.out.println(am.Video_material.entrySet());
            } else {
                System.out.println("The video format is not .mp4");
                //Here it will give error for some cases if we will not return something!!!
            }
//            java.util.Date date=new java.util.Date();
//            System.out.println(date);
        }
        Date d1 = new Date();
        System.out.println(d1);
        String r = d1.toString();
//        Upload.put(inst,r);
        M_date.add(r);
        inst.add(prof);
        num++;
    }


    //    public HashMap<String,Integer> Add_assessment(int choice ,HashMap<String,Integer>Add_assign,HashMap<String,Integer>Add_quiz)
//    public void Add_assessment(int choice ,HashMap<String,Integer>Add_assign,HashMap<String,Integer>Add_quiz,HashMap<String,Integer>id_assign,HashMap<String,Integer>id_quiz,ArrayList<String>As_date)
    public void Add_assessment(int choice, ArrayList<String> As_date) {
        ASSIGNMENT_2 a1 = new ASSIGNMENT_2();
        Scanner s = new Scanner(System.in);
        int max = 100;
        int min = 1;
        Random ID = new Random();
        int Unique_id = min + ID.nextInt(max);
        if (choice == 1) {
            System.out.println("Enter the assignment marks");
            int assign_num = s.nextInt();
            System.out.println("Enter the problem statement");
            String problem = s.next();
            a1.A_assign.put(problem, assign_num);
//            Add_assign.put(problem,assign_num);
            a1.assignMid.put(problem, Unique_id);
//            id_assign.put(problem,Unique_id);
            a1.idMassign.put(Unique_id, problem);

//            return Add_assign;
//            System.out.println(Add_assign);
            System.out.println(a1.A_assign);
            //printing part i will see again if ther is a problem in the Output

        } else {
            System.out.println("Enter the Quiz number");
            int quiz_num = s.nextInt();
            System.out.println("Enter the Quiz question");
            String Question = s.next();
            a1.Q_assign.put(Question, quiz_num);
//            Add_quiz.put(Question,quiz_num);
            a1.quizMid.put(Question, Unique_id);
//            id_quiz.put(Question,Unique_id);
            a1.idMquiz.put(Unique_id, Question);
//            return Add_quiz;
//            System.out.println(Add_quiz);
            System.out.println(a1.Q_assign);
            //Same for above for printing
        }
        Date d = new Date();
        System.out.println(d);
        String r = d.toString();
        As_date.add(r);
    }


//    public void View_Lecture_material()
//    {
//manage it in the main function maybe create a classes and use concept of polymorphism
//    }
//    public void View_assignment(){
    //This is common in both student and instructor

//    }

    //    public void Grade_assessment(ArrayList<Integer>Submission,String inst_name)
    public void Grade_assessment(String inst_name) {
        ASSIGNMENT_2 g = new ASSIGNMENT_2();
        Scanner s = new Scanner(System.in);
        System.out.println("List of Assessments");
        for (Map.Entry<String, Integer> set : g.assignMid.entrySet()) {
            if (g.Submit_assign.contains(set.getValue()) || g.Submit_assign == null) {
                System.out.println("ID " + set.getValue() + " Assignment " + set.getKey() + " " + "Maximum marks: " + g.A_assign.values());
//                continue;
            } else {
//                System.out.println("ID "+set.getValue()+" Assignment "+set.getKey()+" "+"Maximum marks: "+a.A_assign.values());
                continue;
            }
        }
        for (Map.Entry<String, Integer> set : g.quizMid.entrySet()) {
            if (g.Submit_quiz.contains(set.getValue()) || g.Submit_quiz == null) {
                System.out.println("ID " + set.getValue() + " Question " + set.getKey() + " " + "Maximum marks: 1");
//                continue;
            } else {
//                System.out.println("ID "+set.getValue()+" Question "+set.getKey()+" "+"Maximum marks: 1");
                continue;
            }
        }
        System.out.println("Enter the ID of Assessment to view submission");
        int put_id = s.nextInt();
        if (g.Submit_assign.contains(put_id)) {
            System.out.println(g.Sub_detail_assign.entrySet());
            System.out.println("Choose the ID from these ungraded submissions");
            int enter_id = s.nextInt();
            System.out.println("Subission: " + g.idMfile.get(g.stuMid.get(enter_id)));
            System.out.println("maximum marks " + 5);
            System.out.println("Enter the marks you want to allocate");
            int marks = s.nextInt();
            g.markMassign.put(marks, g.idMfile.get(g.stuMid.get(enter_id)));
            System.out.println("Marks Scored " + marks);
            g.marks_byprof.put(g.idMfile.get(g.stuMid.get(enter_id)), inst_name);

        } else {
            System.out.println(g.Sub_detail_quiz.entrySet());
            System.out.println("Choose the ID from these ungraded submissions");
            int enter_id = s.nextInt();
            System.out.println("Subission: " + g.idMfile.get(g.stuMid.get(enter_id)));
            System.out.println("maximum marks " + 1);
            int marks = s.nextInt();
            g.markMassign.put(marks, g.idMfile.get(g.stuMid.get(enter_id)));
            System.out.println("Marks Scored " + marks);
            g.marks_byprof.put(g.idMfile.get(g.stuMid.get(enter_id)), inst_name);

        }
    }


    public void close_assessment() {
        Scanner s = new Scanner(System.in);
        System.out.println("List of open assignments");
        Common c = new Common();
        c.View_assessment();
        System.out.println("Enter the ID of assignment to close");
        int req_id = s.nextInt();
        if (c.Submit_assign.contains(req_id)) {
            c.assignMid.values().remove(req_id);

        } else {
            c.quizMid.values().remove(req_id);

        }

    }
}


//    public void View_comments()
//    {
//
//    }


//    public void Add_comments()
//    {
//
//    }


//    public void Logout()
//    {
//    System.exit(0);
//    }






// From here i will do the Student requirement
interface Student{
//    public void View_material();
//    public void View_assessment();
    void Submit_assessment(int a,String S);
    void View_grades();
//    public void View_comments();
//    public void Add_comments();
//    public void Logout();

}


class perform implements Student{
    Scanner r=new Scanner(System.in);
//    public void View_material(){

//    }
//    public void Submit_assessment(ArrayList<Integer>done_assign,ArrayList<Integer>done_quiz,HashMap<Integer,String>sub_detail,int Sid,String Sname){
    public void Submit_assessment(int Sid,String Sname){
        ASSIGNMENT_2 a=new ASSIGNMENT_2();
        int n=r.nextInt();
        do{
            System.out.println("Pending assessment  ");
//        Common c=new Common();
//        c.View_assessment();

            for (Map.Entry<String,Integer> set : a.assignMid.entrySet()) {
//                if(done_assign.contains(set.getValue())){
                if(a.Submit_assign.contains(set.getValue())){
                    continue;
                }else{
                System.out.println("ID "+set.getValue()+" Assignment "+set.getKey()+" "+"Maximum marks: "+a.A_assign.values());
            }}
            for (Map.Entry<String,Integer> set : a.quizMid.entrySet()) {
//                if(done_quiz.contains(set.getValue())){
                if(a.Submit_quiz.contains(set.getValue())){
                    continue;
                }else{
                System.out.println("ID "+set.getValue()+" Question "+set.getKey()+" "+"Maximum marks: 1");

            }}
            System.out.println("Enter the ID of assessment ");
            int ass_id=r.nextInt();
//            if(done_assign.contains(a.assignMid.values())){
            if(a.Submit_assign.contains(a.assignMid.values())){
//                done_assign.add(ass_id);
                a.Submit_assign.add(ass_id);
                a.Sub_detail_assign.put(Sid,Sname);
                a.idMstu.put(ass_id,Sid);
                a.stuMid.put(Sid,ass_id);
            }
            else{
//                done_quiz.add(ass_id);
                a.Submit_quiz.add(ass_id);
                a.Sub_detail_quiz.put(Sid,Sname);
                a.idMstu.put(ass_id,Sid);
                a.stuMid.put(Sid,ass_id);
            }
            System.out.println("Enter the filename of assignment");
            String file_name=r.next();
            a.idMfile.put(ass_id,file_name);
//            sub_detail_assign.put(Sid,Sname);
            n--;
        }while(n>0);
    }
    public void View_grades(){
        ASSIGNMENT_2 a=new ASSIGNMENT_2();
        System.out.println("Graded Submission");
        System.out.println("Marks  ---->  Submission");
        System.out.println(a.markMassign.entrySet());
        System.out.println("Graded by "+a.marks_byprof.values());

    }


}

class Common extends ASSIGNMENT_2 {
    public static void View_material(ArrayList<String> Upload_inst, ArrayList<String> Upload_date) {

        System.out.println("Title: " + Slide_material.values());
        System.out.println(Slide_material.keySet());
        System.out.println("Date of Upload " + Upload_date.get(number - 1));
//        Upload_date.remove(0);
        System.out.println("Uploaded by: " + Upload_inst.get(number - 1));

        System.out.println("Title of Video: " + Video_material.values());
        System.out.println("Video file: " + Video_material.values() + ".mp4");
        System.out.println("Date of Upload " + Upload_date.get(number - 1));
        System.out.println("Uploaded by " + Upload_inst.get(number - 1));

    }

    public static void View_assessment() {
        for (Map.Entry<String, Integer> set : assignMid.entrySet()) {
            System.out.println("ID " + set.getValue() + " Assignment " + set.getKey() + " " + "Maximum marks: " + A_assign.values());

        }
        for (Map.Entry<String, Integer> set : quizMid.entrySet()) {
            System.out.println("ID " + set.getValue() + " Question " + set.getKey() + " " + "Maximum marks: 1");

        }
    }

//    public static void View_grades(){
//        System.out.println("Graded Submission");
//        System.out.println("Marks  ---->  Submission");
//        System.out.println(markMassign.entrySet());
//        System.out.println("Graded by "+marks_byprof.values());
//
//    }

    public static void View_comments() {
        System.out.println(Comment_section);

    }


    public static void Add_comments() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the Commnet");
        String com = s.next();
        Comment_section.add(com);
    }


    public static void Logout() {
        return;
    //        System.exit(0);

    }

}




public class ASSIGNMENT_2 {
    static int number=0;
    static int number1=0;
//    static ArrayList<Integer>Submission_id=new ArrayList<>();
    static ArrayList<Integer>Submit_assign=new ArrayList<>();//Submit assignment
    static ArrayList<Integer>Submit_quiz=new ArrayList<>();// submit assignment
    static ArrayList<String> set_date_material=new ArrayList<>();
    static ArrayList<String> set_date_assign=new ArrayList<>();
    static ArrayList<String>Professor=new ArrayList<>();
    static ArrayList<String>Comment_section=new ArrayList<>();

    static HashMap<Integer,String>Gen_instruct=new HashMap<Integer,String>();
    static HashMap<Integer,String>Gen_Student=new HashMap<Integer,String>();
    static HashMap<Integer,String>idMfile=new HashMap<Integer,String>();
    static HashMap<Integer,String>Sub_detail_assign=new HashMap<Integer,String>();//Grade assignment
    static HashMap<Integer,String>Sub_detail_quiz=new HashMap<Integer,String>();//Grade assignment
    static HashMap<Integer,String>markMassign=new HashMap<Integer,String>();
    static HashMap<Integer,Integer>idMstu=new HashMap<Integer,Integer>();
    static HashMap<Integer,Integer>stuMid=new HashMap<Integer,Integer>();
    static HashMap<String,String> marks_byprof=new HashMap<String,String>();
    static HashMap<String,String> Slide_material=new HashMap<String,String>();//Case1
    static HashMap<String,String> Video_material=new HashMap<String,String>();// Case1
    static HashMap<String,Integer> A_assign=new HashMap<String,Integer>();//case2
    static HashMap<String,Integer> Q_assign=new HashMap<String,Integer>();//case2
    static HashMap<String,Integer>assignMid=new HashMap<String,Integer>();//case2
    static HashMap<String,Integer>quizMid=new HashMap<String,Integer>();
    static HashMap<Integer,String>idMassign=new HashMap<Integer,String>();//case2opp
    static HashMap<Integer,String>idMquiz=new HashMap<Integer,String>();//case2opp

//    static HashMap<String,String>dateMinst=new HashMap<String,String>();
    // void main function i will do in this //


    public static void Greeting(){
        System.out.println("Welcome to Backpack");
        System.out.println("1. Enter as Instructor");
        System.out.println("2. Enter as Student");
        System.out.println("3. Exit");
    }

    public static void gen_instructor(){
        Scanner sn=new Scanner(System.in);
        for (int i=0; i<3;i++){
        int max = 100;
        int min = 1;
        Random ID = new Random();
        int Unique_id =min+ID.nextInt(max);
        System.out.println("Enter the instructor");
        String ins=sn.next();
        Gen_instruct.put(Unique_id,ins);
    }
    }
    public  static void gen_student(){
        Scanner sn=new Scanner(System.in);
        for (int i=0; i<3;i++){
            int max = 100;
            int min = 1;
            Random ID = new Random();
            int Unique_id =min+ID.nextInt(max);
            System.out.println("Enter the Student");
            String stu=sn.next();
            Gen_Student.put(Unique_id,stu);
        }
    }
    public static void Portal(int choice) {
        if (choice == 1) {
            System.out.println("INSTRUCTOR MENU");
            System.out.println("1. Add class materials");
            System.out.println("2. Add assessments");
            System.out.println("3. View lecture material");
            System.out.println("4. View assessments");
            System.out.println("5. Grade assessments");
            System.out.println("6. Close assessment");
            System.out.println("7. View Comment ");
            System.out.println("8. Add comments");
            System.out.println("9. Logout");
        } else if(choice==2) {
            System.out.println("STUDENT MENU");
            System.out.println("1. View lecture materials");
            System.out.println("2. View assessments");
            System.out.println("3. Submit Assessments");
            System.out.println("4. View grades");
            System.out.println("5. View comments");
            System.out.println("6. Add comments");
            System.out.println("7. Logout");
        }
        else if(choice==3){
            System.exit(0);
        }
        else{
            System.out.println("Invalid choice choice from the above choices only");
        }
    }



    public static void main(String[] args) {
//        ArrayList<String> set_date_material=new ArrayList<>();
//        ArrayList<String> set_date_assign=new ArrayList<>();
//        HashMap<String,String> Slide_material=new HashMap<String,String>();//Case1
//        HashMap<String,String> Video_material=new HashMap<String,String>();// Case1
//        HashMap<String,Integer> A_assign=new HashMap<String,Integer>();//case2
//        HashMap<String,Integer> Q_assign=new HashMap<String,Integer>();//case2
//        HashMap<String,Integer>idMassign=new HashMap<String,Integer>();//case2


//        HashMap<String,Integer>Gen_instruct=new HashMap<String,Integer>();
//        HashMap<String,Integer>Gen_Stud=new HashMap<String,Integer>();
        int flag=0;
        int count=1;
        Greeting();
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        if(choice==1)
        {
            gen_instructor();
            System.out.println(Gen_instruct.entrySet());
            System.out.println("choose from the above Id");
            int id=sc.nextInt();
            System.out.println("Welcome "+Gen_instruct.get(id));

            Portal(choice);
            System.out.println("Enter the choice from the portal");
            int pchoice=sc.nextInt();
            while(count!=0){
                work w=new work();
                switch(pchoice){
                    case 1:
                        System.out.println("1. Add Lecture Slides ");
                        System.out.println("2. Add Lecture Videos ");
                        System.out.println("What you want to add choose from above");
                        int choice1=sc.nextInt();
                        w.Add_material(choice1,set_date_material,Professor,Gen_instruct.get(id),number);
//                        w.Add_material(choice1,Slide_material,Video_material,Gen_instruct.get(id),dateMinst);
                        break;
                    case 2:
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        System.out.println("Chose any option from above");
                        int choice2=sc.nextInt();
//                        w.Add_assessment(choice2,A_assign,Q_assign,assignMid,quizMid,set_date_assign);
                        w.Add_assessment(choice2,set_date_assign);
                        break;

                    case 3:
                        Common c1=new Common();
                        c1.View_material(Professor,set_date_material);
                        break;

                    case 4:
                        Common c2=new Common();
                        c2.View_assessment();
                        break;

                    case 5:
                        work w1=new work();
                        w1.Grade_assessment(Gen_instruct.get(id));
                        break;

                    case 6:
                        work w2=new work();
                        w2.close_assessment();
                        break;

                    case 7:
                        Common c=new Common();
                        c.View_comments();
                        break;

                    case 8:
                        Common Ac=new Common();
                        Ac.Add_comments();
                        break;

                    case 9:
                        Common Lc=new Common();
                        Lc.Logout();
                        flag=1;
                        count--;
                        break;

                }
                System.out.println("Welcome "+Gen_instruct.get(id));
                Portal(choice);
                System.out.println("Enter the choice from the portal");
                choice=sc.nextInt();
                count--;
//                if(flag==0){
//                System.out.println("Welcome "+Gen_instruct.get(id));
//                Portal(choice);
//                System.out.println("Enter the choice from the portal");
//                pchoice=sc.nextInt();

//            }else{
//                    count=0;
//                }
        }}
        else{
            gen_student();
            System.out.println(Gen_Student.entrySet());
            System.out.println("choose from the above Id");
            int id=sc.nextInt();
            System.out.println("Welcome "+Gen_Student.get(id));
            Portal(choice);
            System.out.println("Enter the choice from the portal");
            int pchoice=sc.nextInt();
            while(count!=0){
                work w=new work();
                switch(pchoice){
                    case 1:
                        Common c1=new Common();
                        c1.View_material(Professor,set_date_material);
                        break;

                    case 2:
                        Common c2=new Common();
                        c2.View_assessment();
                        break;

                    case 3:
                        perform p=new perform();
                        p.Submit_assessment(id,Gen_Student.get(id));
                        break;

                    case 4:
                        perform p1=new perform();
                        p1.View_grades();
                        break;

                    case 5:
                        Common c=new Common();
                        c.View_comments();
                        break;

                    case 6:
                        Common Ac=new Common();
                        Ac.Add_comments();
                        break;
                    case 7:
                        Common Lc=new Common();
                        Lc.Logout();
                        count--;
                        break;


                }
                System.out.println("Welcome "+Gen_Student.get(id));
                Portal(choice);
                System.out.println("Enter the choice from the portal");
                pchoice=sc.nextInt();

            }

        }
    }

}
