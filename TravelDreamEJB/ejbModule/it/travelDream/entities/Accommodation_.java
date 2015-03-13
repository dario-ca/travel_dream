package it.travelDream.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-13T20:14:17.286+0100")
@StaticMetamodel(Accommodation.class)
public class Accommodation_ {
	public static volatile SingularAttribute<Accommodation, Integer> idAccommodation;
	public static volatile SingularAttribute<Accommodation, String> name;
	public static volatile SingularAttribute<Accommodation, Double> price;
	public static volatile SingularAttribute<Accommodation, Date> checkInDate;
	public static volatile SingularAttribute<Accommodation, Date> checkOutDate;
	public static volatile SingularAttribute<Accommodation, Integer> rating;
	public static volatile SingularAttribute<Accommodation, String> address;
	public static volatile SingularAttribute<Accommodation, Boolean> status;
	public static volatile ListAttribute<Accommodation, PackageTd> packageTds;
}
