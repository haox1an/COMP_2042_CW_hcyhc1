package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class FroggerButton extends Button{
	
	private final String Button_Style1 = "-fx-background-color: transparent; -fx-background-image: url('/View/Button.png'); -fx-background-repeat: no-repeat; -fx-background-position: center;";
	private final String Button_Style2 = "-fx-background-color: transparent; -fx-background-image: url('/View/frog_face.png'); -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-size: 200px;";
	private final String Button_Font = "src/View/ARCADECLASSIC.ttf";

	public FroggerButton(String text, int Xpos, int Ypos)
	{
		setText(text);
		setButtonFont();
		setPrefWidth(500);
		setPrefHeight(199);
		setStyle(Button_Style1);
		initializeButtonListener();
		setLayoutX(Xpos);
		setLayoutY(Ypos);
		
		
	}

	private void setButtonFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(Button_Font), 85));
		}
		catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", 50));
			
		}
		
	}
	
	public void setButtonPressedStyle() {
		setStyle(Button_Style2);
	}
	
	public void setButtonReleasedStyle() {
		setStyle(Button_Style1);
	}
	
	private void initializeButtonListener() {
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY))
				{
					setButtonPressedStyle();
				}
				
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY))
				{
					setButtonReleasedStyle();
				}
			}
		});
		
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				{
					setButtonPressedStyle();
				}
			}
		});
		
		
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				{
					setButtonReleasedStyle();
				}
			}
		});
	}
	

	
}
