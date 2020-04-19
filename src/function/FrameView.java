//package swing;
//
//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import javax.swing.*;
//
//class FrameCls extends JFrame {
//    ImageIcon img1 = null;
//    ImageIcon img2 = null;
//    ImageIcon img3 = null;
//
//    /*
//    panel: 전체 프레임이 될 패널 (background)
//    imgPanel: 이미지 표시할 패널
//    menuPanel: 이미지 아래 메뉴 명과 주문할 수량 표시할 스피너 포함될 패널
//    creditPanel: 현재 잔고와 주문할 메뉴 가격 계산할 버튼 포함될 패널
//    bottomPanel: 가장 아래 주문 메뉴의 합계와 구매 버튼이 포함될 패널
//    */
//    JPanel panel = new JPanel();
//    JPanel imgPanel = new JPanel();
//    JPanel menuPanel = new JPanel();
//    JPanel creditPanel = new JPanel();
//    JPanel bottomPanel = new JPanel();
//
//    //SpinnerNumberModel(현재, 최소값, 최대값, 증가/감소하는 단위)
//    SpinnerNumberModel numberModel1 = new SpinnerNumberModel(0, 0, 10, 1);
//    SpinnerNumberModel numberModel2 = new SpinnerNumberModel(0, 0, 10, 1);
//    SpinnerNumberModel numberModel3 = new SpinnerNumberModel(0, 0, 10, 1);
//    //이미지 아래 메뉴와 스피너
//    JLabel menu1 = new JLabel("햄버거");
//    JSpinner menu1_spin = new JSpinner(numberModel1);
//    JLabel menu2 = new JLabel("김치볶음밥");
//    JSpinner menu2_spin = new JSpinner(numberModel2);
//    JLabel menu3 = new JLabel("라면");
//    JSpinner menu3_spin = new JSpinner(numberModel3);
//
//    //잔고 및 계산 시작 버튼
//    JLabel creditLabel = new JLabel("현재 금액");
//    JTextField tf = new JTextField("현재 금액을 입력해주세요", 20);
//    JButton startBtn = new JButton("시작");
//
//    //총합 및 구매 버튼
//    JLabel totalLabel = new JLabel("합계: ");
//    JTextField totalCost = new JTextField(" ", 20);
//    JButton buyBtn = new JButton("구매");
//
//    public FrameCls() {
//        setSize(450, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setTitle("음식 주문창");
//        setLayout(new GridLayout(0, 1));
//
//        img1 = new ImageIcon("img/burger.jpg");
//        img2 = new ImageIcon("img/gimchibap.jpg");
//        img3 = new ImageIcon("img/ramen.jpg");
//        //이미지 레이블
//        JLabel ilabel1 = new JLabel(img1, JLabel.CENTER);
//        JLabel ilabel2 = new JLabel(img2, JLabel.CENTER);
//        JLabel ilabel3 = new JLabel(img3, JLabel.CENTER);
//
//        totalCost.setEditable(false);
//
//        imgPanel.add(ilabel1);
//        imgPanel.add(ilabel2);
//        imgPanel.add(ilabel3);
//
//        menuPanel.add(menu1);
//        menuPanel.add(menu1_spin);
//        menuPanel.add(menu2);
//        menuPanel.add(menu2_spin);
//        menuPanel.add(menu3);
//        menuPanel.add(menu3_spin);
//
//        creditPanel.add(creditLabel);
//        creditPanel.add(tf);
//        creditPanel.add(startBtn);
//
//        bottomPanel.add(totalLabel);
//        bottomPanel.add(totalCost);
//        bottomPanel.add(buyBtn);
//
//        panel.add(imgPanel);
//        panel.add(menuPanel);
//        panel.add(creditPanel);
//        panel.add(bottomPanel);
//        add(panel);
//        setVisible(true);
//    }
//
//}
//
//public class FrameView {
//
//    public static void main(String[] args) {
//        FrameCls frameCls = new FrameCls();
//
//    }
//
//}
package swing;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import  java.awt.event.*;
// 아래 임포트 2개는 액션이벤트에 쓰임

class FrameCls extends JFrame {
    ImageIcon img1 = null;
    ImageIcon img2 = null;
    ImageIcon img3 = null;

