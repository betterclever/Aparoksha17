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
    
    static {
        teamAprList.add(
            new TeamPerson(R.drawable.sahil,
                "Sahil Hindwani","Overall Coordinator",
                "7617027345","https://github.com/betterclever",true));
    
        teamAprList.add(
            new TeamPerson(R.drawable.deora2,
                "Abhishek Deora","Tech Head",
                "7617027345","https://github.com/betterclever",true));
    
        teamAprList.add(
            new TeamPerson(R.drawable.sample2,
                "Pranjal Paliwal","App Developer",
                "7617027345","https://github.com/betterclever",true));
    
        teamAprList.add(
            new TeamPerson(R.drawable.sample2,
                "Pranjal Paliwal","App Developer",
                "7617027345","https://github.com/betterclever",true));
    
        teamAprList.add(
            new TeamPerson(R.drawable.sample2,
                "Pranjal Paliwal","App Developer",
                "7617027345","https://github.com/betterclever",true));
    
        teamAprList.add(
            new TeamPerson(R.drawable.sample2,
                "Pranjal Paliwal","App Developer",
                "7617027345","https://github.com/betterclever",true));
    
        developersList.add(new TeamPerson(R.drawable.naveen,
            "Naveen Shukla","App Head",
            "7617027345","https://github.com/betterclever",true));
        
        developersList.add(new TeamPerson(R.drawable.pran,
            "Pranjal Paliwal","App Developer",
            "7617027345","https://github.com/betterclever",true));
    
        developersList.add(new TeamPerson(R.drawable.affan,
            "Affan Ahmad Fahmi","App Developer",
            "7617027345","https://github.com/betterclever",true));
    }
}
