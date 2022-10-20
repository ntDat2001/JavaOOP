package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;
import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	private JTextField textField_maThiSinh;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_Hovaten;
	public JTextField textField_Ngaysinh;
	public JTextField textField_Diem1;
	public JTextField textField_Diem2;
	public JTextField textField_Diem3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_Quequan;
	public JRadioButton jRadiobutton_nam;
	public JRadioButton jRadiobutton_nu;
	private JComboBox comboBox_Quequan_timkiem;
	public QLSVView() {
		this.model = new QLSVModel();
		ActionListener action = new QLSVController(this);
		this.setTitle("QLSV - NTĐ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.GRAY);
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menu_Open = new JMenuItem("Open");
		menu_Open.setIcon(new ImageIcon("/Users/nguyenthanhdat/Downloads/open-file-icon.png"));
		menu_Open.addActionListener(action);
		menuFile.add(menu_Open);
		
		JMenuItem menu_Save = new JMenuItem("Save");
		menu_Save.setIcon(new ImageIcon("/Users/nguyenthanhdat/Downloads/Save-icon.png"));
		menu_Save.addActionListener(action);
		menuFile.add(menu_Save);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menu_Exit = new JMenuItem("Exit");
		menu_Exit.setIcon(new ImageIcon("/Users/nguyenthanhdat/Downloads/Close-2-icon.png"));
		menu_Exit.addActionListener(action);
		menuFile.add(menu_Exit);
		
		JMenu menuAbout = new JMenu("Introduce");
		menuBar.add(menuAbout);
		
		JMenuItem menu_Aboutme = new JMenuItem("About Me");
		menu_Aboutme.setIcon(new ImageIcon("/Users/nguyenthanhdat/Downloads/help-icon.png"));
		menu_Aboutme.addActionListener(action);
		menuAbout.add(menu_Aboutme);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		
		JLabel lbl_danhSachSinhVien = new JLabel("Danh sách sinh viên");
		lbl_danhSachSinhVien.setBounds(6, 35, 168, 33);
		lbl_danhSachSinhVien.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Mã thí sinh", "Họ và tên", "Quê quán", "Ngày sinh", "Giới tính", "Điểm PRO192", "Điểm MAD101","Điểm SSG103"
				}
				));
		
		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 64, 588, 243);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 588, 33);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		JLabel label_Quequan = new JLabel("Quê quán");
		label_Quequan.setBounds(6, 6, 69, 19);
		panel.add(label_Quequan);
		label_Quequan.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		comboBox_Quequan_timkiem = new JComboBox();
		ArrayList <Tinh> listTinh = Tinh.getDSTinh();
		comboBox_Quequan_timkiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_Quequan_timkiem.addItem(tinh.getTenTinh());
		}
		comboBox_Quequan_timkiem.setBounds(77, 4, 110, 27);
		panel.add(comboBox_Quequan_timkiem);
		
		JLabel lbl_maSinhVien = new JLabel("Mã sinh viên");
		lbl_maSinhVien.setBounds(188, -1, 97, 33);
		panel.add(lbl_maSinhVien);
		lbl_maSinhVien.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		textField_maThiSinh = new JTextField();
		textField_maThiSinh.setBounds(278, 1, 110, 30);
		panel.add(textField_maThiSinh);
		textField_maThiSinh.setColumns(10);
		
		JButton btn_huyTim = new JButton("Hủy tìm");
		btn_huyTim.addActionListener(action);
		btn_huyTim.setBounds(497, 3, 85, 29);
		panel.add(btn_huyTim);
		
		JButton btn_tim = new JButton("Tìm");
		btn_tim.addActionListener(action);
		btn_tim.setBounds(400, 3, 85, 29);
		panel.add(btn_tim);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 331, 588, 161);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(null);
		
		JLabel lbl_idSinhVien = new JLabel("Mã sinh viên");
		lbl_idSinhVien.setBounds(10, 5, 90, 19);
		lbl_idSinhVien.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		panel_1.add(lbl_idSinhVien);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(115, 2, 130, 26);
		panel_1.add(textField_ID);
		
		JLabel label_Hovaten = new JLabel("Họ và tên");
		label_Hovaten.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_Hovaten.setBounds(10, 45, 69, 19);
		panel_1.add(label_Hovaten);
		
		textField_Hovaten = new JTextField();
		textField_Hovaten.setColumns(10);
		textField_Hovaten.setBounds(115, 42, 130, 26);
		panel_1.add(textField_Hovaten);
		
		JLabel lebel_Quequan = new JLabel("Quê quán");
		lebel_Quequan.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lebel_Quequan.setBounds(10, 84, 69, 19);
		panel_1.add(lebel_Quequan);
		
		comboBox_Quequan = new JComboBox();
		comboBox_Quequan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_Quequan.addItem(tinh.getTenTinh());
		}
		comboBox_Quequan.setBounds(115, 82, 130, 27);
		panel_1.add(comboBox_Quequan);
		
		JLabel lebel_Ngaysinh = new JLabel("Ngày sinh");
		lebel_Ngaysinh.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lebel_Ngaysinh.setBounds(10, 127, 71, 19);
		panel_1.add(lebel_Ngaysinh);
		
		textField_Ngaysinh = new JTextField();
		textField_Ngaysinh.setColumns(10);
		textField_Ngaysinh.setBounds(115, 124, 130, 26);
		panel_1.add(textField_Ngaysinh);
		
		JLabel label_Gioitinh = new JLabel("Giới tính");
		label_Gioitinh.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_Gioitinh.setBounds(304, 5, 90, 19);
		panel_1.add(label_Gioitinh);
		
		JLabel label_DiemPRO192 = new JLabel("Điểm CSD201");
		label_DiemPRO192.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		label_DiemPRO192.setBounds(304, 45, 119, 19);
		panel_1.add(label_DiemPRO192);
		
		JLabel lebel_DiemMAD101 = new JLabel("Điểm JPD113");
		lebel_DiemMAD101.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lebel_DiemMAD101.setBounds(304, 84, 119, 19);
		panel_1.add(lebel_DiemMAD101);
		
		JLabel lebel_DiemSSG103 = new JLabel("Điểm DBI202");
		lebel_DiemSSG103.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lebel_DiemSSG103.setBounds(304, 124, 100, 19);
		panel_1.add(lebel_DiemSSG103);
		
		jRadiobutton_nam = new JRadioButton("Nam");
		jRadiobutton_nam.setBounds(373, 3, 69, 23);
		panel_1.add(jRadiobutton_nam);
		
		textField_Diem1 = new JTextField();
		textField_Diem1.setColumns(10);
		textField_Diem1.setBounds(419, 42, 69, 26);
		panel_1.add(textField_Diem1);
		
		jRadiobutton_nu = new JRadioButton("Nữ");
		jRadiobutton_nu.setBounds(433, 3, 69, 23);
		panel_1.add(jRadiobutton_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(jRadiobutton_nam);
		btn_gioiTinh.add(jRadiobutton_nu);
		
		textField_Diem2 = new JTextField();
		textField_Diem2.setColumns(10);
		textField_Diem2.setBounds(419, 81, 69, 26);
		panel_1.add(textField_Diem2);
		
		textField_Diem3 = new JTextField();
		textField_Diem3.setColumns(10);
		textField_Diem3.setBounds(419, 121, 69, 26);
		panel_1.add(textField_Diem3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 500, 588, 44);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setLayout(null);
		
		JButton btn_Taomoi = new JButton("Tạo mới");
		btn_Taomoi.addActionListener(action);
		btn_Taomoi.setBounds(6, 6, 92, 32);
		panel_2.add(btn_Taomoi);
		
		JButton btn_Xoa = new JButton("Xóa");
		btn_Xoa.addActionListener(action);
		btn_Xoa.setBounds(129, 6, 92, 32);
		panel_2.add(btn_Xoa);
		
		JButton btn_Capnhat = new JButton("Cập nhật");
		btn_Capnhat.addActionListener(action);
		btn_Capnhat.setBounds(249, 6, 92, 32);
		panel_2.add(btn_Capnhat);
		
		JButton btn_Luu = new JButton("Lưu");
		btn_Luu.addActionListener(action);
		btn_Luu.setBounds(370, 6, 92, 32);
		panel_2.add(btn_Luu);
		
		JButton btn_Huybo = new JButton("Hủy Bỏ");
		btn_Huybo.addActionListener(action);
		btn_Huybo.setBounds(490, 6, 92, 32);
		panel_2.add(btn_Huybo);
		contentPane.setLayout(null);
		
		JLabel lblThngTinSinh = new JLabel("Thông tin sinh viên");
		lblThngTinSinh.setBounds(6, 301, 150, 33);
		lblThngTinSinh.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblThngTinSinh);
		contentPane.add(scrollPane);
		contentPane.add(panel_1);
		contentPane.add(panel);
		contentPane.add(lbl_danhSachSinhVien);
		contentPane.add(panel_2);
		
		this.setVisible(true);
	}
	public void xoaForm() {
		textField_ID.setText("");
		textField_Hovaten.setText("");
		textField_maThiSinh.setText("");
		textField_Ngaysinh.setText("");
		textField_Diem1.setText("");
		textField_Diem2.setText("");
		textField_Diem3.setText("");
		comboBox_Quequan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	
	
	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[]{
				ts.getMaThiSinh(),
				ts.getTenThiSinh(),
				ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth() + 1)+"/"+(ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh()?"Nam":"Nữ"),
				ts.getDiemMon1()+"",
				ts.getDiemMon2()+"",
				ts.getDiemMon3()+""
				});
	}
	
	
	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
		this.model.insert(ts);
		this.themThiSinhVaoTable(ts);
	} else {
		this.model.update(ts);
		int soLuongDong = model_table.getRowCount();
		for (int i = 0; i < soLuongDong; i++) {
			model_table.getValueAt(i, 0);
			String id = model_table.getValueAt(i, 0)+"";
			if (id.equals(ts.getMaThiSinh())) {
				model_table.setValueAt(ts.getMaThiSinh()+"", i, 0);
				model_table.setValueAt(ts.getTenThiSinh()+"", i, 1);
				model_table.setValueAt(ts.getQueQuan().getTenTinh(), i, 2);
				model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth() + 1)+"/"+(ts.getNgaySinh().getYear() + 1900), i, 3);
				model_table.setValueAt((ts.isGioiTinh()?"Nam":"Nữ"), i, 4);
				model_table.setValueAt(ts.getDiemMon1()+"", i, 5);
				model_table.setValueAt(ts.getDiemMon2()+"", i, 6);
				model_table.setValueAt(ts.getDiemMon3()+"", i, 7);
			}
		}
	}
	}
	
	
	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maThiSinh = model_table.getValueAt(i_row, 0)+"";
