package com.stackroute.agent.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.stackroute.agent.ContainerService.ContainerService;
import com.stackroute.agent.Domain.Metrics;
import com.stackroute.agent.Domain.SystemMetrics;
import com.stackroute.agent.Domain.dockerMetrics;
import io.swagger.models.auth.In;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/container")
public class SampleController {
	private ContainerService containerService;

	@Autowired
	public SampleController(ContainerService containerService){
		this.containerService=containerService;
	}

	@GetMapping("/metrics")
	public ResponseEntity<Metrics> metr(@RequestParam Integer userID, @RequestParam Integer applicationID) {
		containerService.executeCommand();
		try{
			Thread.sleep(4000);
		}
		catch (Exception e){
			System.out.println("for executing command");
		}
		String outputString = containerService.readDatafromOutputFile();

		JSONParser parser = new JSONParser();
		List<JSONObject> json=null;
		try{
			json = (List<JSONObject>) parser.parse("["+outputString+"]");
		}
		catch (Exception e){
			System.out.println("error occcured");
		}

		ResponseEntity responseEntity;
		Metrics metrics=new Metrics();
		metrics.setApplicationID(applicationID);
		metrics.setUserID(userID);
		metrics.setMetrics(json);
		return new ResponseEntity<Metrics>(metrics,HttpStatus.OK);
	}
	
	@GetMapping("/temperature")
	public ResponseEntity<Metrics> temperature(@RequestParam Integer userID, @RequestParam Integer applicationID){
		ResponseEntity responseEntity;
		String temperature;
//			temperature = containerService.temperature();
			temperature="2.0";
//			if(){
//				temperature=0;
//			}double
		JSONParser parser = new JSONParser();
		JSONObject json=null;
		try{
			json = (JSONObject) parser.parse("0.0");
		}
		catch (Exception e){
			System.out.println("error occcured");
		}
			Metrics metrics=new Metrics();
			metrics.setApplicationID(applicationID);
			metrics.setUserID(userID);
			metrics.setMetrics(temperature);
		System.out.println(json);
			return new ResponseEntity<Metrics>(metrics,HttpStatus.OK);
	}

	static int i=0;
	@GetMapping("/systemusage")
	public ResponseEntity<Metrics> cadvisor(@RequestParam Integer userID, @RequestParam Integer applicationID){
		containerService.executeCommand();
		try{
			Thread.sleep(4000);
		}
		catch (Exception e){
			System.out.println("for executing command");
		}
		String outputString = containerService.readDatafromOutputFile();
			int index=outputString.indexOf("raw");
			outputString=outputString.substring(index);
			outputString=outputString.substring(0,outputString.indexOf('p'));
			outputString=outputString.split("/")[1];
			outputString=outputString.substring(1,outputString.length()-7);
//			outputString="x"+outputString;
		float x= Float.valueOf(outputString);
		x=x*1000;
		outputString=String.valueOf(x);
		outputString=outputString.substring(0,outputString.length()-2);
		System.out.println(outputString);
			String[] command3 = {"/bin/bash", "-c","docker run --volume=/:/rootfs:ro --volume=/var/run:/var/run:ro --volume=/sys:/sys:ro --volume=/var/lib/docker/:/var/lib/docker:ro --volume=/dev/disk/:/dev/disk:ro --publish=9003:8080  --detach=true --name=cadvisor google/cadvisor:latest"};
			try{
				Process proc2 = Runtime.getRuntime().exec(command3);

			} catch (Exception e2) {

				System.out.println("running docker error");
			}
		try{
				Thread.sleep(5000);}
			catch (Exception e){
				System.out.println("error in thread");
			}
		ResponseEntity responseEntity;
		String output;
			String url2 = "http://10.20.1.181:9003/api/v2.1/stats/docker";
			RestTemplate temp2= new RestTemplate();
			dockerMetrics obj = temp2.getForObject(url2, dockerMetrics.class);
			output = "{"+"\"systemmemory\""+":"+String.valueOf(obj.getCustomData().getCustomStats().get(0).getMemoryStats().getUsage()).substring(0,4)+","+"\"systemcpu\""+":"+Double.parseDouble(obj.getCustomData().getCustomStats().get(0).getCpUmetrics().getDockerusage().getTotal())+"}";
		JSONParser parser = new JSONParser();
		JSONObject json=null;
		try{
			json = (JSONObject) parser.parse(output);
		}
		catch (Exception e){
			e.printStackTrace();
		}

		Metrics metrics=new Metrics();
		metrics.setApplicationID(applicationID);
		metrics.setUserID(userID);
		metrics.setMetrics(json);
		System.out.println(metrics.toString());
		return new ResponseEntity<Metrics>(metrics,HttpStatus.OK);
	}
}