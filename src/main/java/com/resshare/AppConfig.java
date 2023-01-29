package com.resshare;

import org.springframework.beans.factory.annotation.Value;

public class AppConfig {

	@Value("${database}")
	private String database;

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	@Value("${app_name}")
	private String app_name;

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	@Value("${backend_key}")
	private String backend_key;

	public String getBackend_key() {
		return backend_key;
	}

	public void setBackend_key(String backend_key) {
		this.backend_key = backend_key;
	}

	@Value("${backend_address}")
	private String backend_address;

	public String getBackend_address() {
		return backend_address;
	}

	public void setBackend_address(String backend_address) {
		this.backend_address = backend_address;
	}

	@Value("${debug}")
	private String debug;

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	@Value("${ngrok}")
	private String ngrok;

	public String getNgrok() {
		return ngrok;
	}

	public void setNgrok(String ngrok) {
		this.ngrok = ngrok;
	}

	@Value("${gateway_type}")
	private String gateway_type;

	public String getGateway_type() {
		return gateway_type;
	}

	public void setGateway_type(String gateway_type) {
		this.gateway_type = gateway_type;
	}

	@Value("${gateway_uri}")
	private String gateway_uri;

	public String getGateway_uri() {
		return gateway_uri;
	}

	public void setGateway_uri(String gateway_uri) {
		this.gateway_uri = gateway_uri;
	}

	@Value("${x_api_key}")
	private String x_api_key;

	public String getX_api_key() {
		return x_api_key;
	}

	public void setX_api_key(String x_api_key) {
		this.x_api_key = x_api_key;
	}

	@Value("${http}")
	private String http;

	public String getHttp() {
		return http;
	}

	public void setHttp(String http) {
		this.http = http;
	}

	@Value("${cluster}")
	private String cluster;

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	@Value("${user_id}")
	private String user_id;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Value("${upload_file_uri}")
	private String upload_file_uri;

	public String getUpload_file_uri() {
		return upload_file_uri;
	}

	public void setUpload_file_uri(String upload_file_uri) {
		this.upload_file_uri = upload_file_uri;
	}

	@Value("${x_api_key_upload_file}")
	private String x_api_key_upload_file;

	public String getX_api_key_upload_file() {
		return x_api_key_upload_file;
	}

	public void setX_api_key_upload_file(String x_api_key_upload_file) {
		this.x_api_key_upload_file = x_api_key_upload_file;
	}
}

// database =
// https://quiz-fd509-default-rtdb.asia-southeast1.firebasedatabase.app/
// app_name=quiz3
// backend_key=11223344@Qq
// backend_address=a2ed-2001-ee0-4181-eb12-e0ac-7ab-d9a1-3d9f.ngrok.io
// ngrok=true
// gateway_type=amazonaws
// gateway_uri=5q8i8x9d5m.execute-api.ap-southeast-1.amazonaws.com/request_input
// x_api_key=gPiKY6S3AM2JX1jiZdpeu5RuwfwKMSxc7wAtIQSZ
// http=https
// ent=dev
// cluster=_cluster01
// user_id = ggggggggg
// upload_file_uri=https://t6olsxfyn5.execute-api.ap-southeast-1.amazonaws.com/upload_file
// x_api_key_upload_file=9TkCaSLyk45Fz8YXPW6Qm9UcaIsx70ir1aKYMRja