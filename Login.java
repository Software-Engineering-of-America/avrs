package com.seasoft.savrs;

import java.util.ArrayList;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class Login implements SavrsRest {
	private boolean debug = false;
	private String url = null;

	Login(String h, boolean d) {
		url = getLogonUrl(h);
		debug = d;
	}

	public Login.Response logon(Input data) {
		Response loginResponse = new Response();
		try {
			if (debug)
				prettyPrint("FilterList Input", data);

			// configure POJO mapping
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);

			// endpoint for url
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, data);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			} else {
				loginResponse = response.getEntity(Login.Response.class);
				if (debug)
					prettyPrint("FilterList Output", loginResponse);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return loginResponse;
	}

	static class Input {
		private String username;
		private String password;
		private String error;
		ArrayList<String> catalogs = new ArrayList<String>();
		private String userid;

		public Input(String username, String password) {
			this.username = username;
			this.userid = this.username;
			this.password = password;
		}

		// Getter Methods

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public String getError() {
			return error;
		}

		public String getUserid() {
			return userid;
		}

		// Setter Methods

		public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setError(String error) {
			this.error = error;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}
	}

	static class Response {
		private String authToken;
		private ArrayList<String> catalogs = new ArrayList<String>();

		public void printResponse() {
			System.out.println("Login Response: ");
			System.out.println("  authToken: " + this.authToken);
			System.out.println("  catalogs: ");
			for (String c : this.catalogs)
				System.out.println("      " + c);

		}
		
		public int findCatalogIndex(String catalog) {
			return this.getCatalogs().indexOf(catalog);
		}

		// Getter Methods

		public String getAuthToken() {
			return authToken;
		}

		public ArrayList<String> getCatalogs() {
			return catalogs;
		}

		// Setter Methods

		public void setAuthToken(String authToken) {
			this.authToken = authToken;
		}

		public void setCatalogs(ArrayList<String> catalogs) {
			this.catalogs = catalogs;
		}
	}
}
