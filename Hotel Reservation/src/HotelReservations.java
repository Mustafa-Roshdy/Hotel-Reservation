import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Date;

public class HotelReservations extends JFrame implements ActionListener {
    String[] hotels={"Basma Hotel Aswan (7.4)","Tolip Aswan Hotel (7.8)","Sofitel Legend Old Cataract (9.4)","Movenpick Resort Aswan (8.8)","CityMax Hotel Aswan (8.0)"};
    JTextField  input,input2;
    JButton b1,b2,b3,b4,b5,b6,next;
    JLabel text,text4,text5;
    JLabel text6;
    JLabel text7;
    JLabel text8;
    JLabel text9;
    JLabel t1;
    JLabel t2;
    JLabel t3;
    static JLabel w1;
    static JLabel w2;
    JComboBox<String> cb;
    JPanel ppp;
    int adult=1,child=0,room=1;
    Event event=new Event();


    public  HotelReservations() {

        //ImageIcon img=new ImageIcon(getClass().getResource("open_door.png"));
        Image icon;
        try {
            icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("hotel_icon.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Color Dark_Blue=new Color(0, 0, 103);
        this.setIconImage(icon);
        this.getContentPane().setBackground(Color.orange);
        ppp=new JPanel(null);
        ppp.setBounds(230, 30, 530, 500);
        ppp.setBorder(new LineBorder(Color.BLACK,5,true));
        Font newFont = new Font("Verdana", Font.BOLD, 28);
        Font word = new Font("Verdana", Font.BOLD, 15);
        text = new JLabel("Hotel Reservations");
        text.setFont(newFont);
        text.setBounds(110, 10, 380, 100);
        text.addMouseListener(event);
        input = new JTextField("Name", 30);
        input2 = new JTextField("ID", 14);
        input.setBounds(70, 110, 185, 30);
        input2.setBounds(275, 110, 185, 30);
        input.addMouseListener(event);input2.addMouseListener(event);
        text4 = new JLabel("Check-in date");
        text4.setBounds(70, 150, 170, 26);
        text4.setFont(word);
        DateFormat Date_Format = new SimpleDateFormat("dd MMM yyyy");
        JFormattedTextField Today_Date = new JFormattedTextField(Date_Format);
        Today_Date.setName("Today");
        Today_Date.setColumns(10);
        Today_Date.setEditable(true);
        JLabel Today_Label = new JLabel("Date:");
        Today_Label.setLabelFor(Today_Date);
        Today_Date.setValue(new Date());
        Today_Date.setBounds(70, 180, 185, 30);
        w1 = new JLabel("hh");
        text5 = new JLabel("Check-out date");
        text5.setBounds(275, 150, 170, 26);
        text5.setFont(word);
        JFormattedTextField Choose_Date = new JFormattedTextField(Date_Format);
        Choose_Date.setName("Choose_Date");
        Choose_Date.setColumns(10);
        Choose_Date.setEditable(true);
        JLabel Choose_Label = new JLabel("Date:");
        Choose_Label.setLabelFor(Choose_Date);
        Choose_Date.setValue(new Date("19 Jan 2023"));
        Choose_Date.setBounds(275, 180, 185, 30);
        text7 = new JLabel("Adults");
        text7.setBounds(100, 220, 170, 27);
        text7.setFont(word);
        t1 = new JLabel("1");
        t1.setBounds(117, 240, 26, 26);
        t1.setFont(word);
        b1 = new JButton("<");
        b2 = new JButton(">");
        b1.setBounds(70, 245, 43, 20);
        b2.setBounds(142, 245, 43, 20);
        text8 = new JLabel("Children");
        text8.setBounds(220, 220, 170, 27);
        text8.setFont(word);
        t2 = new JLabel("0");
        t2.setBounds(247, 240, 26, 26);
        t2.setFont(word);
        b3 = new JButton("<");
        b4 = new JButton(">");
        b3.setBounds(200, 245, 43, 20);
        b4.setBounds(272, 245, 43, 20);
        text9 = new JLabel("Rooms");
        text9.setBounds(360, 220, 170, 27);
        text9.setFont(word);
        t3 = new JLabel("1");
        t3.setBounds(377, 240, 26, 26);
        t3.setFont(word);
        b5 = new JButton("<");
        b6 = new JButton(">");
        b5.setBounds(330, 245, 43, 20);
        b6.setBounds(402, 245, 43, 20);
        text6 = new JLabel("Choose Hotel");
        text6.setBounds(70, 280, 170, 26);
        text6.setFont(word);
        cb = new JComboBox<>(hotels);
        cb.setBounds(70, 305, 390, 30);
        cb.addActionListener(this);
        next = new JButton("Next");
        next.setBounds(70, 440, 390, 30);
        w2 = new JLabel("hh");


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        next.addActionListener(this);
        next.setBackground(Dark_Blue);
        next.setForeground(Color.white);
        next.addMouseListener(event);
        b1.addMouseListener(event);
        b2.addMouseListener(event);
        b3.addMouseListener(event);
        b4.addMouseListener(event);
        b5.addMouseListener(event);
        b6.addMouseListener(event);



        ppp.add(text);
        //this.add(lh);
        ppp.add(text4);
        ppp.add(text5);
        ppp.add(text6);
        ppp.add(text7);
        ppp.add(text8);
        ppp.add(text9);
        ppp.add(t1);
        ppp.add(t2);
        ppp.add(t3);
        ppp.add(input);
        ppp.add(input2);
        ppp.add(Today_Date);
        ppp.add(Choose_Date);
        ppp.add(cb);
        ppp.add(b1);
        ppp.add(b2);
        ppp.add(b3);
        ppp.add(b4);
        ppp.add(b5);
        ppp.add(b6);
        ppp.add(next);
        this.add(ppp);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            if(adult>0){
                --adult;
                t1.setText(String.valueOf(adult));
            }
        }if (e.getSource()==b2){
            ++adult;
            t1.setText(String.valueOf(adult));
        } if(e.getSource()==b3){
            if(child>0){
                --child;
                t2.setText(String.valueOf(child));
            }
        }if (e.getSource()==b4){
            ++child;
            t2.setText(String.valueOf(child));
        } if(e.getSource()==b5){
            if(room>1){
                --room;
                t3.setText(String.valueOf(room));
            }
        }if (e.getSource()==b6){
            if(room<7){
            ++room;
            t3.setText(String.valueOf(room));}
        }if (e.getSource()==next){
            if((Objects.equals(input.getText(), "Name") || Objects.equals(input.getText(), "") )){
                JOptionPane.showMessageDialog(this,"Please, Enter the Name and ID");
            }
            else {
                ChooseRoom chooseRoom = new ChooseRoom();
                this.setVisible(false);
                chooseRoom.setVisible(true);
            }
        }
    }

    public class Event implements MouseListener, MouseMotionListener{
        Color Dark_Red=new Color(103, 0, 0);
        Color Dark_Blue=new Color(0, 0, 103);

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource()==input){
                input.setText("");
            }
            if (e.getSource()==input2){
                input2.setText("");
            }
            if (e.getSource()==b1){
                b1.setBackground(Dark_Red);
                b1.setForeground(Color.white);
            }
            if (e.getSource()==b2){
                b2.setBackground(Dark_Blue);
                b2.setForeground(Color.white);
            }
            if (e.getSource()==b3){
                b3.setBackground(Dark_Red);
                b3.setForeground(Color.white);
            }
            if (e.getSource()==b4){
                b4.setBackground(Dark_Blue);
                b4.setForeground(Color.white);
            }
            if (e.getSource()==b5){
                b5.setBackground(Dark_Red);
                b5.setForeground(Color.white);
            }
            if (e.getSource()==b6){
                b6.setBackground(Dark_Blue);
                b6.setForeground(Color.white);
            }
            if (e.getSource()==ChooseRoom.p[0]){
                if (ChooseRoom.txt[0].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[0].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[0].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[0].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[1]){
                if (ChooseRoom.txt[1].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[1].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[1].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[1].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }
            }
            if (e.getSource()==ChooseRoom.p[2]){
                if (ChooseRoom.txt[2].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[2].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[2].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[2].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }
            }
            if (e.getSource()==ChooseRoom.p[3]){
                if (ChooseRoom.txt[3].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[3].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[3].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[3].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }
            }
            if (e.getSource()==ChooseRoom.p[4]){
                if (ChooseRoom.txt[4].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[4].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[4].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[4].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[5]){
                if (ChooseRoom.txt[5].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[5].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[5].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[5].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[6]){
                if (ChooseRoom.txt[6].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[6].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[6].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[6].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[7]){
                if (ChooseRoom.txt[7].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[7].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[7].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[7].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[8]){
                if (ChooseRoom.txt[8].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[8].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[8].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[8].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                }}
            if (e.getSource()==ChooseRoom.p[9]){
                if (ChooseRoom.txt[9].toString().equals(ChooseRoom.txt[15].toString())){
                    ChooseRoom.txt[9].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[9].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[9].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
                    }

            }if (e.getSource()==ChooseRoom.p[10]){
                if (ChooseRoom.txt[10].toString().equals(ChooseRoom.txt[17].toString())){
                    JOptionPane.showMessageDialog(ChooseRoom.p[15],ChooseRoom.roomNum[12].getText()+" Room, +25% price!");
                    ChooseRoom.txt[10].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[10].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[10].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("vip_door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[11]){
                if (ChooseRoom.txt[11].toString().equals(ChooseRoom.txt[17].toString())){
                    JOptionPane.showMessageDialog(ChooseRoom.p[15],ChooseRoom.roomNum[13].getText()+" Room, +25% price!");
                    ChooseRoom.txt[11].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[11].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[11].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("vip_door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[12]){
                if (ChooseRoom.txt[12].toString().equals(ChooseRoom.txt[17].toString())){
                    JOptionPane.showMessageDialog(ChooseRoom.p[15],ChooseRoom.roomNum[14].getText()+" Room, +25% price!");
                    ChooseRoom.txt[12].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[12].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[12].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("vip_door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[13]){
                if (ChooseRoom.txt[13].toString().equals(ChooseRoom.txt[17].toString())){
                    JOptionPane.showMessageDialog(ChooseRoom.p[15],ChooseRoom.roomNum[15].getText()+" Room, +25% price!");
                    ChooseRoom.txt[13].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[13].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[13].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("vip_door.png"))));
                }
            }if (e.getSource()==ChooseRoom.p[14]){
                if (ChooseRoom.txt[14].toString().equals(ChooseRoom.txt[17].toString())){
                    JOptionPane.showMessageDialog(ChooseRoom.p[15],ChooseRoom.roomNum[16].getText()+" Room, +25% price!");
                    ChooseRoom.txt[14].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));}
                else if (ChooseRoom.txt[14].toString().equals(ChooseRoom.txt[16].toString())){
                    ChooseRoom.txt[14].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("vip_door.png"))));
                }
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {


        }

        @Override
        public void mouseReleased(MouseEvent e) {


        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource()==next){
                next.setBackground(Dark_Red);
            }
            if(e.getSource()==text){
                text.setForeground(Color.red);
            }
            if (e.getSource()==ChooseRoom.btn){
                ChooseRoom.btn.setBackground(Dark_Red);
            }


        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource()==next){
                next.setBackground(Dark_Blue);
            }
            if(e.getSource()==text){
                text.setForeground(Color.BLACK);
            }

            if (e.getSource()==ChooseRoom.btn){
                ChooseRoom.btn.setBackground(Dark_Blue);
            }


        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }


    public static class ChooseRoom extends JFrame implements ActionListener{
        static JPanel[] p=new JPanel[19];
        static JLabel[] txt=new JLabel[18];
        static JLabel[] roomNum=new JLabel[17];
        static String []images={"busy_door.png","door.png"};
        static JButton btn;
        HotelReservations hotelReservations =new HotelReservations();

        ChooseRoom(){

            Image icon;
            try {
                icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("hotel_icon.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Color Dark_Blue=new Color(0, 0, 103);
            Font word = new Font("Verdana", Font.BOLD, 15);
            Font newFont = new Font("Verdana", Font.BOLD, 28);
            Font vip = new Font("Verdana", Font.BOLD, 18);
            this.setIconImage(icon);
            this.setTitle("Hotel Reservations");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setSize(1000, 750);
            this.setLocation(300, 15);
            this.setLayout(null);
            this.setResizable(false);
            this.setVisible(false);
            this.getContentPane().setBackground(Color.orange);
            int a=(int) Math.floor(Math.random()*2);
            int b=(int) Math.floor(Math.random()*2);
            int c=(int) Math.floor(Math.random()*2);
            int d=(int) Math.floor(Math.random()*2);
            int e=(int) Math.floor(Math.random()*2);
            txt[0]=new JLabel("");
            txt[1]=new JLabel("");
            txt[2]=new JLabel("");
            txt[3]=new JLabel("");
            txt[4]=new JLabel("");
            txt[5]=new JLabel("");
            txt[6]=new JLabel("");
            txt[7]=new JLabel("");
            txt[8]=new JLabel("");
            txt[9]=new JLabel("");
            txt[10]=new JLabel("");
            txt[11]=new JLabel("");
            txt[12]=new JLabel("");
            txt[13]=new JLabel("");
            txt[14]=new JLabel("");
            txt[15]=new JLabel("");
            txt[16]=new JLabel("");
            txt[17]=new JLabel("");
            roomNum[0]=new JLabel("Please,Choose the Rooms");
            roomNum[0].setFont(newFont);
            roomNum[0].setBounds(100,3,500,100);
            roomNum[1]=new JLabel("1");
            roomNum[1].setFont(word);
            roomNum[1].setBounds(85,80,30,20);
            roomNum[2]=new JLabel("2");
            roomNum[2].setFont(word);
            roomNum[2].setBounds(195,80,30,20);
            roomNum[3]=new JLabel("3");
            roomNum[3].setFont(word);
            roomNum[3].setBounds(305,80,30,20);
            roomNum[4]=new JLabel("4");
            roomNum[4].setFont(word);
            roomNum[4].setBounds(415,80,30,20);
            roomNum[5]=new JLabel("5");
            roomNum[5].setFont(word);
            roomNum[5].setBounds(525,80,30,20);
            roomNum[6]=new JLabel("6");
            roomNum[6].setFont(word);
            roomNum[6].setBounds(85,200,30,20);
            roomNum[7]=new JLabel("7");
            roomNum[7].setFont(word);
            roomNum[7].setBounds(195,200,30,20);
            roomNum[8]=new JLabel("8");
            roomNum[8].setFont(word);
            roomNum[8].setBounds(305,200,30,20);
            roomNum[9]=new JLabel("9");
            roomNum[9].setFont(word);
            roomNum[9].setBounds(415,200,30,20);
            roomNum[10]=new JLabel("10");
            roomNum[10].setFont(word);
            roomNum[10].setBounds(520,200,30,20);
            roomNum[11]=new JLabel("<<<<<<<<<<<< VIPs >>>>>>>>>>>>");
            roomNum[11].setFont(vip);
            roomNum[11].setBounds(85,335,480,20);
            roomNum[12]=new JLabel("V1");
            roomNum[12].setFont(word);
            roomNum[12].setBounds(80,370,30,20);
            roomNum[13]=new JLabel("V2");
            roomNum[13].setFont(word);
            roomNum[13].setBounds(190,370,30,20);
            roomNum[14]=new JLabel("V3");
            roomNum[14].setFont(word);
            roomNum[14].setBounds(300,370,30,20);
            roomNum[15]=new JLabel("V4");
            roomNum[15].setFont(word);
            roomNum[15].setBounds(410,370,30,20);
            roomNum[16]=new JLabel("V5");
            roomNum[16].setFont(word);
            roomNum[16].setBounds(520,370,30,20);
            btn=new JButton("NEXT");
            btn.setFont(word);
            btn.setBounds(89,540,440,30);
            btn.setForeground(Color.white);
            btn.setBackground(Dark_Blue);
            btn.addMouseListener(hotelReservations.event);
            btn.addActionListener(this);

            txt[0].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
            txt[1].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource(images[a])))));
            txt[2].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
            txt[3].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource(images[b])))));
            txt[4].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
            txt[5].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource(images[c])))));
            txt[6].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource(images[d])))));
            txt[7].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource(images[e])))));
            txt[8].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource(images[a])))));
            txt[9].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource(images[b])))));
            txt[10].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("vip_door.png")))));
            txt[11].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("vip_door.png")))));
            txt[12].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("vip_door.png")))));
            txt[13].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("vip_door.png")))));
            txt[14].setIcon(new ImageIcon((Objects.requireNonNull(getClass().getResource("vip_door.png")))));
            txt[15].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("door.png"))));
            txt[16].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("open_door.png"))));
            txt[17].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("vip_door.png"))));

            p[0]=new JPanel();
            p[0].add(txt[0]);
            p[0].setBounds(40,100,100,100);
            p[1]=new JPanel();
            p[1].add(txt[1]);
            p[1].setBounds(150,100,100,100);
            p[2]=new JPanel();
            p[2].add(txt[2]);
            p[2].setBounds(260,100,100,100);
            p[3]=new JPanel();
            p[3].add(txt[3]);
            p[3].setBounds(370,100,100,100);
            p[4]=new JPanel();
            p[4].add(txt[4]);
            p[4].setBounds(480,100,100,100);
            p[5]=new JPanel();
            p[5].add(txt[5]);
            p[5].setBounds(40,220,100,100);
            p[6]=new JPanel();
            p[6].add(txt[6]);
            p[6].setBounds(150,220,100,100);
            p[7]=new JPanel();
            p[7].add(txt[7]);
            p[7].setBounds(260,220,100,100);
            p[8]=new JPanel();
            p[8].add(txt[8]);
            p[8].setBounds(370,220,100,100);
            p[9]=new JPanel();
            p[9].add(txt[9]);
            p[9].setBounds(480,220,100,100);
            p[10]=new JPanel();
            p[10].add(txt[10]);
            p[10].setBounds(40,390,100,100);
            p[11]=new JPanel();
            p[11].add(txt[11]);
            p[11].setBounds(150,390,100,100);
            p[12]=new JPanel();
            p[12].add(txt[12]);
            p[12].setBounds(260,390,100,100);
            p[13]=new JPanel();
            p[13].add(txt[13]);
            p[13].setBounds(370,390,100,100);
            p[14]=new JPanel();
            p[14].add(txt[14]);
            p[14].setBounds(480,390,100,100);
            p[15]=new JPanel(null);
            p[15].setBounds(200,30,620,590);
            p[15].setBackground(Color.lightGray);
            p[16]=new JPanel();
            p[16].setBounds(1000,1000,100,100);
            p[16].add(txt[15]);
            p[17]=new JPanel();
            p[17].add(txt[16]);
            p[17].setBounds(1000,1000,100,100);
            p[18]=new JPanel();
            p[18].setBounds(1000,1000,100,100);
            p[18].add(txt[17]);


            p[0].addMouseListener(hotelReservations.event);
            p[1].addMouseListener(hotelReservations.event);
            p[2].addMouseListener(hotelReservations.event);
            p[3].addMouseListener(hotelReservations.event);
            p[4].addMouseListener(hotelReservations.event);
            p[5].addMouseListener(hotelReservations.event);
            p[6].addMouseListener(hotelReservations.event);
            p[7].addMouseListener(hotelReservations.event);
            p[8].addMouseListener(hotelReservations.event);
            p[9].addMouseListener(hotelReservations.event);
            p[10].addMouseListener(hotelReservations.event);
            p[11].addMouseListener(hotelReservations.event);
            p[12].addMouseListener(hotelReservations.event);
            p[13].addMouseListener(hotelReservations.event);
            p[14].addMouseListener(hotelReservations.event);
            p[16].addMouseListener(hotelReservations.event);
            p[17].addMouseListener(hotelReservations.event);


            p[15].add(p[0]);
            p[15].add(p[1]);
            p[15].add(p[2]);
            p[15].add(p[3]);
            p[15].add(p[4]);
            p[15].add(p[5]);
            p[15].add(p[6]);
            p[15].add(p[7]);
            p[15].add(p[8]);
            p[15].add(p[9]);
            p[15].add(p[10]);
            p[15].add(p[11]);
            p[15].add(p[12]);
            p[15].add(p[13]);
            p[15].add(p[14]);
            p[15].add(roomNum[0]);
            p[15].add(roomNum[1]);
            p[15].add(roomNum[2]);
            p[15].add(roomNum[3]);
            p[15].add(roomNum[4]);
            p[15].add(roomNum[5]);
            p[15].add(roomNum[6]);
            p[15].add(roomNum[7]);
            p[15].add(roomNum[8]);
            p[15].add(roomNum[9]);
            p[15].add(roomNum[10]);
            p[15].add(roomNum[11]);
            p[15].add(roomNum[12]);
            p[15].add(roomNum[13]);
            p[15].add(roomNum[14]);
            p[15].add(roomNum[15]);
            p[15].add(roomNum[16]);
            p[15].add(p[16]);
            p[15].add(p[17]);
            p[15].add(p[18]);
            p[15].add(btn);
            this.add(p[15]);




        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==ChooseRoom.btn){

                Finally fin= new Finally();
                fin.setVisible(true);
                this.setVisible(false);

            }
        }
    }
    public static class Finally extends JFrame{
        JLabel[] service=new JLabel[4];
        JLabel first;
        JPanel pp;
        Finally (){
            Image icon;
            try {
                icon = ImageIO.read(Objects.requireNonNull(getClass().getResource("hotel_icon.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Font newFont = new Font("Verdana", Font.BOLD, 28);
            Font vip = new Font("Verdana", Font.BOLD, 18);
            this.setIconImage(icon);
            this.setTitle("Hotel Reservations");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setSize(750, 400);
            this.setLocation(400, 80);
            this.setLayout(null);
            this.setResizable(false);
            this.setVisible(false);
            this.getContentPane().setBackground(Color.orange);
            pp=new JPanel(null);
            pp.setBounds(100,30,550,300);
            first=new JLabel("Complete!");
            first.setFont(newFont);
            first.setBounds(180,50,200,50);
            service[0]=new JLabel("Thank you for using our Application.");
            service[0].setFont(vip);
            service[0].setBounds(60,130,500,30);
            service[1]=new JLabel("We are waiting for your arrival");
            service[1].setFont(vip);
            service[1].setBounds(60,160,500,30);
            pp.add(first);
            pp.add(service[0]);
            pp.add(service[1]);
            this.add(pp);
        }
    }


    public static void main(String[] args) {
        HotelReservations hotelReservations=new HotelReservations();
        hotelReservations.setResizable(false);
        hotelReservations.setLayout(null);
        hotelReservations.setTitle("Hotel Reservations");
        hotelReservations.setVisible(true);
        hotelReservations.setSize(1000, 650);
        hotelReservations.setLocation(300, 50);
        hotelReservations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}
