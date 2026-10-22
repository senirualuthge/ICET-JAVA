import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


class task3copy{

    static final int Alert_Lvl= 75;
    static int waterLevel =0;
    static final Random RANDOM = new Random();


    //UI

   static final JLabel lvlLabel = new JLabel("0mm", SwingConstants.CENTER);
   static final JProgressBar lvlBar = new JProgressBar(0,100);
   static final JLabel alarmLabel = new JLabel("ALARM:OFF ",SwingConstants.CENTER);
   static final JLabel splitterLabel =new JLabel("SPLITTER:OFF",SwingConstants.CENTER);
   static final JTextArea smsArea = new JTextArea(15,20);
   static final Timer autoTimer;

   
    // new ActionListener() {
    //     public static void actionPerformed(ActionEvent e)
    //     randomizeWaterLevel();
    // };

    static{
        autoTimer = new Timer(1000, e -> randomizeWaterLevel());  
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Water Level Monitor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10));

        JPanel topPanel = new JPanel(new BorderLayout(5,5));
        topPanel .setBorder(BorderFactory.createEmptyBorder(10,10,0,10));

        lvlLabel.setFont(new Font("Sanserif",Font.BOLD,36));
        lvlBar.setStringPainted(true);
        lvlBar.setFont(new Font("Sanserif",Font.BOLD,14));

        topPanel.add(lvlLabel, BorderLayout.NORTH);
        topPanel.add(lvlBar, BorderLayout.CENTER);
        frame.add(topPanel,BorderLayout.NORTH);

        JPanel statusPanel =new JPanel(new GridLayout(1,2,10,10));
        statusPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));

        alarmLabel.setOpaque(true);
        alarmLabel.setFont(new Font("SansSerif",Font.BOLD,18));

        splitterLabel.setOpaque(true);
        splitterLabel.setFont(new Font("SansSerif",Font.BOLD,18));

        statusPanel.add(alarmLabel);
        statusPanel.add(splitterLabel);
        frame.add(statusPanel,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(5,5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));

        JButton randomButton = new JButton("Randomize Water Level");
        randomButton.setFont(new Font("SansSerif",Font.BOLD,14));
        randomButton.addActionListener(e -> randomizeWaterLevel());

        JCheckBox autoBox = new JCheckBox("Randomize");
        autoBox.setFont(new Font("SansSerif",Font.BOLD,14));
        autoBox.addActionListener(e ->{
            if(autoBox.isSelected()){
                autoTimer.start();
            }
            else{
                autoTimer.stop();
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("SansSerif",Font.PLAIN,12));
        resetButton.addActionListener(e ->{
            autoBox.setSelected(false);
            autoTimer.stop();
            waterLevel = 0;
            applyWaterLevel();
        });

        buttonPanel.add(randomButton);
        buttonPanel.add(autoBox);
        buttonPanel.add(resetButton);

        smsArea.setEditable(false);
        smsArea.setFont(new Font("MonoSpaced",Font.PLAIN,12));
        JScrollPane scrollPane = new JScrollPane(smsArea); 
        scrollPane.setBorder(BorderFactory.createTitledBorder("SMS Log"));

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        applyWaterLevel();

        frame.setSize(650,520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    static void randomizeWaterLevel(){
        waterLevel = RANDOM.nextInt(101);
        applyWaterLevel();
    }
    
    static void applyWaterLevel(){
        boolean alert = waterLevel >= Alert_Lvl;

        lvlBar.setValue(waterLevel);
        lvlLabel.setText(waterLevel+"mm");

        if (alert){
            alarmLabel.setText("ALARM : ON");
            alarmLabel.setBackground(Color.RED);
            alarmLabel.setForeground(Color.WHITE);
            lvlBar.setForeground(Color.RED);
        }
        else{
            alarmLabel.setText("ALARM : OFF");
            alarmLabel.setBackground(new Color(220, 220, 220));
            alarmLabel.setForeground(Color.DARK_GRAY);
            lvlBar.setForeground(new Color(0, 130, 0));
        }
        if(alert){
           splitterLabel.setText("SPLITTER : OPEN");
            splitterLabel.setBackground(new Color(0, 130, 0));
            splitterLabel.setForeground(Color.WHITE);
        } else {
            splitterLabel.setText("SPLITTER : CLOSED");
            splitterLabel.setBackground(new Color(220, 220, 220));
            splitterLabel.setForeground(Color.DARK_GRAY);
        }

        sendSms(alert); 
        

    }
    static void sendSms(boolean alert) {
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String message = "Water level updated to " + waterLevel + "mm"
                + " | Alarm: " + (alert ? "ON" : "OFF")
                + " | Splitter: " + (alert ? "OPEN" : "CLOSED");

        System.out.println("[SMS " + time + "] " + message);
        smsArea.append("[SMS " + time + "] " + message + "\n");
        smsArea.setCaretPosition(smsArea.getDocument().getLength());
    }




    


}