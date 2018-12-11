package com.stackroute.agent.ContainerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import oshi.hardware.Sensors;

import oshi.SystemInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
@Service
public class ContainerService {

    String fileName ="output.txt";
    String output;
    String finalOutput;
    public void executeCommand(){
//            String[] command = {"/bin/bash", "-c","docker stats --no-stream --format \"{\\\"container\\\": \\\"{{ .Container }}\\\",\\\"name\\\": \\\"{{ .Name }}\\\",\\\"containerId\\\": \\\"{{ .ID }}\\\",\\\"Network I/O\\\": \\\"{{ .NetIO }}\\\",\\\"Block I/O\\\": \\\"{{ .BlockIO }}\\\",\\\"Threads\\\": \\\"{{ .PIDs }}\\\", \\\"memory\\\": { \\\"raw\\\": \\\"{{ .MemUsage }}\\\", \\\"percent\\\": \\\"{{ .MemPerc }}\\\"}, \\\"cpu\\\": \\\"{{ .CPUPerc }}\\\"}\"\",\" &> output.txt"};
        String[] command = {"/bin/bash", "-c","docker stats --no-stream --format \"{\\\"container\\\": \\\"{{ .Container }}\\\",\\\"name\\\": \\\"{{ .Name }}\\\",\\\"containerId\\\": \\\"{{ .ID }}\\\",\\\"networkIO\\\": \\\"{{ .NetIO }}\\\",\\\"blockIO\\\": \\\"{{ .BlockIO }}\\\",\\\"threads\\\": \\\"{{ .PIDs }}\\\", \\\"memory\\\": { \\\"raw\\\": \\\"{{ .MemUsage }}\\\", \\\"percent\\\": \\\"{{ .MemPerc }}\\\"}, \\\"cpu\\\": \\\"{{ .CPUPerc }}\\\"}\"\",\" &> output.txt"};

        try{
                    Process proc = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        public String readDatafromOutputFile() {
            String filePath = "output.txt";
            StringBuilder contentBuilder = new StringBuilder();
            try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
                stream.forEach(s -> contentBuilder.append(s).append("\n"));
                output = contentBuilder.toString();
            } catch (IOException e) {
                output = "error occured";
            }
            return output;
        }
    public double temperature(){
        SystemInfo si = new SystemInfo();
        Sensors s = si.getHardware().getSensors();
        double cpuTemperature = s.getCpuTemperature();

        return cpuTemperature;
    }
}
