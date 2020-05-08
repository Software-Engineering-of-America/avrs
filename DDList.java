package com.seasoft.savrs;

import java.util.ArrayList;

import com.seasoft.savrs.SavrsStructures.PropertyLabels;
import com.seasoft.savrs.SavrsStructures.ddEntries;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class DDList implements SavrsRest {
	private boolean debug = false;
	private String url = null;

	DDList(String h, boolean d) {
		url = getDDListUrl(h);
		debug = d;
	}

	public Response getOutput(Input data) {
		Response ddlist = new Response();
		try {
			if (debug)
				prettyPrint("DDList Input", data);

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, data);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			} else {
				ddlist = response.getEntity(Response.class);
				if (debug)
					prettyPrint("DDList Output", ddlist);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return ddlist;
	}

	// input data
	static class Input {
		private String authToken;
		private String catalog;
		private String clientVersion;
		private String jobUniqueID;

		public Input(String auth, String catalog, String version, String jobuniqueid) {
			this.authToken = auth;
			this.catalog = catalog;
			this.clientVersion = version;
			this.jobUniqueID = jobuniqueid;
		}

		public void printData() {
			System.out.println("DDList.Data:");
			System.out.println("   auth:    " + this.authToken);
			System.out.println("   catalog: " + this.catalog);
			System.out.println("   version: " + this.clientVersion);
			System.out.println("   prefix:  " + this.jobUniqueID);
		}

		// Getter Methods

		public String getAuthToken() {
			return authToken;
		}

		public String getCatalog() {
			return catalog;
		}

		public String getClientVersion() {
			return clientVersion;
		}

		public String getJobUniqueID() {
			return jobUniqueID;
		}

		// Setter Methods

		public void setAuthToken(String authToken) {
			this.authToken = authToken;
		}

		public void setCatalog(String catalog) {
			this.catalog = catalog;
		}

		public void setClientVersion(String clientVersion) {
			this.clientVersion = clientVersion;
		}

		public void setJobUniqueID(String jobuniqueid) {
			this.jobUniqueID = jobuniqueid;
		}
	}

	// response data
	static class Response {
		private PropertyLabels ddPropertyLabels;
		private ArrayList<ddEntries> ddEntries = new ArrayList<ddEntries>();

		public void printResponse() {

			System.out.println("DDList Response: ");
			for (ddEntries d : this.ddEntries) {
				System.out.println("  DD index:  	 " + this.ddEntries.indexOf(d));
				System.out.println(ddPropertyLabels.getName() +": " + d.getName());
				System.out.println(ddPropertyLabels.getClass() +": " + d.getClass());
				System.out.println(ddPropertyLabels.getFormsID() +": " + d.getFormsID());
				System.out.println(ddPropertyLabels.getDestinationID() +": " + d.getDestinationID());
				System.out.println(ddPropertyLabels.getPageCount() +": " + d.getLineCount());
				System.out.println(ddPropertyLabels.getLineCount() +": " + d.getPageCount());
			}
		}
		
		public String findDDName(String ddname) {
			if (this.ddEntries.size() > 0) {
				// find job number and job name
				for (ddEntries j : this.getDdEntries()) {
					if (j.getDdName().equals(ddname))
						return j.getDdUniqueID();
				}
			}
			return null;
		}
		
		// Getter Methods

		public ArrayList<ddEntries> getDdEntries() {
			return ddEntries;
		}
		
		public PropertyLabels getDdPropertyLabels() {
			return ddPropertyLabels;
		}


		// Setter Methods


		public void setDdEntries(ArrayList<ddEntries> ddlist) {
			this.ddEntries = ddlist;
		}
		
		public void setDdPropertyLabels(PropertyLabels ddlabels) {
			this.ddPropertyLabels = ddlabels;
		}


	}
}
