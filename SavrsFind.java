package com.seasoft.savrs;

import java.util.ArrayList;
import java.util.Arrays;

import com.seasoft.savrs.SavrsStructures.Column;

public class SavrsFind {

	public static void main(String[] args) {
		String authkey = null;
		String host = "http://192.168.0.210:8090";
		String catalog = "YEAR_2014";
		String jobname = "C105OFF5";
		String jobnumber = "10586";
		String ddname = "JESMSGLG";		
		String username = "seaguest";
		String pw = "seaguest";
		String uniqueId = null;
		String dduniqueId = null;
		
		boolean debug = false;

		try {
			// create login data and call logon
			Login.Response lr = new Login(host, debug).logon(new Login.Input(username, pw));
			// pick off fields from response
			authkey = lr.getAuthToken();
			
			// check if catalog is in the list
			if (lr.findCatalogIndex(catalog) == -1) {
				System.out.println("Catalog: " + catalog + " not found");
				System.exit(996);
			}

			// create sort criteria and pick type(s) (1 = job, 2 = TSO User, 3 =
			// Started Task, 4 = System Log and call search
			ArrayList<Column> ca = new ArrayList<Column>(Arrays.asList(new Column("lineCount", true)));
			ArrayList<Integer> types = new ArrayList<Integer>(Arrays.asList(1));
			FilterList.Response jl = new FilterList(host, debug).getJobList(
					new FilterList.Input(authkey, catalog, "7.02.123", jobname, jobname, 480, types, ca, 0));

			// find job number if present in job list
			uniqueId = jl.findJobID(jobname, jobnumber);
			if (uniqueId == null) {
				System.out.println("Jobname/Jobnumber: " + jobname + "/" + jobnumber + " not found");
				System.exit(997);
			}
			
			// find ddlist from job list
			DDList.Response ddl = new DDList(host,debug).getOutput(new DDList.Input(authkey, catalog, "7.02.123", uniqueId));
			dduniqueId = ddl.findDDName(ddname);
			if(dduniqueId == null){
				System.out.println("DDName: " + ddname  + " not found");
				System.exit(998);
			}

			// create report data from the dd name
			BrowseOutput.Response d = new BrowseOutput(host, debug).getOutput(
					new BrowseOutput.Input(authkey, catalog, "7.02.123", jobname, uniqueId, jobnumber, ddname, dduniqueId, 100, 0));

			d.displayReport("----------- Report output for DD Name: " + ddname + " -----------\n");
			
			// create report data from the jobname
			BrowseOutput.Response r = new BrowseOutput(host, debug).getOutput(
					new BrowseOutput.Input(authkey, catalog, "7.02.123", jobname, uniqueId, jobnumber, null, null, 100, 0));

			r.displayReport("\n\n-----------Report output for Jobname " + jobname + " -----------\n");

		} catch (Exception e) {

			e.printStackTrace();
			System.exit(999);

		}
	}
}
