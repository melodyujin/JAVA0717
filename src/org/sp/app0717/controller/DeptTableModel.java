package org.sp.app0717.controller;

import javax.swing.table.AbstractTableModel;

import org.sp.app0717.model.DeptDAO;

//Model과 View를 분리시켜 개발하기 위해서는 컨트롤러가 중재해야 하고,
//javase 의 JTable에서의 컨트롤러 역할은 TableModel 인터페이스가 담당
public class DeptTableModel extends AbstractTableModel{
	DeptDAO deptDAO;
	String[][] data;
	String[] column= {"DEPTNO","DNAME","LOC"};
	
	public DeptTableModel() {
		deptDAO = new DeptDAO();
		data=deptDAO.selectAll(); //사원 정보 가져오기
		/*
		//사원수 구하기(커서를 제일 아래로 보내고, 그 위치에서의 rownum을 구하자)
		try {
			rs.last(); //커서 제일 마지막 레코드로 보내기
			total=rs.getRow();
			System.out.println("총 사원수는 "+total);
			//사원수를 구했으므로, 이차원배열을 생성해보자
			data = new String[total][8];
			
			//비어있는 이차원배열의 각 요소에, rs를 이용하여 레코드 채워넣기
			rs.beforeFirst();
			int index=0;
			
			while(rs.next()) { //레코드가 있는 동안..
				data[index][0]=Integer.toString(rs.getInt("empno"));
				data[index][1]=rs.getString("ename");
				data[index][2]=rs.getString("job");
				data[index][3]=Integer.toString(rs.getInt("mgr"));
				data[index][4]=rs.getString("hiredate");
				data[index][5]=Integer.toString(rs.getInt("sal"));
				data[index][6]=Integer.toString(rs.getInt("comm"));
				data[index][7]=Integer.toString(rs.getInt("deptno"));
				index++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}
	
	//아래의 오버라이딩 된 모든~ 메서드는 개발자가 호출하는 것이 아니라,
	//JTable이 표를 어떻게 보여줄지를 결정하는 데이터이기 때문에, JTable이 스스로 호출
	
	public int getRowCount() {
		//System.out.println("getRowCount() 호출");
		return data.length;
	}
	public int getColumnCount() {
		//System.out.println("getColumnCount() 호출");
		return data[0].length;
	}
	
	@Override
	public String getColumnName(int col) {
		return column[col];
	}
	public Object getValueAt(int row, int col) {
		//System.out.println("getValueAt("+row+","+col+") 호출");
		return data[row][col];
	}

}
