package battleships

import scala.collection.mutable.ArrayBuffer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.{Image, ImageView}

object Main extends JFXApp {
	
	var playerShips:ArrayBuffer[Ship] = ArrayBuffer()
	
	var myStage:PrimaryStage = new PrimaryStage {
		title = "Battleships 1.0"
		
		scene = new Scene(1600, 800) {
			var playerGrid:ImageView = new ImageView(new Image("file:src/images/battleshipgrid.png"))
			playerGrid.x = 280
			playerGrid.y = 200
			var enemyGrid:ImageView = new ImageView(new Image("file:src/images/battleshipgrid.png"))
			enemyGrid.x = 820
			enemyGrid.y = 200
			var bg:ImageView = new ImageView(new Image("file:src/images/wood.png"))
			bg.fitWidth = 1600
			bg.fitHeight = 800
			content = List(bg, playerGrid, enemyGrid)
		}
		
		
	}
	
	var newIcon:Image = new Image("file:src/images/icon.jpg")
	myStage.getIcons.add(newIcon)
}
