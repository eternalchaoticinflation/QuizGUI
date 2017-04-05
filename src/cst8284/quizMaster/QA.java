package cst8284.quizMaster;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class QA extends QuesAns {

	private static final long serialVersionUID = 1L;
	private String question, explanation, author;
	private int correctAnswer, difficulty, points;
	private String[] answers;
	private boolean result;
	
	public String getQuestion(){return question;}
	public void setQuestion(String question){this.question = question;}
	
	public String getExplanation(){return explanation;}
	public void setExplanation(String explanation){this.explanation = explanation;}
	
	public String getAuthor(){return author;}
	public void setAuthor(String author){this.author = author;}
	
	public int getCorrectAnswerNumber(){  	
		/*
		 * Returns int, with the right answer number
		 * <p>This method's point is to catch implausiable answers
		 * @param, can be larger that list of answers
		 * @returns the answer non the less
		 * @throws BadQAAnswerChoice a custom Exception, if the answer is larger that answer.length
		 * the transitions are in ParallelTransition 
		 * 
		 * 
		 */
		
		try{ 
			if (correctAnswer<answers.length){
		
				return correctAnswer;
			}
			else {
				throw (new BadQAAnswerChoice());
			}
		} catch (BadQAAnswerChoice b){
			Alert alert = new Alert(AlertType.ERROR);
		     alert.setTitle("BadQAAnserChoice");
		     alert.setContentText("OK");
		     alert.showAndWait();
			return correctAnswer;
		}
		
		    
		}
	public void setCorrectAnswerNumber(int correctAnswer){this.correctAnswer = correctAnswer;}
	
	public int getDifficulty(){return difficulty;}
	public void setDifficulty(int difficulty){this.difficulty = difficulty;}
	
	public int getPoints(){return points;}
	public void setPoints(int points){this.points = points;}
	
	public String[] getAnswers(){return answers;}
	public void setAnswers(String[] answers){
		this.answers = new String[answers.length];
		for (int i=0; i < answers.length; i++) this.answers[i]=answers[i];
	}
	
	public void setResult(boolean b){result = b;}
	public boolean isCorrect(){return result;}
	
	 public QA(String q, String[] a, int correctAnswer, int difficulty, int points, String expl, String author){
		setQuestion(q);
		setAnswers(a);
		setCorrectAnswerNumber(correctAnswer);
		setDifficulty(difficulty);
		setPoints(points);
		setExplanation(expl);
		setAuthor(author);
	}
	
	
}
