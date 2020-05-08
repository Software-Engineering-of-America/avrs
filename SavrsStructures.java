package com.seasoft.savrs;

public class SavrsStructures {

	static class Column {
		private String column;
		private boolean descending;

		public Column(String c, boolean desc) {
			this.column = c;
			this.descending = desc;
		}

		public String printColumn() {
			String s = this.column + ", Descending: " + this.descending;
			return s;
		}

		// Getter Methods

		public String getColumn() {
			return column;
		}

		public boolean getDescending() {
			return descending;
		}

		// Setter Methods

		public void setColumn(String column) {
			this.column = column;
		}

		public void setDescending(boolean descending) {
			this.descending = descending;
		}
	}

	static class PropertyLabels {
		//ddLabels DdPropertyLabelsObject;
		private String name;
		private String stepName;
		private String ddName;
		private String sysoutClass;
		private String formsID;
		private String destinationID;
		private String procedureStepName;
		private String lineCount;
		private String pageCount;
		private String copyCount;
		private String maxLineSize;
		private String databaseBlocks;
		private String writerName;
		private String fcbID;


		// Getter Methods
		
		public String getName() {
			return name;
		}

		public String getStepName() {
			return stepName;
		}

		public String getDdName() {
			return ddName;
		}

		public String getSysoutClass() {
			return sysoutClass;
		}

		public String getFormsID() {
			return formsID;
		}

		public String getDestinationID() {
			return destinationID;
		}

		public String getProcedureStepName() {
			return procedureStepName;
		}

		public String getLineCount() {
			return lineCount;
		}

		public String getPageCount() {
			return pageCount;
		}

		public String getCopyCount() {
			return copyCount;
		}

		public String getMaxLineSize() {
			return maxLineSize;
		}

		public String getDatabaseBlocks() {
			return databaseBlocks;
		}

		public String getWriterName() {
			return writerName;
		}

		public String getFcbID() {
			return fcbID;
		}

		// Setter Methods
		
		public void setName(String name) {
			this.name = name;
		}

		public void setStepName(String stepName) {
			this.stepName = stepName;
		}

		public void setDdName(String ddName) {
			this.ddName = ddName;
		}

		public void setSysoutClass(String sysoutClass) {
			this.sysoutClass = sysoutClass;
		}

		public void setFormsID(String formsID) {
			this.formsID = formsID;
		}

		public void setDestinationID(String destinationID) {
			this.destinationID = destinationID;
		}

		public void setProcedureStepName(String procedureStepName) {
			this.procedureStepName = procedureStepName;
		}

		public void setLineCount(String lineCount) {
			this.lineCount = lineCount;
		}

		public void setPageCount(String pageCount) {
			this.pageCount = pageCount;
		}

		public void setCopyCount(String copyCount) {
			this.copyCount = copyCount;
		}

		public void setMaxLineSize(String maxLineSize) {
			this.maxLineSize = maxLineSize;
		}

		public void setDatabaseBlocks(String databaseBlocks) {
			this.databaseBlocks = databaseBlocks;
		}

		public void setWriterName(String writerName) {
			this.writerName = writerName;
		}

		public void setFcbID(String fcbID) {
			this.fcbID = fcbID;
		}
	}

	static class ddEntries {
		private String name;
		private String stepName;
		private String ddName;
		private String ddUniqueID;
		private String sysoutClass;
		private String formsID;
		private String destinationID;
		private String procedureStepName;
		private int lineCount;
		private int pageCount;
		private int copyCount;
		private int maxLineSize;
		private int databaseBlocks;
		private String writerName;
		private String fcbID;

		// Getter Methods

		public String getName() {
			return name;
		}

		public String getStepName() {
			return stepName;
		}

		public String getDdName() {
			return ddName;
		}

		public String getDdUniqueID() {
			return ddUniqueID;
		}

		public String getSysoutClass() {
			return sysoutClass;
		}

		public String getFormsID() {
			return formsID;
		}

		public String getDestinationID() {
			return destinationID;
		}

		public String getProcedureStepName() {
			return procedureStepName;
		}

		public int getLineCount() {
			return lineCount;
		}

		public int getPageCount() {
			return pageCount;
		}

		public int getCopyCount() {
			return copyCount;
		}

		public int getMaxLineSize() {
			return maxLineSize;
		}

		public int getDatabaseBlocks() {
			return databaseBlocks;
		}

		public String getWriterName() {
			return writerName;
		}

		public String getFcbID() {
			return fcbID;
		}

		// Setter Methods

		public void setName(String name) {
			this.name = name;
		}

		public void setStepName(String stepName) {
			this.stepName = stepName;
		}

		public void setDdName(String ddName) {
			this.ddName = ddName;
		}

		public void setDdUniqueID(String ddUniqueID) {
			this.ddUniqueID = ddUniqueID;
		}

		public void setSysoutClass(String sysoutClass) {
			this.sysoutClass = sysoutClass;
		}

		public void setFormsID(String formsID) {
			this.formsID = formsID;
		}

		public void setDestinationID(String destinationID) {
			this.destinationID = destinationID;
		}

		public void setProcedureStepName(String procedureStepName) {
			this.procedureStepName = procedureStepName;
		}

		public void setLineCount(int lineCount) {
			this.lineCount = lineCount;
		}

		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}

		public void setCopyCount(int copyCount) {
			this.copyCount = copyCount;
		}

		public void setMaxLineSize(int maxLineSize) {
			this.maxLineSize = maxLineSize;
		}

