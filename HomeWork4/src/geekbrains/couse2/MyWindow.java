package geekbrains.couse2;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class MyWindow extends JFrame {
    public MyWindow() { //конструктор
        setTitle("My chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 600);

        JPanel[] jp = new JPanel[2];
        // добавляем
        for (int i = 0; i < 2; i++) {
            jp[i] = new JPanel();
            add(jp[i]);
            jp[i].setBackground(new Color(100 + i * 40, 100 + i * 40, 100 + i * 40));
        }
        // компоновщик

        //2 панели
        jp[0].setLayout(new BorderLayout());
        add(jp[0], BorderLayout.CENTER);
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        jp[0].add(jsp);


        jp[1].setLayout(new BorderLayout());
         add(jp[1], BorderLayout.SOUTH);
         JTextField jtf1 = new JTextField();
        jtf1.setPreferredSize(new Dimension(100, 25));
         JScrollPane jsp1 = new JScrollPane(jtf1);
         jp[1].add(jtf1);
        jtf1.setText("");


        jtf1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Your message: " + jtf1.getText());
                jta.setText(jta.getText()+jtf1.getText() + "\n");
                jtf1.setText("");
            }
        });


//        JButton butt = new JButton("Enter");
//        add(butt, BorderLayout.LINE_END);
//        jp[1].add(butt);






        //;


        setVisible(true);

    }
}
