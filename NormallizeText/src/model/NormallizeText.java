package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class NormallizeText {
    
    private String inputtext;
    private String normalText;
    
    ArrayList<NormallizeText> normaltext = new ArrayList<>();
    static String fileInput = "input.csv";

    public String getInputtext() {
        return inputtext;
    }

    public String getNormalText() {
        return normalText;
    }

    public void setInputtext(String inputtext) {
        this.inputtext = inputtext;
    }

    public void setNormalText(String normalText) {
        this.normalText = normalText;
    }
    
    public void loadData(){
        try{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while((line = br.readLine()) != null){
            sb.append(line).append("\n");
        }
        
        br.close();
        setInputtext(sb.toString());
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public void save(){
        try{
        FileWriter writer = new FileWriter("output.txt");
        writer.write(getNormalText());
        writer.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
