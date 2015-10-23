package component;

import java.awt.*;

import javax.swing.*;

import javax.swing.table.*;

 

 

public class DefaultTableModelDemo extends JFrame {

    private JRootPane jrp;

    private Container con;

 

    // 관리의 편리성...DefaltTableModel

    private DefaultTableModel dtm = new DefaultTableModel(5,4);

    private JTable table = new JTable(dtm);  //  JTable(TableModel) 생성자 이용

    private JScrollPane jsp = new JScrollPane(table);

 

    public DefaultTableModelDemo() {

        this.setTitle("Title Swing");

        this.setSize(400, 300);

        this.initLocation();

        this.init();

        this.start();

 

        this.setVisible(true);

    }

 

    private void init() {

        jrp = this.getRootPane();

        con = jrp.getContentPane();

        con.setLayout(new BorderLayout(5,5));

 

        con.add("North", new JLabel("Table example", JLabel.CENTER));

        con.add("Center", jsp);

        JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        jp.add(new JButton("OK"));

        jp.add(new JButton("Cancel"));

        con.add("South", jp);

 

    }

 

    private void start() {

            dtm.setValueAt("F0-0", 0, 0);  // 테이블에 데이타를 추가

            dtm.setValueAt("F1-0", 1, 0);

            dtm.setValueAt("F3-2", 3, 2);

 

            dtm.addColumn("NewCol");   // 새로운 컬럼을 추가

            dtm.addRow(new Object[]{"first","second","third"});  //  새로운 열을 추가

 

            // 헤더를 셋팅(갯수가 틀리면 부족분 컬럼이 없어짐)

            // dtm.setColumnIdentifiers(new Object[]{"One","TWO"});

    }

 

    // 종료 & 화면중앙

    private void initLocation() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료실행

        Toolkit tk = Toolkit.getDefaultToolkit();

        Dimension dm = tk.getScreenSize();

        Dimension fm = this.getSize();

        this.setLocation((int) (dm.getWidth() / 2 - fm.getWidth() / 2),

                (int) (dm.getHeight() / 2 - fm.getHeight() / 2));

    }

}