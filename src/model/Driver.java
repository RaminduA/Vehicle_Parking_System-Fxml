package model;

public class Driver {
    private String name;
    private String nic;
    private String drivingLicense;
    private String address;
    private String contact;


    public Driver() {

    }
    public Driver(String name, String nic, String drivingLicense, String address, String contact) {
        this.setName(name);
        this.setNic(nic);
        this.setDrivingLicense(drivingLicense);
        this.setAddress(address);
        this.setContact(contact);
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }
    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

}
