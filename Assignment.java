package AP_Assignment;
import java.lang.Math;
import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.lang.*;

class Add_Vaccine{
    String Vname;
    int Vdoses;
    int Vgap;
    public Add_Vaccine(String name,int doses,int gap ){
        Vname=name;
        Vdoses=doses;
        Vgap=gap;
    }


}
class Register_hospital{
    String Hname;
    int Hpincode;
    Register_hospital(String name,int pincode){
        Hname=name;
        Hpincode=pincode;
    }
    public int Unique_ID(){
        int max = 999999;
        int min = 100000;
        Random ID = new Random();
        int Unique_HID =min+ID.nextInt(max);
        return Unique_HID;
    }

}
class Citizen{
    String Cname;
    int Cage;
    long CID;
    public Citizen(String name,int age,long Id){
        Cname=name;
        Cage=age;
        CID=Id;
    }

}
class Create_Slot{
    int Chid;
    int CSlot;
    int CDay;
    int CQuantity;

    public Create_Slot(int hospital_id,int slot,int day,int quantity){
        Chid=hospital_id;
        CSlot=slot;
        CDay=day;
        CQuantity=quantity;
    }
    public String Whichvax(int choice){
        if(choice==0){
            return "Covax";

        }else if(choice==1){

            return "Covi";
        }else{
            return "Invalid choice";
        }
    }


}
class Book_Slot{
    long uniq_id;
    public Book_Slot(long id){
        uniq_id=id;
    }

}
class Available_Slot{
    int H_id;
     public Available_Slot(int id){
         H_id=id;

     }

}
class Status{
    long Citid;
    public Status(long id){
        Citid=id;
    }

}

