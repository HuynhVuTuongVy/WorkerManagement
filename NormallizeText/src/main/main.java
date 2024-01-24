package main;

import model.NormallizeText;
import view.NormallizeTextView;
import control.NormallizeTextController;

public class main {
    
    public static void main(String[] args) {
         NormallizeText model = new NormallizeText();
         NormallizeTextView view = new NormallizeTextView();
         NormallizeTextController control = new NormallizeTextController(model, view);
         
        //control.readInputFile();
        model.loadData();
        control.normalizetext();
        model.save();
        //control.writeOutputFile();
    }
    
}

