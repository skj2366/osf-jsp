package com.osf.test.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.osf.test.db.DBCon;

public class RSTest {

	public static void main(String[] args) {
		String sql = "select * from food";
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();//메타데이터 뽑기~
			List<Map<String,String>> colList = new ArrayList<>();
			
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				String colName = rsmd.getColumnLabel(i);//알리야스안하면 ColumnName으로 못가져옴 ㅠ ..그래서 ColumnLabel
				//??? 알리야스를 안하면 ColumnName과 ColumnLabel과 같기에 Name으로 가져올 필요가 없다.
				Map<String,String> col = new HashMap<>();
				colName = colName.toLowerCase(); //소문자화 시키기.toUpperCase는 대문자화
				int idx = colName.indexOf("_");
				String fName = colName.substring(0,idx);//food
				String lName = colName.substring(idx+1);//num,name,price ... 
				lName = lName.substring(0,1).toUpperCase() + lName.substring(1);//food뒷부분 첫글자 대문자화. lName의 첫글자 대문자화.
				col.put(colName, fName+lName);
				colList.add(col);
//				System.out.println(fName+lName);
//				System.out.println(colName);
				/////Map을 만들었을때의 키값을 만든것 .
			}
			System.out.println(colList);
			while(rs.next()) {
				Map<String,String> row = new HashMap<>();
				for(Map<String,String> col : colList) {
					Iterator<String> it = col.keySet().iterator();
					String key = it.next();
					String value = rs.getString(key);
					row.put(col.get(key), value);
				}
				System.out.println(row);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
