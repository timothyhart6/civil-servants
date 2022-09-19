package com.civilservants.model.api.proPublica.votes.specificRollCallVote;

import java.util.ArrayList;

public class Vote {
    public int congress;
    public int session;
    public String chamber;
    public int roll_call;
    public String source;
    public String url;
    public Bill bill;
    public Amendment amendment;
    public String question;
    public String question_text;
    public String description;
    public String vote_type;
    public String date;
    public String time;
    public String result;
    public Democratic democratic;
    public Republican republican;
    public Independent independent;
    public Total total;
    public ArrayList<Position> positions;
}
