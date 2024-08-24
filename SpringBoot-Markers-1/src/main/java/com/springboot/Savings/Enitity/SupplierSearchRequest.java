package com.springboot.Savings.Enitity;

public class SupplierSearchRequest {

    private String location;
    private String natureOfBusiness; // Single value instead of a list
    private String manufacturingProcess; // Single value instead of a list
    private int page;
    private int size;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getManufacturingProcess() {
        return manufacturingProcess;
    }

    public void setManufacturingProcess(String manufacturingProcess) {
        this.manufacturingProcess = manufacturingProcess;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

	public SupplierSearchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
//	for testing
	 public SupplierSearchRequest(String location, String natureOfBusiness, String manufacturingProcess) {
	        this.location = location;
	        this.natureOfBusiness = natureOfBusiness;
	        this.manufacturingProcess = manufacturingProcess;
	    }
    
}
