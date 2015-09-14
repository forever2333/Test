package com.tool;

import java.text.NumberFormat;
import java.util.List;

public class MyTool {
	
	//9位ID
	private static Integer getID(){
		Integer aa = 1000000000;
		return (int)(Math.random()*aa);
	}
	
	/** 获取编号 */
	@SuppressWarnings("unchecked")
	public static Integer getTruID(List<?> list){
		Integer tID = MyTool.getID();
		if (list!=null&&list.size()>0) {
			for (Integer Integer1 : (List<Integer>)list) {
				if (tID == Integer1) {
					MyTool.getTruID(list);
				}
			}
		}
		return tID;
	}
	
	/**货币的格式自定义*/
	public static String moneyChange(Double num){
		try {
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setMaximumFractionDigits(3);
			nf.setMinimumIntegerDigits(6);
			return nf.format(num);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0.0";
	}
	
}
