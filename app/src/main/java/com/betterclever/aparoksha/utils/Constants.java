package com.betterclever.aparoksha.utils;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.model.TeamPerson;

import java.util.ArrayList;

/**
 * Created by betterclever on 2/21/2017.
 */

public class Constants {
    public static ArrayList<TeamPerson> teamAprList = new ArrayList<>();
    public static ArrayList<TeamPerson> developersList = new ArrayList<>();
    public static ArrayList<TeamPerson> memberList = new ArrayList<>();
    
    static {
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_sahil,
                "Sahil Hindwani","Overall Coordinator",
                "9412262064","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_deora,
                "Abhishek Deora","Tech Head",
                "8756227275","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_vipul,
                "Vipul Agarwal","Head Finance",
                "9838227184","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_shyamnaik,
                "Shyam Naik","Head Creatives",
                "","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_kumawat,
                "Aditya Kumawat","Head Web Operations",
                "","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_yogesh,
                "Yogesh Gupta","Head Sponsorship",
                "9404173123","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_ashish,
                "Ashsih Reddy","Head Workshops",
                "","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_nikhil,
                "Nikhil Ranjan","Head Events",
                "","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_ankush,
                "Ankush Jangid","Head Branding",
                "8756352043","NA",false));
    
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_deepak,
                "Deepak Kumar","Head Events",
                "8182018334","NA",false));
        teamAprList.add(
            new TeamPerson(R.drawable.organizer_gautham,
                "Gautham Santosh","Head Workshops",
                "","NA",false));
        
        
        developersList.add(new TeamPerson(R.drawable.naveen,
            "Naveen Shukla","App Head",
            "7376415693","https://github.com/naveenshukla",true));
        
        developersList.add(new TeamPerson(R.drawable.dev_paliwal,
            "Pranjal Paliwal","App Developer",
            "7988346558","https://github.com/betterclever",true));
    
        developersList.add(new TeamPerson(R.drawable.dev_affan,
            "Affan Ahmad Fahmi","App Developer",
            "8090956103","https://github.com/AnonymousME",true));
        
        
        memberList.add(new TeamPerson(R.drawable.memeber_atul,
            "Atul Sinha","Creatives",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_rohan,
            "Rohan Choudhary","Creatives",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_rajat,
            "Rajat Mishra","Creatives",
            "","",false));
        
        memberList.add(new TeamPerson(R.drawable.memeber_khare,
            "Abhinav Khare","Website",
            "","",false));
        
        memberList.add(new TeamPerson(R.drawable.memeber_padia,
            "Shubham Padia","Website",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_dewan,
            "Aditya Dewan","Website",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_lovish,
            "Lovish Kumar Vatwani","Sponsorship",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_attri,
            "Indresh Attri","Sponsorship",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_navneet,
            "Navneet Kumar Patel","Public Relations",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_shyamsundar,
            "Shyam Sundar","Public Relations",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_hariom,
            "Hariom Niranjan","Finance",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_shyamkotecha,
            "Shyam Kotecha","Finance",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_ram,
            "Ram Kishor","Logistics and Branding",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_bhandari,
            "Shubham Bhandari","Logistics and Branding",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_tarun,
            "Tarun Jain","Logistics and Branding",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_avinash,
            "Avinash Yadav","Logistics and Branding",
            "","",false));
        
        memberList.add(new TeamPerson(R.drawable.memeber_chaitanya,
            "Chaitanya Yadav","Events and Management",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_somendra,
            "Somendra Agrawal","Events and Management",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_rajeev,
            "Rajeev Dixit","Events and Management",
            "","",false));
        
        memberList.add(new TeamPerson(R.drawable.memeber_ashutosh,
            "Ashutosh Chandra","Events and Management",
            "","",false));
    
    
        memberList.add(new TeamPerson(R.drawable.memeber_goyal,
            "Aayush Goyal","Events and Management",
            "","",false));
    
        memberList.add(new TeamPerson(R.drawable.memeber_diwakar,
            "Diwakar Vinay","Workshop/Talks",
            "","",false));
    
    
        memberList.add(new TeamPerson(R.drawable.memeber_rachit,
            "Rachit Parashar","Workshop/Talks",
            "","",false));
        
    
        memberList.add(new TeamPerson(R.drawable.memeber_mubaris,
            "Mubaris Hassan","Workshop/Talks",
            "","",false));
        
    }
}
