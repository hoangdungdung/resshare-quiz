package com.resshare.framework.core.service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.resshare.springboot.StartServiceListenerCore;

public class ResFirebaseReference {

	public static DatabaseReference getInputReference(String path_load_form_script) {

		if (path_load_form_script.startsWith("../")) {
			String path_root = StartServiceListenerCore.APPLICATION_NAME + "/" + StartServiceListenerCore.INPUT
					+ StartServiceListenerCore.CLUSTER;
			String path_load_form_script_full = path_load_form_script.replaceFirst("..", path_root);
			return FirebaseDatabase.getInstance().getReference(path_load_form_script_full);

		}
		return FirebaseDatabase.getInstance().getReference(path_load_form_script);

	}

	public static String getInputPathReference(String path_load_form_script) {

		if (path_load_form_script.startsWith("../")) {
			String path_root = StartServiceListenerCore.APPLICATION_NAME + "/" + StartServiceListenerCore.INPUT
					+ StartServiceListenerCore.CLUSTER;
			String path_load_form_script_full = path_load_form_script.replaceFirst("..", path_root);
			return path_load_form_script_full;

		}
		return path_load_form_script;

	}

	public static String getDataPathReference(String path_load_form_script) {
		if (path_load_form_script.startsWith("../")) {
			String path_root = StartServiceListenerCore.APPLICATION_NAME + "/" + StartServiceListenerCore.DATA
					;
			String path_load_form_script_full = path_load_form_script.replaceFirst("..", path_root);
			return path_load_form_script_full;

		}
		return path_load_form_script;
	}

	public static String getConfigurationPath(String path_load_form_script) {
		if (path_load_form_script.startsWith("../")) {
			String path_root = StartServiceListenerCore.APPLICATION_NAME + "/" + StartServiceListenerCore.CONFIGURATION
					;
			String path_load_form_script_full = path_load_form_script.replaceFirst("..", path_root);
			return path_load_form_script_full;

		}
		return path_load_form_script;
	}
	public static String getAbsolutePath(String path_load_form_script) {
		if (path_load_form_script.startsWith("../")) {
			String path_root = StartServiceListenerCore.APPLICATION_NAME  ;
					;
			String path_load_form_script_full = path_load_form_script.replaceFirst("..", path_root);
			return path_load_form_script_full;

		}
		return path_load_form_script;
	}

}
