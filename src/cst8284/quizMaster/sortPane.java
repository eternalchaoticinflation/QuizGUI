package cst8284.quizMaster;

import java.awt.Insets;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class sortPane {

	 private VBox sortBox;
	   private ToggleGroup group = new ToggleGroup();//so they are one group
	   private RadioButton byAuthor, byDifficulty, byPoint, byNone, byRandom;
	   private String[] answers;
	   //private RadioButton[] rbList=new RadioButton(4);
	   public sortPane(){};
		
	   public VBox getSortPane(){
		   /**Constructs radiobuttons
		    * put them in a RadioButton [] array for later use 
		    * 
		    * @return Vbox, with all the custum radioButtoms
		   *
			 *
			 * 
			 * 
			 * */
		   byAuthor = new RadioButton("Select to sort by Author!");//0
		   byDifficulty = new RadioButton("Select to sort by Difficulty!");//1
		   byPoint = new RadioButton("Select to sort by Point!");//2
		   byNone = new RadioButton("Select to sort by Original order!");//3
		   byRandom = new RadioButton("Select to sort by RANDOM!!! orderZZZZ!");//4
	      //int rbCtr = 0;
		   RadioButton[] rbList ={byAuthor, byDifficulty, byPoint,  byNone, byRandom};
		   byAuthor.setToggleGroup(group);
	      for (RadioButton i: rbList){
	         //rbAr[rbCtr] = new RadioButton(ans);
	         i.setToggleGroup(group);
	        // answerBox.getChildren().add(rbAr[rbCtr++]);
	      } 
	      sortBox=new VBox(30, byAuthor, byDifficulty, byPoint,  byNone, byRandom);
	      //sortBox.setPadding(new Insets(10, 0, 0, 0));
	      return sortBox;
	   }
		
	   public int getButtonSelected(){
		   /** clever way to get the radiobutton selected
		    * by assgining it to a number that is orders.
		    * returns the "index" of the radiobutton selected.
		    * @return int btnCtr, breaks at the index of button selected
		   *
			 *
			 * 
			 * 
			 * */
		   
	      int btnCtr = 0;
	      //problem here... if 
	      RadioButton[] rbList ={byAuthor, byDifficulty, byPoint,  byNone, byRandom};
	      if (rbList.length!=0){
	         for (RadioButton rb: rbList){
	            if (rb.isSelected()) break;
	            btnCtr++;
	         }
	      }
	      return  btnCtr;
	      //gets and returns btnCtr # if selected!
	   }
	}
