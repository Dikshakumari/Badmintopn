package com.tms.model.persistance;

import java.util.Date;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

@Produces("application/json")
@XmlRootElement(name = "batch")
public class Batch {

	private int batchId;
	private String batchName;
	private Date batchStartDate;
	private Date batchEndDate;
	private int batchCapacity;
	private Course batchCourseReferenceId;
}