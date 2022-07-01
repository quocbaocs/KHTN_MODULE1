package thucHanh.bai7_2;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class FrmDictionary extends JFrame {

	private JPanel contentPane;
	private JTextField txtWord;
	private JTextField txtMeaning;
	private JTextField txtSearch;
	private JTextField txtResult;
	private JList lstWordList;
	private List<Dictionary> listDic = new ArrayList<Dictionary>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDictionary frame = new FrmDictionary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDictionary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 616, 332);
		contentPane.add(tabbedPane);

		JPanel pnlShowInsert = new JPanel();
		tabbedPane.addTab("Show - Insert Word", null, pnlShowInsert, null);
		pnlShowInsert.setLayout(null);

		JLabel lblNewLabel = new JLabel("Word");
		lblNewLabel.setBounds(38, 21, 135, 25);
		pnlShowInsert.add(lblNewLabel);

		JLabel lblMeaning = new JLabel("Meaning");
		lblMeaning.setBounds(267, 21, 89, 25);
		pnlShowInsert.add(lblMeaning);

		txtWord = new JTextField();
		txtWord.setBounds(113, 21, 124, 25);
		pnlShowInsert.add(txtWord);
		txtWord.setColumns(10);

		txtMeaning = new JTextField();
		txtMeaning.setColumns(10);
		txtMeaning.setBounds(366, 21, 124, 25);
		pnlShowInsert.add(txtMeaning);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});
		btnInsert.setBounds(500, 21, 89, 23);
		pnlShowInsert.add(btnInsert);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 73, 525, 199);
		pnlShowInsert.add(scrollPane);

		lstWordList = new JList();
		scrollPane.setViewportView(lstWordList);

		JPanel pnlSearch = new JPanel();
		tabbedPane.addTab("Search", null, pnlSearch, null);
		pnlSearch.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Word");
		lblNewLabel_2.setBounds(30, 23, 95, 26);
		pnlSearch.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Meaning");
		lblNewLabel_2_1.setBounds(30, 90, 95, 26);
		pnlSearch.add(lblNewLabel_2_1);

		txtSearch = new JTextField();
		txtSearch.setBounds(135, 23, 117, 26);
		pnlSearch.add(txtSearch);
		txtSearch.setColumns(10);

		txtResult = new JTextField();
		txtResult.setColumns(10);
		txtResult.setBounds(135, 90, 117, 26);
		pnlSearch.add(txtResult);

		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnSearch.setIcon(new ImageIcon("D:\\KHTN_MODULE1\\Bai06M1_DoiTuongNC\\src\\HinhAnh\\search.jpg"));
		btnSearch.setBounds(262, 23, 34, 25);
		pnlSearch.add(btnSearch);
	}

	public void btnInsertActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Dictionary dc = new Dictionary(txtWord.getText(), txtMeaning.getText());
		listDic.add(dc);
		Collections.sort(listDic);
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (int i = 0; i < listDic.size(); i++) {
			Object o = new String(listDic.get(i).word + " : " + listDic.get(i).meaning);
			model.add(i, (String) o);
		}
		lstWordList.setModel(model);
	}

	public void btnSearchActionPerformed(ActionEvent e) {
		String word = txtWord.getText();
		String strResult = "";
		boolean result = false;
		
		for (int i = 0; i < listDic.size(); i++) {
			if (listDic.get(i).getWord().equals(word)) {
				result = true;
				strResult = listDic.get(i).getMeaning();
				break;
			}
		}
		if (result == false) {
			JOptionPane.showMessageDialog(contentPane, "Sorry, cannot find this word!");
		}
		txtResult.setText(strResult);

	}
}
