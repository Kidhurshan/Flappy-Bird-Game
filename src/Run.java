import javax.swing.*;

public class Run{
    public static void main(String[] args){
        int frameHeight = 640;
        int frameWeigth = 360;
        JFrame mainFrame = new JFrame("Flappy Bird Game");

        mainFrame.setSize(frameWeigth,frameHeight);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        //this is new method for
        mainFrame.setLocationRelativeTo(null);

        //set up the panel
        FlappyBird flappyBird = new FlappyBird();
        mainFrame.add(flappyBird);
        //this pack method for correctly set up the panel according to the size
        mainFrame.pack();
        flappyBird.requestFocus();
        mainFrame.setVisible(true);
    }
}