import javax.swing.*;
import java.awt.*;


public class  test1{

    static final int MAX = 12;
    static int count = 0;

        static final String [] Names  = new String[MAX];
        static final JFrame [] frames = new JFrame[MAX];
        static final JTextArea[] chat = new JTextArea[MAX];
        static final JTextField [] Inputs = new JTextField[MAX];

    static void start(){

        for(int i = 0; i < 4; i++){
            int me = i;
            addWindow();

            chat[i] = new JTextArea();
            chat[i].setEditable(false);

            Inputs[i] = new JTextField();

            JButton sendbtn = new JButton("send");
            sendbtn.addActionListener(e -> send(me));

            JPanel panel = new JPanel(new BorderLayout(6,4));
            panel.add(Inputs[i],BorderLayout.CENTER);
            panel.add(sendbtn,BorderLayout.EAST);

            frames[i] = new JFrame(Names[i]);
            frames[i].add(new JScrollPane(chat[i]),BorderLayout.CENTER);
            frames[i].add(panel,BorderLayout.SOUTH);
            frames[i].setSize(520, 450);
            frames[i].setLocationRelativeTo(null);
            frames[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frames[i].setVisible(true);
        }
    }

    static void tile(){

    for(int i = 0; i < count; i++){
        frames[i].setSize(520, 450);
        frames[i].setLocationRelativeTo(null);
    }
}

    static void addWindow(){

        if(count == MAX){
            return;
        }

        int me = count;
        count = count + 1;

        Names[me] = "Sender " + (me + 1);

        chat[me] = new JTextArea();
        chat[me].setEditable(false);

        Inputs[me] = new JTextField();

        JButton sendbtn = new JButton("send");
        sendbtn.addActionListener(e -> send(me));

        JButton addbtn = new JButton("+ Window");
        addbtn.addActionListener(e -> addWindow());

        JPanel right = new JPanel(new GridLayout(1, 2, 4, 0));
        right.add(addbtn);
        right.add(sendbtn);

        JPanel panel = new JPanel(new BorderLayout(6, 4));
        panel.add(Inputs[me], BorderLayout.CENTER);
        panel.add(right, BorderLayout.EAST);

        frames[me] = new JFrame(Names[me]);
        frames[me].add(new JScrollPane(chat[me]), BorderLayout.CENTER);
        frames[me].add(panel, BorderLayout.SOUTH);
        frames[me].setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frames[me].setVisible(true);

        tile();
    }

    static void send(int from){
        String text = Inputs[from].getText().trim();
        if(text.isEmpty()){
            return ;
        }
        for(int i = 0; i < count; i++){
            String who;
            if (i == from) {
                who = "You";
            } else {
                who = Names[from];
            }

            chat[i].append(who + ": " + text + "\n");
        }

        Inputs[from].setText("");
        Inputs[from].requestFocusInWindow();
    }
    static void note (String text){
        for(int i = 0; i < count; i++){
            chat[i].append(text + "\n");
}
    }
    


  public static void main(String[] args){

    SwingUtilities.invokeLater(test1::start);

  }
}