//		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = (model_table.getValueAt(i_row, 3)+"");
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}
	
	
	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();
		this.textField_ID.setText(ts.getMaThiSinh());
		this.textField_Hovaten.setText(ts.getTenThiSinh());
		this.comboBox_Quequan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth() + 1)+"/"+(ts.getNgaySinh().getYear() + 1900);
		this.textField_Ngaysinh.setText(s_ngaySinh+"");
		if (ts.isGioiTinh()) {
			jRadiobutton_nam.setSelected(true);
		} else {
			jRadiobutton_nu.setSelected(true);
		}
		this.textField_Diem1.setText(ts.getDiemMon1()+"");
		this.textField_Diem2.setText(ts.getDiemMon2()+"");
		this.textField_Diem3.setText(ts.getDiemMon3()+"");
	}
	
	
	public void thucHienXoa() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn!");
		if (luaChon == JOptionPane.YES_NO_OPTION) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int i_row = table.getSelectedRowCount();
			ThiSinh ts = getThiSinhDangChon();
			int sd = Integer.valueOf(table.getSelectedRowCount());
			for (int i = 0; i < this.model.getDsThiSinh().size(); i++)
			{
				if (this.model.getDsThiSinh().get(i).getMaThiSinh().equals(ts)) {
					this.model.getDsThiSinh().remove(ts);
					model_table.removeRow(i_row);
				}
			}
