import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.jar.JarFile;

public class program extends JFrame implements ActionListener {
    Image icon = Toolkit.getDefaultToolkit().getImage("D:\\208\\Calculator_gas\\Photo\\Icon\\villain.ico");
    JLabel background = new JLabel(new ImageIcon("D:\\208\\Calculator_gas\\Photo\\Untitled (2).png"));
    AbstractBorder brdr = new TextBubbleBorder(Color.WHITE,2,16,0);
    AbstractBorder brdr_back = new TextBubbleBorder(Color.BLACK,2,16,0);

    String str;
    String line;
    int countWord = 0;
    int sentenceCount = 0;

    JButton[] button_monitor;
    int[] base;
    float[] gas;
    
    JFrame[] frame;


    JPanel panel_left = new JPanel();
    JPanel panel_right = new JPanel();
    JPanel monitor = new JPanel();
    JPanel panel_file = new JPanel();
    JTextField input_path = new JTextField();
    JButton open = new JButton("open");
    JButton clear = new JButton("clear");
    JLabel textfile = new JLabel("File:");
    JFileChooser chooser = new JFileChooser();

    JPanel panel_set_liquid =new JPanel();
    JLabel textshow = new JLabel();
    JButton clear1 = new JButton("Clear");
    JButton ok = new JButton("OK");
    JLabel textshow1 = new JLabel("m.");
    JTextField input_depth = new JTextField();

    JPanel panel_total = new JPanel();
    JLabel Total = new JLabel();
    JLabel Min = new JLabel();
    JLabel Max = new JLabel();
    JLabel Avg = new JLabel();
    JLabel m = new JLabel();
    Font font4 = new Font("Fira code",Font.BOLD,15);
    String total = "Total Gas:";
    String max = "Max:";
    String min = "Min:";
    String avg = "Avg:";
    String m1 = "m³";

    JPanel Monitor_show = new JPanel();

    JPanel panel_show_gas = new JPanel();
    JPanel gas_medium = new JPanel();
    JLabel text2 = new JLabel();
    JPanel more_gas = new JPanel();
    JLabel text1 = new JLabel();
    JPanel no_gas = new JPanel();
    JLabel text = new JLabel();
    JPanel gas_quite = new JPanel();
    JLabel text3 = new JLabel();

    JPanel panel_Monitor_GAS_DIS = new JPanel();
    JPanel panel_set_gas = new JPanel();
    JPanel GAS = new JPanel();
    JPanel DIS = new JPanel();
    JLabel gasArea = new JLabel();
    JLabel disArea = new JLabel();
    String GasArea = "GAS AREA ";
    String DisArea = "Distance ";


    JPanel panel_Message = new JPanel();
    TextArea message = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
    JLabel messengtext = new JLabel("Message");

