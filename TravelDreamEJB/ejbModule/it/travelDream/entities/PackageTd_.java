package it.travelDream.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-01-19T19:02:23.329+0100")
@StaticMetamodel(PackageTd.class)
public class PackageTd_ {
	public static volatile SingularAttribute<PackageTd, Integer> idPackageTd;
	public static volatile SingularAttribute<PackageTd, String> name;
	public static volatile SingularAttribute<PackageTd, String> country;
	public static volatile SingularAttribute<PackageTd, String> city;
	public static volatile SingularAttribute<PackageTd, String> description;
	public static volatile SingularAttribute<PackageTd, Double> price;
	public static volatile SingularAttribute<PackageTd, Boolean> onOffer;
	public static volatile SingularAttribute<PackageTd, Boolean> status;
	public static volatile SingularAttribute<PackageTd, Boolean> personalized;
	public static volatile SingularAttribute<PackageTd, User> user;
	public static volatile ListAttribute<PackageTd, Accommodation> accommodations;
	public static volatile ListAttribute<PackageTd, TransportationMean> transportations;
	public static volatile ListAttribute<PackageTd, Trip> trips;
}
