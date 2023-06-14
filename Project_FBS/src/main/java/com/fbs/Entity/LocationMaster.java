package com.fbs.Entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="locations")
@NamedQuery(name="LocationMaster.findAll", query="SELECT l FROM LocationMaster l")
public class LocationMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOCATION_MASTER_ID")
	private int locationMasterId;

	@Column(name="AIRPORT_NAME")
	private String airportName;

	private String code;

	private String country;

	private String name;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="locationMaster1")
	private Set<Flight> flightMasters1;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="locationMaster2")
	private Set<Flight> flightMasters2;

	public LocationMaster() {
	}

	public int getLocationMasterId() {
		return this.locationMasterId;
	}

	public LocationMaster(String airportName, String code, String country, String name, Set<Flight> flightMasters1,
			Set<Flight> flightMasters2) {
		super();
		this.airportName = airportName;
		this.code = code;
		this.country = country;
		this.name = name;
		this.flightMasters1 = flightMasters1;
		this.flightMasters2 = flightMasters2;
	}

	public String getAirportName() {
		return this.airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Flight> getFlights1() {
		return this.flightMasters1;
	}

	public void setFlights1(Set<Flight> flightMasters1) {
		this.flightMasters1 = flightMasters1;
	}

	public Flight addFlights1(Flight flightMasters1) {
		getFlights1().add(flightMasters1);
		flightMasters1.setLocationMaster1(this);

		return flightMasters1;
	}

	public Flight removeFlights1(Flight flightMasters1) {
		getFlights1().remove(flightMasters1);
		flightMasters1.setLocationMaster1(null);

		return flightMasters1;
	}

	public Set<Flight> getFlights2() {
		return this.flightMasters2;
	}

	public void setFlights2(Set<Flight> flightMasters2) {
		this.flightMasters2 = flightMasters2;
	}

	public Flight addFlights2(Flight flightMasters2) {
		getFlights2().add(flightMasters2);
		flightMasters2.setLocationMaster2(this);

		return flightMasters2;
	}

	public Flight removeFlights2(Flight flightMasters2) {
		getFlights2().remove(flightMasters2);
		flightMasters2.setLocationMaster2(null);

		return flightMasters2;
	}

}