		public void setDatabaseBlocks(int databaseBlocks) {
			this.databaseBlocks = databaseBlocks;
		}

		public void setWriterName(String writerName) {
			this.writerName = writerName;
		}

		public void setFcbID(String fcbID) {
			this.fcbID = fcbID;
		}
	}

	static class Job {
		private int type;
		private String name;
		private String jobName;
		private String jobNumber;
		private String jobUniqueID;
		private boolean syslog;
		private String msgClass;
		private String ackCode;
		private String conditionCode;
		private String startDateTime;
		private String endDateTime;
		private String accumDateTime;
		private String archiveDateTime;
		private int fileCount;
		private int lineCount;
		private int pageCount;
		private String programmerName;
		private String userName;
		private String notifyName;
		private String commentText;
		private String cpuTime;
		private String elapsedTime;
		private String roomNumber;
		private String destinationID;
		private int databaseBlocks;
		private String systemID;
		private int maxLineSize;
		private int annotationCount;
		private String abrvMsg;
		private String respun;
		private boolean archive;

		// Getter Methods

		public int getType() {
			return type;
		}

		public String getName() {
			return name;
		}

		public String getJobName() {
			return jobName;
		}

		public String getJobNumber() {
			return jobNumber;
		}

		public String getJobUniqueID() {
			return jobUniqueID;
		}

		public boolean getSyslog() {
			return syslog;
		}

		public String getMsgClass() {
			return msgClass;
		}

		public String getAckCode() {
			return ackCode;
		}

		public String getConditionCode() {
			return conditionCode;
		}

		public String getStartDateTime() {
			return startDateTime;
		}

		public String getEndDateTime() {
			return endDateTime;
		}

		public String getAccumDateTime() {
			return accumDateTime;
		}

		public String getArchiveDateTime() {
			return archiveDateTime;
		}

		public int getFileCount() {
			return fileCount;
		}

		public int getLineCount() {
			return lineCount;
		}

		public int getPageCount() {
			return pageCount;
		}

		public String getProgrammerName() {
			return programmerName;
		}

		public String getUserName() {
			return userName;
		}

		public String getNotifyName() {
			return notifyName;
		}

		public String getCommentText() {
			return commentText;
		}

		public String getCpuTime() {
			return cpuTime;
		}

		public String getElapsedTime() {
			return elapsedTime;
		}

		public String getRoomNumber() {
			return roomNumber;
		}

		public String getDestinationID() {
			return destinationID;
		}

		public int getDatabaseBlocks() {
			return databaseBlocks;
		}

		public String getSystemID() {
			return systemID;
		}

		public int getMaxLineSize() {
			return maxLineSize;
		}

		public int getAnnotationCount() {
			return annotationCount;
		}

		public String getAbrvMsg() {
			return abrvMsg;
		}

		public String getRespun() {
			return respun;
		}

		public boolean getArchive() {
			return archive;
		}

		// Setter Methods

		public void setType(int type) {
			this.type = type;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setJobName(String jobName) {
			this.jobName = jobName;
		}

		public void setJobNumber(String jobNumber) {
			this.jobNumber = jobNumber;
		}

		public void setJobUniqueID(String jobUniqueID) {
			this.jobUniqueID = jobUniqueID;
		}

		public void setSyslog(boolean syslog) {
			this.syslog = syslog;
		}

		public void setMsgClass(String msgClass) {
			this.msgClass = msgClass;
		}

		public void setAckCode(String ackCode) {
			this.ackCode = ackCode;
		}

		public void setConditionCode(String conditionCode) {
			this.conditionCode = conditionCode;
		}

		public void setStartDateTime(String startDateTime) {
			this.startDateTime = startDateTime;
		}

		public void setEndDateTime(String endDateTime) {
			this.endDateTime = endDateTime;
		}

		public void setAccumDateTime(String accumDateTime) {
			this.accumDateTime = accumDateTime;
		}

		public void setArchiveDateTime(String archiveDateTime) {
			this.archiveDateTime = archiveDateTime;
		}

		public void setFileCount(int fileCount) {
			this.fileCount = fileCount;
		}

		public void setLineCount(int lineCount) {
			this.lineCount = lineCount;
		}

		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}

		public void setProgrammerName(String programmerName) {
			this.programmerName = programmerName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public void setNotifyName(String notifyName) {
			this.notifyName = notifyName;
		}

		public void setCommentText(String commentText) {
			this.commentText = commentText;
		}

		public void setCpuTime(String cpuTime) {
			this.cpuTime = cpuTime;
		}

		public void setElapsedTime(String elapsedTime) {
			this.elapsedTime = elapsedTime;
		}

		public void setRoomNumber(String roomNumber) {
			this.roomNumber = roomNumber;
		}

		public void setDestinationID(String destinationID) {
			this.destinationID = destinationID;
		}

		public void setDatabaseBlocks(int databaseBlocks) {
			this.databaseBlocks = databaseBlocks;
		}

		public void setSystemID(String systemID) {
			this.systemID = systemID;
		}

		public void setMaxLineSize(int maxLineSize) {
			this.maxLineSize = maxLineSize;
		}

		public void setAnnotationCount(int annotationCount) {
			this.annotationCount = annotationCount;
		}

		public void setAbrvMsg(String abrvMsg) {
			this.abrvMsg = abrvMsg;
		}

		public void setRespun(String respun) {
			this.respun = respun;
		}

		public void setArchive(boolean archive) {
			this.archive = archive;
		}
	}

}
