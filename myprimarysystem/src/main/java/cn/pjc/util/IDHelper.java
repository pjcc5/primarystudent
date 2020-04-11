package cn.pjc.util;

import java.util.UUID;

public class IDHelper {
	public static String getUUID()
	{
		return  UUID.randomUUID().toString().replaceAll("-", "");
	}

}
