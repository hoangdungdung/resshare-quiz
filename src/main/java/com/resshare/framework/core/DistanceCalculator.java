package com.resshare.framework.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
 

//http://hoctuduylaptrinh.com/2017/03/30/startup-bai-5-tinh-khoang-cach-giua-2-diem-bang-latitude-va-longitude/
public class DistanceCalculator {
	public final static String UNIT_MILES = "M";
	public final static String UNIT_KILOMETERS = "K";
	public final static String UNIT_NAUTICAL_MILES = "N";

	// http://www.movable-type.co.uk/scripts/latlong.html
	public static double distanceBetween2Points1(double la1, double lo1, double la2, double lo2) {
		double dLat = (la2 - la1) * (Math.PI / 180);
		double dLon = (lo2 - lo1) * (Math.PI / 180);
		double la1ToRad = la1 * (Math.PI / 180);
		double la2ToRad = la2 * (Math.PI / 180);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(la1ToRad) * Math.cos(la2ToRad) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = 6371e3 * c;
		return d;
	}

	public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}
		if ("NaN".equals(String.valueOf(dist)))
			dist = 0;
		System.out.println(lat1 + "," + lon1 + "," + lat2 + "," + lon2 + "," + unit + "return:" + dist);
		return dist;// Math.random();
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	public static String getDistance(double lat1, double lon1, double lat2, double lon2) throws Exception {
		// Reference - https://developers.google.com/maps/documentation/distancematrix/
		URL url = new URL("http://maps.googleapis.com/maps/api/directions/json?origin=" + lat1 + "," + lon1
				+ "&destination=" + lat2 + "," + lon2 + "&sensor=false&units=metric&mode=driving");

		// URL url = new
		// URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC|Seattle&destinations=San+Francisco|Victoria+BC");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		String line, outputString = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = reader.readLine()) != null) {
			outputString += line;
		}
		System.out.println(outputString);
		// DistancePojo capRes = new Gson().fromJson(outputString, DistancePojo.class);
		// System.out.println(capRes);
		return outputString;
	}
//	public static Location  convertStringLocation(String strLocation) {
//		String[] arr = strLocation.split(",");
//		Location   location = new Location();
//		Double lat= Double.valueOf(arr[0].trim());
//		location.setLat(lat);
//		 Double Lon =Double.valueOf(arr[1].trim());
//		location.setLon(Lon);
//	
//		
//		
//	
//		return   location;
//		
//	}

	public static String getDistance(String customerLocation, String supplierLocation, String unit) {
	try {
		String[] arr = customerLocation.split(",");
		 
		Double lat= Double.valueOf(arr[0].trim());
		 
		 Double Lon =Double.valueOf(arr[1].trim());
		 
			String[] arrsupplierLocation = supplierLocation.split(",");
			 
			Double latsupplierLocation= Double.valueOf(arrsupplierLocation[0].trim());
			 
			 Double LonsupplierLocation =Double.valueOf(arrsupplierLocation[1].trim());
			  DecimalFormat df2 = new DecimalFormat("#.####");

		double distanceR;
		 distanceR=distance(lat,Lon,latsupplierLocation,LonsupplierLocation,unit);
		 
		 return df2.format( distanceR);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	 
	return  "0";
	}
}