//			this.model.getDsThiSinh().remove(sd-1);
//			model_table.removeRow(i_row);
		}
	}
	
	
	public void thucHienThem() {
		String maThiSinh = this.textField_ID.getText();
//		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_Hovaten.getText();
		int queQuan = this.comboBox_Quequan.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_Ngaysinh.getText());
		String chonGioiTinh = this.btn_gioiTinh.getSelection()+"";
		boolean gioiTinh = true;
		if (this.jRadiobutton_nam.isSelected()){
			gioiTinh = true;
		}else if(this.jRadiobutton_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Diem1.getText());
		float diemMon2 = Float.valueOf(this.textField_Diem2.getText());
		float diemMon3 = Float.valueOf(this.textField_Diem3.getText());
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);
	}
	
	
	public void thucHienTim() {
		// Goi ham thuc hien huy tim
        this.thucHienHuyTim();
		
		// Thuc hien tim
		int queQuan = this.comboBox_Quequan_timkiem.getSelectedIndex()-1;
		String maThiSinhTimKiem = this.textField_maThiSinh.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<String> idCuaThiSinhCanXoa = new TreeSet<String>();
		if (queQuan >= 0) {
			Tinh tenTinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0 ;i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2)+"";
				String id = model_table.getValueAt(i, 0)+"";
				if (!tenTinh.equals(tenTinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(id);
				}
			}
		}
		if (maThiSinhTimKiem.length()>0) {
			for (int i = 0 ;i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(id);
				}
			}
		}
		for (String idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println("id can xoa:"+idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0 ;i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+"";
				System.out.println("Id trong table:"+idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("da xoa:"+i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			}
	}
	
	
	public void thucHienHuyTim() {
		
		while(true)
		{
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
			System.out.println(ts.toString());
		}
	}
	
	
	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mền quản lí thí sinh - NTĐ");
	}
	
	
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát khỏi chương trình không?");
		if (luaChon == JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}
	
	
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void thucHienSave() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	
	
	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}


	
	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
	
	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}
}
