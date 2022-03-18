package C004_Clz_Obj_2;
/**
 * project_name: Java_Ex
 *
 * package_name: C004_Clz_Obj_2 
 *
 * author:  DarlingKe
 *
 * created Time: 2017-12-29 ионГ9:09:35 
 *
 * version: 1.0 
 *
 * since: JDK 1.7.0_15
 *
 * FileName: Size.java  
 *
 * Description:  
 *
 */

//enum Size0{SMALL, MEDIUM, LARGE, EXTRA_LARGE }
public enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	private String abbreviation;
}


 