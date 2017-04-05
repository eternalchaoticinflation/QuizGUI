package cst8284.quizMaster;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class AnswerPane {
   private VBox answerBox = new VBox();
   private ToggleGroup group = new ToggleGroup();
   private RadioButton[] rbAr;
   private String[] answers;
	
   public AnswerPane(String[] answers){
	   /** constructor
	    * 
	    * 
		 * 
		 * @param String[] answers, is set, so it is ready to check answers.
		 *
		 * 
		 * 
		 * */
      this.answers = answers;
   }
	
   public VBox getAnswerPane(){
      rbAr = new RadioButton[answers.length];
      int rbCtr = 0;
      for (String ans: answers){
         rbAr[rbCtr] = new RadioButton(ans);
         rbAr[rbCtr].setToggleGroup(group);
         answerBox.getChildren().add(rbAr[rbCtr++]);
      } 
      return answerBox;
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
	   
      int btnCtr = 1;
      //problem here... if 
      if (rbAr != null){
         for (RadioButton rb: rbAr){
            if (rb.isSelected()) break;
            btnCtr++;
         }
      }
      return (btnCtr>answers.length)? -1: btnCtr;
   }
}