    /*
    panel: 전체 프레임이 될 패널 (background)
    imgPanel: 이미지 표시할 패널
    menuPanel: 이미지 아래 메뉴 명과 주문할 수량 표시할 스피너 포함될 패널
    creditPanel: 현재 잔고와 주문할 메뉴 가격 계산할 버튼 포함될 패널
    bottomPanel: 가장 아래 주문 메뉴의 합계와 구매 버튼이 포함될 패널
    */
    JPanel panel = new JPanel();
    JPanel imgPanel = new JPanel();
    JPanel menuPanel = new JPanel();
    JPanel creditPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    //SpinnerNumberModel(현재, 최소값, 최대값, 증가/감소하는 단위)
    SpinnerNumberModel numberModel1 = new SpinnerNumberModel(0, 0, 10, 1);
    SpinnerNumberModel numberModel2 = new SpinnerNumberModel(0, 0, 10, 1);
    SpinnerNumberModel numberModel3 = new SpinnerNumberModel(0, 0, 10, 1);
    //이미지 아래 메뉴와 스피너
    JLabel menu1 = new JLabel("햄버거");
    JSpinner menu1_spin = new JSpinner(numberModel1);
    JLabel menu2 = new JLabel("김치볶음밥");
    JSpinner menu2_spin = new JSpinner(numberModel2);
    JLabel menu3 = new JLabel("라면");
    JSpinner menu3_spin = new JSpinner(numberModel3);

    //잔고 및 계산 시작 버튼
    JLabel creditLabel = new JLabel("현재 금액");
    JTextField tf = new JTextField("현재 금액을 입력해주세요", 20);
    JButton startBtn = new JButton("시작");

    //총합 및 구매 버튼
    JLabel totalLabel = new JLabel("합계: ");
    JTextField totalCost = new JTextField(" ", 20);
    JButton buyBtn = new JButton("구매");

    public FrameCls() {
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("음식 주문창");
        setLayout(new GridLayout(0, 1));

        img1 = new ImageIcon("C:\\Users\\82105\\Desktop\\vending_pro\\vending_machine_pjt\\img\\burger.jpg");
        img2 = new ImageIcon("C:\\Users\\82105\\Desktop\\vending_pro\\vending_machine_pjt\\img\\gimchibap.jpg");
        img3 = new ImageIcon("C:\\Users\\82105\\Desktop\\vending_pro\\vending_machine_pjt\\img\\ramen.jpg");
        //이미지 레이블
        JLabel ilabel1 = new JLabel(img1, JLabel.CENTER);
        JLabel ilabel2 = new JLabel(img2, JLabel.CENTER);
        JLabel ilabel3 = new JLabel(img3, JLabel.CENTER);

        totalCost.setEditable(false);

        imgPanel.add(ilabel1);
        imgPanel.add(ilabel2);
        imgPanel.add(ilabel3);

        menuPanel.add(menu1);
        menuPanel.add(menu1_spin);
        menuPanel.add(menu2);
        menuPanel.add(menu2_spin);
        menuPanel.add(menu3);
        menuPanel.add(menu3_spin);

        creditPanel.add(creditLabel);
        creditPanel.add(tf);
        creditPanel.add(startBtn);

        bottomPanel.add(totalLabel);
        bottomPanel.add(totalCost);
        bottomPanel.add(buyBtn);

        panel.add(imgPanel);
        panel.add(menuPanel);
        panel.add(creditPanel);
        panel.add(bottomPanel);
        add(panel);
        setVisible(true);

        buyBtn.addActionListener(new MyAction());
        startBtn.addActionListener(new MyAction2());

    }

    //구매 버튼을 눌렀을 때의 이벤트
    private class MyAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton Butt= (JButton)e.getSource();

            String tfString = tf.getText();   // tf를 문자열로 가져옴
            int tfInt = Integer.parseInt(tfString);   // tf 문자열을 정수로 바꿈

            //그리디 알고리즘으로 잔돈 출력
            greedy G = new greedy(tfInt,(int)menu1_spin.getModel().getValue(),(int)menu2_spin.getModel().getValue(),(int)menu3_spin.getModel().getValue());

        }
    }

    // 시작 버튼 눌렀을때 합계칸에 충금액 출력
    private class MyAction2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jButt = (JButton)e.getSource();

            TotalCost Cost= new TotalCost();
            int Cost_int = Cost.TotalCost((int)menu1_spin.getModel().getValue(),(int)menu2_spin.getModel().getValue(),(int)menu3_spin.getModel().getValue());
            String Totalcost_string = Integer.toString(Cost_int);
            totalCost.setText(Totalcost_string);
        }
    }
}


public class FrameView {

    public static void main(String[] args) {
        FrameCls frameCls = new FrameCls();

    }

}