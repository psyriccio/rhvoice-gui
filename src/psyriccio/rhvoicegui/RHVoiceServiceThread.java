/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psyriccio.rhvoicegui;

import java.io.IOException;

/**
 *
 * @author psyriccio
 */
public class RHVoiceServiceThread extends Thread {

    private Process serviceProcess = null;

    @Override
    public void run() {
        
        try {
            serviceProcess = Runtime.getRuntime().exec("RHVoice-service");
            while(!isInterrupted()) {
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException ex) {
            if(serviceProcess != null) {
                if(serviceProcess.isAlive()) {
                    serviceProcess.destroy();
                }
            }
        }
        if(serviceProcess.isAlive()) {
            serviceProcess.destroy();
        }
    }

    
    
}
