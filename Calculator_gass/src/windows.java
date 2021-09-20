import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windows extends JFrame implements ActionListener {
    Image icon = Toolkit.getDefaultToolkit().getImage("D:\\208\\Calculator_gas\\Photo\\Icon\\villain.ico");
    JLabel background = new JLabel(new ImageIcon("D:\\208\\Calculator_gas\\Photo\\Untitled (2).png"));
    JButton program = new JButton("Program");
    JPanel panel = new JPanel();
    AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,16,0);

    public windows(){
        setIconImage(icon);
        setResizable(false);
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(background,BorderLayout.CENTER);
        background.add(panel);
        //panel.setOpaque(false);

        panel.setBounds(250,100,100,50);
        panel.setLayout(null);
        program.setSize(100,50);
        panel.add(program);

        program.setBorder(brdr);
        program.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        program pg = new program();
        setVisible(false);
        pg.setVisible(true);
    }
}
