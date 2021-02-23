package calendarconverter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class CalendarConverter extends JFrame {
    
    private static final String[] choice1
            = {"\u121D\u1228\u1325", "\u12E8\u12A2\u1275\u12EE\u1335\u12EB \u12A0\u1246\u1323\u1320\u122D",
                "\u12E8\u130E\u122D\u130E\u122E\u1233\u12CD\u12EB\u1295 \u12A0\u1246\u1323\u1320\u122D",
                "\u12E8\u1202\u1305\u122B \u12A0\u1246\u1323\u1320\u122D"};
    private static final String[] choice2 = {"Choose", "Ethiopian Calendar", "Gregorian Calendar", "Hijri Calendar"};
    private GroupLayout jPanel1Layout, jPanel2Layout, jPanel3Layout;
    private JPanel jPanel1, jPanel2, jPanel3;
    private JTabbedPane jTabbedPane;
    private JTextArea jTextArea, jTextArea2, jTextArea3;
    private JTextField jTextField1, jTextField2;
    private JComboBox jComboBox1, jComboBox2, jComboBox3, jComboBox4;
    private JButton jButton1, jButton2;
    public static JLabel jLabel4, jLabel8, jLabel9;
    private JLabel jLabel1, jLabel2, jLabel3,  jLabel5, jLabel6, jLabel7;

    public CalendarConverter() {
        super("\u12E8\u1240\u1295 \u12A0\u1246\u1323\u1320\u122D \u1218\u1240\u12E8\u122D\u12EB");
        Font myFont = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 14);
        super.setFont(myFont);
        jTabbedPane = new JTabbedPane();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jTextArea = new JTextArea("     \u12E8\u1240\u1295 \u12A0\u1246\u1323\u1320\u122D \u1218\u1240\u12E8\u122D\u12EB "
                + "\u12E8\u12A2\u1275\u12EE\u1335\u12EB\u1295\u1363 \u12E8\u130E\u122D\u130E\u122E\u1233\u12CD\u12EB\u1295\u1293 "
                + "\u12E8\u1202\u1305\u122B\u1295 \u12E8\u12D8\u1218\u1295\n\u12A0\u1246\u1323\u1320\u122E\u127D \u12AB\u1295\u12F1 "
                + "\u12C8\u12F0\u120C\u120B\u12CD \u1208\u1218\u1240\u12E8\u122D \u12EB\u1235\u127D\u120B\u120D\u1362\n"
                + "     \u1218\u1240\u12E8\u122D \u12E8\u121A\u1348\u120D\u1309\u1275\u1295 \u1240\u1295 \u1260\u1233\u1325\u1291 "
                + "\u12CD\u1235\u1325 (\u1240\u1295\u12C8\u122D\u12D3.\u121D /8\u12F2\u1302\u1275) "
                + "\u12EB\u1235\u1308\u1261\u1362 \u12A8\u12DA\u12EB\u121D\n\u12A8\u1218\u1300\u1218\u122D\u12EB\u12CD \u1270\u12D8\u122D\u130A "
                + "\u1233\u1325\u1295 \u12A8\u12E8\u1275\u129B\u12CD \u12E8\u1240\u1295 \u12A0\u1246\u1323\u1320\u122D \u12A8\u1201\u1208\u1270"
                + "\u129B\u12CD \u1270\u12D8\u122D\u130A \u1233\u1325\u1295 \u12F0\u130D\u121E\n\u12C8\u12F0\u12E8\u1275\u129B\u12CD \u12E8\u1240\u1295 "
                + "\u12A0\u1246\u1323\u1320\u122D \u1218\u1240\u12E8\u122D \u12A5\u1295\u12F0\u121A\u1348\u120D\u1309 \u12ED\u121D\u1228\u1321\u1293 "
                + "'\u1208\u12CD\u1325' \u12E8\u121A\u1208\u12CD\u1295 \u1241\u120D\u134D\n\u12ED\u132B\u1291\u1362"
                + "\n\n    Calendar Converter enables to convert dates in Ethiopian,\nEuropean and Hijri calendars from one to another.\n"
                + "     To convert a date insert the date in the first box in the\norder date, month and year (8 digits) and choose from which\n"
                + "calendar (first dropdown box) to which calendar (second\ndropdown box) you want to change and press the 'Change'\nbutton."
                + "\n\n\n\n\t\tDeveloped by: D.L.W\n\t\u00a9Copyright 2016•All Rights Reserved");
        jTextArea.setEditable(false);
        jTextArea.setFont(myFont);        
        jTextArea2 = new JTextArea();
        jTextArea2.setEditable(false);
        jTextArea2.setFont(myFont);
        jTextArea2.setLineWrap(true);
        jTextArea3 = new JTextArea();
        jTextArea3.setEditable(false);
        jTextArea3.setFont(myFont);
        jTextArea3.setLineWrap(true);
        jComboBox1 = new JComboBox(choice1);
        jComboBox1.setFont(myFont);
        jComboBox1.setMaximumRowCount(4);        
        jComboBox2 = new JComboBox(choice1);
        jComboBox2.setFont(myFont);
        jComboBox2.setMaximumRowCount(4);        
        jComboBox3 = new JComboBox(choice2);
        jComboBox3.setMaximumRowCount(4);        
        jComboBox4 = new JComboBox(choice2);
        jComboBox4.setMaximumRowCount(4);        
        jButton1 = new JButton("\u1208\u12CD\u1325");
        jButton1.setFont(myFont);
        jButton1.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent event) {                         
                String m1 = "";
                String m2 = "";
                String m3 = "";
                int r; 
                String m = jTextField1.getText();
                m = m.replaceAll("\\s+", "");
                if ((m.length()==8)&& (m.matches("[0-9]+")==true))
                    {
                        int num1 = jComboBox1.getSelectedIndex();
                        int num2 = jComboBox2.getSelectedIndex();
                        jTextArea2.setText(" ");
                        if (num1 ==1)
                        {
                            CalendarConverterFunction.validate_Eth(0, m);
                            r = CalendarConverterFunction.day_of_date(m);
                            if (num2==2)
                            {
                                m1 = CalendarConverterFunction.from_Ethiopian_to_European(m);
                                m2 = CalendarConverterFunction.week_day(r, 1);
                                m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 1);
                                jTextArea2.setText("\u1240\u1291 \u1260\u130E\u122D\u130E\u122E\u1233\u12CD\u12EB\u1295 "
                                    + "\u12E8\u12D8\u1218\u1295 \u12A0\u1246\u1323\u1320\u122D " + m1.substring(0,2) + "/"
                                    + m1.substring(2,4)+ "/" + m1.substring(4)+ " ( " + m2 + " " + m3 + " " 
                                    + m1.substring(0,2) + ", " + m1.substring(4) + " ) " + "\u1290\u12CD\u1362");                                
                            }
                            else if (num2==3)
                            {
                                CalendarConverterFunction.validate_EthForHijri(0, m);
                                m1 = CalendarConverterFunction.ethio_to_hijri(m);
                                m2 = CalendarConverterFunction.week_day(r, 3);
                                m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 5);
                                jTextArea2.setText("\u1240\u1291 \u1260\u1202\u1305\u122B \u12E8\u12D8\u1218\u1295 "
                                        + "\u12A0\u1246\u1323\u1320\u122D " + m1.substring(0,2) + "/"
                                        + m1.substring(2,4)+ "/" + m1.substring(4) + " ( " + m2 + " " + m3 + " " + 
                                        m1.substring(0,2) + ", " + m1.substring(4) + " ) " + "\u1290\u12CD\u1362");
                            }
                            else
                            {
                                CalendarConverterFunction.show_ComboError(0);
                            }
                        }
                        else if (num1 ==2)
                        {
                            CalendarConverterFunction.validate_Euro(0, m);
                            r = CalendarConverterFunction.day_of_date(CalendarConverterFunction.from_European_to_Ethiopian(m));
                            if (num2==1)
                            {
                                m1 = CalendarConverterFunction.from_European_to_Ethiopian(m);
                                m2 = CalendarConverterFunction.week_day(r, 1);
                                m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 2);
                                jTextArea2.setText("\u1240\u1291 \u1260\u12A2\u1275\u12EE\u1335\u12EB "
                                        + "\u12E8\u12D8\u1218\u1295 \u12A0\u1246\u1323\u1320\u122D " + m1.substring(0,2) + "/"
                                        + m1.substring(2,4)+ "/" + m1.substring(4)+ " ( " + m2 + " " + m3 + " " + m1.substring(0,2)
                                        + ", " + m1.substring(4) + " ) " + "\u1290\u12CD\u1362");    
                            }
                            else if (num2==3)
                            {
                                CalendarConverterFunction.validate_EuroForHijri(0, m);
                                m1 = CalendarConverterFunction.ethio_to_hijri(CalendarConverterFunction.from_European_to_Ethiopian(m));
                                m2 = CalendarConverterFunction.week_day(r, 3);
                                m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 5);
                                jTextArea2.setText("\u1240\u1291 \u1260\u1202\u1305\u122B \u12E8\u12D8\u1218\u1295 "
                                        + "\u12A0\u1246\u1323\u1320\u122D " + m1.substring(0,2) + "/"
                                        + m1.substring(2,4)+ "/" + m1.substring(4) + " ( " + m2 + " " + m3 + " " + 
                                        m1.substring(0,2) + ", " + m1.substring(4) + " ) " + "\u1290\u12CD\u1362");
                            }
                            else
                            {
                                CalendarConverterFunction.show_ComboError(0);
                            }
                        }
                        else if (num1 ==3)
                        {
                            CalendarConverterFunction.validate_Hijri(0, m);
                            r = CalendarConverterFunction.day_of_date(CalendarConverterFunction.hijri_to_ethio(m));
                            if (num2==1)
                            {
                                m1 = CalendarConverterFunction.hijri_to_ethio(m);
                                m2 = CalendarConverterFunction.week_day(r, 1);
                                m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 2);
                                jTextArea2.setText("\u1240\u1291 \u1260\u12A2\u1275\u12EE\u1335\u12EB "
                                        + "\u12E8\u12D8\u1218\u1295 \u12A0\u1246\u1323\u1320\u122D " + m1.substring(0,2) + "/"
                                        + m1.substring(2,4)+ "/" + m1.substring(4) + " ( " + m2 + " " + m3 + " " 
                                        + m1.substring(0,2) + ", " + m1.substring(4) + " ) " + "\u1290\u12CD\u1362");  
                            }
                            else if (num2==2)
                            {
                                m1 = CalendarConverterFunction.from_Ethiopian_to_European(CalendarConverterFunction.hijri_to_ethio(m));
                                m2 = CalendarConverterFunction.week_day(r, 1);
                                m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 1);
                                jTextArea2.setText("\u1240\u1291  \u1260\u130E\u122D\u130E\u122E\u1233\u12CD\u12EB\u1295 \u12E8\u12D8\u1218\u1295 "
                                        + "\u12A0\u1246\u1323\u1320\u122D " + m1.substring(0,2) + "/" + m1.substring(2,4)+ "/" + m1.substring(4) 
                                        + " ( " + m2 + " " + m3 + " " + m1.substring(0,2) + ", " + m1.substring(4) + " ) " + "\u1290\u12CD\u1362");
                            }
                            else
                            {
                                CalendarConverterFunction.show_ComboError(0);
                            }
                        }
                    }
                    else 
                    {
                        CalendarConverterFunction.show_ErrorMessage(0);
                    }
                }            
        }
        );
        jButton2 = new JButton("Change");
        jButton2.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent event) {                                           
                String m1 = "";
                String m2 = "";
                String m3 = "";
                int r;  
                String m = jTextField2.getText();
                m = m.replaceAll("\\s+", "");
                int num1 = jComboBox3.getSelectedIndex();
                int num2 = jComboBox4.getSelectedIndex();
                jTextArea3.setText(" ");
                if ((m.length()==8)&& (m.matches("[0-9]+")==true))
                {
                    CalendarConverterFunction.validate_Eth(1, m);
                    r = CalendarConverterFunction.day_of_date(m);
                    if (num1 ==1)
                        {
                            CalendarConverterFunction.validate_Eth(1, m);
                            r = CalendarConverterFunction.day_of_date(m);
                            if (num2==2)
                            {
                                m1 = CalendarConverterFunction.from_Ethiopian_to_European(m);
                                m2 = CalendarConverterFunction.week_day(r, 0);
                                m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 0);
                                jTextArea3.setText("The date in European Calendar is " + m1.substring(0,2) + "/"
                                        + m1.substring(2,4) + "/" + m1.substring(4)+ " ( " + m2 
                                        + " " + m3 + " " + m1.substring(0,2) + ", " + m1.substring(4) + " )." ); 
                            }
                            else if (num2==3)
                            {
                                CalendarConverterFunction.validate_EthForHijri(1, m);
                                m1 = CalendarConverterFunction.ethio_to_hijri(m);
                                m2 = CalendarConverterFunction.week_day(r, 2);
                                m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 4);
                                jTextArea3.setText("The date in Hijri Calendar is " + m1.substring(0,2) + "/"
                                        + m1.substring(2,4)+ "/" + m1.substring(4) + " ( " + m2 + " " + m3 + " " + 
                                        m1.substring(0,2) + ", " + m1.substring(4) + " ).");
                            }
                            else
                            {
                                CalendarConverterFunction.show_ComboError(1);
                            }
                        }
                    else if (num1 ==2)
                    {
                        CalendarConverterFunction.validate_Euro(1, m);
                        r = CalendarConverterFunction.day_of_date(CalendarConverterFunction.from_European_to_Ethiopian(m));
                        if (num2==1)
                        {
                            m1 = CalendarConverterFunction.from_European_to_Ethiopian(m);
                            m2 = CalendarConverterFunction.week_day(r, 0);
                            m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 3);
                            jTextArea3.setText("The date in Ethiopian Calendar is " + m1.substring(0,2) + "/"
                                    + m1.substring(2,4)+ "/" + m1.substring(4) + " ( " + m2 
                                    + " " + m3 + " " + m1.substring(0,2) + ", " + m1.substring(4) + " ).");                              
                        }
                        else if (num2==3)
                        {
                            CalendarConverterFunction.validate_EuroForHijri(1, m);
                            m1 = CalendarConverterFunction.ethio_to_hijri(CalendarConverterFunction.from_European_to_Ethiopian(m));
                            m2 = CalendarConverterFunction.week_day(r, 2);
                            m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 4);
                            jTextArea3.setText("The date in Hijri Calendar is " + m1.substring(0,2) + "/"
                                    + m1.substring(2,4)+ "/" + m1.substring(4) + " ( " + m2 + " " + m3 + " " + 
                                    m1.substring(0,2) + ", " + m1.substring(4) + " ).");
                        }
                        else
                        {
                            CalendarConverterFunction.show_ComboError(1);
                        }
                    }
                    
                    else if (num1 ==3)
                    {
                        CalendarConverterFunction.validate_Hijri(1, m);
                        r = CalendarConverterFunction.day_of_date(CalendarConverterFunction.hijri_to_ethio(m));
                        if (num2==1)
                        {
                            m1 = CalendarConverterFunction.hijri_to_ethio(m);
                            m2 = CalendarConverterFunction.week_day(r, 0);
                            m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 3);
                            jTextArea3.setText("The date in Ethiopian Calendar is " + m1.substring(0,2) + "/"
                                    + m1.substring(2,4)+ "/" + m1.substring(4) + " ( " + m2 
                                    + " " + m3 + " " + m1.substring(0,2) + ", " + m1.substring(4) + " ).");                              
                        }
                        else if (num2==2)
                        {
                            m1 = CalendarConverterFunction.from_Ethiopian_to_European(CalendarConverterFunction.hijri_to_ethio(m));
                            m2 = CalendarConverterFunction.week_day(r, 0);
                            m3 = CalendarConverterFunction.get_Month(Integer.parseInt(m1.substring(2,4)), 0);
                            jTextArea3.setText("The date in European Calendar is " + m1.substring(0,2) + "/"
                                    + m1.substring(2,4)+ "/" + m1.substring(4) + " ( " + m2 + " " + m3 + " " + 
                                    m1.substring(0,2) + ", " + m1.substring(4) + " ).");
                        }
                        else
                        {
                            CalendarConverterFunction.show_ComboError(1);
                        }
                    }
                }
                else
                {
                    CalendarConverterFunction.show_ErrorMessage(1);
                }
            }
                }
        );
        jTextField1 = new JTextField();
        jTextField1.setFont(myFont);
        jTextField2 = new JTextField();
        jTextField1.setToolTipText("8 \u12F2\u1302\u1275(DDMMYYYY)");
        UIManager.put("ToolTip.font", myFont);
        jTextField2.setToolTipText("8 Digits(DDMMYYYY)");
        jTextField2.setFont(myFont);
        jLabel1 = new JLabel("\u1240\u1295\u12C8\u122D\u12D3.\u121D", SwingConstants.CENTER);
        jLabel1.setFont(myFont);
        jLabel2 = new JLabel("\u12A8", SwingConstants.CENTER);
        jLabel2.setFont(myFont);
        jLabel3 = new JLabel("\u12C8\u12F0", SwingConstants.CENTER);
        jLabel3.setFont(myFont);
        jLabel4 = new JLabel();       
        jLabel5 = new JLabel("DDMMYYYY", SwingConstants.CENTER);
        jLabel6 = new JLabel("From", SwingConstants.CENTER);
        jLabel7 = new JLabel("To", SwingConstants.CENTER);
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();                
        jPanel1Layout = new GroupLayout(jPanel1);
        jPanel2Layout = new GroupLayout(jPanel2);
        jPanel3Layout = new GroupLayout(jPanel3);
        jPanel1.setLayout(jPanel1Layout);
        jPanel2.setLayout(jPanel2Layout);
        jPanel3.setLayout(jPanel3Layout);
        jPanel1Layout.setAutoCreateGaps(true);
        jPanel1Layout.setAutoCreateContainerGaps(true);
        jPanel2Layout.setAutoCreateGaps(true);
        jPanel2Layout.setAutoCreateContainerGaps(true);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jTextField1, jComboBox1, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jTextField1, jComboBox1, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jComboBox1, jButton1, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextArea2, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)));

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))                        
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1)
                        .addComponent(jComboBox2)
                        .addComponent(jButton1))
                .addPreferredGap(jTextField1, jTextArea2, LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(jTextField1, jTextArea2, LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextArea2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(jTextArea2, jLabel4, LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(jTextArea2, jLabel4, LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));

        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jTextField2, jComboBox3, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jTextField2, jComboBox3, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(jComboBox4, jButton2, LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextArea3, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)));

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3)
                        .addComponent(jComboBox4)
                        .addComponent(jButton2))
                .addPreferredGap(jTextField2, jTextArea3, LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(jTextField2, jTextArea3, LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextArea3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(jTextArea3, jLabel8, LayoutStyle.ComponentPlacement.UNRELATED)
                .addPreferredGap(jTextArea3, jLabel8, LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE));

        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jTextArea, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextArea, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(jTextArea, jLabel9, LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane.setFont(myFont);
        jTabbedPane.addTab("\u12A0\u121B\u122D\u129B", null, jPanel1, "");
        jTabbedPane.addTab("English", null, jPanel2, "");
        jTabbedPane.addTab("\u1308\u1208\u133B", null, jPanel3, "");
        add(jTabbedPane);

    }

}