    public program() {
        setTitle("Calculator Gas");
        setIconImage(icon);
        setResizable(false);
        setSize(1540, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(background,BorderLayout.CENTER);


        //BackGround Panel Left
        panel_left.setBounds(15,15,329,677);
        panel_left.setBackground(new Color(40,40,40));
        panel_left.setLayout(null);
        background.add(panel_left);

        //Input File & Path
        panel_file.setBounds(8,8,312,96);
        panel_file.setBackground(new Color(130,110,110));
        panel_file.setBorder(brdr);
        panel_file.setLayout(null);

        Font font = new Font("Fira code",Font.BOLD,10);
        textfile.setBounds(20,25,50,25);
        textfile.setFont(font);
        textfile.setForeground(Color.WHITE);
        input_path.setBounds(57,25,210,25);
        input_path.setFont(font);
        open.setBounds(57,55,100,25);
        open.setFont(font);
        clear.setBounds(166,55,100,25);
        clear.setFont(font);

        panel_file.add(textfile);
        panel_file.add(input_path);
        panel_file.add(open);
        panel_file.add(clear);

        open.addActionListener(this);
        clear.addActionListener(this);

        panel_left.add(panel_file);

        //SET LIQUID
        panel_set_liquid.setBounds(8,112,312,170);
        panel_set_liquid.setBackground(new Color(130,110,110));
        panel_set_liquid.setLayout(null);
        panel_set_liquid.setBorder(brdr);

        Font font2 = new Font("Fira code",Font.BOLD,20);
        Font font3 = new Font("Fira code",Font.BOLD,10);
        textshow.setBounds(57,25,210,25);
        textshow.setFont(font2);
        textshow.setText("Set Liquid Depth");
        textshow.setForeground(Color.WHITE);
        input_depth.setBounds(57,60,150,25);
        input_depth.setFont(font3);
        textshow1.setBounds(215,50,50,50);
        textshow1.setFont(font2);
        textshow1.setForeground(Color.WHITE);
        ok.setBounds(57,90,100,25);
        ok.setFont(font3);
        clear1.setBounds(166,90,100,25);
        clear1.setFont(font);

        panel_set_liquid.add(textshow);
        panel_set_liquid.add(textshow1);
        panel_set_liquid.add(input_depth);
        panel_set_liquid.add(ok);
        panel_set_liquid.add(clear1);

        ok.addActionListener(this);
        clear1.addActionListener(this);

        panel_left.add(panel_set_liquid);

        //Panel Total
        panel_total.setBounds(8,292,312,310);
        panel_total.setBackground(new Color(130,110,110));
        panel_total.setLayout(null);
        panel_total.setBorder(brdr);

        Total.setText(total);
        Total.setBounds(10,25,300,25);
        Total.setFont(font4);
        Total.setForeground(Color.WHITE);

        Max.setText(max);
        Max.setBounds(64,60,300,25);
        Max.setFont(font4);
        Max.setForeground(Color.WHITE);

        Min.setText(min);
        Min.setBounds(64,100,300,25);
        Min.setFont(font4);
        Min.setForeground(Color.WHITE);

        Avg.setText(avg);
        Avg.setBounds(64,140,300,25);
        Avg.setFont(font4);
        Avg.setForeground(Color.WHITE);
        m.setText(m1);
        m.setBounds(260, 25, 50, 25);
        m.setFont(font4);
        m.setForeground(Color.WHITE);
        int n =20;
        for (int i = 0; i < 3; i++) {
            JLabel m3 = new JLabel();
            m3.setText(m1);
            m3.setBounds(260, n=n+40, 50, 25);
            m3.setFont(font4);
            m3.setForeground(Color.WHITE);
            panel_total.add(m3);
        }

        panel_total.add(Total);
        panel_total.add(Max);
        panel_total.add(Min);
        panel_total.add(Avg);
        panel_total.add(m);
        panel_left.add(panel_total);

        //Exit
        panel_exit exit = new panel_exit(brdr);
        panel_left.add(exit);

        //Monitor
        monitor.setBounds(355,15,800,677);
        monitor.setBackground(new Color(40,40,40));
        monitor.setLayout(null);
        background.add(monitor);
        monitor.add(Monitor_show);




        //BackGround Panel Right
        panel_right.setBounds(1165,15,329,677);
        panel_right.setBackground(new Color(40,40,40));
        panel_right.setLayout(null);
        background.add(panel_right);

        //Show Gas
        panel_show_gas.setBounds(8,8,312,170);
        panel_show_gas.setBackground(new Color(130,110,110));
        panel_show_gas.setLayout(null);
        panel_show_gas.setBorder(brdr);


        no_gas.setBounds(10,25,40,40);
        no_gas.setBackground(new Color(255,0,0));
        text.setBounds(60,25,100,50);
        text.setText("No Gas");
        text.setFont(font);
        text.setForeground(Color.WHITE);


        more_gas.setBounds(10,85,40,40);
        more_gas.setBackground(new Color(0,255,0));
        text1.setBounds(60,85,100,50);
        text1.setText("More Gas");
        text1.setFont(font);
        text1.setForeground(Color.WHITE);

        gas_medium.setBounds(150,25,40,40);
        gas_medium.setBackground(new Color(255,200,0));
        text2.setBounds(210,25,100,50);
        text2.setText("Gas Medium");
        text2.setFont(font);
        text2.setForeground(Color.WHITE);

        gas_quite.setBounds(150,85,40,40);
        gas_quite.setBackground(new Color(255,110,0));
        text3.setBounds(210,85,100,50);
        text3.setText("Gas Quite A Few");
        text3.setFont(font);
        text3.setForeground(Color.WHITE);

        panel_show_gas.add(no_gas);
        panel_show_gas.add(more_gas);
        panel_show_gas.add(gas_medium);
        panel_show_gas.add(gas_quite);
        panel_show_gas.add(text);
        panel_show_gas.add(text1);
        panel_show_gas.add(text2);
        panel_show_gas.add(text3);
        panel_right.add(panel_show_gas);

        // Message
        panel_Message.setBounds(8,186,312,170);
        panel_Message.setBackground(new Color(130,110,110));
        panel_Message.setLayout(null);
        panel_Message.setBorder(brdr);

        message.setBounds(10,20,292,140);
        messengtext.setBounds(20,0,100,20);
        messengtext.setForeground(Color.WHITE);
        panel_Message.add(messengtext);
        panel_Message.add(message);

        panel_right.add(panel_Message);

        //Gas Dis
        panel_Monitor_GAS_DIS.setBounds(8,364,312,298);
        panel_Monitor_GAS_DIS.setBackground(new Color(130,110,110));
        panel_Monitor_GAS_DIS.setLayout(null);
        panel_Monitor_GAS_DIS.setBorder(brdr);
        panel_right.add(panel_Monitor_GAS_DIS);

        panel_set_gas.setBounds(10,10,294,270);
        panel_set_gas.setBorder(brdr);
        panel_set_gas.setLayout(null);

        GAS.setBackground(new Color(0,200,255));
        GAS.setBounds(10,10,274,125);
        GAS.setBorder(brdr);
        GAS.setLayout(null);

        gasArea.setBounds(10,0,250,125);
        gasArea.setText(GasArea+"0"+" m³");
        GAS.add(gasArea);

        DIS.setBackground(new Color(255,110,0));
        DIS.setBounds(10,135,274,125);
        DIS.setBorder(brdr);

        DIS.setLayout(null);
        disArea.setBounds(10,0,250,125);
        disArea.setForeground(Color.WHITE);
        disArea.setText(DisArea+"0"+" m³");
        DIS.add(disArea);

        panel_set_gas.add(GAS);
        panel_set_gas.add(DIS);

        panel_Monitor_GAS_DIS.add(panel_set_gas);
    }
    public void actionPerformed(ActionEvent e){

        String strDate = new SimpleDateFormat("< dd-MM-yyyy > HH:mm:ss aaa ").format(new Date());  //เวลา


        if (e.getSource() == open){

            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); //set ที่อยู่ไฟล์
            chooser.showSaveDialog(null);
            str = String.valueOf(chooser.getSelectedFile());
            input_path.setText(str);

            message.append("\n"+strDate+" >> You Import File intro the Program.");

            File file = new File(str);      //ที่อยู่ไฟล์
          


            try {
                FileInputStream fileStream = new FileInputStream(file);  //แปลง file ไปเป็น byte stream, Stream (bus) สำหรับอ่าน byte ข้อมูลจาก file
                InputStreamReader input = new InputStreamReader(fileStream); //แปลง FileInputStream มาเป็น FileReader
                BufferedReader reader = new BufferedReader(input); //อ่าน file
                while((line = reader.readLine()) != null) //
                {
                    String[] wordList = line.split("\\s+");
                    countWord += wordList.length;
                    String[] sentenceList = line.split("[!?.:]+");
                    sentenceCount++;

                }
                button_monitor = new JButton[countWord];
                frame = new JFrame[countWord];
                base = new int[countWord];
                gas = new float[countWord];

                Scanner scanner = new Scanner(file);
                for (int i = 0;i<countWord;i++) {
                    base[i] = scanner.nextInt();
                }
            }
            catch (FileNotFoundException xx){}
            catch (IOException xxx){}
            for (int i = 0;i<countWord;i++){
                button_monitor[i] = new JButton();
                frame[i] = new JFrame();
            }

        }
        if (e.getSource() == ok){

            str = String.valueOf(chooser.getSelectedFile());
            int textnum = Integer.parseInt(input_depth.getText());

            Monitor_show.setLayout(new GridLayout(countWord/sentenceCount,sentenceCount));
            Monitor_show.setBounds(10,10,780,657);
            Monitor_show.setBorder(brdr);


            float min1=0;
            float max1=0;


            float result;
            for (int i = 0;i<countWord;i++){

                gas[i] = (150*150)*(textnum-(base[i]-200));
                result = (textnum-(base[i]-200))*0.5f;
                if (result > 100){
                    gas[i] = gas[i]/(result/100f);
                    result = 100;
                    button_monitor[i].setBackground(Color.GREEN);

                }
                else if (result >= 75 && result <= 100){
                    button_monitor[i].setBackground(Color.GREEN);
                }
                else if (result >= 50 && result < 75){
                    button_monitor[i].setBackground(Color.YELLOW);
                }
                else if (result >= 25 && result < 50){
                    button_monitor[i].setBackground(Color.ORANGE);
                }
                else if (result >= 0 && result < 25){
                    button_monitor[i].setBackground(Color.RED);
                }
                else if (result < 0 ){
                    gas[i] = 0;
                    result = 0;
                    button_monitor[i].setBackground(Color.RED);
                }
                else {
                    button_monitor[i].setBackground(new Color(255,(int)(510*result/100),0));
                }

                button_monitor[i].setText(""+result+"%");
                button_monitor[i].setBorder(brdr_back);
                Monitor_show.add(button_monitor[i]);
                
                button_monitor[i].addActionListener(this);


            }
            Arrays.sort(gas);
            min1 = gas[0];
            max1 = gas[gas.length-1];
            Max.setText(max+String.format("%,.02f",max1));
            Min.setText(min+String.format("%,.02f",min1));
            float sum=0;
            for (int i = 0;i<countWord;i++){
                sum = sum + gas[i];
            }
            Total.setText(total+String.format("%,.02f",sum));
            Float avg1 = max1/1.991039878095265f;
            Avg.setText(avg+String.format("%,.02f",avg1));




            message.append("\n"+strDate+" >> You Input Fluid Contact "+input_depth.getText()+" m.");


        }
       if (e.getSource() == clear){
            input_path.setText("");
            str = "";
            line = "";
            
            message.append("\n"+strDate+" >> clear");
        }
        if (e.getSource() == clear1){
            input_depth.setText("");
            message.append("\n"+strDate+" >> clear");

        }
        for (int i = 0; i<countWord;i++) {
			if (e.getSource() == button_monitor[i]) {
				frame[i].setSize(300, 300);
				frame[i].setLocationRelativeTo(null);
				frame[i].setVisible(true);
			}
			
		}
        
    }
}