public class Assignment{
    public static int QCovax=0;
    public static int QCovi=0;
    public static int QTotal;
    public static int Count=1;
//    public static int Required_ID;
    public static void main(String[] args){
        System.out.println("Cowin Portal initialized");
        System.out.println("---------------------------------------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for vacination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all the Slots for hospitals");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println("Enter your choice from portal ");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        HashMap<Integer,String> Hrecord1 = new HashMap<Integer,String>();
        HashMap<String,Integer> Hrecord2 = new HashMap<String,Integer>();
        HashMap<Integer,String> Hrecord3 = new HashMap<Integer,String>();
        HashMap<String,Integer> VaxMhid = new HashMap<String,Integer>();
        HashMap<String,Integer> vaxMday = new HashMap<String,Integer>();
        HashMap<Integer,String> hidMvax = new HashMap<Integer,String>();
        HashMap<Integer,String> hidMcovax = new HashMap<Integer,String>();
        HashMap<Integer,String> hidMcovi = new HashMap<Integer,String>();
        HashMap<Integer,String> Avail_slot = new HashMap<Integer,String>();
        HashMap<Integer,String> temp = new HashMap<Integer,String>();
//        HashMap<Integer,Integer> DayMq = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> QMday = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> hidMq = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> DMS = new HashMap<Integer,Integer>();
        HashMap<Long,String> Citizen_record  = new HashMap<Long,String>();
        HashMap<Long,String> ID_map_Status  = new HashMap<Long,String>();
        HashMap<Long,String> Citizen_m_vax  = new HashMap<Long,String>();
        HashMap<Long,Integer> Citize_id_dose  = new HashMap<Long,Integer>();
        HashMap<String,String> nameMcovax = new HashMap<String,String>();
        HashMap<String,String> nameMcovi = new HashMap<String,String>();

        while(Count!=0){
        switch(choice){
            case 1:
                System.out.println("Enter the name of vacine ");
                String name=sc.next();
                System.out.println("Enter the number of doses");
                int doses=sc.nextInt();
                System.out.println("Enter the gap between doses");
                int gap=sc.nextInt();
                Add_Vaccine V=new Add_Vaccine(name,doses,gap);
                System.out.println("Vaccine name : "+V.Vname+"  Number of doses: "+V.Vdoses+" Gap between doses:  "+V.Vgap);
                if(V.Vname=="Covax"){
                    QCovax++;
                }else{
                    QCovi++;
                }
                QTotal=QCovax+QCovi;
                break;

            case 2:
                System.out.println("Enter the name of hospital ");
                String hosp_name=sc.next();
                System.out.println("Enter the hospital pincode ");
                int hosp_pincode=sc.nextInt();
                Register_hospital RH=new Register_hospital(hosp_name,hosp_pincode);
                int hosp_Uid=RH.Unique_ID();
                Hrecord1.put(hosp_Uid,RH.Hname);
                Hrecord2.put(RH.Hname,hosp_Uid);
                Hrecord3.put(RH.Hpincode,RH.Hname);
                System.out.println("Hospital Name: "+RH.Hname+" PinCode:"+RH.Hpincode+" Unique ID: "+hosp_Uid);

                break;

            case 3:
                System.out.println("Enter the name of Citizen ");
                String Citi_name=sc.next();
                System.out.println("Enter the citizen age");
                int Citi_age=sc.nextInt();
                if(Citi_age>=18){
                    System.out.println("Enter the citizen Unique ID");
                    long  Citi_Uid=sc.nextLong();
                    Citizen C=new Citizen(Citi_name,Citi_age,Citi_Uid);
                    System.out.println("Citizen Name: "+C.Cname+" Age: "+C.Cage+" Unique ID: "+C.CID);
                    Citizen_record.put(C.CID,C.Cname);
                }
                else{
                    System.out.println("Enter the citizen Unique ID");
                    long  Citi_Uid=sc.nextLong();
                    Citizen C=new Citizen(Citi_name,Citi_age,Citi_Uid);
                    System.out.println("Citizen Name: "+C.Cname+" Age: "+C.Cage+" Unique ID: "+C.CID);
                    System.out.println("Only above 18 are allowed");
                }

                break;
            case 4:
                System.out.println("Enter the Hospital ID");
                int hosp_ID=sc.nextInt();
                System.out.println("Enter the number of slot to be added");
                int hosp_slot=sc.nextInt();
                while(hosp_slot>0) {
                    System.out.println("Enter Day Number");
                    int hosp_day = sc.nextInt();
                    System.out.println("Enter the Quantity");
                    int hosp_quantity = sc.nextInt();
                    System.out.println("Select Vaccine 0.Covax  1.Covi");

                    int wish = sc.nextInt();
                    Create_Slot CS = new Create_Slot(hosp_ID, hosp_slot, hosp_day, hosp_quantity);
                    vaxMday.put(CS.Whichvax(wish),hosp_day);
                    if (CS.Whichvax(wish) == "Covax") {
                        VaxMhid.put("Covax", CS.Chid);
                        hidMvax.put(CS.Chid, "Covax");
                        hidMcovax.put(CS.Chid, "Covax");
                        nameMcovax.put(Hrecord1.get(hosp_ID),"Covax");
                        QTotal = QTotal - CS.CQuantity;
                    } else {
                        VaxMhid.put("Covi", CS.Chid);
                        hidMvax.put(CS.Chid, "Covi");
                        hidMcovi.put(CS.Chid, "Covi");
                        nameMcovi.put(Hrecord1.get(hosp_ID),"Covi");
                        QTotal = QTotal - CS.CQuantity;
                    }
//                DayMq.put(CS.CDay,CS.CQuantity);
                    QMday.put(CS.CQuantity, CS.CDay);
                    hidMq.put(CS.Chid, CS.CQuantity);
                    DMS.put(CS.CDay, CS.CSlot);
                    System.out.println("Slot added by Hospital "+CS.Chid+ " for Day "+CS.CDay+ " Available Quantity: "+CS.CQuantity+" of Vaccine "+CS.Whichvax(wish));
                    hosp_slot--;
                }
                break;

            case 5:
                System.out.println("Enter the citizen unique ID");
                long Book_ID=sc.nextLong();
                Book_Slot BS=new Book_Slot(Book_ID);
                System.out.println("1.Search by area  2.Search by Vaccine   3.Exit");
                int Schoice=sc.nextInt();
                if(Schoice==1){
                    System.out.println("Enter the pincode ");
                    int Bpincode=sc.nextInt();
                    String Required_name=Hrecord3.get(Bpincode);
                    int Required_ID=Hrecord2.get(Required_name);
                    Avail_slot.put(Required_ID,Required_name);
                    temp.putAll(Avail_slot);
                    System.out.println(temp);
//                    System.out.println(Required_ID +" "+Required_name);
                    System.out.println("Enter the  hospital id from the above displayed ids and hospital names ");
                    int show_ID=sc.nextInt();
                    if(hidMq.get(show_ID)!=0){
                        int i = 0;
                        int j;
                        String covax_nam;
                        String covi_nam;
                        do{
                            int Quant = hidMq.get(show_ID);
                            covax_nam = hidMcovax.get(show_ID);
                            covi_nam = hidMcovi.get(show_ID);
                            int Daay = QMday.get(Quant);
                            int Sslot = DMS.get(Daay);
                            if(covax_nam==covi_nam ) {
                                if(Avail_slot.keySet()==null) {
                                    System.out.println("No slot available");
                                }else{
                                System.out.println(i + " Day: " + vaxMday.get(covax_nam) + " Available Quantity: " + Quant + " Vaccine: " + covax_nam);
                            }}
                            else {
                                if(Avail_slot.keySet()==null) {
                                    System.out.println("No slot available");}
                                else{
                                System.out.println(i + " Day: " + vaxMday.get(covax_nam) + " Available Quantity: " + Quant + " Vaccine: " + covax_nam);
                                System.out.println((i + 1) + " Day: " + vaxMday.get(covi_nam) + " Available Quantity: " + Quant + " Vaccine: " + covi_nam);
                            }}
                            i++;
                            j=Sslot;
                            j--;
                        }while(j>0);
                        System.out.println("Choose Slot");
                        int choose=sc.nextInt();
                        if(choose==0) {
                            Avail_slot.remove(Required_ID);
                            System.out.println((Citizen_record.get(BS.uniq_id)) + " vaccinated with " + covax_nam);
                            Citizen_m_vax.put(BS.uniq_id,covax_nam);
                        }else{
                            Avail_slot.remove(Required_ID);
                            System.out.println((Citizen_record.get(BS.uniq_id))+" vaccinated with "+covi_nam);
                            Citizen_m_vax.put(BS.uniq_id,covi_nam);
                        }
                        boolean is_present=ID_map_Status.containsKey(BS.uniq_id);
                        if(is_present){
                            ID_map_Status.put(BS.uniq_id,"Fully Vacinated");
                            Citize_id_dose.put(BS.uniq_id,2);
                        }else{
                            ID_map_Status.put(BS.uniq_id,"Partial Vaccinated");
                            Citize_id_dose.put(BS.uniq_id,1);
                        }}
                    else{
                        System.out.println("No slot available because there is no vaccine");
                    }

                    break;
                }else if(Schoice==2){
                    System.out.println("Enter the vaccine name");
                    String Bvaccine=sc.next();
                    if(Bvaccine=="Covax"){
//                        int Required_ID=VaxMhid.get("Covax");
//                        String Required_name=Hrecord1.get(Required_ID);
//                        System.out.println(Required_ID +" "+Required_name);
                        System.out.print(hidMcovax.keySet()+" "+nameMcovax.keySet());
                    }
                    else{
//                        int Required_ID=VaxMhid.get("Covi");
//                        String Required_name=Hrecord1.get(Required_ID);
//                        System.out.println(Required_ID +","+Required_name);
                        System.out.println(hidMcovi.keySet()+" "+nameMcovi.keySet());
                    }
                    System.out.println("Enter the  hospital id from the above displayed ids and hospital names ");
                    int show_ID=sc.nextInt();
                    if(hidMq.get(show_ID)!=0){
                        int i = 0;
                        int j;
                        String covax_nam;
                        String covi_nam;
                        do{
                            int Quant = hidMq.get(show_ID);
                            covax_nam = hidMcovax.get(show_ID);
                            covi_nam = hidMcovi.get(show_ID);
                            int Daay = QMday.get(Quant);
                            int Sslot = DMS.get(Daay);
                            if(covax_nam==covi_nam) {

                                System.out.println(i + " Day: " + vaxMday.get(covax_nam) + " Available Quantity: " + Quant + " Vaccine: " + covax_nam);
                            }else {
                                System.out.println(i + " Day: " + vaxMday.get(covax_nam) + " Available Quantity: " + Quant + " Vaccine: " + covax_nam);
                                System.out.println((i + 1) + " Day: " + vaxMday.get(covi_nam) + " Available Quantity: " + Quant + " Vaccine: " + covi_nam);
                            }
                            i++;
                            j=Sslot;
                            j--;
                        }while(j>0);
                        System.out.println("Choose Slot");
                        int choose=sc.nextInt();
                        if(choose==0) {
                            vaxMday.remove(covax_nam);
                            System.out.println((Citizen_record.get(BS.uniq_id)) + " vaccinated with " + covax_nam);
                            Citizen_m_vax.put(BS.uniq_id,covax_nam);
                        }else{
                            vaxMday.remove(covi_nam);
                            System.out.println((Citizen_record.get(BS.uniq_id))+" vaccinated with "+covi_nam);
                            Citizen_m_vax.put(BS.uniq_id,covi_nam);
                        }

                        boolean is_present=ID_map_Status.containsKey(BS.uniq_id);
                        if(is_present){
                            ID_map_Status.put(BS.uniq_id,"Fully Vacinated");
                            Citize_id_dose.put(BS.uniq_id,2);
                        }else{
                            ID_map_Status.put(BS.uniq_id,"Partial Vaccinated");
                            Citize_id_dose.put(BS.uniq_id,1);
                        }}
                    else{
                        System.out.println("No slot available because there is no vaccine");
                    }

                    break;
                } else{
                    break;
                }

            case 6:
                System.out.println("Enter the Hospital ID");
                int Hp_id=sc.nextInt();
                Available_Slot AS=new Available_Slot(Hp_id);
//                int i = 0;
                int j;
                String covax_nam;
                String covi_nam;
                do {
                    int Quant = hidMq.get(AS.H_id);
                    covax_nam = hidMcovax.get(AS.H_id);
                    covi_nam = hidMcovi.get(AS.H_id);
                    int Daay = QMday.get(Quant);
                    int Sslot = DMS.get(Daay);
                    if(covax_nam==covi_nam){
                        System.out.println(" Day: "+vaxMday.get(covax_nam)+" Available Quantity: "+Quant+" Vaccine "+covax_nam);
                    }
                    else {
                        System.out.println(" Day: " + vaxMday.get(covax_nam) + " Available Quantity: " + Quant+" Vaccine "+covax_nam);
                        System.out.println(" Day: " + vaxMday.get(covi_nam) + " Available Quantity: " + Quant+" Vaccine "+covi_nam);
                    }
//                    i++;
                    j=Sslot;
                    j--;
                }while(j>0);
                break;

            case 7:
                System.out.println("Enter the patient ID");
                long status_id=sc.nextLong();
                Status S=new Status(status_id);
                boolean is_present=ID_map_Status.containsKey(S.Citid);
                if(is_present){
                    System.out.println(ID_map_Status.get(S.Citid));
                    System.out.println("Vaccine Given "+Citizen_m_vax.get(S.Citid));
                    System.out.println("number of Doses give: "+Citize_id_dose.get(S.Citid));

                }else{
                    System.out.println("Registered");

                }

                break;
            case 8:
                Count--;
                System.exit(0);
                break;
        }
            System.out.println("Enter which operation you want to use from portal");
            choice=sc.nextInt();
    }

}
}
