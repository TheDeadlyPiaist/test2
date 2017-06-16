package battleships

import scala.collection.mutable.ListBuffer
import scalafx.scene.text._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.input._
import scalafx.scene.shape.Rectangle
import scalafx.Includes._
import scalafx.scene.control.Label
import scalafx.scene.layout.Pane

object Main extends JFXApp {
	val mapAlpha:Map[String, Int] = Map("A" -> 0, "B" -> 1, "C" -> 3, "D" -> 4, "E" -> 5, "F" -> 6, "G" -> 7, "H" -> 8,"I" -> 9,"J" -> 10)
	val gridWidth:Double = 45
	val offset:Double = 37
	val gridP:List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
	var shipGridPositions:ListBuffer[List[Double]] = ListBuffer()
	var gridHitPlayer:Array[Int] = Array()
	var gridMissPlayer:Array[Int] = Array()
	var shipTypes:List[Ship] = List(Ship.newPatrolBoat, Ship.newDestroyer, Ship.newSubmarine, Ship.newBattleship, Ship.newAircraftCarrier)
	
	var myStage:PrimaryStage = new PrimaryStage {
		title = "Battleships 1.0"
		
		scene = new Scene(1600, 800) {
			var container:Pane = new Pane()
			
			val textFont:Font = new Font("Times New Roman", 40)
			
			
			var playerGrid:ImageView = new ImageView(new Image("file:src/images/battleshipgrid.png"))
			playerGrid.x = 280
			playerGrid.y = 200
			var enemyGrid:ImageView = new ImageView(new Image("file:src/images/battleshipgrid.png"))
			enemyGrid.x = 820
			enemyGrid.y = 200
			var bg:ImageView = new ImageView(new Image("file:src/images/wood.png"))
			bg.fitWidth = 1600
			bg.fitHeight = 800
			
			var topTextField:Text = new Text("PLACE YOUR SHIPS")
			topTextField.layoutX = playerGrid.getX
			topTextField.layoutY = 150
			topTextField.font = textFont
			topTextField.fill = "white"
			
			
			var patrolBoatP:ImageView = new ImageView(new Image("file:src/images/ships/patrol boat.png"))
			var destroyerP:ImageView = new ImageView(new Image("file:src/images/ships/destroyer.png"))
			var submarineP:ImageView = new ImageView(new Image("file:src/images/ships/submarine.png"))
			var battleshipP:ImageView = new ImageView(new Image("file:src/images/ships/battleship.png"))
			var aircraftCarrierP:ImageView = new ImageView(new Image("file:src/images/ships/aircraft carrier.png"))
			
			val playerBoats:List[ImageView] = List(patrolBoatP, destroyerP, submarineP, battleshipP, aircraftCarrierP)
			var curBoatPlace:Int = 0
			var boatsPlaced:Boolean = false
			
			var rectan = Rectangle(playerGrid.getX+40, playerGrid.getY+38, gridWidth, gridWidth)
			
			def shipRotation():Unit ={
				val i = playerBoats(curBoatPlace)
				i.rotate = i.getRotate + 90
				if(i.getRotate == 360) {i.rotate = 0}
				i.getRotate match {
					case 0 | 180=> i.translateY = 0; i.translateX = 0
					case 90 | 270 => i.translateY = -(i.image().getHeight - gridWidth)/2; i.translateX = (i.image().getHeight-gridWidth)/2
					case _ =>
				}
			}
			def shipPosition(x:Double, y:Double): Unit ={
				if((x > playerGrid.getX && x < playerGrid.getX + playerGrid.image().getWidth) && (y > playerGrid.getY && y < playerGrid.getY + playerGrid.image().getHeight)) {
					var gridCoords:List[Double] = restrictMove(setPosition(x, y))
					playerBoats(curBoatPlace).x = gridCoords(0)
					playerBoats(curBoatPlace).y = gridCoords(1)
				}
			}
			def shipArea(l:List[Double]):List[Double] ={
				val iX = l(0)
				val iY = l(1)
				var returnList:ListBuffer[Double] = ListBuffer()
				val i = playerBoats(curBoatPlace)
				val j = shipTypes(curBoatPlace)
				if(i.getRotate == 0 || i.getRotate == 180) {
					for(k <- 0 until j.getLength) {
						returnList += iX
						returnList += iY + k
					}
				} else {
					for(k <- 0 until j.getLength) {
						returnList += iX + k
						returnList += iY
					}
				}
				returnList.toList
			}
			def setPosition(mX:Double, mY:Double, asNumericOffset:Boolean = false):List[Double] = {
				val oO:List[Double] = List(playerGrid.getX+40, playerGrid.getY+38) //Original Offset
				var returnList:List[Double] = List()
				for(i <- gridP.indices) {
					for(j <- gridP.indices) {
						val xOffset:Double = oO.head + gridP(i)*gridWidth
						val yOffset:Double = oO(1) + gridP(j)*gridWidth
						if((mX >= xOffset && mX <= xOffset+gridWidth) && (mY >= yOffset && mY <= yOffset+gridWidth)) {
							if(!asNumericOffset) {
								returnList = List(xOffset, yOffset)
							} else {
								returnList = List(i.toDouble, j.toDouble)
							}
						}
					}
				}
				returnList
			}
			def restrictMove(position:List[Double]):List[Double] ={
				val x:Double = position(0)
				val y:Double = position(1)
				val i = playerBoats(curBoatPlace)
				val shipLength:Double = shipTypes(curBoatPlace).getLength.toDouble
				
				val positionIndex:List[Double] = setPosition(x, y, true)
				var returnList:List[Double] = List()
				
				if(i.getRotate == 0 || i.getRotate == 180) {
					if(positionIndex(1) > 10 - shipLength) {
						returnList = setPosition(position(0), position(1) - ((shipLength-(10-positionIndex(1))) * gridWidth))
					} else {
						returnList = List(x, y)
					}
				} else if(i.getRotate == 90 || i.getRotate == 270) {
					if(positionIndex(0) > 10 - shipLength) {
						returnList = setPosition(position(0) - ((shipLength-(10-positionIndex(0))) * gridWidth), position(1))
					} else {
						returnList = List(x, y)
					}
				}
				returnList
			}
			def checkCollision(l:List[Double]):Boolean ={
				var returnB:Boolean = false
				val iX:Double = l(0)
				val iY:Double = l(1)
				val newShipArea:List[Double] = shipArea(List(iX, iY))
				if(shipGridPositions.nonEmpty) {
					for(i <- newShipArea.indices by 2 if i < newShipArea.length if !returnB) {
						for(j <- shipGridPositions.indices) {
							val q = shipGridPositions(j)
							for(k <- q.indices by 2 if k<shipGridPositions(j).length) {
								if(newShipArea(i) == q(k) && newShipArea(i+1) == q(k+1)) {
									returnB = true
								}
							}
						}
					}
				}
				returnB
			}
			//==================================================================================================== Events =============================
			onMouseClicked = (e:MouseEvent) => {
				val placeOnGrid:List[Double] = setPosition(e.getX, e.getY, true)
				if(!boatsPlaced && (placeOnGrid.length > 1) && !checkCollision(placeOnGrid)) {
					shipPosition(e.getX, e.getY)
					shipGridPositions += shipArea(setPosition(e.getX, e.getY, true))
					if(curBoatPlace < 4) curBoatPlace += 1 else {topTextField.text = ""; boatsPlaced = true}
				}
			}
			onMouseMoved = (e:MouseEvent) => {
				var placeOnGrid:List[Double] = setPosition(e.getX, e.getY)
				if(!boatsPlaced && (placeOnGrid.length > 1)) {
					shipPosition(e.getX, e.getY)
				}
			}
			onKeyPressed = (e:KeyEvent) => {
				if(e.code == KeyCode.R) {
					shipRotation()
				}
			}
			
			content = List(bg, playerGrid, enemyGrid, container, topTextField)
			
			playerBoats.foreach(i => {
				i.x = 100
				i.y = 100 + (playerBoats.indexOf(i)*100)
				container.children.add(i)
			})
		}
	}
	var newIcon:Image = new Image("file:src/images/icon.jpg")
	myStage.getIcons.add(newIcon)
}
