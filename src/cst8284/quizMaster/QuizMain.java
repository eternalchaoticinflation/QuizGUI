package cst8284.quizMaster;

import javafx.application.Application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;


import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuizMain extends Application {
	/**  @Copyright Dave Houtman 2016.  For use in Fall 2016 - CST8284 classes only 
	 * 	 @Copyright Wei Cui 2016, for Assignment3 Fall 2016 - CST8284 class
	 * 
	 * */
	private ArrayList<QA> QAList= new ArrayList<>();
	//private QA[] QAList;                       // Array of QA objects, read from file
	//private final int MAX_QA_SIZE = 5;         // Number of QA objects in array, assumed known
	private File f;                            // Handle to QA file
	private static int currentQuestionNumber; 
	private int choice;// Current question number, zero-based
	//private Pane worldPane= new Pane();
	@Override
	public void start(Stage primaryStage){
		/**  
		 * returns noting void
		 * This method, starts the stage
		 * It mainly uses getSplashPane to display everything
		 * @param Stage primaryStage, to display everything
		 * @return nothing
		 * @throws nothing
		 * 
		 * */
	
	   // Display Splash Screen
	   primaryStage.setTitle("Quiz Master");
	   Scene scene =  new Scene(getSplashPane("Welcome to QuizMaster", primaryStage), 1024, 512);
	   //Scene scene =  new Scene(customContent());
	   /*private Parent customContent() {
		// TODO Auto-generated method stub
	   worldPane.setPrefSize(1024, 512);
	   return worldPane;
	}*/
	   /*scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{//anonclass, override
	@Override
	public void handle(KeyEvent event){
		handleKeyEvent(event);
	}	//for older jdks that's how EventHandler is handled
	
		});
	   */
	

	   
	   
	   primaryStage.setScene(scene);
	   primaryStage.show();	
	   
	   // Get QA file name, open QA file, load QAList array with QA objects
	   /*
	   while(true){
	      f = FileUtils.getFileHandle(primaryStage);  
	      if (FileUtils.getFileName()=="") showMissingFileNameAlert();
	      else break;                          // Escape while() once file name entered
	   } 
       QAList = FileUtils.getQAArray(FileUtils.getFileName(f), MAX_QA_SIZE); // got file name
       
       // Display each QA object in order
	   displayQA(0, QAList, primaryStage);
*/
   }
	
  // private Parent customContent() {
		// TODO Auto-generated method stub
	 //  worldPane.setPrefSize(1024, 512);
	//   return worldPane;
//	}
public class SortByAuthor implements Comparator<QA>{
	
	
	@Override
	public int compare(QA qa1, QA qa2) {
		/**  
		 * 
		 * This method, usings string methods .getAuthor to compare strings
		 * str1 is lexicographically less than str2, 
		 * a negative number will be returned, 
		 * 0 if equal or a positive number if str1 is greater.
		 * 
		 * @param QA qa1, QA qa1, expects QA input to have .getAuthor()
		 * 		the .getAuthor() returns a String
		 * @return integer <0 if qa1.getAuthor()<qa2.getAuthor()
		 * 			integer 0 if qa1.getAuthor() equals qa2.getAuthor()
		 * 			integer 0> if qa1.getAuthor() > qa2.getAuthor()
		 * @throws nothing
		 * 
		 * */
		
		return qa1.getAuthor().compareTo(qa2.getAuthor());
		//str1 is lexicographically less than str2, 
		//a negative number will be returned, 
		//0 if equal or a positive number if str1 is greater.
	}// there is some thing called comparator weird interface
		
}

public class SortByDifficulty implements Comparator<QA>{
	
	
	@Override
	public int compare(QA qa1, QA qa2) {
		/**  
		 * 
		 * This method, use methods .getDifficulty() to compare Difficulty of questions
		 * 
		 * 
		 * @param QA qa1, QA qa1, expects QA input to have .getDifficulty() method
		 * 		.getDifficulty() method
		 * 		returns an integer
		 * @return integer  <0 if qa1.getDifficulty()<qa2.getDifficulty()
		 * 			integer 0 if qa1.getDifficulty() equals qa2.getDifficulty()
		 * 			integer 0> if qa1.getDifficulty() > qa2.getDifficulty()
		 * @throws nothing
		 * 
		 * */
		// TODO Auto-generated method stub
		int latch=0;
		if (qa1.getDifficulty()<qa2.getDifficulty()){
			latch=-1;
		}
		else if (qa1.getDifficulty()>qa2.getDifficulty()){
			latch=1;
		}
		return latch;
	}// there is some thing called comparator weird interface
	
}

public class SortByPoints implements Comparator<QA>{

	

	@Override
	public int compare(QA qa1, QA qa2) {
		/**  
		 * 
		 * This method, use methods .getPoints() to compare how many points each question is worth
		 * 
		 * 
		 * @param <QA> type of class, QA extends QuesAns, QA qa1, QA qa1, expects QA input to have .getPoints() method
		 * 		.getPoints() method
		 * 		returns an integer
		 * @return integer  <0 if qa1.getPoints()<qa2.getPoints()
		 * 			integer 0 if qa1.getPoints() equals qa2.getPoints()
		 * 			integer 0> if qa1.getPoints() > qa2.getPoints()
		 * @throws nothing
		 * 
		 * */
		// TODO Auto-generated method stub
		int latch=0;
		if (qa1.getPoints()<qa2.getPoints()){
			latch=-1;
		}
		else if (qa1.getPoints()>qa2.getPoints()){
			latch=1;
		}
		return latch;
	}// there is some thing called comparator weird interface
	
	
}
public class SortByRandom implements Comparator<QA>{

	
	int min=-5;
	int max=10;
	int randomNum = min + (int)(Math.random() * max); 

	@Override
	public int compare(QA qa1, QA qa2) {
		/**  
		 * THIS IS A RANDOM COMPARSION!!!! METHODSSSSS~~~!!!
		 * This method, use methods .getPoints() to compare how many points each question is worth
		 * THEN it uses a random math function to add to one of the comparions
		 * 
		 * the Random number ranges from -5 to 10.
		 * 
		 * @param <QA> type of class, QA extends QuesAns,
		 * 	QA qa1, QA qa1, expects QA input to have .getPoints() method
		 * 		.getPoints() method
		 * 		returns an integer
		 * @return integer  <0 if qa1.getPoints()+add a random number<qa2.getPoints()
		 * 			integer 0 if qa1.getPoints() add a random number equals qa2.getPoints()
		 * 			integer 0> if qa1.getPoints() add a random number > qa2.getPoints()
		 * @throws nothing
		 * 
		 * */
		
		// TODO Auto-generated method stub
		//System.out.println("Random!");
		int latch=0;
		if ((qa1.getPoints()+randomNum)<(qa2.getPoints())){
			
			latch=-1;
		}
		else if ((qa1.getPoints()+randomNum)>(qa2.getPoints())){
			latch=1;
		}
		return latch;
	}// there is some thing called comparator weird interface
	
	
}


public class SortByNoSort implements Comparator<QA>{
	

	@Override
	public int compare(QA qa1, QA qa2) {
		/**  
		 * the method, always returns 0
		 *  will have quiz in original order
		 * 
		 * 
		 * @param QA qa1, QA qa1, <QA> type of class, QA extends QuesAns,
		 * @return always returns 0, will have quiz in original order
		 * @throws nothing
		 * 
		 * */
		// TODO Auto-generated method stub
		return 0;
	}// there is some thing called comparator weird interface
	
	
}
private void displayQA(int q, ArrayList<QA> qAList2, Stage pStage){
	/**  
	 * the method, In the most important method in this application
	 * it SHOULD BE triggered AFTER, the SORT IT! button has been pressed
	 * if sort it button not pressed, quiz in original order
	 * It returns nothing, but first it has sortMethod to get the 
	 * SortMethod, the user wanted in the radio buttons
	 * then the array qAlist2 is sorted, according to preference then 
	 * the scene is loaded onto the stage and displayed
	 * with sorted questions
	 * ONCE done the original Getresults display. 
	 * 
	 * 
	 * @param -int q has to be integer, in order to access qAlist array,
	 * 		  once q is larger then array size, if condition triggers
	 * 		  then getQAResults displays
	 * 		  increments as next button is pushed
	 *        
	 *        -ArrayList<QA> qAList2 is not sorted, will be sorted by Comparator
	 *        is used to access questions from file, <QA> type of class, QA extends QuesAns,
	 *        
	 *        -Stage used to display 
	 * @return nothing
	 * @throws nothing
	 * 
	 * */
	
	   Scene scene; 
	   // hold current scene object
	   Comparator<QA> sortMethod= getSortMethod2();
	   qAList2.sort(sortMethod);
	   if (q < qAList2.size()){
		   //we should sort this.
		   
		   QA thisQA = qAList2.get(q);
		   currentQuestionNumber = q;		  // load current question to static variable
		   
		   BorderPane bp = new BorderPane();  // Use BorderPane to organize GUI objects
		   
		   // Load Question as text and new AnswerPane with radio buttons and answers into VBox
		   String qNum = new String((currentQuestionNumber + 1) + ". ");  
		   Text txtQuestion = new Text(qNum + thisQA.getQuestion() + "\n");
		   
		   // Instantiate AnswerPane object and load radio buttons/answers into VBox
   		   AnswerPane ap = new AnswerPane(thisQA.getAnswers());
   		   VBox vbAnswerPane = ap.getAnswerPane();
		   
   		   // Instantiate and configure buttons
		   Button btnCheckAnswer = new Button("Check Answer");
		   Button btnNextQuestion = new Button("Next Button");
		   configureButtons(btnCheckAnswer, btnNextQuestion, bp, ap, thisQA);
		   
		   // When 'Next' button clicked, re-enter this code with next question indexed in first parameter
		   btnNextQuestion.setOnAction((ActionEvent e) -> displayQA(++currentQuestionNumber, qAList2, pStage));
		   
		   // Instantiate and configure sub-Panes before loadings into BorderPane
		   HBox hbCheckPane = new HBox(btnCheckAnswer);
		   VBox vbNextPane = new VBox(btnNextQuestion);
		   configurePanes(bp, hbCheckPane, vbNextPane);
		   VBox vbQAPane = new VBox();
		   vbQAPane.getChildren().addAll(txtQuestion, vbAnswerPane, hbCheckPane);

		   // Load BorderPane with Center and Right Panes
		   bp.setCenter(vbQAPane);
		   bp.setRight(vbNextPane);
		   scene = new Scene(bp, 800, 480);                   // Display the current question in the scene
	   }
	   else 
	  	   scene = new Scene(getQAResults(QAList), 800, 480); // Display results in new scene
	   pStage.setScene(scene);                                // Display current scene in stage
   }
private void getSortingPane( ArrayList<QA> qAList2, Stage pStage){
	/**  
	 * the method, returns nothing
	 * takes ArrayList<QA> qAList2 to pass to displayQA(0, qAList2, pStage)
	 * contains  displayQA(0, qAList2, pStage) as part of Eventriggers
	 * will display in getSplashPane BEFORE displayQA(0, qAList2, pStage) therefore replacing it.
	 * makes buttons, and uses buttons to lead you to displayQA(0, qAList2, pStage)
	 * makes a sortPane, the sortPane lets you choose a sort. 
	 * the sort number is stored a choice in private variable.
	 * makes "Sort it!" button
	 * 
	 * 
	 * @param ArrayList<QA> qAList2 to pass to displayQA(0, qAList2, pStage), 
	 * 		  Stage pStage to display sorting choice pane.
	 * @return returns nothing
	 * @throws nothing
	 * 
	 * */
	
	   Scene scene;                           // hold current scene object
	     		   
		   BorderPane bp = new BorderPane();  // Use BorderPane to organize GUI objects
		   // Instantiate AnswerPane object and load radio buttons/answers into VBox
		   sortPane ap = new sortPane();
		   VBox vbsortPane = ap.getSortPane();//gets sort Pane
		   // Instantiate and configure buttons
		   //Button btnCheckAnswer = new Button("Check Answer");
		   Button btnNextQuestion = new Button("To Quiz");
		   Button btnSortQ = new Button("Sort it!");
		   //configureButtons(btnCheckAnswer, btnNextQuestion, bp, ap, thisQA);
		   //btnCheck.setDisable(false);                  // When 'Check' is Enabled 'Next' is not
		   btnNextQuestion.setDisable(false);
		   //btnCheck.setAlignment(Pos.BOTTOM_RIGHT);
		   btnNextQuestion.setAlignment(Pos.BOTTOM_RIGHT);
		   btnSortQ.setAlignment(Pos.CENTER_RIGHT);
		   // When 'Next' button clicked, re-enter this code with next question indexed in first parameter
		   //qAList2 needs sorting
		   
		   // Instantiate and configure sub-Panes before loadings into BorderPane
		   //HBox hbCheckPane = new HBox(btnCheckAnswer);
		   VBox vbNextPane = new VBox(btnNextQuestion);
		   VBox vbNextPane2 = new VBox(btnSortQ);
		 		   //configurePanes(bp, vbNextPane);
		   Pane centerPane = new Pane ();
		   Pane rightPane = new Pane ();
		   Pane bottomPane=new Pane();
		   centerPane.getChildren().add(vbsortPane);
		   rightPane.getChildren().add(btnNextQuestion);
		   bottomPane.getChildren().add(btnSortQ);
		   //VBox vbQAPane = new VBox();
		   //vbQAPane.getChildren().addAll( vbsortPane, vbNextPane);

		   // Load BorderPane with Center and Right Panes
		   bp.setCenter(centerPane);
		   bp.setRight(rightPane);
		   bp.setBottom(bottomPane);
		   scene = new Scene(bp, 900, 580); 
		   
		   
		   btnSortQ.setOnAction((ActionEvent e) -> 
		   
		   choice=ap.getButtonSelected()
		   
				   );// Display the current question in the scene
		   	 
		   
	   
		   //now we have a choice!!!!
		
  btnNextQuestion.setOnAction((ActionEvent e) -> 
		   
		   displayQA(0, qAList2, pStage)
		   
				   );
		   pStage.setScene(scene);   
		   		   	   	   
		 
		   
		  // Display the current question in the scene
 
	    
	  	    // Display results in new scene
	                                // Display current scene in stage
}

private Comparator<QA> getSortMethod2(){
	/**  
	 * 
	 * This method, uses private variable choice and switch cases to determine how to sort it
	 * 
	 * 
	 * @param it uses this.choice, and variable in class, to trigger switch cases
	 * @return Comparator<QA> SortMethod, a generic sortmethod, that depends on switch cases
	 * 		   is used by displayQA(int q, ArrayList<QA> qAList2, Stage pStage) to sort questions
	 * @throws nothing
	 * 
	 * */
	
	switch (choice){/*
			byAuthor = new RadioButton("Select to sort by Author!");//0
			byDifficulty = new RadioButton("Select to sort by Difficulty!");//1
			byPoint = new RadioButton("Select to sort by Point!");//2
			byNone = new RadioButton("Select to sort by Original order!");//3
			*/
						
			case 0 :
			 Comparator<QA> SortAuthor=(new QuizMain()).new SortByAuthor();
			 return SortAuthor;
			case 1 :
			 Comparator<QA> SortDifficulty=(new QuizMain()).new SortByDifficulty();
			 return SortDifficulty;
			case 2 :
			 Comparator<QA> SortPoints=(new QuizMain()).new SortByPoints();
			 return SortPoints;
			case 3 :
			 Comparator<QA> SortNone=(new QuizMain()).new SortByNoSort(); 
			 return SortNone;
			 
			case 4 :
			 Comparator<QA> SortRandom=(new QuizMain()).new SortByRandom(); 
			 return SortRandom;
			 
			default: System.out.println("Error too lazy to catch!");
			Comparator<QA> SortNone2=(new QuizMain()).new SortByNoSort(); 
			return SortNone2;
			}
	}


   private void configureButtons(Button btnCheck, Button btnNext, BorderPane bp, AnswerPane ap, QA thisQuestion){
	   /**  
		 * the method, takes Already created buttons and aligns them, give errors if improper things happen
		 * 
		 * 
		 * @param Button btnCheck, Button btnNext, are aligned with setAlignment(Pos.BOTTOM_RIGHT);
		 * either disabled or enabled
		 * 
		 *  BorderPane bp, AnswerPane ap 
		 * 		  have buttons align in them
		 * @return returns nothing
		 * @throws nothing, 
		 * However there are Alert methods for improper events.
		 * 
		 * */
	   
	   
	   // Configure the properties of the two buttons
	   btnCheck.setDisable(false);                  // When 'Check' is Enabled 'Next' is not
	   btnNext.setDisable(true);
	   
	   btnCheck.setAlignment(Pos.BOTTOM_RIGHT);
	   btnNext.setAlignment(Pos.BOTTOM_RIGHT);
	   
	   btnCheck.setOnAction((ActionEvent e) -> {   // Check clicked; test for valid answer
	      int selectedAnswer = (ap.getButtonSelected());  // Which button was selected?
		  if (selectedAnswer <= 0){                // If invalid selection, show alert...
		     Alert alert = new Alert(AlertType.ERROR);
		     alert.setTitle("Missing Selection");
		     alert.setContentText("Please select an answer from the choices available");
		     alert.showAndWait();
		  }
		  else {                                   // ...otherwise display result and explanation
			 thisQuestion.setResult(selectedAnswer == thisQuestion.getCorrectAnswerNumber());  // set result: correct or not?
			 String rightWrong = thisQuestion.isCorrect()?"Right! ":"Wrong. ";
			 Text txtExplanation = new Text(rightWrong + thisQuestion.getExplanation());
			 
			 BorderPane.setMargin(txtExplanation, new Insets(0,0,100,100));  // Explanation text formatting
			 bp.setBottom(txtExplanation);
			 
		     btnCheck.setDisable(true);         // When 'Check' is Disable 'Next' is Enabled
		     btnNext.setDisable(false);
		  }
	   });
   }
   
   private void configurePanes(BorderPane bp, HBox hbCheck, VBox vbNext){
	   /**  
		 * the method, takes Already created panes and boxes and GIVES a standard height and width.
		 * 
		 * Standard dimesions
		 * 
		 * @param BorderPane bp, HBox hbCheck, VBox vbNext
		 * 		Vboxes are aligned to be bottom right or center right
		 * 
		 *  
		 * @return returns nothing
		 * @throws nothing, 
		 * 
		 * 
		 * 
		 * */
	   
	  // Handles spacing requirements for BorderPane
      VBox vbSpace = new VBox(); vbSpace.setPrefHeight(100); bp.setTop(vbSpace);
 	  HBox hbSpace = new HBox(); hbSpace.setPrefWidth(100); bp.setLeft(hbSpace);
 	  VBox vbBottom = new VBox(); vbSpace.setPrefHeight(150); bp.setBottom(vbBottom);
	  BorderPane.setMargin(vbBottom, new Insets(0,0,115,100));
	  vbNext.setAlignment(Pos.BOTTOM_RIGHT);
	  hbCheck.setAlignment(Pos.CENTER_RIGHT);
   }
	
   // Modified from: Prasad Saya, https://examples.javacodegeeks.com/desktop-java/
   // javafx/dialog-javafx/javafx-dialog-example/  Downloaded Nov. 20, 2016
   
   private void showMissingFileNameAlert(){
	   /**  
		 * the method, displays Alerts if files are missing.
		 * 
		 * 
		 * */
  	  Alert alert = new Alert(AlertType.CONFIRMATION);
	  alert.setTitle("Missing File Name");
	  alert.setContentText("Press OK to exit program or Continue to re-enter file name");
	  Optional<ButtonType> response = alert.showAndWait();
	  if (response.isPresent() && response.get() == ButtonType.OK) {
         Platform.exit();
         System.exit(0);
      }    
   }

	private Pane getSplashPane(String str, Stage primaryStage){
		   /** Returns a borderPane with a dropshadow and an indefinite animation
		    * the transitions are in ParallelTransition  
			 * the method, a string that displays are welcome message, and a primaryStage to display 
			 * the splash screen
			 * BroderPanes, Circle Objects, DropShadow effects, PathTransitions
			 * File input and Output, Menu Bars with Event triggers and
			 * getSortingPane(QAList, primaryStage) are displayed by this method
			 * Standard dimesions
			 * 
			 * @param String str, a string that displays a welcome message, that goes through 
			 * path transitions.
			 * 		
			 * 
			 *  
			 * @return a Pane is return, so it can be displayed in the start(Stage primaryStage) method.
			 * 		   this lets the user select file or exit. 
			 * @throws nothing, 
			 * 
			 * 
			 * */
	
	
		Text text = new Text(str);
		text.setStyle("-fx-font: 40px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		BorderPane splashPane = new BorderPane();
		DropShadow dropShadow= new DropShadow();
		dropShadow.setOffsetX(15);
		dropShadow.setOffsetY(15);
		dropShadow.setColor(Color.AQUA);
		Circle circle = new Circle(75);//import javascene circle
		//root.setPrefSize(600, 600);
		circle.setTranslateX(300);
		//1024, 512
		circle.setTranslateY(0);
		circle.setEffect(dropShadow);
		text.setEffect(dropShadow);
		splashPane.setCenter(text);
		PathTransition fun = new PathTransition(Duration.seconds(3),circle, text);
		fun.setAutoReverse(true);//one full animation then go back
		fun.setCycleCount(Animation.INDEFINITE);
		RotateTransition fun2 = new RotateTransition(Duration.seconds(4), text );
		fun2.setFromAngle(0);
		fun2.setToAngle(360);
		fun2.setAutoReverse(true);
		fun2.setCycleCount(5);
		//fun.play();
		//fun2.play();
		 ParallelTransition pt = new ParallelTransition(fun, fun2);
	        pt.play();
	     MenuBar menuBar = new MenuBar(); 
	 	   
	        // --- Menu File
	     
	     Menu menuFile = new Menu("File");
	     MenuItem open =new MenuItem ("Open...");
	     open.setOnAction(e -> { while(true){
		      f = FileUtils.getFileHandle(primaryStage);  
		      if (FileUtils.getFileName()=="") showMissingFileNameAlert();
		      else break;                          // Escape while() once file name entered
		   } 
	       QAList = FileUtils.getQAArray(FileUtils.getFileName(f)); // got file name
	       
	       // Display each QA object in order
	       //Must sort before displaying QA
	       ///////////////////////////////////////////
	       ///////////////////////////////////////////
	       //GSM
	       getSortingPane(QAList, primaryStage);
	       
		  // displayQA(0, QAList, primaryStage);
	    	 
	     });
	     MenuItem exit = new MenuItem ("Exit");
	     exit.setOnAction(e->{ Platform.exit();});
	     menuFile.getItems().add(open);
	     menuFile.getItems().add(exit);

	        // --- Menu View
	        //Menu menuView = new Menu("View");

	     menuBar.getMenus().addAll(menuFile);
	     splashPane.setTop(menuBar);
		return splashPane;	
		/*
		 * Text newtext= new Text("monsterQuiz");
		//if gets whatyou type.
		newtext.setFont(Font.font(20));
		//private Pane root = new Pane();
		root.getChildren().add(newtext);//pane 
		//pane get new Children, new panes
		//then use Circle shape to define animation
		Circle circle = new Circle(75);//import javascene circle
		//root.setPrefSize(600, 600);
		circle.setTranslateX(300);
		circle.setTranslateY(300);
		//pathTransition the circel
		
		PathTransition fun = new PathTransition(Duration.seconds(3),circle, newtext);
		fun.setAutoReverse(true);//one full animation then go back
		fun.setCycleCount(Animation.INDEFINITE);
		fun.play();
		 */
	}
	
	private BorderPane getQAResults(ArrayList<QA> qAList2){
		   /** Returns an ArrayList,
		    * checks to see if the Questions are right or wrong 
		    * 
			 * 
			 * @param ArrayList<QA> qAList2, gets questions with methods to display
			 * and record whether it is right or wrong.
			 *
			 * @return a BorderPane, so the the final results can be displayed
			 * @throws nothing, 
			 * 
			 * */
		
	
		StringBuilder strResults = new StringBuilder();
		for (int question=0; question < qAList2.size(); question++){ // loop through each QA object
			String str = "Q" + (question + 1) + (qAList2.get(question).isCorrect()?".  Correct":".  Wrong") + "\n";
			strResults.append(str);                       // For each QA, indicate Question number and result
		}
		Text txtResults = new Text(strResults.toString());  // Output results to BorderPane...
		BorderPane.setAlignment(txtResults, Pos.CENTER);
		BorderPane QAResults = new BorderPane();
		QAResults.setCenter(txtResults);
		return QAResults;                                   // ...and return pane for display
	}
	
	
	public static void main(String[] args){
		Application.launch(args);
	}
}