package com.example.cardiacrecorder;

public class DataClass {

    private String datasys;
    private String dataDis;
    private String databpm;
    private String datacom;

    public String getDatasys() {
        return datasys;
    }

    public String getDataDis() {
        return dataDis;
    }

    public String getDatabpm() {
        return databpm;
    }

    public String getDatacom() {
        return datacom;
    }

    public DataClass(String data1, String data2, String data3, String data4) {
        this.datasys = data1;
        this.dataDis = data2;
        this.databpm = data3;
        this.datacom = data4;
    }
}
