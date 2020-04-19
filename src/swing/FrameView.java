package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import function.Greedy;


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
    JTextField tf = new JTextField("0", 20);
    JButton startBtn = new JButton("시작");

    //총합 및 구매 버튼
    JLabel totalLabel = new JLabel("합계: ");
    JTextField totalCost = new JTextField(" ", 20);
    JButton buyBtn = new JButton("구매");

    public FrameCls() {
        setSize(640, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("음식 주문창");
        setLayout(new GridLayout(0, 1));

        img1 = new ImageIcon("img/burger.jpg");
        img2 = new ImageIcon("img/gimchibap.jpg");
        img3 = new ImageIcon("img/ramen.jpg");
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

        startBtn.addActionListener(new AcListener());
        buyBtn.addActionListener(new AcListener());

        panel.add(imgPanel);
        panel.add(menuPanel);
        panel.add(creditPanel);
        panel.add(bottomPanel);
        add(panel);
        setVisible(true);
    }

    //버튼 이벤트 (Inner Class)
    private class AcListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int paid = 0, hamburger = 0, rice = 0, noodle = 0;
            hamburger = Integer.parseInt(menu1_spin.getValue().toString());
            rice = Integer.parseInt(menu2_spin.getValue().toString());
            noodle = Integer.parseInt(menu3_spin.getValue().toString());
            paid = Integer.parseInt(tf.getText());
			/*
			 시작버튼 누르면 주문할 메뉴들의 총 합계를 totalCost 텍스트필드에 띄움
			 구매버튼을 누르면 새 프레임을 띄워 구매 후 거스름돈과 거슬러 줄 총 화폐의 개수를 띄움
			 현재 잔고가 더 적으면 금액이 부족하다는 텍스트 출력
			 (화폐는 10000, 5000, 1000, 500, 100, 50, 10원이 있다고 가정)
			 */
            if(e.getSource() == startBtn) {
                int itotalCost = 0;
                Greedy greedy = new Greedy(paid, hamburger, rice, noodle);
                itotalCost = greedy.TotalCost();
                totalCost.setText(Integer.toString(itotalCost));

            } else if(e.getSource() == buyBtn) {
                int itotalCost = 0;
                Greedy greedy = new Greedy(paid, hamburger, rice, noodle);

                itotalCost = greedy.TotalCost();

                if(itotalCost <= 0) {
                    BuyingFrame frameB = new BuyingFrame();
                    frameB.textl.setText("주문하신 메뉴가 없습니다.");
                    frameB.changetext.setVisible(false);
                } else if (itotalCost > paid) {
                    BuyingFrame frameB = new BuyingFrame();
                    frameB.textl.setText("현재 돈이 부족합니다.");
                    frameB.changetext.setVisible(false);
                } else {
                    int totalChanges = 0, totalMoney = 0;
                    String changeStr;

                    totalMoney = greedy.GreedyChange();
                    totalChanges = greedy.getTotalChange();
                    changeStr = Integer.toString(totalChanges) + " (화폐 수: " + Integer.toString(totalMoney) + ")";

                    BuyingFrame frameB = new BuyingFrame();

                    // 새 창에 거스름돈 나타내기
                    frameB.changetext.setText(Integer.toString(totalChanges)+"원" +"\n" +"10000원 : " +Integer.toString(Greedy.n10000)+ "\n" +"5000원 : " +Integer.toString(Greedy.n5000)+ "\n" +
               "1000원 : " +Integer.toString(Greedy.n1000)+ "\n" +"500원 : " +Integer.toString(Greedy.n500)+ "\n" +
                "100원 : " + Integer.toString(Greedy.n100)+ "\n" + "50원 : " + Integer.toString(Greedy.n50) + "\n" +
                "10원 : " +Integer.toString(Greedy.n10)+ "\n" + "총 : "+Integer.toString(totalMoney)+"개");
                }
            }
        }
    }

}

class BuyingFrame extends JFrame {
    JPanel mainpanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel btnPanel = new JPanel();

    JLabel textl = new JLabel("주문 완료! 총 거스름돈:  ");
    JTextArea changetext = new JTextArea(8, 3);
    JButton checkBtn = new JButton("확인");

    public BuyingFrame () {
        setSize(500, 350);
        setTitle("주문 확인창");
        mainpanel.setLayout(new GridLayout(0, 1));

        changetext.setEditable(false);
        labelPanel.add(textl);
        labelPanel.add(changetext);

        btnPanel.add(checkBtn);
        checkBtn.addActionListener(new BtListener());

        mainpanel.add(labelPanel);
        mainpanel.add(btnPanel);
        add(mainpanel);
        setVisible(true);
    }

    private class BtListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == checkBtn) {
                dispose();
            }
        }
    }

}

public class FrameView {

    public static void main(String[] args) {

        FrameCls frameCls = new FrameCls();

    }

}
