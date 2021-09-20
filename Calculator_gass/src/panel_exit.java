import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panel_exit extends JButton implements ActionListener {
    public panel_exit(AbstractBorder brdr){
        setBounds(8,612,312,55);
        setLayout(new GridLayout(1,1));
        Font font = new Font("fira code",Font.BOLD,20);
        setFont(font);
        setText("Exit");
        setBorder(brdr);


        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }
}
