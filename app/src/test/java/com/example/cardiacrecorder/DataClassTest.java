package com.example.cardiacrecorder;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DataClassTest {

    String date = "2023-07-05";
    String time = "12:34";
    String sys = "120";
    String dis = "80";
    String bpm = "70";
    String cmnt = "Normal";
    String passeduser = "John";
    String id = "12345";

    DataClass data = new DataClass(date, time, sys, dis, bpm, cmnt, passeduser, id);


    @Test
    public void getPasseduser() {
        Assert.assertEquals(passeduser, data.getPasseduser());
    }

    @Test
    public void getId() {
        Assert.assertEquals(id, data.getId());
    }

    @Test
    public void getDate() {
        Assert.assertEquals(date, data.getDate());
    }

    @Test
    public void getTime() {
        Assert.assertEquals(time, data.getTime());
    }

    @Test
    public void getSys() {
        Assert.assertEquals(sys, data.getSys());
    }

    @Test
    public void getDis() {
        Assert.assertEquals(dis, data.getDis());
    }

    @Test
    public void getBpm() {
        Assert.assertEquals(bpm, data.getBpm());
    }

    @Test
    public void getCmnt() {
        Assert.assertEquals(cmnt, data.getCmnt());
    }
}