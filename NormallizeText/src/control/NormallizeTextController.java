package control;

import java.util.ArrayList;
import java.util.Scanner;
import model.NormallizeText;
import view.NormallizeTextView;

public class NormallizeTextController {

    private NormallizeText model;
    private NormallizeTextView view;

    public NormallizeTextController(NormallizeText model, NormallizeTextView view) {
        this.model = model;
        this.view = view;
    }
    

    public void normalizetext() {

        String getInputText = model.getInputtext();

        getInputText.replace("\\s+", " "); //thay thế tất cả kí tự trắng vd: tab, xuống dòng -> khoảng trắng" "
        getInputText.replace(",\\s*", ", "); // thay thế sau , có các kí tự -> , và khoảng trắng
        getInputText.replace(".\\s*", ". "); // tương tự dấu phẩy
        getInputText.replace(":\\s*", ": "); // tương tự
        
        
        String[] lines = getInputText.split("\n");

        if (lines.length > 0 && !lines[0].isEmpty()) {
            lines[0] = lines[0].substring(0, 1).toUpperCase() + lines[0].substring(1).toLowerCase();
        }

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].startsWith("\"")) {
                lines[i] = lines[i].substring(0, 2).toUpperCase() + lines[i].substring(2).toLowerCase();
            }
        }

        String result = String.join(" ", lines).trim() + ".";
        model.setNormalText(result);

        view.message("complete");
    }

//    public void readInputFile() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the input file name (vd: input.txt):");
//        String fileName = sc.nextLine();
//
//        try {
//            model.loadData(fileName);
//            view.message("File read successfully.");
//        } catch (Exception e) {
//            view.message("Error reading the file ");
//        }
//    }
//
//    public void writeOutputFile() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the output file name (vd: output.txt):");
//        String fileName = sc.nextLine();
//
//        try {
//            model.save();
//            view.message("Result written to file successfully.");
//        } catch (Exception e) {
//            view.message("Error writing to the file");
//        }
//    }

}
