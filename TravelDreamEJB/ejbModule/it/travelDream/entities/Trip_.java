package it.travelDream.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-13T20:59:15.768+0100")
@StaticMetamodel(Trip.class)
public class Trip_ {
	public static volatile SingularAttribute<Trip, Integer> idTrip;
	public static volatile SingularAttribute<Trip, String> name;
	public static volatile SingularAttribute<Trip, Double> price;
	public static volatile SingularAttribute<Trip, Date> tripDate;
	public static volatile SingularAttribute<Trip, String> description;
	public static volatile SingularAttribute<Trip, Boolean> status;
	public static volatile ListAttribute<Trip, PackageTd> packageTds;
}
