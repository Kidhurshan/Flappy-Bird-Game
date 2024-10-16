import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird extends JPanel implements KeyListener {
    int panelHeight = 640;
    int panelWidth = 360;

    Image backgroundImg ;
    Image birdImg;
    Image topObsticle;
    Image bottomObsticle;

    class Bird{
        int x = panelWidth/8;

        int y = panelHeight/2;
        int width = 34;
        int height = 24;
        Image img = birdImg;
    }
    class Pipe{
        int x = panelWidth;
        int y =0;
        int width = 64;
        int height = 512;
        Image img ;
        boolean pass = false;
        Pipe(Image img){
            this.img = img;
        }

    }
    Bird bird;
    int score =0 ;
    boolean gameOver = false;
    ArrayList<Pipe> pipes;
    int velocityBirdY = -10;
    int velocityPipeX = -4;
    int gravity = 1;
    Timer gameLoop;
    Timer pipeLoop;


    FlappyBird(){
        setPreferredSize(new Dimension(panelWidth,panelHeight));

        setFocusable(true);
        addKeyListener(this);

        //loading the images in java we can load the image using Image icon type then change to image type using .getImage() method to get the location we use getclass and getResourse method

        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topObsticle = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomObsticle = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();


        //for the game loop we can use for or while loop, but we use timer because for 1s we create 60 frames so according to the time timer call the Action Listener obj thats why we implement the class with action listener
        //for bird moving
        bird = new Bird();
        gameLoop = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                repaint();
                if(gameOver){
                    gameLoop.stop();
                    pipeLoop.stop();
                }
            }
        });
        gameLoop.start();

        pipes = new ArrayList<>();
        //for pipe moving
        pipeLoop = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipe();
            }
        });
        pipeLoop.start();


    }

    private void placePipe(){
        Pipe topPipe = new Pipe(topObsticle);
        topPipe.y= (int)(topPipe.y - topPipe.height/4 - Math.random()*topPipe.height/2);
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomObsticle);
        bottomPipe.y = (int)(topPipe.y + bottomPipe.height/Math.min(Math.random()*10,4) + bottomPipe.height);
        pipes.add(bottomPipe);
    }

    private void move() {
        //For bird
        velocityBirdY += gravity;
        bird.y += velocityBirdY;
        bird.y = Math.max(bird.y,1);

        //For Pipe
        for(Pipe pipe : pipes){
            pipe.x += velocityPipeX;
            if(collision(bird, pipe)){
                gameOver =true;
            }
            if( !pipe.pass &&bird.x > pipe.x + pipe.width){
                pipe.pass = true;
                score++;
            }
        }
        if(bird.y>panelHeight){
            gameOver = true;
        }
    }

    private boolean collision(Bird a, Pipe b){
        return a.x< b.x + b.width &&
                a.x + a.width > b.x &&
                a.y < b.y + b.height &&
                a.y + a.height >b.y;
    }

    private void drawBackground(Graphics g) {
        //background
        g.drawImage(backgroundImg,0,0,360,640,null);
        //bird
        g.drawImage(bird.img, bird.x, bird.y,bird.width,bird.height,null);
        //Pipes
        for(Pipe pipe: pipes){
            g.drawImage(pipe.img,pipe.x,pipe.y,pipe.width,pipe.height,null);
        }


        if(gameOver){
            g.setColor(Color.red);
            g.setFont(new Font("Bodoni MT Black", Font.BOLD, 35));
            g.drawString("G A M E  O V E R ",17,300);
            g.drawString(String.valueOf(score),180,355);
        }else {
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("SCORE : " + score,10,20);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
            velocityBirdY = - 10;
        }
        if(e.getKeyCode()== KeyEvent.VK_R && gameOver){
            velocityBirdY = - 10;
            gameOver = false;
            pipes.clear();
            bird.y = panelHeight/2;
            score =0;
            gameLoop.start();
            pipeLoop.start();

        }

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBackground(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
