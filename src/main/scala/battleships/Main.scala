package battleships

import scalafx.application
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.Image

object Main extends JFXApp {
	var myStage:PrimaryStage = new PrimaryStage {
		title = "Battleships 1.0"
		
		
		scene = new Scene(1000, 800) {
			content = List()
		}
	}
	
	var newIcon:Image = new Image("file:src/images/icon.jpg")
	myStage.getIcons.add(newIcon)
}
