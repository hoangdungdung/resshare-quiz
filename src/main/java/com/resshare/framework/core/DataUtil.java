package com.resshare.framework.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

 

public class DataUtil {
	public static Map ConvertDataSnapshotToMap(DataSnapshot snapshot1) {
		if (snapshot1 != null) {
			Iterable<DataSnapshot> chil = snapshot1.getChildren();
			if (chil != null) {
				HashMap hm = new HashMap<>();

				for (DataSnapshot dataSnapshot : chil) {
					hm.put(String.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue());

				}
				return hm;
			}

		}
		return null;

	}
	public static Map ConvertDataSnapshotToMapAll(DataSnapshot snapshot1) {
		if (snapshot1 != null) {
			Iterable<DataSnapshot> chil = snapshot1.getChildren();
			if (chil != null) {
				HashMap hm = new HashMap<>();

				for (DataSnapshot dataSnapshot : chil) {
					if(dataSnapshot.hasChildren())
					{
						Map hmchil = ConvertDataSnapshotToMapAll(dataSnapshot);
						hm.put(String.valueOf(dataSnapshot.getKey()), hmchil);
						
					}
					else
					{	
				
					hm.put(String.valueOf(dataSnapshot.getKey()), dataSnapshot.getValue());
					}
				}
				return hm;
			}

		}
		return null;

	}
	public static  <T> T fromJson(Object obj, Class<T> classOfT)
	{
		Gson gson = new Gson();
		JsonElement jsonElement = gson.toJsonTree(obj);

		String json = gson.toJson(jsonElement);
		T book_item = gson.fromJson(json,classOfT);
		return book_item;
	}
	
	public static  String toJson(Object obj )
	{
		Gson gson = new Gson();
		JsonElement jsonElement = gson.toJsonTree(obj);
		
		//jsonElement.

		String json = gson.toJson(jsonElement);
	 
		return json;
	}

	public static String getStringDay() {
		
		
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		//System.out.println(date);
		

//		Date dt = Calendar.getInstance().getTime();
//		String sDay = String
//				.valueOf(String.valueOf(dt.getYear()) + String.valueOf(dt.getMonth()) + String.valueOf(dt.getDate()));
 		return date;
	}

	public static String getStringDayOld() {
		// TODO Auto-generated method stub
		Date dt = Calendar.getInstance().getTime();
		String sDay = String
				.valueOf(String.valueOf(dt.getYear()) + String.valueOf(dt.getMonth()) + String.valueOf(dt.getDate()));
 		return sDay;
	}
}
