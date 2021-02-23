package calendarconverter;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class CalendarConverterFunction {
    public static Font myFont = InternalFont.getFont(InternalFont.Custom, Font.BOLD, 14);

    public static String from_Ethiopian_to_European(String m) {
        String q = "";
        int s = no_of_days(m);
        s = s + 2797;

        int i = 1;        
        while (s > 365) {
            s = s - 365;
            i += 1;
            if (i < 1582) {
                if (i % 4 == 0) {
                    if (s > 366) {
                        s -= 366;
                        i += 1;
                    } else {
                        q = print_date_european(i,s);
                    }
                }
            } else if (i == 1582) {
                if (s > 277) {
                    s += 10;
                } else {
                    q = print_date_european(i,s);                    
                }
            } else
            {
                if (i % 4 == 0) {
                    if ((i % 100 != 0) | ((i % 100 == 0) && (i % 400 == 0))) {
                        if (s > 366) {
                            s -= 366;
                            i += 1;
                        }
                        else
                        {
                            q = print_date_european(i,s);                              
                        }
                    }
                }
            }

        }
        q = print_date_european(i,s);
        return q;
    }
   
    public static String print_date_european(int i, int s) {
        int j = 0;
        int[] l = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (i <= 1582) {
            if (i % 4 == 0) {
                l[1] = 29;
            }
        } else if (i > 1582) {
            if (i % 4 == 0) {
                if ((i % 100 != 0) | ((i % 100 == 0) && (i % 400 == 0))) {
                    l[1] = 29;
                }
            }
        }
        for (int k = 0; k < l.length; k++) {
            if (s > l[k]) {
                s -= l[k];
            } else {
                j = k;
                break;
            }
        }
        return String.format("%02d", s) + String.format("%02d", j + 1) + String.format("%04d", i);

    }

    public static int day_of_date(String m) {
        int r = (no_of_days(m) + 2) % 7;
        return r;
    }

    public static int no_of_days(String m) {
        int no_of_days = (Integer.parseInt(m.substring(4)) - 1) * 365 + (Integer.parseInt(m.substring(4))) / 4
                + (Integer.parseInt(m.substring(2, 4)) - 1) * 30 + Integer.parseInt(m.substring(0, 2));
        return no_of_days;
    }

    public static int leap_count(String m) {
        int q = (Integer.parseInt(m.substring(4)) - 1) / 30;
        int r = (Integer.parseInt(m.substring(4)) - 1) % 30;
        int leap = q * 11;
        int j = Integer.parseInt(m.substring(4)) - 1 - r;
        int[] leapValue = {2, 5, 7, 10, 13, 15, 18, 21, 24, 26, 29};
        while (j < Integer.parseInt(m.substring(4))) {
            for (int value : leapValue) {
                if (j % 30 == value) {
                    leap += 1;
                }
            }
            j += 1;
        }
        return leap;
    }

    public static String print_date(int d, int m, int y) {
        String day, mo, q;
        if (d == 0) {
            day = Integer.toString(30);
            mo = String.format("%02d", m);
            q = String.format("%04d", y);
        } else {
            day = String.format("%02d", d);
            mo = String.format("%02d", m + 1);
            q = String.format("%04d", y);
        }
        String date = day + mo + q;
        return date;
    }

    public static String print_date_hijri(int d, int m, int i) {
        String day, mo, q, date = "";
        q = String.format("%04d", i);
        if (m == 6 && d == 1) {
            mo = Integer.toString(12);
            day = Integer.toString(30);
            date = day + mo + q;
        } else if (d == 0) {
            mo = String.format("%02d", 2 * m);
            day = Integer.toString(29);
            date = day + mo + q;
        } else if ((0 < d) && (d <= 30)) {
            mo = String.format("%02d", 2 * m + 1);
            day = String.format("%02d", d);
            date = day + mo + q;
        } else if (d > 30) {
            mo = String.format("%02d", 2 * m + 2);
            day = String.format("%02d", d - 30);
            date = day + mo + q;
        }
        return date;
    }

    public static String date_of_days(int m) {
        int mo = 0;
        int d = 0;
        int i = 1;
        String date;
        while (m > 365) {
            m -= 365;
            i += 1;
            if ((i + 1) % 4 == 0) {
                if (m > 366) {
                    m -= 366;
                    i += 1;
                } else {
                    mo = m / 30;
                    d = m % 30;
                    date = print_date(d, mo, i);
                    return date;
                }
            }
        }
        mo = m / 30;
        d = m % 30;
        date = print_date(d, mo, i);
        return date;

    }

    public static String ethio_to_hijri(String m) {
        int mo, d;
        String date = "";
        int t = no_of_days(m);
        int day_before_614 = no_of_days("20110614");
        t -= day_before_614;
        if (t > 0) {
            int[] list = {2, 5, 7, 10, 13, 15, 18, 21, 24, 26, 29};
            int i = 1;
            while (t > 354) {
                t -= 354;
                i += 1;
                for (int value : list) {
                    if (i % 30 == value) {
                        if (t > 355) {
                            t -= 355;
                            i += 1;
                        } else {
                            mo = t / 59;
                            d = t % 59;
                            date = print_date_hijri(d, mo, i);
                            return date;
                        }
                    }
                }
            }
            mo = t / 59;
            d = t % 59;
            date = print_date_hijri(d, mo, i);
        } else {
            date = "00000000";
        }
        return date;
    }

    public static String hijri_to_ethio(String m) {
        int hijri_dates;
        String date;
        int q = leap_count(m);
        if ((Integer.parseInt(m.substring(2, 4))) % 2 == 1) {
            hijri_dates = ((Integer.parseInt(m.substring(4))) - 1) * 354 + q + (((Integer.parseInt(m.substring(2, 4))) - 1) / 2) * 59
                    + Integer.parseInt(m.substring(0, 2));
        } else {
            hijri_dates = ((Integer.parseInt(m.substring(4))) - 1) * 354 + q + (((Integer.parseInt(m.substring(2, 4))) - 2) / 2) * 59
                    + 30 + Integer.parseInt(m.substring(0, 2));
        }
        int day_before_614 = no_of_days("20110614");
        int dates = hijri_dates + day_before_614;
        date = date_of_days(dates);
        return date;
    }

    public static int count_date_european(String m) {
        int[] l = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        if ((Integer.parseInt(m.substring(4)) < 1582) | (Integer.parseInt(m.substring(4)) == 1582 & Integer.parseInt(m.substring(2, 4)) < 10)
                | (Integer.parseInt(m.substring(4)) == 1582 & Integer.parseInt(m.substring(2, 4)) == 10 & Integer.parseInt(m.substring(0, 2)) < 5)) {
            if (Integer.parseInt(m.substring(4)) % 4 == 0) {
                l[1] = 29;
            } else {
            }

            for (int i = 0; i < Integer.parseInt(m.substring(2, 4)) - 1; i++) {
                count = count + l[i];
            }
            int date_count = (Integer.parseInt(m.substring(4)) - 1) * 365 + (Integer.parseInt(m.substring(4)) - 1) / 4 + count
                    + Integer.parseInt(m.substring(0, 2));
            return date_count;
        } else {
            if (Integer.parseInt(m.substring(4)) % 4 == 0) {
                if ((Integer.parseInt(m.substring(4)) % 100 != 0) | (Integer.parseInt(m.substring(4)) % 100 == 0 & Integer.parseInt(m.substring(4)) % 400 == 0)) {
                    l[1] = 29;
                } else {

                }
            } else {
            }
            for (int i = 0; i < (Integer.parseInt(m.substring(2, 4))) - 1; i++) {
                count = count + l[i];
            }
            int k = Integer.parseInt(m.substring(4)) - 1599;
            int r = k / 100;
            int t = r / 4;
            int z = r - t;
            int date_count = (Integer.parseInt(m.substring(4)) - 1) * 365 + (Integer.parseInt(m.substring(4)) - 1) / 4
                    + count + Integer.parseInt(m.substring(0, 2)) - 10 - z;
            return date_count;
        }
    }

    public static String from_European_to_Ethiopian(String m) {
        int t = count_date_european(m);
        t -= 2797;
        String date = date_of_days(t);
        return date;
    }
    
    public static String get_Month(int j, int n)
    {
        String[][] month_name = {{"January", "\u1303\u1295\u12CB\u122A", "\u1218\u1235\u12A8\u1228\u121D", "Meskerem", "Muharram",
                                "\u1219\u1203\u1228\u121D"}, {"February", "\u134C\u1265\u122A\u12CB\u122A", "\u1325\u1245\u121D\u1275", 
                                "Tikimt", "Safar", "\u1230\u1348\u122D"}, {"March", "\u121B\u122D\u127D", "\u1205\u12F3\u122D", "Hidar",
                                "Rabi' al-Awwal", "\u1228\u1262 \u12A0\u120D \u12A0\u12C8\u120D"}, {"April", "\u12A0\u1355\u122A\u120D",
                                "\u1273\u1205\u1233\u1235", "Tahisas","Rabi' al-thani", "\u1228\u1262 \u12A0\u120D \u1230\u1292"}, 
                                {"May", "\u121C\u12ED", "\u1325\u122D", "Tir", "Jumadal al-Awwal", "\u1301\u1218\u12FB \u12A0\u120D \u12A0\u12C8\u120D"},
                                {"June", "\u1301\u1295", "\u12E8\u12AB\u1272\u1275", "Yekatit", "Jumadal al-thani", "\u1301\u1218\u12FB \u12A0\u120D \u1230\u1292"},
                                {"July", "\u1301\u120B\u12ED", "\u1218\u130B\u1262\u1275","Megabit", "Rajab", "\u1228\u1302\u1265"}, {"August",
                                "\u12A6\u1308\u1235\u1275", "\u121A\u12EB\u12DD\u12EB","Miazia","Sha'aban", "\u1238\u1265\u12D0\u1295"}, {"September", 
                                "\u1234\u1355\u1274\u121D\u1260\u122D", "\u130D\u1295\u1266\u1275", "Ginbot", "Ramadan", "\u1228\u1218\u12F3\u1295"},
                                {"October", "\u12A6\u12AD\u1276\u1260\u122D", "\u1230\u1294", "Sene","Shawwal", "\u1238\u12C8\u120D"}, {"November", 
                                "\u1296\u126C\u121D\u1260\u122D", "\u1210\u121D\u120C", "Hamle","Dhu al-Qi'dah", "\u12D9\u120D \u1240\u12ED\u12FB"},
                                {"December", "\u12F4\u1234\u121D\u1260\u122D", "\u1290\u1210\u1234", "Nehassie", "Dhu al-Hijjah", "\u12D9\u120D \u1202\u1303"},
                                {" ", "\u1333\u1309\u121C","Pagumie"," "," "}};
        return month_name[j-1][n];        
    }
    
    public static String week_day(int r, int n)
    {
        String[][] week_day = {{"Sunday", "\u12A5\u1201\u12F5", "Ahad", "\u12A0\u1203\u12F5"},
                                {"Monday", "\u1230\u129E", "Ithnin", "\u12A0\u120D \u12A2\u1235\u1294\u12ED\u1295"}, 
                                {"Tuesday", "\u121B\u12AD\u1230\u129E", "Thulatha", "\u1231\u1208\u1233"},
                                {"Wednesday", "\u1228\u1261\u12D5", "Arbaa",  "\u12A0\u122D\u1262\u12D0"},
                                {"Thursday", "\u1210\u1219\u1235", "Khams", "\u12A8\u121A\u1235"},
                                {"Friday", "\u12A0\u122D\u1265", "Jumuah", "\u1301\u121D\u12D0"},
                                {"Saturday", "\u1245\u12F3\u121C", "Sabt", "\u1230\u1265\u1275"}};
        return week_day[r][n];        
    }
    
    public static void validate_Eth(int id, String m)
    {
        if ((((1 <= Integer.parseInt(m.substring(0, 2)) && Integer.parseInt(m.substring(0, 2)) <= 30)
                && (1 <= Integer.parseInt(m.substring(2, 4)) && (Integer.parseInt(m.substring(2, 4)) <= 12)))
                | (Integer.parseInt(m.substring(2, 4)) == 13 && Integer.parseInt(m.substring(4)) % 4 == 3
                && (1 <= Integer.parseInt(m.substring(0, 2)) && Integer.parseInt(m.substring(0, 2)) <= 6))
                | (Integer.parseInt(m.substring(2, 4)) == 13 && Integer.parseInt(m.substring(4)) % 4 != 3
                && (1 <= Integer.parseInt(m.substring(0, 2)) && Integer.parseInt(m.substring(0, 2)) <= 5)))
                && (1 <= Integer.parseInt(m.substring(4)) && Integer.parseInt(m.substring(4)) <= 9999))
        {
            return;
        }
        else
        {
            show_ErrorMessage(id);               
        } 
    }
    
    public static void validate_EuroForHijri(int id, String m)
    {
        if (Integer.parseInt(m.substring(4)) < 622)
        {
            show_ErrorMessage(id);
            System.exit(1);
        }
        else if ((Integer.parseInt(m.substring(4)) == 622)&&(Integer.parseInt(m.substring(2, 4)) < 7))
        {
            show_ErrorMessage(id);
            System.exit(1);
        }
        else if ((Integer.parseInt(m.substring(4)) == 622)&&(Integer.parseInt(m.substring(2, 4))==7)
                &&(Integer.parseInt(m.substring(0, 2))<15))
        {
            show_ErrorMessage(id);
            System.exit(1);
        }
        else
        {
            return;
        }
    }    
    
    public static void validate_EthForHijri(int id, String m)
    {
        if (Integer.parseInt(m.substring(4)) < 614)
        {
            show_ErrorMessage(id);
            System.exit(1);
        }
        else if ((Integer.parseInt(m.substring(4)) == 614)&&(Integer.parseInt(m.substring(2, 4)) < 11))
        {
            show_ErrorMessage(id);
            System.exit(1);
        }
        else if ((Integer.parseInt(m.substring(4)) == 614)&&(Integer.parseInt(m.substring(2, 4))==11)
                &&(Integer.parseInt(m.substring(0, 2))<21))
        {
            show_ErrorMessage(id);
            System.exit(1);
        }
        else
        {
            return;
        }        
    }    
    
    public static void validate_Euro(int id, String m)
    {
        int [][] l = {{1,31},{3,31},{4,30},{5,31},{6,30},{7,31},{8,31},{9,30},{10,31},{11,30},{12,31}};
        if ((Integer.parseInt(m.substring(0, 2))< 1 )| ((Integer.parseInt(m.substring(2, 4))<1)|(Integer.parseInt(m.substring(2, 4))>12))|
                 (Integer.parseInt(m.substring(4)) <8))
        {
           show_ErrorMessage(id);  
        }
        else if ((Integer.parseInt(m.substring(4))==8)&&(Integer.parseInt(m.substring(2, 4))<8))
        {
            show_ErrorMessage(id);
        }
        else if ((Integer.parseInt(m.substring(4))==8)&&(Integer.parseInt(m.substring(2, 4))==8)
                &&(Integer.parseInt(m.substring(6,8))<29))
        {
            show_ErrorMessage(id);
        }
        else if (((Integer.parseInt(m.substring(4))==1582)&&(Integer.parseInt(m.substring(2, 4))==10))
                    &&((4 < Integer.parseInt(m.substring(0, 2)))&&(Integer.parseInt(m.substring(0, 2))<15)))
        {
            show_ErrorMessage(id);
        }
        else if (Integer.parseInt(m.substring(2, 4))==2)
        {
            if (Integer.parseInt(m.substring(4))<=1582)
            {
                if ((Integer.parseInt(m.substring(4))%4==0)&&(Integer.parseInt(m.substring(0, 2))> 29))
                {
                    show_ErrorMessage(id);
                }
                else if ((Integer.parseInt(m.substring(4))%4!=0)&&(Integer.parseInt(m.substring(0, 2))>28))
                {
                    show_ErrorMessage(id);
                }
            }
            else if (Integer.parseInt(m.substring(4))> 1582)
            {
                if (Integer.parseInt(m.substring(4))%4==0)
                {
                    if((Integer.parseInt(m.substring(4))%100!=0)|((Integer.parseInt(m.substring(4))%100==0)&&
                                (Integer.parseInt(m.substring(4))%400==0)))
                        {
                            if (Integer.parseInt(m.substring(0, 2))>29)
                            {
                               show_ErrorMessage(id); 
                            }
                        }
                        else if (Integer.parseInt(m.substring(0, 2))> 28)
                        {
                            show_ErrorMessage(id); 
                        } 
                    }
                    else if ((Integer.parseInt(m.substring(4))%4!=0)&&(Integer.parseInt(m.substring(0, 2))>28))
                    {
                        show_ErrorMessage(id);
                    }
                }
                else 
                {
                    for(int k =0; k < l.length; k++)
                    {
                        if((Integer.parseInt(m.substring(2, 4))==l[k][0])&&(Integer.parseInt(m.substring(0, 2))>l[k][1]))
                        {
                            show_ErrorMessage(id);
                        }
                    }  
                }
        }
    }
            
    public static void validate_Hijri(int id, String m)
    {
        if (((1 <= Integer.parseInt(m.substring(0, 2))) && (Integer.parseInt(m.substring(0, 2)) <= 30))
                && ((1 <= Integer.parseInt(m.substring(2, 4))) && (Integer.parseInt(m.substring(2, 4)) <= 12))
                && ((1 <= Integer.parseInt(m.substring(4))) && (Integer.parseInt(m.substring(4)) <= 9999)))
        {
            return;
        }
        else
        {
            show_ErrorMessage(id);  
        }
    }    
    
    public static void show_ErrorMessage(int id)
    {
        if (id ==0)
            {              
                UIManager.put("OptionPane.messageFont", myFont);
                JOptionPane.showMessageDialog(null, "\u1270\u1233\u1235\u1270\u12CB\u120D\u1362  \u12A5\u1295\u12F0\u1308\u1293"
                            + " \u12EB\u1235\u1308\u1261!", "\u1218\u120D\u12D5\u12AD\u1275!", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                UIManager.put("OptionPane.messageFont", myFont);
                JOptionPane.showMessageDialog(null, "Invalid input. Please insert again!", "Warning!", JOptionPane.WARNING_MESSAGE);                
            }        
    }
    
    public static void show_ComboError(int id)
    {
        if(id==0)
        {
            UIManager.put("OptionPane.messageFont", myFont);
            JOptionPane.showMessageDialog(null, "\u12E8\u12D8\u1218\u1295 \u12A0\u1246\u1323\u1320\u122E\u1279\u1295 "
                    + "\u12ED\u121D\u1228\u1321!", "\u1218\u120D\u12D5\u12AD\u1275!", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            UIManager.put("OptionPane.messageFont", myFont);
            JOptionPane.showMessageDialog(null, "Please select the calendars!", "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }  
    
    public static void display_Images() throws InterruptedException {
        Random generator = new Random();
        String[] images = {"message.png", "message2.png"};
        JLabel[] labels = {CalendarConverter.jLabel4, CalendarConverter.jLabel8, CalendarConverter.jLabel9};
        int num = generator.nextInt(images.length);
        while (true) {
            ImageIcon icon = new ImageIcon(CalendarConverterFunction.class.getResource(images[num]));
            Image icon1 = icon.getImage();
            for (int k = 0; k < labels.length; k++) {
                Image icon2 = getScaledImage(icon1, labels[k].getWidth(), labels[k].getHeight());
                labels[k].setIcon(new ImageIcon(icon2));

            }
            try {
                Thread.sleep(6000L);
            } catch (InterruptedException e) {
                for (int k = 0; k < labels.length; k++) {
                    labels[k].setText("Interrupted!");
                }

            }
            num = (num + 1) % images.length;
        }
    }

    public static Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage buffImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = buffImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        return buffImg;
    }

}
