package cst8284.quizMaster;

import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FileUtils {
	
   private static String QuizFileAbsolutePathAndName="";
	
   public static File getFileHandle(Stage primaryStage){

	  FileChooser fc = new FileChooser();
	  fc.setTitle("Open Quiz File");
	  fc.getExtensionFilters().addAll(
	      new ExtensionFilter("Quiz Files", "*.quiz"),
	      new ExtensionFilter("All Files", "*.*"));
	  File quizFile = fc.showOpenDialog(primaryStage);
	  setFileName(quizFile);
	  return(quizFile);
   }
   
   public static ArrayList<QA> getQAArray(String absPath) {
	   /*
		 * 
		 * @param, String absPath, leads you to the absolut path of the file on a computer.
		 * @returns ArrayList<QA> of type QA object, it is a custom class that extends QuesAns
		 * @throws BEOFException or NullPointerException at the end of file
		 * or if file not found
		 * n 
		 * 
		 * 
		 */
	   
	   //QA[] qaAr = new QA[numObjects];
	   ArrayList<QA> qaAr= new ArrayList<>();
	  try  {
         FileInputStream fis = new FileInputStream(absPath);
         ObjectInputStream ois = new ObjectInputStream(fis);
		 QA bump;
		 try{
			 while (true){
			 bump=(QA)(ois.readObject());
            qaAr.add(bump);}
		 }
		 catch(EOFException|NullPointerException r){ois.close();}
		 finally{ois.close();}
		 
		} catch (IOException | ClassNotFoundException e) {}
	  
		return qaAr;
   }
    
   private static void setFileName(File f) {
	   QuizFileAbsolutePathAndName = (FileExists(f))? f.getAbsolutePath():"";
   }
   
   public static String getFileName(){
	   return QuizFileAbsolutePathAndName;
   }
   
   public static String getFileName(File f){
	   return f.getAbsolutePath();
   }
   
   private static Boolean FileExists(File f){
	   return (f!=null && f.exists() && f.isFile() && f.canRead());
   }
      
}
