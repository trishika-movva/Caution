package features;

import java.util.ArrayList;

public class ReportIncident {
	
	private String reportStatement;
	private String reportFile;
	private String time;
	ArrayList<String> report = new ArrayList<String>();
	
	public ReportIncident(String reportStatement, String time) {
		report.add(reportStatement);
		this.time = time;
		reportFile = "";
	}
	
	public String getReportFile() {
		printTopStatement(report, time);
		return reportFile;
	}
	
	public void fileStatement(String statement, String time) {
		String statementTime = statement + " (" + time + ")";
		report.add(statementTime);
	}
	
	public void printTopStatement(ArrayList<String> top, String time) {
		if(report.size() < 3) {
			int j = 1;
			for(int i = report.size() - 1; i >= 0; i--) {
				reportFile += "Top incident " + (j) + ": " + report.get(i) + "\n\n";		
				j++;
			}	
		} else {
			int j = 1;
			for(int i = report.size() - 1; i > report.size() - 4; i--) {
				reportFile += "Top incident " + (j) + ": " + report.get(i) + "\n\n";
				j++;
			}
		}
	}	
	
}

