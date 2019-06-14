package core.videorecorder;

//import com.thoughtworks.device.SimulatorManager;
import core.helpers.ADB;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

import static core.json.parsers.ConfigJasonFileReading.getIOSJasonResults;

public class VideoRecordingAndroid {

    private static final ConcurrentHashMap<Long, Integer> androidScreenRecordProcess =
            new ConcurrentHashMap<>();
    Process screenRecord;
//    private SimulatorManager simulatorManager;
    ThreadLocal<Process> simulatorRecordSession = new ThreadLocal<>();

//    public VideoRecordingAndroid() {
//        simulatorManager = new SimulatorManager();
//    }

    public static void screenRecord(String fileName)
            throws Exception {
        ADB.command("adb -s " + getIOSJasonResults().getDeviceID()
                + " shell screenrecord --bit-rate 3000000 /sdcard/" + fileName
                + ".mp4");
    }

    public static void pullVideoFromDevice(String fileName)
            throws Exception {
        String videoPath = System.getProperty("user.dir");
        String videoLocationAndroid =
                videoPath + "/target/screenshot/android/"
                        + getIOSJasonResults().getDeviceID() + "/"
                        + fileName;
        fileDirectoryCheck(videoLocationAndroid);
        ADB.command("adb -s" + getIOSJasonResults().getDeviceID() +
                "pull" + "/sdcard/" + fileName + ".mp4" +
                videoLocationAndroid);
        System.out.println("Done");
        Thread.sleep(5000);
    }

    public static void removeVideoFileFromDevice(String fileName)
            throws Exception {
        ADB.command("adb -s " + getIOSJasonResults().getDeviceID() + " shell rm -f /sdcard/"
                + fileName + ".mp4");
    }

    public static void stopRecording() throws IOException {
        Integer processId = androidScreenRecordProcess.get(Thread.currentThread().getId());
        stopRunningProcess(processId);
    }

    private static void stopRunningProcess(Integer processId) throws IOException {
        if (processId != -1) {
            String process = "pgrep -P " + processId;
            System.out.println(process);
            Process p2 = Runtime.getRuntime().exec(process);
            BufferedReader r = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            String command = "kill -2 " + processId;
            System.out.println("Stopping Video Recording");
            System.out.println("******************" + command);
            try {
                ADB.command(command);
                Thread.sleep(10000);
                System.out.println("Killed video recording with exit code :" + command);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void fileDirectoryCheck(String folderPath) {
        File f = new File(folderPath);
        f.mkdirs();
    }

}
