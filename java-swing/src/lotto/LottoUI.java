package lotto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import component.ButtonDemo;

public class LottoUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	Lotto lotto;
	// 컴포넌트(스윙에서 화면을 나타내는 클래스)는 연관관계로 부모-자식 관계를 맺는다.
	JButton button, btnTest, btnExit;
	JPanel northPanel, southPanel;		// 보더레이아웃 개념으로 볼 때, 동서남북으로 위치값을 줌.
	ImageIcon icon;
	List<JButton> btns;
	
	public LottoUI() {
		init();
	}

	public void init() { // initialize
		// 부품 준비 단계 => 큰것에서 작은것 순으로
		this.setTitle("SBS로또추첨");
		lotto = new Lotto();
		btns = new ArrayList<JButton>();
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		button = new JButton("로또번호추첨");
		btnTest = new JButton("테스트");
		btnExit = new JButton("종료");
		
		// 조립단계 => 작은것부터 큰것 순으로
		
		button.addActionListener(this); // 이 클래스에서 구현한 관련 메소드를 할당한다.
		btnTest.addActionListener(this); // 이 클래스에서 구현한 관련 메소드를 할당한다.
		btnExit.addActionListener(this); // 이 클래스에서 구현한 관련 메소드를 할당한다.
		northPanel.add(button); // 북쪽패널에 버튼 장착
		northPanel.add(btnTest);
		northPanel.add(btnExit);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.setBounds(300, 400, 1200, 300); // 300,400은 좌표값, 1200,300길이
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		switch (e.getActionCommand()) {
		case "로또번호추첨":
			if (btns.size() == 0) {
				JButton tmp = null;
				for (int i = 0; i < 6; i++) {
					tmp = new JButton();		// 번호가 붙지않은 로또볼 객체
					btns.add(tmp);				// 6회전 빈로또볼 6개 리스트에
					southPanel.add(tmp);		// 담고 패널에 붙이기
				}
			}
			lotto.setLotto();
			int[] temp = lotto.getLotto();
			for (int i = 0; i < temp.length; i++) {
				//btns.get(i).setIcon(new ImageIcon("src/image/"+temp[i]+".gif"));
				btns.get(i).setIcon(createImageIcon("../image/"+temp[i]+".gif"));
			}
			break;
		case "테스트":
			System.out.println("테스트");
			break;
		case "종료":
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	 protected static ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL = ButtonDemo.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	    }

}
