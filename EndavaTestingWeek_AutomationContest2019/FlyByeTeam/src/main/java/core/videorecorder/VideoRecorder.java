package core.videorecorder;

import core.helpers.MacTerminalCmd;
import core.watchers.MyLogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

import static core.json.parsers.ConfigJasonFileReading.getAndroidJasonResults;
import static core.json.parsers.ConfigJasonFileReading.getIOSJasonResults;

public class VideoRecorder extends MacTerminalCmd {

    private static final ConcurrentHashMap<Long, Integer> androidScreenRecordProcess =
            new ConcurrentHashMap<>();
    //    private static SimulatorManager simulatorManager;
    private static final ThreadLocal<Process> simulatorRecordSession = new ThreadLocal<>();

//    public VideoRecorder() {
//        simulatorManager = new SimulatorManager();
//    }

    /**
     * @param className     - Current test class name
     * @param methodName    - Current test method name
     * @param videoFileName - filename should have TimeStamp,deviceID with TestMethod name
     * @throws IOException
     * @throws InterruptedException
     */
    public static void stopVideoRecording(String className, String methodName,
                                          String videoFileName) throws Exception {
        System.out.println("**************Stopping Video Recording**************");

        if (getIOSJasonResults().getDeviceID().length() == 40) {
            stopRunningProcess(getPid(simulatorRecordSession.get()));
            System.out.println("Killed .........");
        } else {
            flickRecordingCommand("stop", className, methodName, videoFileName);
        }
    }

    /**
     * @param className     - Current test class name
     * @param methodName    - Current test method name
     * @param videoFileName - filename should have TimeStamp,deviceID with TestMethod name
     * @throws IOException
     * @throws InterruptedException
     */
//    public static void startVideoRecording(String className, String methodName,
//                                           String videoFileName) throws Exception {
//        System.out.println("**************Starting Video Recording**************");
//        if (getIOSJasonResults().getDeviceID().length() == 40) {
//            String videoPath = System.getProperty("user.dir");
//            String videoLocationIOS =
//                    videoPath + "/target/screenshot/iOS/" + getIOSJasonResults().getDeviceID()
//                            + "/" + className + "/" + methodName;
//            File file = new File(videoLocationIOS);
//            if (!file.exists()) {
//                file.mkdirs();
//            }
//            simulatorRecordSession.set(simulatorManager
//                    .startScreenRecording(getIOSJasonResults().getDeviceID(),
//                            videoLocationIOS + "/" + videoFileName + ".mp4"));
//        } else {
//            MyLogger.log.info("RECORDING STARTED FOR ADROID DEVICES");
//            flickRecordingCommand("start", className, methodName, videoFileName);
//        }
//
//    }

    private static void flickRecordingCommand(String command, String className,
                                              String methodName, String videoFileName) throws Exception {
        String videoPath = System.getProperty("user.dir");
        String android;
        String ios;
        if (getAndroidJasonResults().getDeviceID().length() != 40) {
            String videoLocationAndroid =
                    videoPath + "/target/screenshot/android/"
                            + getAndroidJasonResults().getDeviceID() + "/"
                            + className + "/" + methodName;
            fileDirectoryCheck(videoLocationAndroid);
            if (command.equals("start")) {
                try {
                    if (!getDeviceManufacturer()
                            .equals("unknown") && checkIfRecordable()) {
                        MyLogger.log.info("Manufacturer is not unknown");
                        Process screenRecord = Runtime.getRuntime()
                                .exec(screenRecord(methodName));
                        System.out.println(
                                "ScreenRecording has started..." + Thread.currentThread().getId());
                        androidScreenRecordProcess
                                .put(Thread.currentThread().getId(), getPid(screenRecord));
                        System.out.println("Process ID's:" + getPid(screenRecord));
                        Thread.sleep(1000);
                    } else {
                        android = "flick video -a " + command + " -p android -u "
                                + getAndroidJasonResults().getDeviceID();
                        runCommandThruProcess(android);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (!getDeviceManufacturer()
                        .equals("unknown")
                        && checkIfRecordable()) {
                    stopRecording();
//                    pullVideoFromDevice(methodName, videoLocationAndroid);
                    removeVideoFileFromDevice(methodName);
                } else {
                    android = "flick video -a " + command + " -p android -o "
                            + videoLocationAndroid + " -n " + videoFileName
                            + " -u " + getAndroidJasonResults().getDeviceID() + " --trace";
                    runCommandThruProcess(android);
                    System.out.println("Stopping Video recording on Emulator");
                    Thread.sleep(10000);
                }
            }
        } else {
            String videoLocationIOS =
                    videoPath + "/target/screenshot/iOS/" + getIOSJasonResults().getDeviceID()
                            + "/" + className + "/" + methodName;
            fileDirectoryCheck(videoLocationIOS);
            if (command.equals("start")) {
                ios = "flick video -a " + command + " -p ios -u "
                        + getIOSJasonResults().getDeviceID();
            } else {
                ios = "flick video -a " + command + " -p ios -o " + videoLocationIOS + " -n "
                        + videoFileName + " -u " + getIOSJasonResults().getDeviceID();
            }

            System.out.println(ios);
            try {
                runCommand(ios);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void fileDirectoryCheck(String folderPath) {
        File f = new File(folderPath);
        f.mkdirs();
    }

    private static int getPid(Process process) {
        try {
            Class<?> cProcessImpl = process.getClass();
            Field fPid = cProcessImpl.getDeclaredField("pid");
            if (!fPid.isAccessible()) {
                fPid.setAccessible(true);
            }
            return fPid.getInt(process);
        } catch (Exception e) {
            return -1;
        }
    }

    private static void stopRecording() throws IOException {
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
                runCommand(command);
                Thread.sleep(10000);
                System.out.println("Killed video recording with exit code :" + command);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getDeviceManufacturer()
            throws Exception {
        return runCommand("adb -s " + getIOSJasonResults().getDeviceID()
                + " shell getprop ro.product.manufacturer")
                .trim();
    }

    private static boolean checkIfRecordable() throws Exception {
        String screenrecord =
                runCommand("adb -s " + getIOSJasonResults().getDeviceID()
                        + " shell ls /system/bin/screenrecord");
        return screenrecord.trim().equals("/system/bin/screenrecord");
    }

    private static String screenRecord(String fileName)
            throws Exception {
        return "adb -s " + getIOSJasonResults().getDeviceID()
                + " shell screenrecord --bit-rate 3000000 /sdcard/" + fileName
                + ".mp4";
    }

    public static void pullVideoFromDevice(String fileName, String className, String methodName)
            throws Exception {
        String videoPath = System.getProperty("user.dir");
        String videoLocationAndroid =
                videoPath + "/target/screenshot/android/"
                        + getIOSJasonResults().getDeviceID() + "/"
                        + className + "/" + methodName;
        ProcessBuilder pb =
                new ProcessBuilder("adb", "-s", getIOSJasonResults().getDeviceID(),
                        "pull", "/sdcard/" + fileName + ".mp4",
                        videoLocationAndroid);
        Process pc = pb.start();
        pc.waitFor();
        System.out.println("Exited with Code::" + pc.exitValue());
        System.out.println("Done");
        Thread.sleep(5000);
    }

    private static void removeVideoFileFromDevice(String fileName)
            throws Exception {
        runCommand("adb -s " + getIOSJasonResults().getDeviceID() + " shell rm -f /sdcard/"
                + fileName + ".mp4");
    }
}
