package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener {
	private QLSVView view;
	public QLSVController(QLSVView view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Tạo mới")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Tạo mới");
		} else if (cm.equals("Lưu")) {
			try {
				this.view.thucHienThem();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	} else if(cm.equals("Cập nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();
	} else if(cm.equals("Xóa")){
		    this.view.thucHienXoa();
	} else if(cm.equals("Hủy bỏ")){
	    this.view.xoaForm();
    } else if(cm.equals("Tìm")){
	    this.view.thucHienTim();
    } else if(cm.equals("Hủy tìm")){
	    this.view.thucHienHuyTim();
    } else if(cm.equals("About Me")){
	    this.view.hienThiAbout();
    } else if(cm.equals("Exit")){
	    this.view.thoatKhoiChuongTrinh();
    } else if(cm.equals("Save")){
	    this.view.thucHienSave();
    } else if(cm.equals("Open")){
	    this.view.thucHienOpen();
    }
  }
	}
