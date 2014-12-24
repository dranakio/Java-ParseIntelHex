/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parseintelhex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author aknay
 */
public class FXMLDocumentController implements Initializable {
    
  //  @FXML
   // private Label label;
     @FXML
    private Stage stage;
    @FXML
    TextArea inputTextArea = new TextArea();
    //in order to write to TextArea
    //each fx:id must be defined with @FXML
    //cannot be 'final' 
    @FXML
    TextArea outputTextArea = new TextArea();
   
    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//   //     label.setText("Hello World!");
//           inputTextArea.setText("helloooooo");
//           outputTextArea.setText("testinggggggleft");
//           outputTextArea.appendText("added");
//        sortlist();
//    }
    
    //to get file from menu->open
    @FXML
    private void locateFile() throws FileNotFoundException{
        // inputTextArea.setText("helloooooo");
        System.out.println("Opening again");
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Open Text File");
        
        //Filter to get only text file
        //'addAll' for more than one type
        //'add' for only one type
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
            
        //get the file
        File file = filechooser.showOpenDialog(stage);
        
        if (file !=null)
        {    
           readFileAndWriteToTextArea(file);
           readInputFile(file);
        }
    }

    @FXML
    private void saveFile()
    {
        //ref from http://java-buddy.blogspot.sg/2012/05/save-file-with-javafx-filechooser.html
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Text File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        
        if(file !=null)
        {
            writeFileWithFileWriter(outputTextArea.getText(),file);
        }
        
    }   
    
    
    private void writeFileWithFileWriter (String content, File file)
    {
        FileWriter fileWriter = null;
         try {
             fileWriter = new FileWriter(file);
             fileWriter.write(content);
             fileWriter.close();
             
             
             
         } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    
    
    
       //to exit from menu
    public void doExit()
    {
        Platform.exit();
    }
       
    
    public void openFile()
    {
        System.out.println("openfile");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void init(Stage stage) {
        this.stage = stage;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void sortlist ()
    {
//        List<ArrayList<String>> namesAndNumbers = new ArrayList<ArrayList<String>>();
//namesAndNumbers.add(new ArrayList<String>(Arrays.asList("Aike", "(805) 766-4920")));
//namesAndNumbers.add(new ArrayList<String>(Arrays.asList("Cmily", "(705) 668-9292", "(705) 555-1060")));
//namesAndNumbers.add(new ArrayList<String>(Arrays.asList("Bames", "(605) 965-2000")));
//Collections.sort(namesAndNumbers, new Comparator<ArrayList<String>>() {    
//        @Override
//        public int compare(ArrayList<String> o1, ArrayList<String> o2) {
//            return o1.get(0).compareTo(o2.get(0));
//        }               
//});
//System.out.println(namesAndNumbers);
        
// int a = (int) Long.parseLong("AA", 16);
// int b = (int) Long.parseLong("AB", 16);
// int c = (int) Long.parseLong("AC", 16);
// 
//System.out.println(Integer.toString(a));
 
 
 
 
 //ref from http://stackoverflow.com/questions/20480723/how-to-sort-2d-arrayliststring-by-only-the-first-element
//List<ArrayList<Integer>> namesAndNumbers = new ArrayList<ArrayList<Integer>>();
//namesAndNumbers.add(new ArrayList<Integer>(Arrays.asList(a, 111)));
//namesAndNumbers.add(new ArrayList<Integer>(Arrays.asList(b, 222)));
//namesAndNumbers.add(new ArrayList<Integer>(Arrays.asList(c, 333)));
//Collections.sort(namesAndNumbers, new Comparator<ArrayList<Integer>>() {    
//        @Override
//        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//            return o1.get(0).compareTo(o2.get(0));
//        }               
//});
//System.out.println(namesAndNumbers);
        
        
        
        
        
        
        
    }
    
    
    
    private List<ArrayList<Integer>> sortMemoryAddress (List<ArrayList<Integer>> list)
    {
        //ref from http://stackoverflow.com/questions/20480723/how-to-sort-2d-arrayliststring-by-only-the-first-element
           Collections.sort(list, new Comparator<ArrayList<Integer>>() {    
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return o1.get(0).compareTo(o2.get(0));
        }               
});
           
           return list;
                }
    
    
    private List<ArrayList<Integer>> addMissingMemoryAddress (List<ArrayList<Integer>> list)
    {
        
        
         int lastAddress;
        
      ArrayList lastArrayInTheList =  list.get(list.size()-1);
      lastAddress =   (int) lastArrayInTheList.get(0);
//      System.out.println("lastAddress");
//      System.out.println(String.format("%x",lastAddress));  
      
      List<ArrayList<Integer>> memoryAddressList = new ArrayList<ArrayList<Integer>>();
      
      
      int a = 0;
      for (int i = 0; i< lastAddress;i++)
      {
          
          
           ArrayList innerList = list.get(a);
           if (i == (int)innerList.get(0))
           {
               
               memoryAddressList.add(new ArrayList<Integer>(Arrays.asList(i, (int)innerList.get(1))));
               a++;
               
           }
           else
           {
               memoryAddressList.add(new ArrayList<Integer>(Arrays.asList(i, 0)));
//                System.out.println("missingNumber");
//                System.out.println(i);
           }
         
      }      
        return memoryAddressList;
    }
    
    
    
    void readFileAndWriteToTextArea(File file) throws FileNotFoundException
    {
         Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
           
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNext()) {
            String linebyline = lineScanner.next();
            inputTextArea.appendText(linebyline);
            }
            lineScanner.close();
            inputTextArea.appendText("\n"); //to make new line for better reading         
            System.out.println(line);
        }sc.close();       
    }
    
    
    private void readInputFile (File file) throws FileNotFoundException
    {
       
        
        List<ArrayList<Integer>> memoryAddressList = new ArrayList<ArrayList<Integer>>();
        
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            
            Scanner lineScanner = new Scanner(line);
            while (lineScanner.hasNext()) {
                String linebyline = lineScanner.next();
                // get number of data in one line
                int numOfData = Integer.valueOf(linebyline.substring(1, 3),
                        16);
                
                if (numOfData > 0) {
                    System.out.println(linebyline);
                    
                    int i = 0;
                    while (i < numOfData) {
                        // get address and print it out as hex for address
                        System.out.print(String.format(
                                "%x",
                                Integer.valueOf(linebyline.substring(3, 7),
                                        16) + i));
                        System.out.print(" ");
                        
                        // print out data up to numOfData
                        System.out.println(linebyline.substring(
                                9 + (i * 2), 11 + (i * 2)));
                        
                        //both are changed from 'hex string' to 'int' //Integer.valueOf(foo,16)
                        int memoryAddress = Integer.valueOf(linebyline.substring(3, 7),16)+i;
                        int dataByte = Integer.valueOf(linebyline.substring(9 + (i * 2), 11 + (i * 2)),16); 
                        
                       //System.out.println("test"+memoryAddress);
                       //System.out.println("data"+dataByte);
                        
                        memoryAddressList.add(new ArrayList<Integer>(Arrays.asList(memoryAddress, dataByte)));                                           
                        i++;
                    }
                }
            }
            // close for line by line Scanner
            lineScanner.close();
        }
        sc.close();
        //now it becomes sorted list
        memoryAddressList = sortMemoryAddress(memoryAddressList);
        
        
         /*                 -----LOGGING PURPOSE----        */
        /*
        System.out.println("Printing whole array");
        
        for (int i = 0; i< memoryAddressList.size();i++)
        {
            
            ArrayList innerList = memoryAddressList.get(i);
            System.out.print(String.format("%x",innerList.get(0)));
             System.out.print(" ");
            System.out.println(String.format("%x",innerList.get(1)));
        }
        */
        //now it becomes list with complete memory address
        memoryAddressList = addMissingMemoryAddress(memoryAddressList);
        
        
        
