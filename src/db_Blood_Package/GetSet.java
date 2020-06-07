package db_Blood_Package;

public class GetSet 
{
	static int bID;
	static String uNAME;
	static String uCONTACT;
	static String uBLOOD;
	static int uID;
	public static int getuID() {
		return uID;
	}

	public static void setuID(int uID) {
		GetSet.uID = uID;
	}

	public static String getuCONTACT() {
		return uCONTACT;
	}

	public static void setuCONTACT(String uCONTACT) {
		GetSet.uCONTACT = uCONTACT;
	}

	public static String getuNAME() {
		return uNAME;
	}

	public static void setuNAME(String uNAME) {
		GetSet.uNAME = uNAME;
	}

	public static String getuBLOOD() {
		return uBLOOD;
	}

	public static void setuBLOOD(String uBLOOD) {
		GetSet.uBLOOD = uBLOOD;
	}

	public static int getBID() {
		return bID;
	}

	public static void setBID(int bID) {
		GetSet.bID = bID;
	}
}
