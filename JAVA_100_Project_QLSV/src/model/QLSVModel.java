package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String luaChon;
	private String tenFile;
	
	public QLSVModel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		this.luaChon = ""; 
		this.tenFile = "";
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}

	public ArrayList<ThiSinh> getDsThiSinh() {
		return dsThiSinh;
	}

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	public void insert(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}
//	public void delete(ThiSinh thiSinh) {
//		for (int i = 0; i < dsThiSinh.size(); i++) {
//			dsThiSinh.remove()
//		}
////		this.dsThiSinh.remove(thiSinh);
//	}
	public void update(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
		this.dsThiSinh.add(thiSinh);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean kiemTraTonTai(ThiSinh ts) {
		for (ThiSinh thiSinh : dsThiSinh) {
			if (thiSinh.getMaThiSinh().equals(ts.getMaThiSinh())) {
				return true;
			}
		}
		return false;
	}
}
