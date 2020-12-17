package com.example.moayo;

public class busInfo {

    String dptPlaceName; //도착지
    String arrPlaceName; //출발지
    String charge;       //요금
    String dptTime;      //출발시간
    String arrTime;      //도착시간
    String busGrade;

    public String getArrPlaceName(){
        return arrPlaceName;
    }
    public void setArrPlaceName(String arrPlaceName){
        this.arrPlaceName = arrPlaceName;
    }
    public String getDptPlaceName(){
        return dptPlaceName;
    }
    public void setDptPlaceName(String dptPlaceName) {
        this.dptPlaceName = dptPlaceName;
    }
    public String getCharge(){
        return charge;
    }
    public void setCharge(String charge){
        this.charge = charge;
    }
    public String getDptTime(){
        return dptTime;
    }
    public void setDptTime(String dptTime){
        this.dptTime = dptTime;
    }
    public String getArrTime(){
        return arrTime;
    }
    public void setArrTime(String arrTime){
        this.arrTime = arrTime;
    }
    public String getBusGrade(){
        return busGrade;
    }
    public void setBusGrade(String busGrade){
        this.busGrade = busGrade;
    }

    public busInfo(String dptPlaceName, String arrPlaceName, String charge, String dptTime, String arrTime, String busGrade){
        this.dptPlaceName = dptPlaceName;
        this.arrPlaceName = arrPlaceName;
        this.charge = charge;
        this.dptTime = dptTime;
        this.arrTime = arrTime;
        this.busGrade = busGrade;
    }
}