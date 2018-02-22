/**
 *	@author Jadie Adams
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import adapter.Controller;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

public class Game1 extends JPanel
{
	private static final long serialVersionUID = -5262708339581599541L;
	private Controller base;
	private String question;
	private int answer;
	private List<String> questionList;
	private GridBagLayout gridBagLayout;

	private JLabel timer;
	private JLabel questionLabel;
	
	//use addScore(num) to increase score. Don't just increase score, the JLabel needs to update.
	private int score = 0;
	private String scoreString;
	private JLabel scoreLabel;
	
	public Game1(Controller base) 
	{
		this.base = base;
		question = null;
		frequency = base.getFrequency();
		answer = 0;
		questionList = base.getEquations();
		gridBagLayout = new GridBagLayout();

		setUpLayout();
		setUpListeners();
		
		timer = new JLabel("Timer");
		questionLabel = new JLabel("Question");scoreString = "Score: 0";
		scoreLabel = new JLabel(scoreString);
		
		setUpLayout();
		setUpListeners();
		playGame();
	}
	
	public void updateScoreString() 
	{
		scoreString = ("Score: " + Integer.toString(score));
	}
	
	private void setUpLayout() 
	{
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setBorder(new LineBorder(new Color(70, 130, 180), 10));
		setForeground(new Color(0, 255, 255));
		setBackground(new Color(0, 0, 0));
		
<<<<<<< HEAD
		timerLabel.setVerticalAlignment(SwingConstants.TOP);
		timerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		timerLabel.setForeground(new Color(135, 206, 250));
		timerLabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
		GridBagConstraints gbc_timerLabel = new GridBagConstraints();
		gbc_timerLabel.insets = new Insets(0, 0, 5, 0);
		gbc_timerLabel.gridx = 2;
		gbc_timerLabel.gridy = 0;
		add(timerLabel, gbc_timerLabel);
=======
		timer.setVerticalAlignment(SwingConstants.TOP);
		timer.setHorizontalAlignment(SwingConstants.LEFT);
		timer.setForeground(new Color(135, 206, 250));
		timer.setFont(new Font("MV Boli", Font.PLAIN, 35));
		GridBagConstraints gbc_timer = new GridBagConstraints();
		gbc_timer.insets = new Insets(0, 0, 5, 0);
		gbc_timer.gridx = 2;
		gbc_timer.gridy = 0;
		add(timer, gbc_timer);

		updateScoreString();
		scoreLabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
		scoreLabel.setForeground(new Color(135, 206, 250));
		GridBagConstraints gbc_labelScore = new GridBagConstraints();
		gbc_labelScore.insets = new Insets(0, 0, 0, 5);
		gbc_labelScore.gridx = 0;
		gbc_labelScore.gridy = 2;
		add(scoreLabel, gbc_labelScore);
>>>>>>> 489a04275678d48cefe191ae96162cd2feee05da
		
		questionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setForeground(new Color(135, 206, 250));
		questionLabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
		GridBagConstraints gbc_question = new GridBagConstraints();
		gbc_question.insets = new Insets(0, 0, 0, 5);
		gbc_question.gridx = 1;
		gbc_question.gridy = 2;
		add(questionLabel, gbc_question);
	
	}
	
<<<<<<< HEAD
=======
	// Make sure you add to score using this, don't just increase score, label needs to update.
	private void addScore(int num)
	{
		score += num;
		updateScoreString();
		scoreLabel.setText(scoreString);
	}
>>>>>>> 489a04275678d48cefe191ae96162cd2feee05da
	
	private void setUpListeners() 
	{
	
	}
	
	private void playGame()
	{
		//Our Game Loop
		getQuestion();
	}
	
	private void getQuestion()
	{
		if(frequency > 0 && Controller.rng.nextInt(10) < frequency && questionList != null)
		{
			questionFromList();
		}
		else
		{
			generateQuestion();
		}
		while(answer < 0)
		{
			//generates a new question if the answer is negative
			generateQuestion();
		}
		removeAll();
		questionLabel.setText(question);
		setUpLayout();
	}
	
	private void questionFromList()
	{
		//Assumes only a + or - operator
		question = questionList.get(Controller.rng.nextInt(questionList.size()));
		if(question.contains("+"))
		{
			int operator = question.indexOf("+");
			int firstInteger = Integer.parseInt(question.substring(0, operator));
			int secondInteger = Integer.parseInt(question.substring(operator + 1));
			answer = firstInteger + secondInteger;
			question = firstInteger + " + " + secondInteger;
		}
		else
		{
			int operator = question.indexOf("-");
			int firstInteger = Integer.parseInt(question.substring(0, operator));
			int secondInteger = Integer.parseInt(question.substring(operator + 1));
			answer = firstInteger - secondInteger;
			question = firstInteger + " - " + secondInteger;
		}
	}
	
	private void generateQuestion()
	{
		int random = Controller.rng.nextInt(2);
		if(random < 1)
		{
			int firstInteger = Controller.rng.nextInt(100);
			int secondInteger = Controller.rng.nextInt(100);
			answer = firstInteger - secondInteger;
			question = firstInteger + " - " + secondInteger;
		}
		else
		{
			int firstInteger = Controller.rng.nextInt(100);
			int secondInteger = Controller.rng.nextInt(100);
			answer = firstInteger + secondInteger;
			question = firstInteger + " - " + secondInteger;
		}
	}
}
