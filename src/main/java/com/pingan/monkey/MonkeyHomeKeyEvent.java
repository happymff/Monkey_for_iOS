package com.pingan.monkey;

import macaca.client.common.Keycode;

import java.io.IOException;

import com.pingan.monkey.util.Shell;

import macaca.client.MacacaClient;

public class MonkeyHomeKeyEvent extends MonkeyEvent{
	private String UDID, BUNDLEID;	
    private MacacaClient driver;

    public MonkeyHomeKeyEvent(MacacaClient driver,String udid, String bundleid) {
        super(MonkeyEvent.EVENT_TYPE_HOMEKEY);
        this.driver = driver;
        this.UDID = udid;
        this.BUNDLEID = bundleid;

    }


    public int injectEvent() throws Exception {
    	System.out.println("sending HOMEKEY Event.");
    	driver.keys("\uE105");
    	new Thread(new Runnable() {
            public void run() {
                try {
                    Shell.exec("pkill idevicedebug");
                    System.out.println("idevicedebug stop");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("launch App:" + BUNDLEID);
                try {
                    Shell.exec("idevicedebug -u " + UDID + " run " + BUNDLEID);
                    Thread.sleep(3000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        return MonkeyEvent.INJECT_SUCCESS;
    } 
}
