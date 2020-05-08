package com.seasoft.savrs;

import java.util.ArrayList;

import com.seasoft.savrs.SavrsStructures.Column;
import com.seasoft.savrs.SavrsStructures.Job;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class FilterList implements SavrsRest {
	private boolean debug = false;
	private String url = null;

	FilterList(String h, boolean d) {
		url = getFilterListtUrl(h);
		debug = d;
	}

	public Response getJobList(Input data) {
		Response jobList = new Response();
		try {
			if (debug)
				prettyPrint("Joblist Input", data);

			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, data);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			} else {
				jobList = response.getEntity(Response.class);
				if (debug)
					prettyPrint("Joblist Output", jobList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return jobList;
	}

	static class Input {
		private String authToken;
		private String catalog;
		private String clientVersion;
		private String jobName;
		private String jobNamePrefix;
		private String jobNumber;
		ArrayList<Integer> type = new ArrayList<Integer>();
		private int limit;
		ArrayList<Column> orderBy = new ArrayList<Column>();
		private int skipRows;

		public Input(String auth, String catalog, String version, String jobname, String jobnameprefix, int limit,
				ArrayList<Integer> type, ArrayList<Column> order, int skip) {
			this.authToken = auth;
			this.catalog = catalog;
			this.clientVersion = version;
			this.jobName = jobname;
			this.jobNamePrefix = jobnameprefix;
			this.limit = limit;
			this.orderBy = new ArrayList<Column>(order);
			this.skipRows = skip;
			this.type = new ArrayList<Integer>(type);

		}

		public void printData() {
			System.out.println("JobList.Data:");
			System.out.println("   auth:    " + this.authToken);
			System.out.println("   catalog: " + this.catalog);
			System.out.println("   version: " + this.clientVersion);
			System.out.println("   name:    " + this.jobName);
			System.out.println("   prefix:  " + this.jobNamePrefix);
			System.out.println("   number:  " + this.jobNumber);
			System.out.println("   limit:   " + this.limit);
			System.out.println("   type:    " + this.type);
			System.out.println("   skip:    " + this.skipRows);
			for (Column c : this.orderBy) {
				System.out.println("   orderby: " + c.printColumn());
			}
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

		public String getJobNamePrefix() {
			return jobNamePrefix;
		}

		public String getJobNumber() {
			return jobNumber;
		}

		public ArrayList<Integer> getType() {
			return type;
		}

		public int getLimit() {
			return limit;
		}

		public ArrayList<Column> getOrderBy() {
			return orderBy;
		}

		public int getSkipRows() {
			return skipRows;
		}

		// Setter Methods

		public void setOrderBy(ArrayList<Column> orderBy) {
			this.orderBy = orderBy;
		}

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

		public void setJobNamePrefix(String jobNamePrefix) {
			this.jobNamePrefix = jobNamePrefix;
		}

		public void setJobNumber(String jobNumber) {
			this.jobNumber = jobNumber;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}

		public void setType(ArrayList<Integer> type) {
			this.type = type;
		}

		public void setSkipRows(int skipRows) {
			this.skipRows = skipRows;
		}
	}

	static class Response {

		private int count;
		private ArrayList<Job> jobs = new ArrayList<Job>();
		private boolean moreRows;

		public void printResponse() {

			System.out.println("FilterList Response: ");
			System.out.println("  job count: " + this.count);
			System.out.println("  more rows: " + this.moreRows);
			for (Job j : this.jobs) {
				System.out.println("  Job index:  " + this.jobs.indexOf(j));
				System.out.println("    jobname:   " + j.getJobName());
				System.out.println("    jobNumber: " + j.getJobNumber());
				System.out.println("    jobID:     " + j.getJobUniqueID());
				System.out.println("    fileCount: " + j.getFileCount());
				System.out.println("    lineCount: " + j.getLineCount());
				System.out.println("    pageCount: " + j.getPageCount());
			}
		}

		public String findJobID(String jobnam, String jobnum) {
			if (this.count > 0) {
				// find job number and job name
				for (Job j : this.getJobs()) {
					if (j.getJobName().equals(jobnam) && j.getJobNumber().equals(jobnum))
						return j.getJobUniqueID();
				}
			}
			return null;
		}
		
		// Getter Methods

		public int getCount() {
			return count;
		}

		public ArrayList<Job> getJobs() {
			return jobs;
		}

		public boolean getMoreRows() {
			return moreRows;
		}

		// Setter Methods

		public void setCount(int count) {
			this.count = count;
		}

		public void setJobs(ArrayList<Job> j) {
			this.jobs = j;
		}

		public void setMoreRows(boolean moreRows) {
			this.moreRows = moreRows;
		}

	}

}
