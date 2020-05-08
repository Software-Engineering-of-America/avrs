package com.seasoft.savrs;

import java.util.ArrayList;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class BrowseOutput implements SavrsRest {
	private boolean debug = false;
	private String url = null;

	BrowseOutput(String h, boolean d) {
		url = getBrowseOutputUrl(h);
		debug = d;
	}

	public Response getOutput(Input data) {
		Response report = new Response();
		try {
			if (debug)
				prettyPrint("Report Input", data);

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, data);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			} else {
				report = response.getEntity(Response.class);
				if (debug)
					prettyPrint("Report Output", report);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return report;
	}

	// input data
	@JsonSerialize(include=Inclusion.NON_NULL)		// takes care of ddname and dduniqueid not being present on whole job report input
	static class Input {
		private String authToken;
		private String catalog;
		private String clientVersion;
		private String jobName;
		private String jobUniqueID;
		private String jobNumber;
		private String ddName;
		private String ddUniqueID;
		private int maxLines;
		private int skipLines;

		
		public Input(String auth, String catalog, String version, String jobname, String jobuniqueid, String jobnumber,
				String ddname, String dduniqueid, int maxlines, int skip) {
			this.authToken = auth;
			this.catalog = catalog;
			this.clientVersion = version;
			this.jobName = jobname;
			this.jobUniqueID = jobuniqueid;
			this.jobNumber = jobnumber;
			this.ddName = ddname;
			this.ddUniqueID = dduniqueid;
			this.maxLines = maxlines;
			this.skipLines = skip;
		}

		public void printData() {
			System.out.println("Report.Data:");
			System.out.println("   auth:    " + this.authToken);
			System.out.println("   catalog: " + this.catalog);
			System.out.println("   version: " + this.clientVersion);
			System.out.println("   name:    " + this.jobName);
			System.out.println("   prefix:  " + this.jobUniqueID);
			System.out.println("   number:  " + this.jobNumber);
			System.out.println("   limit:   " + this.maxLines);
			System.out.println("   skip:    " + this.skipLines);
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

		public String getJobName() {
			return jobName;
		}

		public String getJobUniqueID() {
			return jobUniqueID;
		}

		public String getJobNumber() {
			return jobNumber;
		}

		public String getDdName() {
			return ddName;
		}

		public String getDdUniqueID() {
			return ddUniqueID;
		}

		public int getMaxLines() {
			return maxLines;
		}

		public int getSkipLines() {
			return skipLines;
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

		public void setJobName(String jobname) {
			this.jobName = jobname;
		}

		public void setJobNamePrefix(String jobuniqueid) {
			this.jobUniqueID = jobuniqueid;
		}

		public void setJobNumber(String jobNumber) {
			this.jobNumber = jobNumber;
		}

		public void setJobUniqueID(String jobUniqueID) {
			this.jobUniqueID = jobUniqueID;
		}

		public void setDdName(String ddName) {
			this.ddName = ddName;
		}

		public void setDdUniqueID(String ddUniqueID) {
			this.ddUniqueID = ddUniqueID;
		}

		public void setSkipLines(int skipLines) {
			this.skipLines = skipLines;
		}

		public void setMaxLines(int limit) {
			this.maxLines = limit;
		}

		public void setSkipLiness(int skip) {
			this.skipLines = skip;
		}
	}

	// response data
	static class Response {
		private String jobName;
		private String jobNumber;
		private String ddName;
		ArrayList<String> lines = new ArrayList<String>();

		public void displayReport(String header){
			// display report
			System.out.println(header);
			for (String line : this.getLines()) {
				System.out.println(line);
			}
		}
		
		// Getter Methods

		public String getJobName() {
			return jobName;
		}

		public String getJobNumber() {
			return jobNumber;
		}

		public String getDdName() {
			return ddName;
		}

		public ArrayList<String> getLines() {
			return lines;
		}

		// Setter Methods

		public void setLines(ArrayList<String> lines) {
			this.lines = lines;
		}

		public void setJobName(String jobName) {
			this.jobName = jobName;
		}

		public void setJobNumber(String jobNumber) {
			this.jobNumber = jobNumber;
		}

		public void setDdName(String ddName) {
			this.ddName = ddName;
		}
	}
}