        /*                 -----LOGGING PURPOSE----        */
        //Printing out and sppend Text into outputTextArea
        
              //   System.out.println("Printing added new whole array");
        
                for (int i = 0; i< memoryAddressList.size();i++)
        {     
            ArrayList innerList = memoryAddressList.get(i);
            
            outputTextArea.appendText(String.format("%x",innerList.get(0)));
            outputTextArea.appendText(" ");
            outputTextArea.appendText(String.format("%x",innerList.get(1)));
            outputTextArea.appendText("\n");
            
          //  System.out.print(String.format("%x",innerList.get(0)));
          //   System.out.print(" ");
          //  System.out.println(String.format("%x",innerList.get(1)));
        }
        
        
        
        /*
        // memoryAddressList = addMemoryAddress(memoryAddressList);
        
        
        //trying to add here.
        
        //get last address
        int lastAddress;
        
      ArrayList lastArrayInTheList =  memoryAddressList.get(memoryAddressList.size()-1);
      lastAddress =   (int) lastArrayInTheList.get(0);
      System.out.println("lastAddress");
      System.out.println(String.format("%x",lastAddress));  
      
      List<ArrayList<Integer>> finalMemoryAddressList = new ArrayList<ArrayList<Integer>>();
      
      
      int a = 0;
      for (int i = 0; i< lastAddress;i++)
      {
          
          
           ArrayList innerList = memoryAddressList.get(a);
           if (i == (int)innerList.get(0))
           {
               
               finalMemoryAddressList.add(new ArrayList<Integer>(Arrays.asList(i, (int)innerList.get(1))));
               a++;
               
           }
           else
           {
               finalMemoryAddressList.add(new ArrayList<Integer>(Arrays.asList(i, 0)));
                System.out.println("missingNumber");
                System.out.println(i);
           }
         
      }
      
      
      
          System.out.println("Printing added new whole array");
        
                for (int i = 0; i< finalMemoryAddressList.size();i++)
        {
            
            ArrayList innerList = finalMemoryAddressList.get(i);
            System.out.print(String.format("%x",innerList.get(0)));
             System.out.print(" ");
            System.out.println(String.format("%x",innerList.get(1)));
        }
        
        
      
      
      
      
      
      
        
        
         System.out.println("Printing added whole array");
        
                for (int i = 0; i< memoryAddressList.size();i++)
        {
            
            ArrayList innerList = memoryAddressList.get(i);
            System.out.print(String.format("%x",innerList.get(0)));
             System.out.print(" ");
            System.out.println(String.format("%x",innerList.get(1)));
        }
        
        
        
        */
        
        
        
        
        
        
        
//        ArrayList innerList = memoryAddressList.get(5);
        
        
      // int test = (int) innerList.get(1);
        
//       String test = String.valueOf(innerList.get(1));
       //ArrayList test = (ArrayList) innerList.get(1);
        
       // String test = (String) innerList.get(1);
        
       
        
//          System.out.println("inner item");
//          System.out.println(String.format("%x",innerList.get(1)));
          
      // System.out.println(String.valueOf(innerList.get(1)));
       //System.out.println(String.format("%x",String.valueOf(innerList.get(1))));
        
       // Item item = (Item) innerList.get(1);
        
//        System.out.println("inner");
//        System.out.println(innerList);
        
        
        
//        System.out.println("final");
//        System.out.println(memoryAddressList);
        //System.out.println(String.format("%x",memoryAddressList));
        
    }
    
    
    
    
    
}
