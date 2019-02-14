import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("run0.png");

	Player hero = new Player();

	Monster monster1;
	Monster monster2;
	Monster monster3;
	Monster monster4;


	public Draw(){
		monster1 = new Monster(200, 200);
		monster2 = new Monster(300, 200);
		monster3 = new Monster(400, 200);
		monster4 = new Monster(500, 200);

		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}


	public void moveUp(){
		hero.moveUp();
		repaint();
	}

	public void moveDown(){
		hero.moveDown();
		repaint();
	}

	public void moveLeft(){
		hero.moveLeft();
		repaint();
	}

	public void moveRight(){
		hero.moveRight();
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(hero.image, hero.x, hero.y, this);
		g.setColor(Color.GREEN);
		g.fillRect(5, 5, 100 * 2, 20);


		//Enemies
		g.drawImage(monster1.image, monster1.xPos, monster1.yPos, this);
		g.setColor(Color.GREEN);
		g.fillRect(monster1.xPos - 7, monster1.yPos, 50, 5);

		g.drawImage(monster2.image, monster2.xPos, monster2.yPos, this);
		g.setColor(Color.GREEN);
		g.fillRect(monster2.xPos - 7, monster2.yPos, 50, 5);

		g.drawImage(monster3.image, monster3.xPos, monster3.yPos, this);
		g.setColor(Color.GREEN);
		g.fillRect(monster3.xPos - 7, monster3.yPos, 50, 5);

		g.drawImage(monster4.image, monster4.xPos, monster4.yPos, this);
		g.setColor(Color.GREEN);
		g.fillRect(monster4.xPos - 7, monster4.yPos, 50, 5);
	}
}